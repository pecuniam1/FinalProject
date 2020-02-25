import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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

        // add the JLabel
        JLabel foodListBox = new JLabel("Teste");
        foodListBox.setBackground(new Color(222,224,248)); // light blue
        foodListBox.setOpaque(true);
        foodListBox.setBounds(720,0,240,540);
        frame.add(foodListBox);

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