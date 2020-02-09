package Restaurant.restaurantApp;

import Restaurant.io.MenuManager;
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

    public static Table getCurrent() {
        return instance.currentTable;
    }

    private final Table table1 = new Table("Table 1");
    private final Table table2 = new Table("Table 2");
    private final Table table3 = new Table("Table 3");
    private final Table table4 = new Table("Table 4");
    private final Table table5 = new Table("Table 5");
    private final Table table6 = new Table("Table 6");
    private final Table table7 = new Table("Table 7");
    private final Table table8 = new Table("Table 8");
    private final Table table9 = new Table("Table 9");
    private final Table bar = new Table("Bar");
    private Table currentTable;

    public Table getTable(String id){

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
    private static ArrayList<Product> menu;

    public ArrayList<Product> getMenu() {

        menuManager = new MenuManager();
        menu = menuManager.readMenuFile();
        return menu;
    }
}



