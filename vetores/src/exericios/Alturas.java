package exericios;

import entities.Person;

import java.util.Scanner;

public class Alturas {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n, menoresDeDezesseis = 0;
        double somaAlturas = 0;
        System.out.print("Quantas pessoas serão digitadas: ");
        n = sc.nextInt();

        Person[] pessoas = new Person[n];

        for (int i = 0; i < pessoas.length; i++) {
            sc.nextLine();
            System.out.printf("Dados da %da pessoa: \n", i + 1);

            System.out.print("Nome: ");
            String name = sc.nextLine();

            System.out.print("Idade: ");
            int idade = sc.nextInt();

            System.out.print("Altura: ");
            double altura = sc.nextDouble();

            pessoas[i] = new Person(name, idade, altura);

            somaAlturas += altura;

            if (idade < 16) {
                menoresDeDezesseis++;
            }
        }

        System.out.printf("Altura Média: %.2f\n", somaAlturas / pessoas.length);

        double percent = (double) (menoresDeDezesseis * 100 / pessoas.length);

        System.out.printf("Pessoas com menos de 16 anos: %.2f\n", percent);

        for (Person pessoa : pessoas) {
            if (pessoa.getAge() < 16.0) {
                System.out.println(pessoa.getName());
            }
        }

    }

}
