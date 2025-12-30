import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Print statements = new Print();
        Choice choice = new Choice();

        statements.introduction();
        int choosed = choice.startValidator();
        if(choosed == 1){
            statements.existingCustomer();
            choice.existingCustomer();
        } else {
            statements.newCustomer();
            choice.newCustomer();
        }
        


    }
}