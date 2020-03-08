package src.main.java;

/** Food class
 * 
 */
public class Food extends MenuItem {
    public Food() {}
    public Food(String name, float cost) {
        super.setName(name);
        super.setCost(cost);
    }
}
