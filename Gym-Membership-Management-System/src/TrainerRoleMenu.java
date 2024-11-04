import javax.swing.*;
import java.awt.*;

public class TrainerRoleMenu extends JFrame {

    private JPanel panel1;
    private JButton addMemberButton;
    private JButton logoutButton;
    private JButton viewRegistratonsButton;
    private JButton cancelRegistrationButton;
    private JButton registerMemberForClassButton;
    private JButton viewClassButton;
    private JButton addClassButton;
    private JButton viewMemberButton;
    public TrainerRoleMenu() {
        setVisible(true);
        setSize(new Dimension(600, 700));
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TrainerRoleMenu();
    }
}

