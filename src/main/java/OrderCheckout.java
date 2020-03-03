package src.main.java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OrderCheckout implements ActionListener {

    public OrderCheckout() {
        checkout();
    }

    public void checkout() {
        System.out.println("Checking out!");
        Popup p; // create a frame

        // first create the frame
        JFrame frame = new JFrame();
        final int app_width = Main.SCREEN_WIDTH/2;
        final int app_height = Main.SCREEN_HEIGHT/2;
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Close Out Order");
        frame.setSize(app_width/4, app_height);
        frame.setLocation(Main.SCREEN_WIDTH-app_width-(app_width/8), Main.SCREEN_HEIGHT-app_height-(app_height/2)); // centers the app

        //next create the panel
        JPanel panel = Main.createPanel(new Rectangle(0, 0, app_width/4, app_height), Color.RED, new FlowLayout());

        // add panel to frame
        // frame.add(panel);
        // frame.setLayout(null);
        frame.setVisible(true);

        // create popup
        PopupFactory pf = new PopupFactory();
        
        // create a popup
        p = pf.getPopup(frame, panel, 180, 100);
        
        // create a button
        JButton b = new JButton("click");
        b.addActionListener(this);
        
        // create a panel
        // JPanel p1 = new JPanel();
        
        // p1.add(b);
        // frame.add(p1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}