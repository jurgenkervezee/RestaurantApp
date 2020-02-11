package Restaurant.test;

import Restaurant.restaurantApp.Product;
import Restaurant.restaurantApp.RestaurantManager;
import Restaurant.restaurantApp.Tables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

class RestaurantManagerTest {

    @Test
    void getTableTest() {
        Tables table;
        table = RestaurantManager.get().getTable("table1");
        assertEquals(table.getName(),"Table 1");
    }

    @Test
    void getMenuTest() {
        ObservableList<Product> test = FXCollections.observableArrayList();
        test = RestaurantManager.get().getMenu();
        for (Product a:test)  {
            System.out.println(a.getDescription());
        }

    }
}