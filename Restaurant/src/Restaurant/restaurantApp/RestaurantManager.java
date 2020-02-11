package Restaurant.restaurantApp;

import Restaurant.io.MenuManager;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class RestaurantManager {
    private static RestaurantManager instance = new RestaurantManager();

    public static RestaurantManager get() {
        return instance;
    }

    public static Tables getCurrent() {
        return instance.currentTable;
    }

    private final Tables table1 = new Tables("Table 1");
    private final Tables table2 = new Tables("Table 2");
    private final Tables table3 = new Tables("Table 3");
    private final Tables table4 = new Tables("Table 4");
    private final Tables table5 = new Tables("Table 5");
    private final Tables table6 = new Tables("Table 6");
    private final Tables table7 = new Tables("Table 7");
    private final Tables table8 = new Tables("Table 8");
    private final Tables table9 = new Tables("Table 9");
    private final Tables bar = new Tables("Bar");
    private Tables currentTable;

    public Tables getTable(String id){

        switch (id) {
            case "table1":
                currentTable = table1;
                break;
            case "table2":
                currentTable = table2;
                break;
            case "table3":
                currentTable = table3;
                break;
            case "table4":
                currentTable = table4;
                break;
            case "table5":
                currentTable = table5;
                break;
            case "table6":
                currentTable = table6;
                break;
            case "table7":
                currentTable = table7;
                break;
            case "table8":
                currentTable = table8;
                break;
            case "table9":
                currentTable = table9;
                break;
            case "bar":
                currentTable = bar;
                break;
        }
        return currentTable;
    }

    private MenuManager menuManager;
    private static ObservableList<Product> menu;

    public ObservableList<Product> getMenu() {

        menuManager = new MenuManager();
        menu =  menuManager.readMenuFile();
        return menu;
    }
}



