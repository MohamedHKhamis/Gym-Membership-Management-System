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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new AddMember();
    }
}
