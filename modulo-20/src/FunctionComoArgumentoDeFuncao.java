import entities.Product;
import util.ProductService;

import java.util.ArrayList;
import java.util.List;

public class FunctionComoArgumentoDeFuncao {

    public static void main(String[] args) {
        List<Product> produtos = new ArrayList<>();

        produtos.add(new Product("TV", 900.00));
        produtos.add(new Product("Notebook", 1200.00));
        produtos.add(new Product("Tablet", 45.00));
        produtos.add(new Product("Hd Case", 10.00));

        ProductService productService = new ProductService();

        double sum = productService.filteredSum(produtos);

        double sum2 = productService.filteredSumWithPredicate(produtos,
                p -> p.getName().charAt(0) == 't'
                        || p.getName().charAt(0) == 'T');

        double sum3 = productService.filteredSumWithPredicate(produtos,
                p -> p.getName().charAt(0) == 'N'
                        || p.getName().charAt(0) == 'H');

        double sum4 = productService.filteredSumWithPredicateAndFunction(produtos,
                p -> p.getName().equals("Notebook"),
                p -> p.getPrice() * 0.1);

        double sum5 = productService.filteredSumWithPredicateAndFunctionAndConsumer(produtos,
                p -> p.getName().equals("Notebook"),
                p -> p.getPrice() * 0.1,
                p -> p.setPrice(p.getPrice() * 1.1));

        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(sum4);
        System.out.println(sum4);

        produtos.forEach(System.out::println);
    }

}
