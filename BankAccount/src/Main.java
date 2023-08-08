import entities.Account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Account account;
        String name, numberAccount;
        double deposit;
        String hasInitialDeposit;

        System.out.print("Enter account number: ");
        numberAccount = sc.nextLine();

        System.out.print("Enter account holder: ");
        name = sc.nextLine();

        System.out.print("Is there an initial deposit (y/n): ");
        hasInitialDeposit = sc.nextLine();

        if(hasInitialDeposit.equals("y")){
            System.out.print("Enter initial deposit value: ");
            deposit = sc.nextDouble();

            account = new Account(name, numberAccount, deposit);
        }else{
            account = new Account(name, numberAccount);
        }

        System.out.println(account.toString());

        System.out.print("Enter a deposit value: ");
        deposit = sc.nextDouble();
        account.deposit(deposit);

        System.out.println("Updated account data: ");
        System.out.println(account.toString());

        System.out.print("Enter a withdraw value: ");
        deposit = sc.nextDouble();
        account.withdraw(deposit);

        System.out.println("Updated account data: ");
        System.out.println(account.toString());

        sc.close();
    }
}