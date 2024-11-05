package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Backend.*;

public class AddTrainerWindow extends JFrame {
    private JPanel AddTrainerWindow;
    private JButton addButton;
    private JTextField textName;
    private JTextField textEmail;
    private JTextField textId;
    private JTextField textSpeciality;
    private JTextField textNumber;
    private JLabel id;
    private JLabel email;
    private JLabel speciality;
    private JLabel number;
    private JLabel name;

    public AddTrainerWindow() {
        setTitle("Add Trainer");
        AdminRole adminRole = new AdminRole();
        setContentPane(AddTrainerWindow);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        addButton.setBackground(new Color(36, 36, 36));
        addButton.setForeground(Color.white);
        addButton.setOpaque(true);
        addButton.setContentAreaFilled(true);
        addButton.setBorderPainted(false);
        setBoxShape(name);
        setBoxShape(id);
        setBoxShape(speciality);
        setBoxShape(number);
        setBoxShape(email);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textId.getText();
                String name = textName.getText();
                String email = textEmail.getText();
                String speciality = textSpeciality.getText();
                String phoneNumber = textNumber.getText();
                if (id.isEmpty() || name.isEmpty() || email.isEmpty() || speciality.isEmpty() || phoneNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(AddTrainerWindow, "Please fill all the fields");
                    return;
                }
                if (!id.matches("\\d+")) {
                    JOptionPane.showMessageDialog(AddTrainerWindow, "ID must be numeric");
                    return;
                }
                if (!name.matches("[a-zA-Z ]+")) {
                    JOptionPane.showMessageDialog(AddTrainerWindow, "Name must contain only letters and spaces");
                    return;
                }
                if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(AddTrainerWindow, "Please enter a valid email address");
                    return;
                }
                if (!phoneNumber.matches("\\d{10,}")) {
                    JOptionPane.showMessageDialog(AddTrainerWindow, "Phone number must be at least 10 digits and contain only numbers");
                    return;

                }else{
                    AdminRoleWindow.admin.addTrainer(id, name, email, speciality, phoneNumber);
                    dispose();
                }
                textId.setText("");
                textName.setText("");
                textEmail.setText("");
                textSpeciality.setText("");
                textNumber.setText("");
            }
        });
    }
    public void setBoxShape(JLabel box) {
        box.setBackground(new Color(153, 255, 153));
        box.setBorder(BorderFactory.createLineBorder(Color.black));
        box.setOpaque(true);
    }

    public static void main(String[] args) {
        AddTrainerWindow window = new AddTrainerWindow();
        window.setVisible(true);
    }
}
