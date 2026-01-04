import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Services{

    Scanner sc = new Scanner(System.in);
    Account account;
    
    private Choice choice;

    void setAccount(Account account){
        this.account = account;
    }
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
        account.addAccount(acc);
        System.out.println("You're bank account is been created, Successfully");
        System.out.println("You're account number is " + account.accountNumber );
        choice.mainMenu();
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
            System.out.println("USER FOUND. Enter the password for authentication");
            int userpassword = sc.nextInt();
            
            if(userAccount.getAccountPassword() == userpassword){
                System.out.println("Enter 1 : To Update the account Holder name. ");
                System.out.println("Enter 2 : To Update the account Password. ");
                updater(userAccount);
            }
        } else {
            System.out.println("You're account does not exists with the given Account Number");
            System.out.println();
            choice.mainMenu();
        }
    }

    void updater(Account userAccount){
        byte updateWhat = sc.nextByte();
        if(updateWhat == 1){
            System.out.println("Enter the new Account holder name : ");
            String updateHolderName = sc.next();
            userAccount.setAccoutDetails(updateHolderName);
            choice.mainMenu();
        } else if(updateWhat == 2){
            int newPassword = passwordvalidator();
            if(newPassword == 0){
                System.out.println("The password updation failed, Please retry again");
            } else{
                System.out.println("Your password Updation is successful ");
                System.out.println("Please DO NOT SHARE your new password, that might put your account into DANGER!!!");
                System.out.println("THANK YOU");
                userAccount.setPassword(newPassword);
            }
            choice.mainMenu();
        }
    }

    void delete(int accountNumber){
        if(account.ifaccountExists(accountNumber) != null){
            Account userAccount = account.ifaccountExists(accountNumber);
            System.out.println("USER FOUND. Enter the password for authentication");
            int userpassword = sc.nextInt();
            
            if(userAccount.getAccountPassword() == userpassword){
                accountDeleter(userAccount);
            }
        } else {
            System.out.println("You're account does not exists with the given Account Number");
            System.out.println();
            choice.mainMenu();
        }
        
    }
    
    void accountDeleter(Account userAccount){
        System.out.println("Enter 1 : FOR DELETION OF YOUR ACCOUNT");
        System.out.println("Enter 2 : TO CANCEL THE DELETION OF YOUR ACCOUNT");   
        byte todelete = sc.nextByte();
        if(todelete == 1){
            int accountIndex = account.getIndexOfAccount(userAccount);
            account.deleteaccount(accountIndex);
            choice.mainMenu();
        } else {
            System.out.println("The process is been cancelled, Your account is remains intacted");
            choice.mainMenu();
        }

    }
    void deposit(int userAccountNumber){
       if(account.ifaccountExists(userAccountNumber) != null){
            Account userAccount = account.ifaccountExists(userAccountNumber);
            System.out.println("USER FOUND. Enter the password for authentication");
            int userpassword = sc.nextInt();
            
            if(userAccount.getAccountPassword() == userpassword){
                System.out.println("This account belongs to " + userAccount.getAccountHolder());
                System.out.println("Enter the ammount you want to deposit in this bank");
                int ammount = sc.nextInt();
                System.out.println("Are you sure to deposit AMOUNT " + ammount + " to the " + userAccount.getAccountHolder() + "'s Name");
                System.out.println("Enter 1 : TO CONFIRM THIS TRANSACTION");
                byte lastconfirmation = sc.nextByte();
                if(lastconfirmation == 1){
                    userAccount.updatebankBalance(ammount);
                    choice.mainMenu();
                } else {
                    System.out.println("The transaction is been cancelled, redirecting towards the Main Menu");
                    choice.mainMenu();
                }
                
            }
        } else {
            System.out.println("You're account does not exists with the given Account Number");
            System.out.println();
            choice.mainMenu();
        } 
    }

    void withDrawMoney(int userAccountNumber){
        if(account.ifaccountExists(userAccountNumber) != null){
            Account userAccount = account.ifaccountExists(userAccountNumber);
            System.out.println("USER FOUND. Enter the password for authentication");
            int userpassword = sc.nextInt();
            
            if(userAccount.getAccountPassword() == userpassword){
                System.out.println("This account belongs to " + userAccount.getAccountHolder());
                System.out.println("Enter the ammount you want to Withdraw from this bank account");
                int ammount = sc.nextInt();
                System.out.println("Are you sure to withdraw AMOUNT " + ammount);
                System.out.println("Enter 1 : TO CONFIRM THIS TRANSACTION");
                byte lastconfirmation = sc.nextByte();
                if(lastconfirmation == 1){
                    userAccount.withdrawlbankBalance(ammount);
                    System.out.println("The amount "+ ammount + " is been withdrawn");
                    choice.mainMenu();
                } else {
                    System.out.println("The transaction is been cancelled, redirecting towards the Main Menu");
                    choice.mainMenu();
                }
                
            }
        } else {
            System.out.println("You're account does not exists with the given Account Number");
            System.out.println();
            choice.mainMenu();
        } 
    }

    void disable(){

    }

    void fileAComplain() {
    System.out.println("Please file your complaint, we will look forward to solve it as soon as possible: ");

    String compliants = sc.nextLine();

    try (PrintWriter writer = new PrintWriter(new FileWriter("Complaint.txt", true))) {
        writer.println(compliants);
        choice.mainMenu();
    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
        System.out.println("The compliant file resulted in failure, Please try again. Or Directly contact us.");
        choice.mainMenu();
        return;
    }

    System.out.println("The complaint has been filed successfully.");
    System.out.println("Sorry for the inconvenience. We look forward to your cooperation.");
}       
}
