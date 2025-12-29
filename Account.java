public class Account {
    private String accountHolder;
    private int accountNumber;
    private int accountPassword;
    private int bankBalance;
    private int lastWithdrawl;

    void getAccountdetails(){
        System.out.println("The name of the account holder is : " + accountHolder);
        System.out.println("Your account number is : " + accountNumber);
        System.out.println("Your current bank balance is : " + bankBalance);
        System.out.println("Your last withdrawl money was Amount : " + lastWithdrawl);
    }

    void setAccoutDetails(String accountHolder, int accountNumber){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    void setPassword(int accountPassword){
        this.accountPassword = accountPassword;
    }
}
