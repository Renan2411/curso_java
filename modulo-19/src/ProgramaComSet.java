import entities.Produto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ProgramaComSet {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        //Adição de elementos
        set.add("TV");
        set.add("Tablet");
        set.add("Notebook");
        set.add("Barco");

        //Remoção de elementos
        set.remove("Tablet");

        //Remoção de elementos a partir de um predicado
        set.removeIf(element -> element.length() >= 3);
        set.removeIf(element -> element.charAt(0) == 'B');

        System.out.println(set.contains("Notebook"));

        for (String p : set) {
            System.out.println(p);
        }

        System.out.println("=========OPERAÇÕES DE CONJUNTOS===========");

        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        //Operação de União
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        //Operação de Intersecção
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);

        //Operaçao de diferença
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);

        System.out.println("==========COMPARAÇÃO===========");

        Set<Produto> setProduto = new HashSet<>();
        Produto produto = new Produto("TV", 900.0);

        setProduto.add(produto);
        setProduto.add(new Produto("Notebook", 1200.0));
        setProduto.add(new Produto("Tablet", 400.0));

        Produto prod = new Produto("Notebook", 1200.0);

        System.out.println(setProduto.contains(prod));
        System.out.println(setProduto.contains(produto));

        System.out.println("==========COMPARAÇÃO TREE SET===========");

        Set<Produto> produtoTreeSet = new TreeSet<>();
        Produto produtoTs = new Produto("TV", 900.0);

        produtoTreeSet.add(produtoTs);
        produtoTreeSet.add(new Produto("Notebook", 1200.0));
        produtoTreeSet.add(new Produto("Tablet", 400.0));

        Produto prodNovo = new Produto("Notebook", 1200.0);

        System.out.println(produtoTreeSet.contains(prod));
        System.out.println(produtoTreeSet.contains(produtoTs));

    }

}
