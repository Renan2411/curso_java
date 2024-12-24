import entities.Client;

public class EqualsHashCode {

    public static void main(String[] args) {
        String a = "Renana";
        String b = "Renan";

//        System.out.println(a.equals(b));
//
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());

        Client c1 = new Client("renan@gmail.com", "Renan");
        Client c2 = new Client("renan@gmail.com", "Renan");

        String s1 = "Teste";
        String s2 = "Teste";

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c2.equals(c1));
        System.out.println(c1 == c2); //false pois "==" compara a referência de memória, exceto em tipos como o String
        System.out.println(s1 == s2);
    }

}
