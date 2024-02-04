import java.util.ArrayList;
import java.util.Comparator;

class ShoppingCart {
    ArrayList<Product> cart= new ArrayList<>(); //not sure of this one

    void addToCart(Product product){
        cart.add(product);
    }

    void minSortCartByPrice(){
        cart.sort(Comparator.comparing(Product::getPrice));
    }

    void maxSortCartByPrice(){
        cart.sort(Comparator.comparing(Product::getPrice).reversed());
    }

    public Product getCheapestProduct(){
        return this.cart.stream().min(Comparator.comparing(Product::getPrice)).orElse(null);
    }

    public Product getMostEspensiveProduct(){
        return this.cart.stream().max(Comparator.comparing(Product::getPrice)).orElse(null);
    }


    public double getTotalPrice(){
        return cart.stream().mapToDouble(p -> p.discountPrice).sum();
    }

    public boolean containsProduct(Product product){
        return cart.contains(product);
    }

}
