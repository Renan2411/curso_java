import entities.Produto;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProgramaMap {

    public static void main(String[] args) {
        Map<String, String> cookies = new TreeMap<>();

        //Inserção de elementos
        cookies.put("username", "John");
        cookies.put("email", "William@gmail.com");
        cookies.put("phone", "99711122");
        cookies.put("phone", "99711133");

        //Remoção de valores
        cookies.remove("email");

        //Verifica se existe a chave
        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Phone Number: " + cookies.get("phone"));
        System.out.println("Email: " + cookies.get("email"));

        System.out.println("ALL COOKIES");
        for(String key : cookies.keySet()){
            System.out.println(key + " : " + cookies.get(key));
        }

        System.out.println("=============COMPARAÇÃO===============");
        System.out.println();

        Map<Produto, Double> stock = new HashMap<>();

        Produto p1 = new Produto("Tv", 900.0);
        Produto p2 = new Produto("Notebook", 1200.0);
        Produto p3 = new Produto("Tablet", 400.0);

        stock.put(p1, 10000.0);
        stock.put(p2, 20000.0);
        stock.put(p3, 15000.0);

        Produto ps = new Produto("Tv", 900.0);
        System.out.println("Contains 'ps' key: " + stock.containsKey(ps));
        System.out.println("Contains 'p1' key: " + stock.containsKey(p1));
    }

}
