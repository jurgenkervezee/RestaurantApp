package Restaurant.restaurantApp;

import java.util.ArrayList;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class Tables {

    private String name;
    private ArrayList<String> orders;

    public Tables(String name) {
        this.name = name;
        orders = new ArrayList<String>();
    }

    public String getName(){
        return name;
    }

    public void addOrders(String value) {
        orders.add(value);
    }

    public ArrayList<String> getOrders(){
        return orders;
    }

    public void clearTable(){
        name= "";
        orders.clear();
    }

    public Double payBill() {

        Double value = 0.00;
//        for (int i = 0; i < orders.size(); i++)
//            value += orders.get(i);

        return value;
    }
}
