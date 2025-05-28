package service;

import exception.CoffeeMachineException;

public class PaymentProcessor {
    public void validation(String method, double amount, double price) throws CoffeeMachineException, CoffeeMachineException {
        if (!method.equalsIgnoreCase("CASH") && !method.equalsIgnoreCase("CARD")) {
            throw new CoffeeMachineException("Moyen de paiement invalide.");
        }
        if (amount < price) {
            throw new CoffeeMachineException("Solde insuffisant.");
        }
        System.out.println("Paiement validé.");
    }
}
