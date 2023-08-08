import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        int x = 10;

        Object obj = x;
        Integer objInt = x;

        System.out.println(obj);

        int y = (int) obj;
        int z = objInt;

        System.out.println(y);
        System.out.println(z);

    }
}