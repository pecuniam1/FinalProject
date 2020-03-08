package src.test.java;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import src.main.java.Drink;
import src.main.java.Food;

import org.junit.jupiter.api.Test;

class MyTestRunner {
    
    @Test
    void groupedAssertions() { // all executed together
        Food food = new Food("Hamburger", 3.5f);
        Drink drink = new Drink("Coffee", 2.75f, true);
        // food
        assertAll("food",
            () -> assertEquals("Hamburger", food.getName()),
            () -> assertEquals(3.5f, food.getCost())
        );
        
        // drink
        assertAll("drink",
            () -> assertEquals("Coffee", drink.getName()),
            () -> assertEquals(2.75f, drink.getCost()),
            () -> assertEquals(true, drink.isAlcohol())
        );
    }
}