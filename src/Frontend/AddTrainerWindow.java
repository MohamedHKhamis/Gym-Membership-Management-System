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
        setVisible(true);
        setContentPane(AddTrainerWindow);
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

    }

    public JTextField getTextName() {
        return textName;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getTextEmail() {
        return textEmail;
    }

    public JTextField getTextSpeciality() {
        return textSpeciality;
    }

    public JTextField getTextNumber() {
        return textNumber;
    }

    public JTextField getTextId() {
        return textId;
    }

    public void setBoxShape(JLabel box) {
        box.setBackground(new Color(153, 255, 153));
        box.setBorder(BorderFactory.createLineBorder(Color.black));
        box.setOpaque(true);
    }

}
