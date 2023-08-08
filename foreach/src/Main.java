public class Main {
    public static void main(String[] args) {

        String[] vect = new String[] {"Renan", "Ana Paula", "Laísa"};

        //Laço For normal
        for(int i = 0; i < vect.length; i++){
            System.out.println(vect[i]);
        }

        System.out.println("-----------");

        //Laço Foreach - Para cara objeto obj, contido no vetor vect., faça
        for(String obj : vect){
            System.out.println(obj);
        }

    }
}