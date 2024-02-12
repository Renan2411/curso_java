import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escrita {
    public static void main(String[] args) {
        String[] lines = new String[] {
                "A primeira linha",
                "A segunda linha",
                "A terceira linha",
                "A quarta linha",
                "A quinta linha"
        };

        String path = "/home/az/Área de Trabalho/curso_java/modulo-17/src/textos/novoArquivo.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){

            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }

        }catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
