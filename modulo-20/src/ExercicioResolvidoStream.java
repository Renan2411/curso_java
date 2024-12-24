import entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ExercicioResolvidoStream {

    public static void main(String[] args) {
        String path = "/home/renan/Documentos/curso_java/modulo-20/src/produtos.txt";
        List<Product> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            getProdutosDoArquivo(produtos, br);

            Double precoMedio =  getMediaProdutos(produtos);

            System.out.println("Avarage price: " + precoMedio);

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
            Comparator<String> compSimples = Comparator.comparing(String::toUpperCase);

            produtos.stream()
                    .filter(p -> p.getPrice() < precoMedio)
                    .map(Product::getName)
                    .sorted(compSimples.reversed())
                    .forEach(System.out::println);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void getProdutosDoArquivo(List<Product> produtos, BufferedReader br) throws IOException {
        String line = br.readLine();

        while (Objects.nonNull(line)) {
            String[] produto = line.split(",");
            produtos.add(new Product(produto[0], Double.parseDouble(produto[1])));
            line = br.readLine();
        }
    }

    private static Double getMediaProdutos(List<Product> produtos){
        return produtos.stream()
                .map(Product::getPrice)
                .reduce((double) 0, Double::sum) / produtos.size();
    }

}
