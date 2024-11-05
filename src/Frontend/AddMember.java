package Frontend;

import javax.swing.*;
import java.awt.*;

public class AddMember extends JFrame {
    private JPanel Entry;
    private JTextField IdField;
    private JTextField nameField;
    private JTextField membershipField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JButton addButton;
    private JTextField statusFeild;

    public AddMember() {
        setVisible(true);
        setSize(new Dimension(600, 700));
        setContentPane(Entry);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getIdField() {
        return IdField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getMembershipField() {
        return membershipField;
    }

    public JTextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public JTextField getStatusFeild() {
        return statusFeild;
    }
}
