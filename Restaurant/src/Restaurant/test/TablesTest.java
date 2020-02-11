package Restaurant.test;

import Restaurant.restaurantApp.Product;
import Restaurant.restaurantApp.Tables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TablesTest {

    @Test
    void payBillTest() {

        Tables tables = new Tables("table1");
        Product product1 = new Product("HenkBier", 1.01);
        Product product2 = new Product("TruusBier", 2.02);
        tables.addToOrder(product1);
        tables.addToOrder(product2);
        double total;
        total = tables.payBill();
        assertEquals(3.03, total);
        tables.clearTable();
        assertNull(tables.getOrders());
    }

}