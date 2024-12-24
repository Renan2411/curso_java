import entities.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExercicioResolvidoSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path;
        Set<Usuario> usuarios = new HashSet<>();

        System.out.print("Enter file full path: ");
        path = sc.next();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line = bf.readLine();
            LocalDateTime date;

            while (line != null) {
                String[] fields = line.split(" ");

                //Conversão de uma String no formato ISO 8601 para LocalDateTime
                date = LocalDateTime.ofInstant(Instant.parse(fields[1]), ZoneId.systemDefault());

                usuarios.add(new Usuario(fields[0], date));
                line = bf.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(String.format("Total users: %d", usuarios.size()));

        sc.close();

    }
}
