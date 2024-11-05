package Frontend;

import javax.swing.*;
import java.awt.*;

public class CancelRegistration extends JFrame {
    private JPanel Entry;
    private JTextField memberIdField;
    private JTextField classIdField;
    private JButton cancelRegistrationButton;
    public CancelRegistration() {
        setVisible(true);
        setSize(new Dimension(600, 400));
        setContentPane(Entry);
    }

    public JTextField getMemberIdField() {
        return memberIdField;
    }

    public JTextField getClassIdField() {
        return classIdField;
    }

    public JButton getCancelRegistrationButton() {
        return cancelRegistrationButton;
    }
}
