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
        final MenuItem hamburger = factory.getMenuItem("hamburger", 3.75f);
        final MenuItem beer = factory.getMenuItem("beer", 2.50f);

        ArrayList<String> itemsOrderedArray = new ArrayList<String>();
        itemsOrderedArray.add("hamburger");
        itemsOrderedArray.add("hot dog");


        JFrame frame = createFrame();
        Insets insets = frame.getInsets();
        int titleBarSize = insets.top;

        
        JPanel leftPanel = createLeftPanel();
        JPanel rightPanel = createRightPanel();
        JPanel bottomPanel = createBottomPanel();

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

    private static JPanel createLeftPanel() {
        final JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 720, 540);
        leftPanel.setBackground(new Color(255,0,0)); // red
        leftPanel.setOpaque(true);
        final FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        leftPanel.setLayout(layout);
        return leftPanel;
    }

    /**
     * This function creates the right panel that holds
     * the ongoing list of menu items. It also holds the
     * 'Cancel Order' and 'Close Out' buttons.
     * @return
     */
    private static JPanel createRightPanel() {
        final JPanel rightPanel = new JPanel();
        rightPanel.setBounds(720, 0, 240, 440);
        rightPanel.setBackground(new Color(0,0,255)); // blue
        rightPanel.setOpaque(true);
        final GridLayout layout = new GridLayout(4, 1);
        rightPanel.setLayout(layout);
        return rightPanel;
    }

    private static JPanel createBottomPanel() {
        final JPanel rightPanel = new JPanel();
        rightPanel.setBounds(720, 440, 240, 100);
        rightPanel.setBackground(new Color(0,255,0)); // green
        rightPanel.setOpaque(true);
        rightPanel.setLayout(null);
        return rightPanel;
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