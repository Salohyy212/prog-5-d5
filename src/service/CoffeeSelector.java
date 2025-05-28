package service;

import exception.CoffeeMachineException;
import model.Coffee;
import java.util.List;

public class CoffeeSelector {
    public Coffee select(String name, List<Coffee> options) throws CoffeeMachineException {
        return options.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new CoffeeMachineException("Café indisponible."));
    }
}
