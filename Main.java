import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

class Main {
    private static int screen_width = 1920;
    private static int screen_height = 1080;
    public static void main(String args[]) {
        getGUI();
    }

    private static void getGUI() {
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

        // add buttons to leftPanel
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        leftPanel.add(b1); leftPanel.add(b2);





        // adding buttons
        JButton button = new JButton("Food button");
        button.setBounds(50, 50, 100, 100);

        // adding buttons to the JFrame
        frame.add(button);
        frame.setLayout(null); // change this to something to control layout
        frame.setVisible(true);

        // adding an action listener to button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // do something
            }
        });
    }
}