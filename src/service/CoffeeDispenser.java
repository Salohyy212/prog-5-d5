package service;

import exception.CoffeeMachineException;
import model.Coffee;
import java.util.Random;

public class CoffeeDispenser {
    public void prepare(Coffee coffee) throws CoffeeMachineException {
        Random rand = new Random();
        if (rand.nextInt(10) < 1) throw new CoffeeMachineException("Blocage mécanique.");
        if (rand.nextInt(20) < 1) throw new CoffeeMachineException("Erreur de chauffage.");

        coffee.reductionStock();
        System.out.println("Préparation du café en cours...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        System.out.println("Veuillez récupérer votre boisson !");
    }
}
