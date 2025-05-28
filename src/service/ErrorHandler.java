package service;

import exception.CoffeeMachineException;

public class ErrorHandler {
    public void handleError(CoffeeMachineException e) {
        System.out.println("Erreur : " + e.getMessage());
    }
}
