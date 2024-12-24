import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExemploStream {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> st1 = list.stream().map(num -> num * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("Renan", "Laísa", "Ede");
        System.out.println(Arrays.toString(st2.toArray()));

        //Cria elementos, a partir de um inicial. Potencialmente infinita
        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        Stream<Long> st4 = Stream.iterate(new Long[]{0L, 1L}, x -> new Long[]{x[1], x[0] + x[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(20).toArray()));

    }

}
