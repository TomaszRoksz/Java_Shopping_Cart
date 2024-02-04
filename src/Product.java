public class Product implements Comparable<Product>{
     String code;
     String name;
     Double price;
     Double discountPrice;

    public Product(String code, String name, Double price){
        this.code=code;
        this.name=name;
        this.price=price;
        this.discountPrice=price;
    }



    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product other) {
        int priceComparison = Double.compare(price, other.price);

        if(priceComparison==0){
            return name.compareTo(other.name);
        }
        else return priceComparison;
        }
        //Dependency Inversion Principle słabo - szczególnie w klasie produkt
        //testy parametryczne, a nie takie proste
        //przetestuj command
}
