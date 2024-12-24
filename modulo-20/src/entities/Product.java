package entities;

public class Product implements Comparable<Product> {

    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static boolean staticProductPredicate(Product p) {
        return p.getPrice() >= 100.0;
    }

    public boolean nonStaticProductPredicate() {
        return price >= 100.0;
    }

    public static void staticPriceUpdate(Product p) {
        p.setPrice(p.getPrice() * 1.1);
    }

    public void nonStaticPriceUpdate() {
        price = price * 1.1;
    }

    public static String staticUpperCaseName(Product p){
        return p.getName().toUpperCase();
    }

    public String nonStaticUpperCaseName(){
        return name.toUpperCase();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return name.toUpperCase().compareTo(o.getName().toUpperCase());
    }
}