import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of taz payers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Taz payer #" + (i + 1) + " data: ");

            System.out.print("Individual or company (i/c): ");
            char typePerson = sc.next().charAt(0);

            sc.nextLine();

            System.out.print("Name: ");
            String nome = sc.nextLine();

            System.out.print("Anual Income: ");
            double gastoAnual = sc.nextDouble();

            if(typePerson == 'i'){
                System.out.print("Healt expenditures: ");
                double gastosSaude = sc.nextDouble();
                pessoas.add(new PessoaFisica(nome, gastoAnual, gastosSaude));
            }else{
                System.out.print("Number of emplyees: ");
                int numeroFuncionarios = sc.nextInt();
                pessoas.add(new PessoaJuridica(nome, gastoAnual, numeroFuncionarios));
            }
        }

        System.out.println("");
        System.out.println("TAXES PAID:");
        double totalTaxes = 0.0;

        for(Pessoa pessoa : pessoas){
            totalTaxes += pessoa.calcularImpostos();
            System.out.printf("%s: $ %.2f\n", pessoa.getNome(), pessoa.calcularImpostos());
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + totalTaxes);

    }
}