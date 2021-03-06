package src.main.java;
/** This is the MenuItem superclass that extends to all menu items including food and drinks.
 * @author Kevin J. Kelly
 * @version 2.5
 */
public class MenuItem {
	/**
	 * A flag to indicate that the item is a soft drink.
	 */
	public static final int SOFT_DRINK = 1; 

	/**
	 * A flag to indicate that the item is alcohol.
	 */
	public static final int ALCOHOL = 2; 

	/**
	 * A flag to indicat that the item is food.
	 */
	public static final int FOOD = 3; 

	/**
	 * The name of the MenuItem.
	 */
	protected String name;
	
	/**
	 * The cost of the MenuItem.
	 */
    protected float cost;
    
    public void setName(String name) {
        this.name = name;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCost() {
        return this.cost;
    }

    public String getName() {
        return this.name;
	}
	
	public boolean isAlcohol() {
		return false;
	}

    public String toString() {
        return String.format("%s $%.2f", this.name, this.cost);
    }
}
