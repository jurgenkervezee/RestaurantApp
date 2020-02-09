package Restaurant.users;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class UserManager {
    private static UserManager instance = new UserManager();

    public static UserManager get() {
        return instance;
    }

    public static Users getCurrent() {
        return instance.currentUser;
    }

    private UserManager() {}

    private Users owner, waiter, chef;
    private Users currentUser;

    public Users createUser(String type, String name) {

        switch (type) {
            case "Owner":
                owner = new Owner(name);
                currentUser = owner;
                break;
            case "Chef":
                chef = new Chef(name);
                currentUser = chef;
                break;
            case "Waiter":
                waiter = new Waiter(name);
                currentUser = waiter;
                break;
        }
        return currentUser;
    }
}