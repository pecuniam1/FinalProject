package src.main.java;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.*;

import javax.swing.*;

/**
 * This is the Panel Class. It produces all of the panels.
 * 
 * @author Kevin J. Kelly
 * @version 2.0
 */
public class ViewBuilder {
    public static int SCREEN_WIDTH = 1920;
    public static int SCREEN_HEIGHT = 1080;

    public ViewBuilder() {}

    // public ArrayList<String> addPrices(ArrayList<MenuItem> items) {
    //     ArrayList<String> pricesArray = new ArrayList<>();
    //     float totalPrice = 0f;
    //     float totalPriceAfterTaxes = 0f;
    //     float totalTax = 0f;
    //     for (MenuItem item : items) {
    //         totalPrice += item.getCost();
    //     }
    //     totalTax = totalPrice * KevinProgram.TAX_PERCENT;
    //     totalPriceAfterTaxes = totalTax + totalPrice;

    //     pricesArray.clear();
    //     pricesArray.add(String.format("Pre Tax ........     $%.2f", totalPrice));
    //     pricesArray.add(String.format("Tax ..............     $%.2f", totalTax));
    //     pricesArray.add(String.format("Post Tax ......     $%.2f", totalPriceAfterTaxes));
    //     return pricesArray;
    // }

	/** This function creates the right, left, and bottm panels that hold the bill, order buttons, and execute buttons.
	 * @param rectangle The dimensions of the panel.
	 * @param color The color of the panel.
	 * @param layout The layout of the panel.
	 * @return The new panel.
	 */
    public JPanel createPanel(Rectangle rectangle, Color color, LayoutManager layout) {
        JPanel panel = new JPanel();
        panel.setBounds(rectangle);
        panel.setBackground(color);
        panel.setOpaque(true);
        panel.setLayout(layout);
        return panel;
    }

    /** This function creates the frame that the application lives in.
     * @return The created JFrame.
     */
    public JFrame createFrame() {
        int app_width = SCREEN_WIDTH/2;
        int app_height = SCREEN_HEIGHT/2;
        JFrame frame =  new JFrame();
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(KevinProgram.APP_NAME);
        frame.setSize(app_width, app_height);
        frame.setLocation(SCREEN_WIDTH-app_width-(app_width/2), SCREEN_HEIGHT-app_height-(app_height/2)); // centers the app
        return frame;
    }
    
    /**
     * 
     * @return
     */
    public JButton createButton(String label, int button_type, JPanel bottomPanel) {
        JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (button_type) {
                    case KevinProgram.CHECK_OUT:
                        new OrderCheckout();
                        break;
                    case KevinProgram.CANCEL_ORDER:
                        //itemsOrderedArray.clear();
                        // don't forget to reset age
                        // addPrices(pricePanel);
                        break;
                    default:
                        break;
                }
            }
        });
        return button;
    }

    /**
     * Creates a button that represents a menu item.
     * @param item The menu item being added to the button panel.
     * @return
     */
    public JButton createButton(MenuItem item) {
        JButton button = new JButton(item.getName());
        button.setMargin(new Insets(10, 20, 10, 20));
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        return button;
    }
}
