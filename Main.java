
public class Main {

    public static void main(String[] args) {
        

        Print statements = new Print();
        Choice choice = new Choice();
        Services services = new Services();
        Account account = new Account();

        services.setAccount(account);
        services.setChoice(choice);
        choice.setServices(services);
        choice.setprint(statements);
        
        statements.introduction();
        choice.mainMenu();
        

    }
}