public class OperacoesString {

    public static void main(String[] args) {
        String original = "abcde ASDGFSD fsdfsd SDFSFD aaaaa ABC abc  ";

        String s01 = original.toLowerCase();
        String s02 = original.toUpperCase();
        String s03 = original.trim();
        String s04 = original.substring(2);
        String s05 = original.substring(2, 9);
        String s06 = original.replace("a", "x");
        String s07 = original.replace("abc", "xy");

        System.out.println("Original : -" + original + "-");
        System.out.println("Tudo Minúscula: " + s01);
        System.out.println("Tudo Maiúscula: " + s02);
        System.out.println("Sem Espaços : -" + s03 + "-");
        System.out.println("Substring(2) : -" + s04 + "-");
        System.out.println("Substring(2, 9) : -" + s05 + "-");
        System.out.println("replace(a, x) : -" + s06 + "-");
        System.out.println("replace(abc, xy) : -" + s07 + "-");


        System.out.println();

        //Split

        String s = "potato apple lemon";
        String[] vect = s.split("at");

        for (String word: vect) {
            System.out.println(word);
        }

    }

}
