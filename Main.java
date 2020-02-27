import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.*;

class Main {
    private static int screen_width = 1920;
    private static int screen_height = 1080;

    public static void main(String args[]) {
        MenuItemFactory factory = new MenuItemFactory();
        getGUI(factory);
    }

    private static void getGUI(MenuItemFactory factory) {
        ArrayList<MenuItem> itemsOrderedArray = new ArrayList<MenuItem>();
        MenuItem hamburger = factory.getMenuItem("hamburger", 3.75f);
        MenuItem beer = factory.getMenuItem("beer", 2.50f);
        System.out.println(hamburger);
        
        int app_width = screen_width/2;
        int app_height = screen_height/2;
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Menu Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Kevin POS");
        frame.setSize(app_width, app_height);
        frame.setLocation(screen_width-app_width-(app_width/2), screen_height-app_height-(app_height/2)); // centers the app

        // add the 2 JPanels
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(222,224,248)); // light blue
        rightPanel.setOpaque(true);
        rightPanel.setBounds(720,0,240,540);
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 720, 540);
        leftPanel.setBackground(new Color(255,0,0)); // red
        leftPanel.setOpaque(true);
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        leftPanel.setLayout(layout);
        frame.add(rightPanel);
        frame.add(leftPanel);


        // add stuff to right layout
        DefaultListModel<String> li = new DefaultListModel<>();
        li.addElement(hamburger.toString());
        li.addElement(beer.toString());
        JList<String> list = new JList<>(li);
        list.setBounds(0,0,240,540);
        rightPanel.add(list);


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
        frame.setLayout(null); // change this to something to control layout
        frame.setVisible(true);


    }
}