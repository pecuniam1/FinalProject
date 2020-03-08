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

class KevinProgram implements ActionListener {
    public static String APP_NAME = "Kevin Point O\'Sale";
    public static final int CANCEL_ORDER = 0;
    public static final int CHECK_OUT = 1;
    public static final float TAX_PERCENT = 0.035f;
    public static ArrayList<MenuItem> itemsOrderedArray = new ArrayList<MenuItem>();
    public static ArrayList<MenuItem> totalMenuItems = new ArrayList<MenuItem>();
    private static boolean OLD_ENOUGH;
    private static JPanel PRICE_PANEL = new JPanel();

    public KevinProgram() {
        totalMenuItems = MenuProvider.getFullMenu();
        ViewBuilder view = new ViewBuilder();
        JFrame frame = view.createFrame();
        JPanel leftPanel = view.createPanel(new Rectangle(0, 0, 720, 500), Color.RED, new FlowLayout(FlowLayout.LEFT));
        JPanel rightPanel = view.createPanel(new Rectangle(720, 0, 220, 400), Color.BLUE, new GridLayout(4, 1));
        KevinProgram.PRICE_PANEL = view.createPanel(new Rectangle(720, 400, 220, 50), Color.MAGENTA, new GridLayout(3, 0));
        JPanel bottomPanel = view.createPanel(new Rectangle(720, 450, 220, 50), Color.GREEN, new FlowLayout());
        
        // pricing add buttons
        JButton cancel_button = view.createButton("Cancel Order", KevinProgram.CANCEL_ORDER, bottomPanel);
        JButton close_out = view.createButton("Close Order", KevinProgram.CHECK_OUT, bottomPanel);
        cancel_button.addActionListener(this);
        close_out.addActionListener(this);
        bottomPanel.add(cancel_button);
        bottomPanel.add(close_out);

        // add menu items to left panel        
        for (MenuItem item : totalMenuItems) {
            JButton button = view.createButton(item);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (item.isAlcohol()) {
                        if (getOKToDrink() == false) {
                            String date = Drink.getOldEnoughDate();
                            int input = JOptionPane.showConfirmDialog(null, "Was this person born on or after " + date + "?");
                            if (input != 0) { // 0 = yes
                                return;
                            }
                            setOKToDrink(true);
                        }
                    }
                    itemsOrderedArray.add(item);
                    buildPricePanel();
                    System.out.println(item);
                }
            });
            leftPanel.add(button);
        };

        buildPricePanel();

        // add panels to frame
        frame.add(rightPanel);
        frame.add(leftPanel);
        frame.add(KevinProgram.PRICE_PANEL);
        frame.add(bottomPanel);
        frame.setLayout(null);
        frame.setVisible(true);

        // itemizeBill(itemsOrderedArray, rightPanel);

        // add list to rightPanel.
        // rightPanel.add(new JLabel("name", JLabel.LEFT));

        // does not work

        // add stuff to right layout
        // final DefaultListModel<String> li = new DefaultListModel<>();
        // li.addElement(hamburger.toString());
        // li.addElement(beer.toString());
        // JList<String> list = new JList<>(li);
        // list.setBounds(0,0,0,0);
        // rightPanel.add(list);

    }

    public void buildPricePanel() {
        resetPricePanel();
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
        for (String price : pricesArray) {
            JLabel label = new JLabel(price);
            label.setFont(new Font("Arial", Font.PLAIN, 18));
            KevinProgram.PRICE_PANEL.add(label);
        }
    }
    
    public void orderItem() {
        //resetPricePanel();
        ViewBuilder view = new ViewBuilder();
        //ArrayList<String> menuItems = view.addPrices(MenuProvider.getFullMenu());
        // for (String price : menuItems) {
        //     JLabel label = new JLabel(price);
        //     label.setFont(new Font("Arial", Font.PLAIN, 18));
        //     KevinProgram.PRICE_PANEL.add(label);
        // }
    }

    private void resetPricePanel() {
        KevinProgram.PRICE_PANEL.removeAll();
        KevinProgram.PRICE_PANEL.revalidate();
        KevinProgram.PRICE_PANEL.repaint();
    }

	
    
    private static void itemizeBill(ArrayList<String> itemsOrderedArray, JPanel rightPanel) {
        for(String food : itemsOrderedArray) {
            JLabel billItem = new JLabel(food, JLabel.CENTER);
            billItem.setForeground(Color.WHITE);
            rightPanel.add(billItem);
        }
    }

    /**
     * Sets the age back to zero after transaction is finished.
     */
    private static void setOKToDrink(boolean ok) {
        KevinProgram.OLD_ENOUGH = ok;
    }

    private static boolean getOKToDrink() {
        return KevinProgram.OLD_ENOUGH;
    }


    public void actionPerformed(ActionEvent ae) {
        String choice = ae.getActionCommand();
        switch (choice) {
            case "Close Order":
                // close order
                setOKToDrink(false);
                break;
            case "Cancel Order":
                JOptionPane.showMessageDialog(null, "Order Cancelled");
                itemsOrderedArray.clear();
                buildPricePanel();
                setOKToDrink(false);
                break;
            default:
                buildPricePanel();
                break;
        }
    }

    /**
     * Then entry for this program.
     * @param args
     */
    public static void main(final String args[]) {
        KevinProgram kp = new KevinProgram();
    }
}