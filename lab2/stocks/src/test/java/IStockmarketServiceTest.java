import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;

import lab2_1.IStockmarketService;
import lab2_1.Stock;
import lab2_1.StockPortfolio;


public class IStockmarketServiceTest {
    @Mock
    private IStockmarketService stockmarket = new IStockmarketService();

    @Test
    public void testGetTotalValue() {
        StockPortfolio portfolio = new StockPortfolio(stockmarket);
        Stock googleStock = new Stock("1", 10, 1);
        Stock microsoftStock = new Stock("2", 100, 1);

        portfolio.addStock(googleStock);
        portfolio.addStock(microsoftStock);

        double result = portfolio.getTotalValue();
        assertEquals(110, result, 0.01);
    }
}
