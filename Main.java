import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.*;

class Main {
    private static int screen_width = 1920;
    private static int screen_height = 1080;

    public static void main(final String args[]) {
        final MenuItemFactory factory = new MenuItemFactory();
        getGUI(factory);
    }

    private static void getGUI(final MenuItemFactory factory) {
        final ArrayList<MenuItem> itemsOrderedArray2 = new ArrayList<MenuItem>();
        MenuItem hamburger = factory.getMenuItem("Hamburger", 3.75f, MenuItem.FOOD);
        MenuItem beer = factory.getMenuItem("Beer", 2.50f, MenuItem.ALCOHOL);
        MenuItem pepsi = factory.getMenuItem("Pepsi", 2.50f, MenuItem.SOFT_DRINK);

        ArrayList<String> itemsOrderedArray = new ArrayList<String>();
        itemsOrderedArray.add("hamburger");
        itemsOrderedArray.add("hot dog");


        JFrame frame = createFrame();
        Insets insets = frame.getInsets();
        int titleBarSize = insets.top;

        
        JPanel leftPanel = createPanel(new Rectangle(0, 0, 720, 540), Color.RED, new FlowLayout(FlowLayout.LEFT));
        JPanel rightPanel = createPanel(new Rectangle(720, 0, 240, 440), Color.BLUE, new GridLayout(4, 1));
        JPanel bottomPanel = createPanel(new Rectangle(720, 440, 240, 100), Color.GREEN, null);


        // add panels to frame
        frame.add(rightPanel);
        frame.add(leftPanel);
        frame.add(bottomPanel);
        frame.setLayout(null);
        frame.setVisible(true);

        // itemizeBill(itemsOrderedArray, rightPanel);

        // add list to rightPanel.
        // rightPanel.add(new JLabel("name", JLabel.LEFT));


        //does not work
     
        // add stuff to right layout
        // final DefaultListModel<String> li = new DefaultListModel<>();
        // li.addElement(hamburger.toString());
        // li.addElement(beer.toString());
        // JList<String> list = new JList<>(li);
        // list.setBounds(0,0,0,0);
        // rightPanel.add(list);
        

        // add buttons to right panel
        // final JButton startOverButton = new JButton("Start Over");
        // startOverButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(final ActionEvent e) {
        //         System.out.println(list);
        //         list = null;

        //         System.out.println("buton pressed");
        //         System.out.println(list);
        //     }
        // });
        // startOverButton.setBounds(0,0,0,0);
        // rightPanel.add(startOverButton);


        // add buttons to leftPanel
        // for (String food : foods) {
        //     JButton button = new JButton(food);
        //     button.addActionListener(new ActionListener() {
        //         @Override
        //         public void actionPerformed(ActionEvent e) {
        //             System.out.println("You selected " + food);
        //         }
        //     });
        //     leftPanel.add(button);
        // }


    }

    // figure out how big title bar is
	/** This function creates the right, left, and bottm panels that hold the bill, order buttons, and execute buttons.
	 * @param rectangle The dimensions of the panel.
	 * @param color The color of the panel.
	 * @param layout The layout of the panel.
	 * @return The new panel.
	 */
    private static JPanel createPanel(Rectangle rectangle, Color color, LayoutManager layout) {
        final JPanel panel = new JPanel();
        panel.setBounds(rectangle);
        panel.setBackground(color);
        panel.setOpaque(true);
        panel.setLayout(layout);
        return panel;
    }


    private static JFrame createFrame() {
        final int app_width = screen_width/2;
        final int app_height = screen_height/2;
        final JFrame frame =  new JFrame();
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Kevin POS");
        frame.setSize(app_width, app_height);
        frame.setLocation(screen_width-app_width-(app_width/2), screen_height-app_height-(app_height/2)); // centers the app
        return frame;
	}
	
	/** This function will return the whole menu as an ArrayList. 
	 * @return The whole menu as an ArrayList
	 */
	private String getFullMenu() {
		String hotdog = "hot dog";
		return hotdog;
	}

    // private static void itemizeBill(ArrayList<String> itemsOrderedArray, JPanel rightPanel) {
    //     for(String food : itemsOrderedArray) {
    //         JLabel billItem = new JLabel(food, JLabel.CENTER);
    //         billItem.setForeground(Color.WHITE);
    //         rightPanel.add(billItem);
    //     }
    //     JButton completeOrderButton = new JButton("Complete Order");
    //     completeOrderButton.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             System.out.println("You selected complete order");
    //         }
    //     });
    //     JButton startOverButton = new JButton("Start Over");
    //     startOverButton.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             System.out.println("You selected start over");
    //             System.out.println(itemsOrderedArray);
    //             resetRightPanel(itemsOrderedArray, rightPanel);

    //         }
    //     });

    //     rightPanel.add(completeOrderButton);
    //     rightPanel.add(startOverButton);
    // }

    // private static void resetRightPanel(ArrayList<String> itemsOrderedArray, JPanel rightPanel) {
    //     itemsOrderedArray.clear();
    //     rightPanel.repaint();
    // }
}