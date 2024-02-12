import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Encapsula todo o processo de acessar o arquivo, além do seu caminho
        File file = new File("/home/az/Área de Trabalho/curso_java/modulo-17/src/textos/texto.txt");

        Scanner sc = null;
        //Ao tentar abrir o arquivo, pode ocorrer uma IOExecption

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

        } catch (IOException exception) {
            System.out.println("Error opening file: " + exception.getMessage());
        } finally {
            if (!Objects.isNull(sc))
                sc.close();
        }
    }
}