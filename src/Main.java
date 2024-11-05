import Frontend.*;
import Inferance.LoginCredentials;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {
        FirstPage window = new FirstPage();
        window.getAdminRoleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                LoginPage login = new LoginPage();
                login.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        window.setVisible(true);
                    }
                });
                login.getLoginButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String userName = login.getUsernameField1().getText();
                        String password = new String(login.getPasswordField1().getPassword());
                        if (userName.equals(LoginCredentials.ADMIN_USERNAME) && password.equals(LoginCredentials.ADMIN_PASSWORD)) {
                            login.dispose();
                            AdminRoleBackend adminRoleBackend= new AdminRoleBackend();
                            adminRoleBackend.getFrame().addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosing(WindowEvent e) {
                                    adminRoleBackend.logout();
                                    window.setVisible(true);
                                }
                            });
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong username or password");
                        }
                    }
                });
            }
        });

        window.getTrainerRoleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                LoginPage login = new LoginPage();
                login.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                window.setVisible(true);
            }
        });
                login.getLoginButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String userName = login.getUsernameField1().getText();
                        String password = new String(login.getPasswordField1().getPassword());
                        if (userName.equals(LoginCredentials.TRAINER_USERNAME) && password.equals(LoginCredentials.TRAINER_PASSWORD)) {
                            login.dispose();
                            TrainerRoleBackend trainerRoleBackend= new TrainerRoleBackend();
                            trainerRoleBackend.getFrame().addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosing(WindowEvent e) {
                                    trainerRoleBackend.logout();
                                    window.setVisible(true);
                                }
                            });
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong username or password");
                        }
                    }
                });
            }
        });


    }
}
