import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryResources {
    public static void main(String[] args) {
        String path = "/home/az/Área de Trabalho/curso_java/modulo-17/src/textos/texto.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
