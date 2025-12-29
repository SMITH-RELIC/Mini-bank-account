import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Print statements = new Print();
        Validator validator = new Validator();

        statements.introduction();
        int choice = validator.startValidator();
        if(choice == 1){
            statements.existingCustomer();
            validator.existingCustomer();
        } else {
            statements.newCustomer();
        }
        


    }
}