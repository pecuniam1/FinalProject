package src.main.java;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public String[] getReceipt(String type) {
        String[] returnText = {"error"};
        switch (type) {
            case "header":
                String[] header = {"Kevin Kellys Cookery House", "1025 Anyroad Dr", "Bolingbrook IL 60440", "630-756-5652","      ", "We will see you next Time!", "**************"};
                return header;
            case "footer":
                String[] footer = {"**************", "Open Mon-Fri 8am-7pm", "Sat 8am-10pm", "Closed Sundays"};
                return footer;
        }
        return returnText;
    }

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
