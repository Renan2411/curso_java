import entities.Produto;
import services.CalculationService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenericosDelimitados {

    public static void main(String[] args) {
        final String PATH = "src/produtos.txt";
        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line = br.readLine();
            while (line != null) {
                String[] produto = line.split(",");
                produtos.add(new Produto(produto[0], Double.parseDouble(produto[1])));
                line = br.readLine();
            }

            Produto x = CalculationService.max(produtos);
            System.out.println(x);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
