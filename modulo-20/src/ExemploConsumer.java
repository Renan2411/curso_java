import entities.Product;
import util.ProductConsumer;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExemploConsumer {

    public static void main(String[] args) {
        List<Product> produtos = new ArrayList<>();

        produtos.add(new Product("TV", 900.00));
        produtos.add(new Product("Notebook", 1200.00));
        produtos.add(new Product("Tablet", 45.00));
        produtos.add(new Product("Hd Case", 10.00));

        //Implementação de interface
        produtos.forEach(new ProductConsumer());

        //Method reference static
        produtos.forEach(Product::staticPriceUpdate);

        //Method reference non static
        produtos.forEach(Product::nonStaticPriceUpdate);

        //Expressão lambda declarada
        Consumer<Product> consumer = (p) -> p.setPrice(p.getPrice() * 1.1);
        produtos.forEach(consumer);

        //Expressão lambda inline
        produtos.forEach(p -> p.setPrice(p.getPrice() * 1.1));

        produtos.forEach(System.out::println);

    }

}
