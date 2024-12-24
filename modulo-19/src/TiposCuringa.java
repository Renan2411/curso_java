import java.util.Arrays;
import java.util.List;

public class TiposCuringa {
    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<String> myStrings = Arrays.asList("1", "2"," 3"," 4");
        printList(myInts);
        printList(myStrings);
    }

    public static void printList(List<?> list){
        for(Object elem: list){
            System.out.println(elem);
        }
    }
}
