
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestShoppingCart {
    Product product1, product2, product3;
    ShoppingCart testCart;

    @BeforeEach
    void productsSetup(){
        product1 = new Product("code1", "Product1", 10.0);
        product2 = new Product("code2", "Product2", 20.0);
        product3 = new Product("code3", "Product3", 30.0);

        testCart = new ShoppingCart();

    }
    @Test
    void testMinSortCartByPrice(){
        testCart.addToCart(product3);
        testCart.addToCart(product2);
        testCart.addToCart(product1);

        testCart.minSortCartByPrice();

        assertEquals(product1, testCart.cart.get(0));
        assertEquals(product2, testCart.cart.get(1));
        assertEquals(product3, testCart.cart.get(2));
    }

    @Test
    void testMaxSortCartByPrice(){
        testCart.addToCart(product1);
        testCart.addToCart(product2);
        testCart.addToCart(product3);

        testCart.maxSortCartByPrice();

        assertEquals(product1, testCart.cart.get(2));
        assertEquals(product2, testCart.cart.get(1));
        assertEquals(product3, testCart.cart.get(0));
    }

    @Test void testGetCheapestProduct(){
        testCart.addToCart(product1);
        testCart.addToCart(product2);

        assertEquals(product1, testCart.getCheapestProduct());
    }

    @Test void testGetMostExpensiveProduct(){
        testCart.addToCart(product1);
        testCart.addToCart(product2);

        assertEquals(product2, testCart.getMostEspensiveProduct());
    }

    @Test void testGetTotalprice(){
        testCart.addToCart(product1);
        testCart.addToCart(product2);

        assertEquals(30.0, testCart.getTotalPrice() );
    }
    @Test void testPercentageDiscount(){
        testCart.addToCart(product1);
        testCart.addToCart(product2);

        Discount discount = new PercentageDiscount(0.1, 20);
        if(discount.canExecute(testCart)){
            discount.Execute(testCart);
        }

        assertEquals(27.0, testCart.getTotalPrice() );
    }

    @Test
    void testFreeProductDiscount() {
        testCart.addToCart(product1);
        testCart.addToCart(product2);
        testCart.addToCart(product3);

        Discount discount = new FreeProductDiscount(2.0);
        if(discount.canExecute(testCart)){
            discount.Execute(testCart);
        }
        assertEquals(50.0, testCart.getTotalPrice() );
    }

    @Test
    void testFreeCupDiscount(){
        testCart.addToCart(product1);
        testCart.addToCart(product2);
        testCart.addToCart(product3);
        Product cup1 = new Product("cup1", "ProductCup", 0.0);

        Discount discount =  new FreeCupDiscount(20.0, cup1);
        if(discount.canExecute(testCart)){
            discount.Execute(testCart);
        }

        assertTrue(testCart.containsProduct(cup1));
    }
    @Test
    void testCouponDiscount() {
        testCart.addToCart(product1);
        testCart.addToCart(product2);
        testCart.addToCart(product3);

        Discount discount = new CouponDiscount(0.20, product1);
        if(discount.canExecute(testCart)){
            discount.Execute(testCart);
        }
        assertEquals(58.0, testCart.getTotalPrice() );
    }

}
