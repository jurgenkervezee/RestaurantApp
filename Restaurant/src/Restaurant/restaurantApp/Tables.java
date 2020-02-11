package Restaurant.restaurantApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class Tables {

    private String name;
    private ObservableList<Product> orders = FXCollections.observableArrayList();

    public Tables(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addOrders(Product product) {
        orders.add(product);
    }

    public ObservableList<Product> getOrders(){
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
