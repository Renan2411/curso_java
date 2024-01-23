import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Account> list = new ArrayList<>();

//        Account acc1 = new Account(1001, "Renan", 1000.0);
        Account acc2 = new SavingsAccount(1002, "Ana Paula", 1000.0, 0.01);
        Account acc3 = new BusinessAccount(1003, "Laása", 1000.0, 500.0);

        list.add(acc2);
        list.add(acc3);
        list.add(new SavingsAccount(1002, "Ede", 1000.0, 0.01));
        list.add(new BusinessAccount(1003, "Talita", 1000.0, 500.0));

        double sum = 0.0;
        for(Account acc : list){
            sum += acc.getBalance();
        }

        System.out.printf("Total: %.2f\n", sum);

        for(Account acc : list){
            acc.deposit(10.0);
            System.out.printf("Update Balance account %d = %.2f\n", acc.getNumber(), acc.getBalance());
        }
    }
}