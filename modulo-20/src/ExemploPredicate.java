import entities.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ExemploPredicate {

    public static void main(String[] args) {
        List<Product> produtos = new ArrayList<>();

        produtos.add(new Product("TV", 900.00));
        produtos.add(new Product("Notebook", 1200.00));
        produtos.add(new Product("Tablet", 45.00));
        produtos.add(new Product("Hd Case", 10.00));

        // Expressão lambda inline
        produtos.removeIf(p -> p.getPrice() >= 100.0);

        // implementação de interface
        produtos.removeIf(new ProductPredicate());

        //Method Reference com método estático
        produtos.removeIf(Product::staticProductPredicate);

        //Method Reference com método não estático
        produtos.removeIf(Product::nonStaticProductPredicate);

        //Expressão lambda declarada
        Predicate<Product> predicate = p -> p.getPrice() >= 100;
        produtos.removeIf(predicate);

        for (Product p : produtos) {
            System.out.println(p);
        }

    }

}
