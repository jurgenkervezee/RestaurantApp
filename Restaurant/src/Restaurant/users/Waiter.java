package Restaurant.users;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class Waiter extends Users {
    private String password = "Waiter01";
    private String name;

    public Waiter(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean verifyPassword(String value) {

        if (value.equals(password)){
            return true;
        }else return false;
        }

    @Override
    public boolean authorization(String type) {

        switch (type) {
            case "Restaurant":
                return false;
            case "Orders":
                return false;
            case "Menu":
                return true;
        }
        return true;
    }
}

