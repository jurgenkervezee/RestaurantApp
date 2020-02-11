package Restaurant.restaurantApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static jdk.nashorn.internal.objects.NativeMath.round;

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

    public void addToOrder(Product product) {
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

        double sum = 0.00;
            for (Product product:orders){
              sum = sum + product.getPrice();
            }
        return round(sum, 2);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
