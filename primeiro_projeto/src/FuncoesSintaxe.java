import java.util.Scanner;

public class FuncoesSintaxe {

    public static void main(String args[]) {

        int a, b, c;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Three Number: ");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

       showResult(max(a, b, c));

        sc.close();
    }

    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        }

        return c;
    }

    public static void showResult(int higher) {
        System.out.println("Higher: " + higher);
    }

}
