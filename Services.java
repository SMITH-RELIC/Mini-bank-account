import java.util.Scanner;

public class Services{

    Scanner sc = new Scanner(System.in);
    Account account = new Account();
    
    private Choice choice;

    void setChoice(Choice choice){
        this.choice = choice;
    }
    
    void create(){
        Account acc = new Account();
        
        System.out.println("Enter your name :");
        String accountHolder = sc.next();

        int accountPassword = passwordvalidator();
        if(accountPassword == 0){
            return;
        }
        acc.setAccoutDetails(accountHolder);
        acc.setPassword(accountPassword);
        Account.accountNumber++;
        acc.addAccount(acc);
        System.out.println("You're bank account is been created, Successfully");
        System.out.println("You're account number is " + acc.accountNumber );
    }

    int passwordvalidator(){
        System.out.println("Enter your password (Your password pin should be 8 letters)");
        int accountPassword = sc.nextInt();
        if (accountPassword >= 10000000 && accountPassword <= 99999999 ) {
            System.out.println("Valid password");
            return accountPassword;
        } else {
            System.out.println("Password must be exactly 8 digits");
            System.out.println("Password setting Failed");
            return 0;
        }
    }

    void update(int accountNumber){
        if(account.ifaccountExists(accountNumber) != null){
            Account userAccount = account.ifaccountExists(accountNumber);
            int userpassword = sc.nextInt();
            
            if(userAccount.getAccountPassword() == userpassword){
                System.out.println("Enter 1 : To Update the account Holder name. ");
                System.out.println("Enter 2 : To Update the account Password. ");
                updater(userAccount);
            }
        } else {
            System.out.println("You're account does not exists with the given Account Number");
            System.out.println();
            // choice.existingCustomer();
        }
    }

    void updater(Account userAccount){
        byte updateWhat = sc.nextByte();
        if(updateWhat == 1){
            String updateHolderName = sc.next();
            userAccount.setAccoutDetails(updateHolderName);
        } else if(updateWhat == 2){
            int newPassword = passwordvalidator();
            if(newPassword == 0){
                return;
            } else{
                userAccount.setPassword(newPassword);
            }
        }
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
