package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Frontend.AdminRoleWindow.admin;

public class RemoveTrainerWindow extends JFrame {
    private JPanel Remove;
    private JTextField textField1;
    private JButton removeButton;
    private JLabel trainerId;

    public RemoveTrainerWindow() {
        setTitle("Remove Trainer");
        setContentPane(Remove);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 150);
        trainerId.setBackground(new Color(153, 255, 153));
        trainerId.setBorder(BorderFactory.createLineBorder(Color.black));
        trainerId.setOpaque(true);
        removeButton.setSize(120,50);
        removeButton.setBackground(new Color(36, 36, 36));
        removeButton.setForeground(Color.white);
        removeButton.setOpaque(true);
        removeButton.setContentAreaFilled(true);
        removeButton.setBorderPainted(false);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainerId = textField1.getText();
            admin.removeTrainer(trainerId);
            dispose();
            }
        });
    }

    public static void main(String[] args) {
        RemoveTrainerWindow window = new RemoveTrainerWindow();
        window.setVisible(true);
    }
}
