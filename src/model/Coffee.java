package model;

public class Coffee {
    private final String name;
    private final double price;
    private int stock;

    public Coffee(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void reductionStock() {
        if (stock > 0) stock--;
    }
}
