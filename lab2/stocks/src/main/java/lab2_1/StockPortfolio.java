package lab2_1;

import java.util.ArrayList;

public class StockPortfolio {
    private ArrayList<Stock> stocks;
    private IStockmarketService stockmarket;

    public StockPortfolio(IStockmarketService stockmarket) {
        this.stockmarket = stockmarket;
        stocks = new ArrayList<Stock>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double getTotalValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.getValue();
        }
        return totalValue;
    }
}