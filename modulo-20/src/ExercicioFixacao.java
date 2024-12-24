import entities.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ExercicioFixacao {

    public static void main(String[] args) {
        String path = "/home/renan/Documentos/curso_java/modulo-20/src/funcionarios.txt";
        List<Funcionario> funcionarios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            popularListaFuncionarios(funcionarios, br);

            System.out.println("Digite um valor: ");
            Double valor = sc.nextDouble();

            funcionarios.stream()
//                    .sorted((f1, f2) -> f1.getEmail().compareTo(f2.getEmail()))//forma manual
                    .sorted(Comparator.comparing(Funcionario::getEmail)) //Com method reference
                    .filter(funcionario -> funcionario.getSalario() >= valor)
                    .map(Funcionario::getEmail)
                    .forEach(System.out::println);

            Double somaTotal = funcionarios.stream()
                    .filter(funcionario -> funcionario.getNome().charAt(0) == 'M')
                    .map(Funcionario::getSalario)
                    .reduce(0.0, Double::sum);

            System.out.println(somaTotal);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void popularListaFuncionarios(List<Funcionario> funcionarios, BufferedReader br) throws IOException {
        String line = br.readLine();
        while (Objects.nonNull(line)) {
            String[] fields = line.split(",");
            funcionarios.add(new Funcionario(fields[0], fields[1], Double.parseDouble(fields[2])));
            line = br.readLine();
        }
    }

}
