package Restaurant.restaurantApp;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class Product {

    private String description;
    private Double price;
    private int amount = 0;

    public Product(String description, Double price) {
        this.description = description;
        this.price = price;
    }

    public Product(String description, Double price, int amount){
        this.description = description;
        this.price = price;
        this.amount=amount;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public int getAmount(){
        return amount;
    }

    public void addAmount(){
        amount++;
    }

    public void delOneAmount(){
        amount--;
    }

    @Override
    public String toString() {
        return description;
    }
}


