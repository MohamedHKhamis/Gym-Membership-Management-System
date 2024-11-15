package Frontend;

import Backend.AdminRole;
import Backend.TrainerDatabase;
import Inferance.FileNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRoleWindow extends JFrame {
    private JPanel AdminRoleWindow;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;


    public AdminRoleWindow() {
        setVisible(true);
        setTitle("Admin Role");
        setContentPane(AdminRoleWindow);
        AdminRoleWindow.setBackground(new Color(215, 217, 223));
        setSize(700,500);
        button1.setBackground(new Color(36,36,36));
        button1.setForeground(Color.white);
        button1.setPreferredSize(new Dimension(200, 40));
        button1.setOpaque(true);
        button1.setContentAreaFilled(true);
        button1.setBorderPainted(false);
        button2.setBackground(new Color(36,36,36));
        button2.setForeground(Color.white);
        button2.setPreferredSize(new Dimension(200, 40));
        button2.setOpaque(true);
        button2.setContentAreaFilled(true);
        button2.setBorderPainted(false);
        button3.setBackground(new Color(36,36,36));
        button3.setForeground(Color.white);
        button3.setPreferredSize(new Dimension(200, 40));
        button3.setOpaque(true);
        button3.setContentAreaFilled(true);
        button3.setBorderPainted(false);
        button4.setBackground(new Color(36,36,36));
        button4.setForeground(Color.white);
        button4.setPreferredSize(new Dimension(200, 40));
        button4.setOpaque(true);
        button4.setContentAreaFilled(true);
        button4.setBorderPainted(false);

    }

    public JButton getButton4() {
        return button4;
    }

    public JButton getButton3() {
        return button3;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton1() {
        return button1;
    }
}
