package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends JFrame{
    private JPanel FirstPage;
    private JButton trainerRoleButton;
    private JButton adminRoleButton;



    public FirstPage() {
        setTitle("Gym System");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(FirstPage);
        trainerRoleButton.setBackground(new Color(36,36,36));
        trainerRoleButton.setForeground(Color.white);
        trainerRoleButton.setPreferredSize(new Dimension(200, 40));
        trainerRoleButton.setOpaque(true);
        trainerRoleButton.setContentAreaFilled(true);
        trainerRoleButton.setBorderPainted(false);
        adminRoleButton.setBackground(new Color(36,36,36));
        adminRoleButton.setForeground(Color.white);
        adminRoleButton.setPreferredSize(new Dimension(200, 40));
        adminRoleButton.setOpaque(true);
        adminRoleButton.setContentAreaFilled(true);
        adminRoleButton.setBorderPainted(false);
        adminRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        trainerRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        FirstPage firstPage = new FirstPage();
        firstPage.setVisible(true);

    }
}
