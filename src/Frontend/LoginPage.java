package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Inferance.LoginCredentials;

public class LoginPage extends JFrame {

    private JButton loginButton;
    private JPasswordField passwordField1;
    private JTextField usernameField1;
    private JPanel LoginPage;
    private JLabel username;
    private JLabel password;

    public LoginPage() {
    setTitle("Login");
    setVisible(true);
    setSize(700, 500);
    setContentPane(LoginPage);
    username.setBackground(new Color(153, 255, 153));
    password.setBackground(new Color(153, 255, 153));
    username.setBorder(BorderFactory.createLineBorder(Color.black));
    password.setBorder(BorderFactory.createLineBorder(Color.black));
    username.setOpaque(true);
    password.setOpaque(true);
    loginButton.setBackground(new Color(36,36,36));
    loginButton.setForeground(Color.white);
    loginButton.setPreferredSize(new Dimension(200, 40));
    loginButton.setOpaque(true);
    loginButton.setContentAreaFilled(true);
    loginButton.setBorderPainted(false);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public JTextField getUsernameField1() {
        return usernameField1;
    }
}
