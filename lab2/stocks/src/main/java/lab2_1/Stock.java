package lab2_1;

public class Stock {
    private double price;
    private int quantity;

    public Stock(String symbol, double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getValue() {
        return price * quantity;
    }
    
}
