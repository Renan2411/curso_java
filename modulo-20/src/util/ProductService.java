package util;

import entities.Product;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductService {

    //Filtro fechado, ou seja, só funciona para um caso especifico
    public double filteredSum(List<Product> produtos) {
        double sum = 0.0;

        for (Product produto : produtos) {
            if (produto.getName().charAt(0) == 'T'
                    || produto.getName().charAt(0) == 't') {
                sum += produto.getPrice();
            }
        }

        return sum;
    }

    public double filteredSumWithPredicate(List<Product> produtos, Predicate<Product> criteria) {
        double sum = 0.0;

        for (Product produto : produtos) {
            if (criteria.test(produto)) {
                sum += produto.getPrice();
            }
        }

        return sum;
    }

    public double filteredSumWithPredicateAndFunction(List<Product> produtos,
                                                      Predicate<Product> criteria,
                                                      Function<Product, Double> applyChange) {
        double sum = 0.0;

        for (Product produto : produtos) {
            if (criteria.test(produto)) {
                sum += applyChange.apply(produto);
            }
        }

        return sum;
    }

    public double filteredSumWithPredicateAndFunctionAndConsumer(List<Product> produtos,
                                                                 Predicate<Product> criteria,
                                                                 Function<Product, Double> applyChange,
                                                                 Consumer<Product> acceptChange) {
        double sum = 0.0;

        for (Product produto : produtos) {
            if (criteria.test(produto)) {
                sum += applyChange.apply(produto);
                acceptChange.accept(produto);
            }
        }

        return sum;
    }

}
