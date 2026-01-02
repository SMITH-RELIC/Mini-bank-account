import java.util.ArrayList;

public class Account {
    private String accountHolder;
    static int accountNumber = 1000;
    private int accountPassword;
    private int bankBalance;
    private int lastWithdrawl;

    private ArrayList<Account> accounts = new ArrayList<>();

    void addAccount(Account account){
        accounts.add(account);
    }

    int getIndexOfAccount(Account account){
        return accounts.indexOf(account);
    }

    void deleteaccount(int index){
        accounts.remove(index);
    }

    void setbankBalance(int money){
        this.bankBalance = money;
    }
    String getAccountHolder(){
        return accountHolder;
    }
    Account ifaccountExists(int accountNumber){
        for(Account acc : accounts){
            if(acc.getaccountNumber() == accountNumber){
                return acc;
            }
        }
        System.out.println("Your account with account Number : " + accountNumber + " does not exists");

        return null;
    }

    int getaccountNumber(){
        return accountNumber;
    }
    
    void getAccountdetails(){
        System.out.println("The name of the account holder is : " + accountHolder);
        System.out.println("Your account number is : " + accountNumber);
        System.out.println("Your current bank balance is : " + bankBalance);
        System.out.println("Your last withdrawl money was Amount : " + lastWithdrawl);
    }

    void setAccoutDetails(String accountHolder){
        this.accountHolder = accountHolder;
    }

    void setPassword(int accountPassword){
        this.accountPassword = accountPassword;
    }

    int getAccountPassword(){
        return accountPassword;
    }
}
