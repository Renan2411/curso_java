package exericios;

import entities.Room;

import java.util.Objects;
import java.util.Scanner;

public class Pensionato {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Room[] quartos = new Room[10];

        System.out.print("How many rooms will be rented: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.println("Rent #" + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Room: ");
            int room = sc.nextInt();

            quartos[room] = new Room(name, email);
        }

        System.out.println();

        for (int i = 0; i < quartos.length; i++) {
            if (!Objects.isNull(quartos[i])) {
                System.out.printf("%d: %s, %s\n", i, quartos[i].getName(), quartos[i].getEmail());

            }
        }
    }
}
