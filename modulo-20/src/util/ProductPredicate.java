package util;

import entities.Product;

import java.util.function.Predicate;

public class ProductPredicate implements Predicate<Product> {

    private static final Double VALOR_MINIMO = 100.0;

    @Override
    public boolean test(Product product) {
        return product.getPrice() >= VALOR_MINIMO;
    }

}
