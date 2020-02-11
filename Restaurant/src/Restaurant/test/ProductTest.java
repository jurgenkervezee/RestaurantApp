package Restaurant.test;

import Restaurant.restaurantApp.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getDescriptionAndPrice() {
        Product product = new Product("HenkBier", 1.01);
        assertEquals("HenkBier",product.getDescription());
        assertEquals(1.01, product.getPrice());
    }

    @Test
    void getDescriptionAndPriceAndAmount() {
        Product product = new Product("TruusBier", 99.01, 24);
        assertEquals("TruusBier",product.getDescription());
        assertEquals(99.01, product.getPrice());
        assertEquals(24, product.getAmount());
    }
}