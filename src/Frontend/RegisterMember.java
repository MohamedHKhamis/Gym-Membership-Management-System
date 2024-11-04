package Frontend;

import javax.swing.*;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.util.Properties;

public class RegisterMember extends JFrame {
    private JPanel Entry;
    private JTextField memberIdField;
    private JTextField classIdField;
    private JButton registerButton;
    private JDatePickerImpl datePicker;
    private JDatePicker j;


    public RegisterMember() {
        // TODO: place custom component creation code here
        // Set up the date picker
        setVisible(true);
        setSize(new Dimension(600, 500));
        setContentPane(Entry);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        JFrame frame = new RegisterMember();
    }
}
