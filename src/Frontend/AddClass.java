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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new AddClass();
    }
}
