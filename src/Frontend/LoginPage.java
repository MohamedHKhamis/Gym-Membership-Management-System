package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

    private JButton loginButton;
    private JPasswordField passwordField1;
    private JTextField usernameField1;
    private JPanel LoginPage;
    private JLabel username;
    private JLabel password;

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
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        });
    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);

//        JOptionPane.showMessageDialog(
//                null,
//                "An error has occurred.",
//                "Error",
//                JOptionPane.ERROR_MESSAGE
//        );

    }
}
