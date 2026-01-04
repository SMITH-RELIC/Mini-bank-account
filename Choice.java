import java.util.Scanner;

public class Choice {
    Account acc = new Account();
    Scanner sc = new Scanner(System.in);
    private Print statements;
    private Services service;
    

    void setprint(Print print){
        this.statements = print;
    }

    void setServices(Services service){
        this.service = service;
    }

    void mainMenu(){
        System.out.println("Select the corresponding Number for the specific Task");
        System.out.println("Enter 1 : If you are currently a customer of the bank");
        System.out.println("Enter 2: If you want to create a New bank account");
        int choosed = startValidator();
        if(choosed == 1){
            statements.existingCustomer();
            existingCustomer();
        } else {
            statements.newCustomer();
            newCustomer();
        }
    }
    
    int startValidator(){               
        int choice = sc.nextInt();
        if(choice == 1){
            return 1;
        } else if(choice == 2){
            return 2;
        } else {
            System.out.println("Please enter the correct number");
            startValidator();
            return 0;
        }
    }

    int accountNumber(){
        System.out.println("Enter your account number");
            int accountNumber = sc.nextInt();
            return accountNumber;
    }

    void existingCustomer(){       

        int choice = sc.nextInt();
        if(choice == 1){
          service.update(accountNumber());
        } else if (choice == 2) {
            service.delete(accountNumber());
        } else if (choice == 3) {
            service.deposit(accountNumber());
        } else if (choice == 4) {
            service.withDrawMoney(accountNumber());
        } else if (choice == 5) {
            service.fileAComplain();
        } else if(choice == 6) {
            acc.getAccountdetails();
        } else {
            System.out.println("Please enter the valid Number");
            existingCustomer();
        }
    }

    void newCustomer(){
        int choice = sc.nextInt();
        if(choice == 1){
            service.create();
        } else if (choice == 2){
            statements.printBankDetails();
        } else {
            System.out.println("Please enter the valid Number");
            newCustomer();
        }
    }
}
