package services;

import java.util.ArrayList;
import java.util.List;

//Funciona para o tipo de dados parametrizado
public class GenericPrintService<T> {

    List<T> list = new ArrayList<>();

    public void addValue(T value) {
        list.add(value);
    }

    public void print() {
        String print = "[ ";

        for (T value : list) {
            print += value + ", ";
        }

        print += "]";
        System.out.println(print);
    }

    public T first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        return list.get(0);
    }

}
