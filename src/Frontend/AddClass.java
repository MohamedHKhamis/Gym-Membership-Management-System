package Frontend;

import javax.swing.*;
import java.awt.*;

public class AddClass extends JFrame{
    private JPanel Entry;
    private JTextField classIdField;
    private JTextField classNameField;
    private JTextField trainerIdField;
    private JTextField emailField;
    private JTextField durationField;
    private JButton addButton;
    private JTextField maxparticipantsFeild;
    public AddClass() {
        setVisible(true);
        setSize(new Dimension(600, 700));
        setContentPane(Entry);
    }

    public JTextField getClassIdField() {
        return classIdField;
    }

    public JTextField getClassNameField() {
        return classNameField;
    }

    public JTextField getTrainerIdField() {
        return trainerIdField;
    }

    public JTextField getDurationField() {
        return durationField;
    }

    public JTextField getMaxparticipantsFeild() {
        return maxparticipantsFeild;
    }

    public JButton getAddButton() {
        return addButton;
    }
}
