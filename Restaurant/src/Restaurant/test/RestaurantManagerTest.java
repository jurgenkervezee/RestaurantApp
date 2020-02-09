package Restaurant.test;

import Restaurant.restaurantApp.Product;
import Restaurant.restaurantApp.RestaurantManager;

import Restaurant.restaurantApp.Tables;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        ArrayList<Product> test = new ArrayList<Product>();
        test = RestaurantManager.get().getMenu();
        for (Product a:test)  {
            System.out.println(a.getDescription());
        }

    }
}