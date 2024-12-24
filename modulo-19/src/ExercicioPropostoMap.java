import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExercicioPropostoMap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path;
        Map<String, Double> candidatos = new HashMap<>();

        System.out.print("Enter file full path: ");
        path = sc.next();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line = bf.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String nome = fields[0];
                Double votos = Double.parseDouble(fields[1]);

                if (candidatos.containsKey(nome)) {
                    votos += candidatos.get(nome);
                }

                candidatos.put(nome, votos);
                line = bf.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(String key : candidatos.keySet()){
            System.out.println(key + ": " + candidatos.get(key));
        }

        System.out.println();

        sc.close();
    }

}
