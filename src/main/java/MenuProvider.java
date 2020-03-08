package src.main.java;

import java.util.ArrayList;

class MenuProvider {
    public static ArrayList<MenuItem> getFullMenu() {
        ArrayList<MenuItem> menuItemsArray = new ArrayList<MenuItem>();
        MenuItemFactory factory = new MenuItemFactory();
        menuItemsArray.add(factory.getMenuItem("Hot Dog", 2.99f, MenuItem.FOOD));
        menuItemsArray.add(factory.getMenuItem("Hamburger", 3.79f, MenuItem.FOOD));
        menuItemsArray.add(factory.getMenuItem("Gyros", 4.29f, MenuItem.FOOD));
        menuItemsArray.add(factory.getMenuItem("Pepsi", 1.99f, MenuItem.SOFT_DRINK));
        menuItemsArray.add(factory.getMenuItem("Diet Pepsi", 1.99f, MenuItem.SOFT_DRINK));
        menuItemsArray.add(factory.getMenuItem("Sprite", 1.99f, MenuItem.SOFT_DRINK));
        menuItemsArray.add(factory.getMenuItem("Regular Coffee", 2.49f, MenuItem.SOFT_DRINK));
        menuItemsArray.add(factory.getMenuItem("Decafe Coffee", 2.49f, MenuItem.SOFT_DRINK));
        menuItemsArray.add(factory.getMenuItem("Beer", 5.99f, MenuItem.ALCOHOL));
        menuItemsArray.add(factory.getMenuItem("Red Wine", 7.99f, MenuItem.ALCOHOL));
        menuItemsArray.add(factory.getMenuItem("White Wine", 7.99f, MenuItem.ALCOHOL));
        return menuItemsArray;
    }
}
