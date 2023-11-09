package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarketImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void mostValuableStock1() {
        Stock stock1 = new Stock(1000, "Stock1");
        Stock stock2 = new Stock(2000, "Stock2");
        Stock stock3 = new Stock(3000, "Stock3");

        StockMarketImpl market = new StockMarketImpl();
        market.add(stock3);
        market.add(stock1);
        market.add(stock2);

        assertEquals("Stock3", market.mostValuableStock().name());
    }

    @Test
    void mostValuableStock2() {
        Stock stock1 = new Stock(1000, "Stock1");
        Stock stock2 = new Stock(2000, "Stock2");
        Stock stock3 = new Stock(3000, "Stock3");

        StockMarketImpl market = new StockMarketImpl();
        market.add(stock3);
        market.add(stock1);
        market.add(stock2);
        market.remove(stock3);

        assertEquals("Stock2", market.mostValuableStock().name());
    }
}
