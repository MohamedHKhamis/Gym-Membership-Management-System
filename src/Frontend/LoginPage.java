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
    private boolean succ=false;
    public LoginPage() {
    setTitle("Login");
    setSize(700, 500);
    setContentPane(LoginPage);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField1.getText();
                String password = new String(passwordField1.getPassword());
                if (username.equals(LoginCredentials.ADMIN_USERNAME) && password.equals(LoginCredentials.ADMIN_PASSWORD)) {
                   succ=true;
                    dispose();
                    new AdminRoleWindow().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Wrong username or password");
                }
            }
        });
    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }
}
