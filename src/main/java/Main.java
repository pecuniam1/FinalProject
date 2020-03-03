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

class Main {
    public static int SCREEN_WIDTH = 1920;
    public static int SCREEN_HEIGHT = 1080;
    private static final int CANCEL_ORDER = 0;
    private static final int CHECK_OUT = 1;
    private static final float TAX_PERCENT = 0.035f;
    private static ArrayList<MenuItem> itemsOrderedArray = new ArrayList<MenuItem>();
    private static ArrayList<MenuItem> totalMenuItems = new ArrayList<MenuItem>();
    private static ArrayList<String> pricesArray = new ArrayList<>();


    public static void main(final String args[]) {
        getGUI();
    }

    private static void getGUI() {
        getFullMenu();
        JFrame frame = createFrame();

        JPanel leftPanel = createPanel(new Rectangle(0, 0, 720, 500), Color.RED, new FlowLayout(FlowLayout.LEFT));
        JPanel rightPanel = createPanel(new Rectangle(720, 0, 220, 400), Color.BLUE, new GridLayout(4, 1));
        JPanel pricePanel = createPanel(new Rectangle(720, 400, 220, 50), Color.MAGENTA, new GridLayout(3, 0));
        JPanel bottomPanel = createPanel(new Rectangle(720, 450, 220, 50), Color.GREEN, new FlowLayout());
        populateMenu(leftPanel, pricePanel);

        // add buttons
        addBottomButton("Cancel Order", Main.CANCEL_ORDER, bottomPanel, pricePanel);
        addBottomButton("Close Out", Main.CHECK_OUT, bottomPanel, pricePanel);

        // add stuff to price panel
        addPrices(pricePanel);

        // add panels to frame
        frame.add(rightPanel);
        frame.add(leftPanel);
        frame.add(pricePanel);
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

    /** This function updates the total prices.
     * @param panel The panel being updated (pricePanel in this case).
     */
    private static void addPrices(JPanel panel) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        float totalPrice = 0f;
        float totalPriceAfterTaxes = 0f;
        float totalTax = 0f;
        for (MenuItem item : itemsOrderedArray) {
            totalPrice += item.getCost();
        }
        totalTax = totalPrice * Main.TAX_PERCENT;
        totalPriceAfterTaxes = totalTax + totalPrice;

        pricesArray.clear();
        pricesArray.add(String.format("Pre Tax ........     $%.2f", totalPrice));
        pricesArray.add(String.format("Tax ..............     $%.2f", totalTax));
        pricesArray.add(String.format("Post Tax ......     $%.2f", totalPriceAfterTaxes));
        for (String price : pricesArray) {
            JLabel label = new JLabel(price);
            label.setFont(new Font("Arial", Font.PLAIN, 18));
            panel.add(label);
        }
    }

    private static void populateMenu(JPanel leftPanel, JPanel pricePanel) {
        for (MenuItem item : totalMenuItems) {
            System.out.println(item);
            addMenuButton(item, leftPanel, pricePanel);
            // addPrices(pricePanel);
        }
    }

    /**
     * This function adds the menu buttons to the left panel.
     * 
     * @param item The item being added.
     */
    private static void addMenuButton(MenuItem item, JPanel panel, JPanel pricePanel) {
        JButton button = new JButton(item.getName());
        button.setMargin(new Insets(10, 20, 10, 20));
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (item.isAlcohol()) {
                    String date = getOldEnoughDate();
                    int input = JOptionPane.showConfirmDialog(null, "Was this person born on or after " + date + "?");
                    if (input != 0) { // 0 = yes
                        return;
                    }
                }
                itemsOrderedArray.add(item);
                addPrices(pricePanel);
                System.out.println(item);
            }
        });
        panel.add(button);
    }
    

    /** This function creates the buttons.
     * 
     * @param label The button lable.
     * @param panel The panel to which the buttons are being added.
     */
    private static void addBottomButton(String label, int button_type, JPanel bottomPanel, JPanel pricePanel) {
        JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (button_type) {
                    case Main.CHECK_OUT:
                        new OrderCheckout();
                        break;
                    case Main.CANCEL_ORDER:
                        itemsOrderedArray.clear();
                        addPrices(pricePanel);
                        break;
                    default:
                        break;
                }
            }
        });
        bottomPanel.add(button);
    }

	/** This function creates the right, left, and bottm panels that hold the bill, order buttons, and execute buttons.
	 * @param rectangle The dimensions of the panel.
	 * @param color The color of the panel.
	 * @param layout The layout of the panel.
	 * @return The new panel.
	 */
    public static JPanel createPanel(Rectangle rectangle, Color color, LayoutManager layout) {
        final JPanel panel = new JPanel();
        panel.setBounds(rectangle);
        panel.setBackground(color);
        panel.setOpaque(true);
        panel.setLayout(layout);
        return panel;
    }

    /** This function creates the frame that the application lives in.
     * @return The created JFrame.
     */
    private static JFrame createFrame() {
        final int app_width = SCREEN_WIDTH/2;
        final int app_height = SCREEN_HEIGHT/2;
        final JFrame frame =  new JFrame();
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Kevin POS");
        frame.setSize(app_width, app_height);
        frame.setLocation(SCREEN_WIDTH-app_width-(app_width/2), SCREEN_HEIGHT-app_height-(app_height/2)); // centers the app
        return frame;
	}
	
    
    private static void itemizeBill(ArrayList<String> itemsOrderedArray, JPanel rightPanel) {
        for(String food : itemsOrderedArray) {
            JLabel billItem = new JLabel(food, JLabel.CENTER);
            billItem.setForeground(Color.WHITE);
            rightPanel.add(billItem);
        }
    }




    /****************************** finished *********************/

    /** This function will calculate and return the date 21 years ago from today.
     * @return The date 21 years ago.
     */
    private static String getOldEnoughDate() {
        Date today = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        calendar.add(Calendar.YEAR, -21);
        Date old_enough = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy");
        return sdf.format(old_enough);
    }

    /** This function will set the whole menu.
     * This function mimics what would happen if I were
     * querying a database, but it would be in a loop.
     * It is populating the totalMenuItems ArrayList.
    */
    private static void getFullMenu() {
        MenuItemFactory factory = new MenuItemFactory();
        totalMenuItems.add(factory.getMenuItem("Hot Dog", 2.99f, MenuItem.FOOD));
        totalMenuItems.add(factory.getMenuItem("Hamburger", 3.79f, MenuItem.FOOD));
        totalMenuItems.add(factory.getMenuItem("Gyros", 4.29f, MenuItem.FOOD));
        totalMenuItems.add(factory.getMenuItem("Pepsi", 1.99f, MenuItem.SOFT_DRINK));
        totalMenuItems.add(factory.getMenuItem("Diet Pepsi", 1.99f, MenuItem.SOFT_DRINK));
        totalMenuItems.add(factory.getMenuItem("Sprite", 1.99f, MenuItem.SOFT_DRINK));
        totalMenuItems.add(factory.getMenuItem("Regular Coffee", 2.49f, MenuItem.SOFT_DRINK));
        totalMenuItems.add(factory.getMenuItem("Decafe Coffee", 2.49f, MenuItem.SOFT_DRINK));
        totalMenuItems.add(factory.getMenuItem("Beer", 5.99f, MenuItem.ALCOHOL));
        totalMenuItems.add(factory.getMenuItem("Red Wine", 7.99f, MenuItem.ALCOHOL));
        totalMenuItems.add(factory.getMenuItem("White Wine", 7.99f, MenuItem.ALCOHOL));
    }
}