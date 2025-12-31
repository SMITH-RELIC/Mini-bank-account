import java.util.Scanner;

public class Choice {
    Account acc = new Account();
    Scanner sc = new Scanner(System.in);
    private Print print;
    private Services service;

    void setprint(Print print){
        this.print = print;
    }

    void setServices(Services service){
        this.service = service;
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

    void existingCustomer(){
        int choice = sc.nextInt();
        if(choice == 1){
            System.out.println("Enter your account number");
            byte accountNumber = sc.nextByte();
            service.update(accountNumber);

        } else if (choice == 2) {
            service.delete();
        } else if (choice == 3) {
            service.disable();
        } else if (choice == 4) {
            service.fileAComplain();
        } else if(choice == 5) {
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
            print.printBankDetails();
        } else {
            System.out.println("Please enter the valid Number");
            newCustomer();
        }
    }
}
