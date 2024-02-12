import java.io.File;
import java.util.Scanner;

public class ManipulaPastas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        //File::isDirectors => Sintaxe de referência a métodos, funciona como função lambda
        File[] folders = path.listFiles(File::isDirectory);

        for(File folder : folders){
            System.out.println(folder);
        }

        System.out.println("ARQUIVOS");

        File[] files = path.listFiles(File::isFile);

        for(File file : files){
            System.out.println(file);
        }

        boolean sucess = new File(strPath + "/subDIR").mkdir();

        System.out.println("DIRETIÓRIO CRIADO: " + sucess);

        sc.close();
    }
}
