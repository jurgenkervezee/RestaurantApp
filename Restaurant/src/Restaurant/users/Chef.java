package Restaurant.users;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class Chef extends Users {

    private String password = "Chef01";
    private String name;

    public Chef(String name) {
        this.name=name;
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
                return true;
            case "Orders":
                return true;
            case "Menu":
                return false;
        }
        return true;
    }
}
