package service;

import exception.CoffeeMachineException;

public class InventoryManager {
    private int poudre = 10;
    private int eau = 10;
    private int gobelets = 10;
    private boolean electricite = true;
    private boolean panne = false;

    public void check() throws CoffeeMachineException {
        if (poudre <= 0) throw new CoffeeMachineException("Plus de poudre.");
        if (eau <= 0) throw new CoffeeMachineException("Réservoir vide.");
        if (gobelets <= 0) throw new CoffeeMachineException("Plus de gobelets.");
        if (!electricite) throw new CoffeeMachineException("Coupure d'électricité.");
        if (panne) throw new CoffeeMachineException("Panne de la machine.");
    }

    public void consume() {
        poudre--;
        eau--;
        gobelets--;
    }
}
