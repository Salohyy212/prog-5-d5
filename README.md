# CoffeeMachine - Fonctionnement & Modélisation 

Ce projet modélise le fonctionnement d’un distributeur de café.  
Il se compose de trois étapes principales : **payer**, **choisir un café**, puis **la récupérer**.  
Nous décrivons ici les **use cases**, les **erreurs possibles**, et la **modélisation**.

---

## Fonctionnement

1. **Paiement**  
   L'utilisateur utilise un moyen de paiement.  
     - Si le montant est suffisant, la machine passe à l’étape suivante.

2. **Choix**  
   L'utilisateur sélectionne une boisson parmi les choix présents.

3. **Récupération**  
   La machine prépare la boisson choisie.  
     - L'utilisateur la récupère.

---

## Use Cases

| Nom        | Description                                |
|------------|--------------------------------------------|
| Payer   | Vérifier et valider le paiement            |
| Choisir      | Afficher les cafés disponibles et valider le choix |
| Récupérer  | Préparer et délivrer la boisson choisie    |

---

## Erreurs possibles

 | Étape concernée | Description                               |
 |-----------------|-------------------------------------------|
 | Paiement             | Montant insuffisant                       |
 | Choix           | Boisson non disponible                    |
 | Récupération       | Problème technique pendant la préparation |

---

## Modélisation

### Structure des packages

```
src/
├── model/
│   └── Coffee.java               // Représente un café (nom, prix, stock)
│
├── service/
│   ├── PaymentService.java       // Vérifie que l’argent entré est suffisant
│   ├── CoffeeService.java        // Liste les cafés disponibles, vérifie le stock
│   └── DispenserService.java     // Prépare le café (simulation), gère les erreurs techniques

│
├── controller/
│   └── CoffeeMachine.java        // Classe principale (main), orchestre les étapes
│
├── exception/                    // Contient les erreurs spécifiques (paiement insuffisant, rupture, etc).
│   ├── PaymentException.java
│   ├── CoffeeUnavailableException.java
│   └── MachineException.java
```

