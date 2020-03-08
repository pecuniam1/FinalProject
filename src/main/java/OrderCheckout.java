package src.main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** Prepares the receipt
 * @author Kevin J. Kelly
 * @version 1.4
 */
class OrderCheckout {

    public static void checkout(ArrayList<MenuItem> itemsOrderedArray) {

        // first create the frame
        JFrame frame = new JFrame();
        final int app_width = ViewBuilder.SCREEN_WIDTH/2;
        final int app_height = ViewBuilder.SCREEN_HEIGHT/2;
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Close Out Order");
        frame.setSize(app_width/4, app_height);
        frame.setLocation(ViewBuilder.SCREEN_WIDTH-app_width-(app_width/8), ViewBuilder.SCREEN_HEIGHT-app_height-(app_height/2)); // centers the app

        //next create the panel
        ViewBuilder view = new ViewBuilder();
        JPanel panel = view.createPanel(new Rectangle(0, 0, app_width/4, app_height), Color.WHITE, new FlowLayout(FlowLayout.CENTER));

        frame.setSize(app_width/4, app_height);
        String[] header = view.getReceipt("header");
        String[] footer = view.getReceipt("footer");
        String array[] = new String[itemsOrderedArray.size()];
        for (int x = 0; x < itemsOrderedArray.size(); x++) {
            array[x] = (itemsOrderedArray.get(x).toString());
        }
        ArrayList<String> pricesArray = new ArrayList<>();
        float totalPrice = 0f;
        float totalPriceAfterTaxes = 0f;
        float totalTax = 0f;
        for (MenuItem item : itemsOrderedArray) {
            totalPrice += item.getCost();
        }
        totalTax = totalPrice * KevinProgram.TAX_PERCENT;
        totalPriceAfterTaxes = totalTax + totalPrice;
        pricesArray.clear();
        pricesArray.add(String.format("Pre Tax ........     $%.2f", totalPrice));
        pricesArray.add(String.format("Tax ..............     $%.2f", totalTax));
        pricesArray.add(String.format("Post Tax ......     $%.2f", totalPriceAfterTaxes));

        //convert pricesArray ArrayList to array
        String prices[] = new String[pricesArray.size()];
        for (int x = 0; x < pricesArray.size(); x++) {
            prices[x] = (pricesArray.get(x).toString());
        }

        JList<String> headerList = new JList<String>(header);
        JList<String> itemList = new JList<String>(array);
        JList<String> pricesList = new JList<String>(prices);
        JList<String> footerList = new JList<String>(footer);
        panel.add(headerList);
        panel.add(itemList);
        panel.add(pricesList);
        panel.add(footerList);

        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
