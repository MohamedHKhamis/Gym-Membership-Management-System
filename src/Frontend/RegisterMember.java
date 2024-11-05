package Frontend;

import javax.swing.*;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.util.Calendar;
import java.util.Properties;

public class RegisterMember extends JFrame {
    private JPanel Entry;
    private JTextField memberIdField;
    private JTextField classIdField;
    private  JButton registerButton;
    private JPanel mainWindow;
    private  JDatePickerImpl datePicker;


    public RegisterMember() {
        setVisible(true);
        setSize(new Dimension(600, 500));
        setContentPane(Entry);
    }
    private void createUIComponents() {
        UtilDateModel model = new UtilDateModel();
        Calendar today = Calendar.getInstance();
        model.setDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
        model.setSelected(true);;
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }

    public JTextField getMemberIdField() {
        return memberIdField;
    }

    public JTextField getClassIdField() {
        return classIdField;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }
}
