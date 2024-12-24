package services;

import java.util.ArrayList;
import java.util.List;

//Funciona apenas para o tipo Integer, limitando a implementação
public class PrintService {

    List<Integer> list = new ArrayList<>();

    public void addValue(Integer value) {
        list.add(value);
    }

    public void print() {
        String print = "[ ";

        for (Integer value : list) {
            print += value + ", ";
        }

        print += "]";
        System.out.println(print);
    }

    public Integer first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        return list.get(0);
    }


}
