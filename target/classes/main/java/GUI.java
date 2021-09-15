
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GUI implements ActionListener {
    JButton login = new JButton("Login");
    JLabel welcomelabel = new JLabel();



    ImageIcon ic = new ImageIcon(getClass().getResource("img/logo_50.png"));

    Object panel;

        public void shit() {
            String[] options = {"Profile Lookup","Punishments","Reports","Economy"};
            JFrame f = new JFrame();
            welcomelabel.setBounds(125,250,250,35);
            welcomelabel.setFont(new Font(null,Font.ITALIC,25));


            login.setEnabled(true);


            login.addActionListener(this);
            login.setLayout(null);
            login.setVisible(true);
            login.setBounds(60,300,200,100);
            login.setText("Login");
            login.setFont(new Font(null,Font.BOLD,25));
            login.setBackground(Color.BLUE);


            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(420,420);
            f.setLayout(null);
            f.setVisible(true);
            f.add(login);
            f.add(welcomelabel);






        }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource()==login) {
                welcomelabel.setForeground(Color.BLUE);
                welcomelabel.setText("Login Successfull");




            }
    }
}
