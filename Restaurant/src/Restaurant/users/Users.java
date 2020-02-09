package Restaurant.users;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public abstract class Users {

    public abstract String getName();

    public abstract boolean verifyPassword(String value);

    public abstract boolean authorization(String type);
}
