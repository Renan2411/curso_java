import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class leitura {
    public static void main(String[] args) {
        String path = "/home/az/Área de Trabalho/curso_java/modulo-17/src/textos/text.txt";

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            //Lendo uma linha, se estiver no final, retorna null
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            } 

        } catch (FileNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
