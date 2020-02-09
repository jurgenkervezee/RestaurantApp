package Restaurant.test;

import Restaurant.restaurantApp.RestaurantManager;
import Restaurant.users.UserManager;
import Restaurant.users.Users;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @Test
    void createUserTest() {
        Users currentuser;
        currentuser = UserManager.get().createUser("Owner", "Truus");
        assertEquals(currentuser.getName(), "Truus");
    }
}