import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Main {
    public static void main(String args[]) {
        getGUI();
    }

    private static void getGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Menu Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adding buttons
        JButton button = new JButton("Food");
        button.setBounds(50, 50, 100, 100);

        // adding label field
        JLabel label = new JLabel();
        label.setBounds(110, 50, 130, 30);

        // adding buttons to the JFrame
        frame.add(button);
        frame.setSize(300, 400);
        frame.setLayout(null); // change this to something to control layout
        frame.setVisible(true);

        // adding an action listener to button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("you clicked it!");

            }
        });
    }
}