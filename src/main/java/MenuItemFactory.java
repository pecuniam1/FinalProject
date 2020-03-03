package src.main.java;
/** This is the MenuItemFactory. It produces all of the MenuItem objects.
 * @author Kevin J. Kelly
 * @version 2.0
 */
public class MenuItemFactory {

    public MenuItemFactory() {}

	/**
	 * This is the factory return method.
	 * @param name The name of the menu item.
	 * @param cost The cost of the item.
	 * @param type The type (soft drink, alcohol, or food).
	 * @return
	 */
    public MenuItem getMenuItem(String name, float cost, int type) {
        if(type == MenuItem.FOOD) {
            return new Food(name, cost);
        }
        if(type == MenuItem.SOFT_DRINK) {
            return new Drink(name, cost, false);
        }
        if(type == MenuItem.ALCOHOL) {
            return new Drink(name, cost, true);
        }
        return null;
    }
}
