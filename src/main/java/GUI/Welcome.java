package GUI;

import javax.swing.*;
import java.awt.*;

public class Welcome {

    JFrame frame = new JFrame();
    JLabel welcome = new JLabel();

    Welcome() {
        welcome.setBounds(0,0,200,35);
        welcome.setFont(new Font(null,Font.PLAIN,25));
        frame.add(welcome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
