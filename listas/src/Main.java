import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();

        //Adicionar elemento na lista
        lista.add("Renan");
        lista.add("Renato");
        lista.add("Renata");
        lista.add("Rodolfo");
        lista.add("Ana Paula");
        lista.add("Laísa");
        lista.add("Ede");
        lista.add("Talita");

        //Adiciona elemento na lista exatamente na posição indicada por parâmetro
        lista.add(2, "Fernanda");

        //Retorna o tamanho da lista
        System.out.println(lista.size());

        for(String x : lista){
            System.out.println(x);
        }

        System.out.println("---------------");

        //Remove Item da lista, a partir da comporação de um item com o outro
        lista.remove("Ede");

        //Remove item da lista na posição indicada
        lista.remove(2);

        //Remove item da lista a partir de um predicado
        lista.removeIf(x -> x.charAt(0) == 'R'); //Remove um elemento x, tal que x tenha seu primeiro caracter igual a M

        for(String x : lista){
            System.out.println(x);
        }

        System.out.println("----------------");

        //Encontra a posição de um elemento passando uma string
        System.out.println("Index of Talita: " + lista.indexOf("Talita"));
        System.out.println("Index of Talita: " + lista.indexOf("Renan"));//Se não estiver na lista retorna -1

        for(String x : lista){
            System.out.println(x);
        }

        System.out.println("----------------");

        //filtra a lista a partir de uma condiçao
        //O STREM() aceita função com lambda
        List<String> result = lista.stream().filter(x -> x.charAt(0) == 'T').collect(Collectors.toList());

        for(String x : result){
            System.out.println(x);
        }

        System.out.println("----------------");

        //Encontra o primeiro elemento que atenda um predicado
        String name = lista.stream().filter(x -> x.charAt(0) == 'm').findFirst().orElse(null);//Pega a lista, convertendo para stream, filtrando os elementos pelo predicado, e então pega o primeiro elemento, retornando null se não achar

        System.out.println(name);
    }
}