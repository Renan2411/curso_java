import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExercicioPropostoSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> cursoA = new HashSet<>();
        Set<Integer> cursoB = new HashSet<>();
        Set<Integer> cursoC = new HashSet<>();

        estudantesCurso(sc, cursoA, "A");
        estudantesCurso(sc, cursoB, "B");
        estudantesCurso(sc, cursoC, "C");

        Set<Integer> alunos = new HashSet<>();

        alunos.addAll(cursoA);
        alunos.addAll(cursoB);
        alunos.addAll(cursoC);

        System.out.println("Total students: " + alunos.size());

        sc.close();
    }

    private static void estudantesCurso(Scanner sc, Set<Integer> curso, String nomeCurso) {
        int n;
        System.out.print(String.format("How many students for course %s: ", nomeCurso));
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            curso.add(sc.nextInt());
        }
    }

}
