public abstract class Drink extends MenuItem {

    float getCost() {
        return 0;
    }

    String getName() {
        return null;
    }

    public abstract boolean isAlcohol();
}