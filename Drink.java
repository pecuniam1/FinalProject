/** This is the Drink class that extends from MenuItem and defines all drinks.
 * @author Kevin J. Kelly
 * @version 2.5
 */
class Drink extends MenuItem {
	/**
	 * To indicate if the drink is alcoholic or not.
	 * Will require id if so.
	 */
    private boolean isAlcohol;

    public Drink(String name, float cost, boolean isAlcohol) {
        super.setName(name);
        super.setCost(cost);
        setIsAlcohol(isAlcohol);            
    }

    private void setIsAlcohol(boolean isAlcohol) {
        this.isAlcohol = isAlcohol;
    }

    public boolean getIsAlcohol() {
        return isAlcohol;
    }

    public boolean isAlcohol() {
        return this.isAlcohol;
    }
}
