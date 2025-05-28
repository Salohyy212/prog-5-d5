import model.Coffee;
import service.*;
import exception.CoffeeMachineException;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Coffee> coffees = new ArrayList<>();
        coffees.add(new Coffee("Expresso", 1.5, 5));
        coffees.add(new Coffee("Cappuccino", 2.0, 5));
        coffees.add(new Coffee("Latte", 2.5, 5));

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        CoffeeSelector coffeeSelector = new CoffeeSelector();
        InventoryManager inventoryManager = new InventoryManager();
        CoffeeDispenser coffeeDispenser = new CoffeeDispenser();
        ErrorHandler errorHandler = new ErrorHandler();

        System.out.println(" -- Distributeur de café -- ");

        while (true) {
            try {
                // Choix
                System.out.println("Options disponibles :");
                for (Coffee c : coffees) {
                    System.out.printf("- %s : %.2f€ (stock: %d)%n", c.getName(), c.getPrice(), c.getStock());
                }

                System.out.print("\n1. Veuillez sélectionner votre café : ");
                String coffeeName = scanner.nextLine();

                Coffee selectedCoffee = coffeeSelector.selection(coffeeName, coffees);

                // Paiement
                System.out.println("2. La machine affiche : \"Veuillez payer\"");
                System.out.print("Méthode de paiement (CASH / CARD) : ");
                String method = scanner.nextLine();

                System.out.print("Montant inséré (€) : ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // flush

                paymentProcessor.validation(method, amount, selectedCoffee.getPrice());
                System.out.println("3. Paiement validé");

                // Vérification du stock
                System.out.println("4. La machine vérifie les stocks");
                inventoryManager.check();
                inventoryManager.consume();

                // Préparation
                System.out.println("5. Préparation du café en cours...");
                coffeeDispenser.prepare(selectedCoffee);

                // Distribution
                System.out.println("6. \"Veuillez récupérer votre boisson\"\n");

            } catch (CoffeeMachineException e) {
                errorHandler.handleError(e);
            }

            System.out.print("\nSouhaitez-vous un autre café ? (oui/non) : ");
            if (!scanner.nextLine().equalsIgnoreCase("oui")) {
                System.out.println("Merci d’avoir utilisé la machine !");
                break;
            }
        }

        scanner.close();
    }
}
