import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        Account acc = new Account(1001, "Renan", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Ana Paula", 0.0, 500.0);

        //UPCASTING => Atribuir/Converter um filho para um pai
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Laísa", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Maju", 0.0, 0.01);

        //DOWNCASTING => Atribuir/Convertar um pai para um filho
        BusinessAccount acc4 = (BusinessAccount) acc2; //Não consigo realizar a conversão sem utilizar o casting; necessário forçar

        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("LOAN!");
        }

        if(acc3 instanceof SavingsAccount){
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

        //Sobreposição

        Account acc6 = new Account(1002, "Renan", 1000.0);
        acc6.withdraw(200.0);
        System.out.println(acc6.getBalance());

        Account acc7 = new SavingsAccount(1003, "ANA PAULA", 1000.0, 5.0);
        acc7.withdraw(200.0);
        System.out.println(acc7.getBalance());

        Account acc8 = new BusinessAccount(1004, "Talita", 1000.0, 500.0);
        acc8.withdraw(200.0);
        System.out.println(acc8.getBalance());

    }
}