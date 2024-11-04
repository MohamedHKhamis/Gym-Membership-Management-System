package Frontend;

import javax.swing.*;
import java.awt.*;

public class cancelRegistration extends JFrame {
    private JPanel Entry;
    private JTextField memberIdField;
    private JTextField classIdField;
    private JButton cancelRegistrationButton;
    public cancelRegistration() {
        setVisible(true);
        setSize(new Dimension(600, 400));
        setContentPane(Entry);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new cancelRegistration();
    }
}
