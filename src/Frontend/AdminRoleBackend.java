package Frontend;

import Backend.AdminRole;
import Backend.MemberClassRegistration;
import Backend.Trainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;

public class AdminRoleBackend {
    private AdminRole adminRole;
    private AdminRoleWindow adminRoleWindow;;
    public AdminRoleBackend() {
        adminRole = new AdminRole();
        adminRoleWindow = new AdminRoleWindow();
        adminRoleWindow.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTrainer();
            }
        });
        adminRoleWindow.getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTrainer();

            }
        });
        adminRoleWindow.getButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminRoleWindow.setVisible(false);
                TrainersTable m = new TrainersTable(adminRole.getListOfTrainers());
                m.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        adminRoleWindow.setVisible(true);
                    }
                });

            }
        });
    }
    public void addTrainer(){
        adminRoleWindow.setVisible(false);
        AddTrainerWindow m = new AddTrainerWindow();
        m.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                adminRoleWindow.setVisible(true);
            }
        });
        m.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = m.getTextId().getText();
                String name = m.getTextName().getText();
                String email = m.getTextEmail().getText();
                String speciality = m.getTextSpeciality().getText();
                String phoneNumber = m.getTextNumber().getText();
                Optional<Trainer> result2 = adminRole.getListOfTrainers().stream().
                        filter(record -> record.getSearchKey().equals(id)).findFirst();
                if(result2.isPresent()) {
                    JOptionPane.showMessageDialog(null,
                            "Member with Id = "+id+"is present",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                if (id.isEmpty() || name.isEmpty() || email.isEmpty() || speciality.isEmpty() || phoneNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                    return;
                }
                if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address");
                    return;
                }
                if (!phoneNumber.matches("\\d{10,}")) {
                    JOptionPane.showMessageDialog(null, "Phone number must be at least 10 digits and contain only numbers");
                    return;

                }
                adminRole.addTrainer(id, name, email, speciality, phoneNumber);
                JOptionPane.showMessageDialog(null, "Trainer added Successfully");

                m.getTextId().setText("");
                m.getTextName().setText("");
                m.getTextEmail().setText("");
                m.getTextSpeciality().setText("");
                m.getTextNumber().setText("");
            }
        });
    }
    public void removeTrainer() {
        adminRoleWindow.setVisible(false);
        RemoveTrainerWindow removeTrainerWindow = new RemoveTrainerWindow();
        removeTrainerWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                adminRoleWindow.setVisible(true);
            }
        });
        removeTrainerWindow.getRemoveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainerId = removeTrainerWindow.getTextField1().getText();
                if (trainerId.isEmpty()) {
                    JOptionPane.showMessageDialog(adminRoleWindow, "Please enter trainer ID");
                    return;
                }
                Optional<Trainer> result2 = adminRole.getListOfTrainers().stream().
                        filter(record -> record.getSearchKey().equals(trainerId)).findFirst();
                if(result2.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "No trainer found with this ID",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                adminRole.removeTrainer(trainerId);
                JOptionPane.showMessageDialog(null, "Trainer removed");
                removeTrainerWindow.getTextField1().setText("");
            }
        });
    }

    public AdminRoleWindow getFrame(){
        return adminRoleWindow;
    }
    public JButton getLogoutButton() {
        return adminRoleWindow.getButton4();
    }
    public AdminRole getAdminRole() {
        return adminRole;
    }

}
