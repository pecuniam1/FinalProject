package src.main.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This is the Drink class that extends from MenuItem and defines all drinks.
 * 
 * @author Kevin J. Kelly
 * @version 2.5
 */
public class Drink extends MenuItem {
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
    
    /** This function will calculate and return the date 21 years ago from today.
     * @return The date 21 years ago.
     */
    public static String getOldEnoughDate() {
        Date today = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        calendar.add(Calendar.YEAR, -21);
        Date old_enough = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy");
        return sdf.format(old_enough);
    }
}
