class MenuItemFactory {

    public MenuItem getMenuItem(String name, float cost) {
        if (name == null) {
            return null;
        }
        if(name == "hamburger") {
            return new Food(name, cost);
        }
        if(name == "hotdog") {
            return new Food(name, cost);
        }
        if(name == "coffee") {
            return new Drink(name, cost, false);
        }
        if(name == "beer") {
            return new Drink(name, cost, true);
        }
        return null;
    }
}