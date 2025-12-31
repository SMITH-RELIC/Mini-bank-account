

public class Main {
    public static void main(String[] args) {
        

        Print statements = new Print();
        Choice choice = new Choice();
        Services services = new Services();

        services.setChoice(choice);
        choice.setServices(services);
        
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