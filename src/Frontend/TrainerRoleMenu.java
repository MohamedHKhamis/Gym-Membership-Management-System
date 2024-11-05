package Frontend;

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
    }

    public JButton getAddMemberButton() {
        return addMemberButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JButton getViewRegistratonsButton() {
        return viewRegistratonsButton;
    }

    public JButton getCancelRegistrationButton() {
        return cancelRegistrationButton;
    }

    public JButton getRegisterMemberForClassButton() {
        return registerMemberForClassButton;
    }

    public JButton getViewClassButton() {
        return viewClassButton;
    }

    public JButton getAddClassButton() {
        return addClassButton;
    }

    public JButton getViewMemberButton() {
        return viewMemberButton;
    }
}

