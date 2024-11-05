package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage {
    private JPanel FirstPage;
    private JButton trainerRoleButton;
    private JButton adminRoleButton;


    public FirstPage(JFrame frame) {
        frame.setTitle("Gym System");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(FirstPage);
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
                frame.setVisible(false);
                new LoginPage();
            }
        });


        trainerRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
