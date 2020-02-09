package Restaurant.test;

import Restaurant.users.Chef;
import Restaurant.users.Owner;
import Restaurant.users.Waiter;
import Restaurant.users.Users;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

class UserTest {

    @org.junit.jupiter.api.Test
    void checkPasswordCorrectWaiter() {

        Waiter waiter = new Waiter("Henk");
        assertTrue(waiter.verifyPassword("Waiter01"));
    }
    @org.junit.jupiter.api.Test
    void checkPasswordCorrectOwner() {

        Users owner = new Owner("Henk");
        assertTrue(owner.verifyPassword("Owner01"));
    }
    @org.junit.jupiter.api.Test
    void checkPasswordCorrectChef() {

        Users chef = new Chef("Henk");
        assertTrue(chef.verifyPassword("Chef01"));
    }

    @org.junit.jupiter.api.Test
    void checkPasswordIncorrect() {

        Waiter waiter = new Waiter("Henk");
        assertFalse(waiter.verifyPassword("welkom01"));
    }
    @org.junit.jupiter.api.Test
    void checkNameWaiter() {

        Users ober = new Waiter("Henk");
        assertEquals("Henk", ober.getName());
    }
    @org.junit.jupiter.api.Test
    void checkNameOwner() {

        Users owner = new Owner("Henk");
        assertEquals("Henk", owner.getName());
    }
    @org.junit.jupiter.api.Test
    void checkNameChef() {

        Users chef = new Chef("Henk");
        assertEquals("Henk", chef.getName());
    }
}