import java.util.Scanner;

public class Services{

    Scanner sc = new Scanner(System.in);

    void create(){
        Account acc = new Account();
        
        System.out.println("Enter your name :");
        String accountHolder = sc.next();

        System.out.println("Enter your password (Your password pin should be 8 letters)");

        int accountPassword = sc.nextInt();
        if (accountPassword >= 10000000 && accountPassword <= 99999999 ) {
            System.out.println("Valid password");
        } else {
            System.out.println("Password must be exactly 8 digits");
            return;
        }
        
        acc.setAccoutDetails(accountHolder);
        acc.setPassword(accountPassword);
        Account.accountNumber++;
        acc.addAccount(acc);
        System.out.println("You're bank account is been created, Successfully");
    }

    void update(){

    }

    void delete(){

    }

    void disable(){

    }

    void fileAComplain(){

    }

    void createAccount(){

    }
}
