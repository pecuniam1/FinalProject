package src.test.java;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import src.main.java.MenuItem;
import src.main.java.MenuItemFactory;
import src.main.java.Drink;
import src.main.java.Food;

import org.junit.jupiter.api.Test;

class MyFirstJUnitJupiterTests {

    private final Food food = new Food("Hamburger", 3.5f);
    private final Drink drink = new Drink("Coffee", 2.75f, true);
    private final MenuItemFactory factory = new MenuItemFactory();

    @Test
    void factoryTest() {
        
    }

	@Test
    void groupedAssertions() { // all executed together
        assertAll("food",
            () -> assertEquals("Hamburger", food.getName()),
            () -> assertEquals(3.5f, food.getCost())
        );
        assertAll("drink",
            () -> assertEquals("Coffee", drink.getName()),
            () -> assertEquals(2.75f, drink.getCost()),
            () -> assertEquals(true, drink.isAlcohol())
        );
    }
}