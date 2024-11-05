package Frontend;

import Backend.*;
import Backend.Class;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class TrainerRoleBackend {
    private TrainerRole trainerRole;
    private TrainerRoleMenu trainerRoleMenu;
    public TrainerRoleBackend() {
        trainerRole = new TrainerRole();
        trainerRoleMenu = new TrainerRoleMenu();
        trainerRoleMenu.getAddMemberButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMember();
            }
        });
        trainerRoleMenu.getViewMemberButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainerRoleMenu.setVisible(false);
                MembersTable m = new MembersTable(trainerRole.getListOfMembers());
                m.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        trainerRoleMenu.setVisible(true);
                    }
                });

            }
        });
        trainerRoleMenu.getAddClassButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClass();
            }
        });
        trainerRoleMenu.getViewClassButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainerRoleMenu.setVisible(false);
                ClassesTable m = new ClassesTable(trainerRole.getListOfClasses());
                m.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        trainerRoleMenu.setVisible(true);
                    }
                });

            }
        });
        trainerRoleMenu.getRegisterMemberForClassButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        trainerRoleMenu.getCancelRegistrationButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelRegistration();
            }
        });
        trainerRoleMenu.getViewRegistratonsButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                trainerRoleMenu.setVisible(false);
                RegistrationTable m = new RegistrationTable(trainerRole.getListOfRegistrations());
                m.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        trainerRoleMenu.setVisible(true);
                    }
                });

            }
        });
        trainerRoleMenu.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
    }
    private void addMember() {
        trainerRoleMenu.setVisible(false);
        AddMember addMember = new AddMember();
        addMember.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                trainerRoleMenu.setVisible(true);
            }
        });
        addMember.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] data = new String[6];
                data[1] = addMember.getNameField().getText();
                data[2] = addMember.getEmailField().getText();
                data[0] = addMember.getIdField().getText();
                data[3] = addMember.getMembershipField().getText();
                data[4] = addMember.getPhoneNumberField().getText();
                data[5] = addMember.getStatusFeild().getText();
                for(String str : data) {
                    if (Objects.equals(str, "")) {
                        JOptionPane.showMessageDialog(null, "Please fill all the fields",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                Optional<Member> result = trainerRole.getListOfMembers().stream().
                        filter(record -> record.getSearchKey().equals(data[0])).findFirst();
                if(result.isPresent()) {
                    JOptionPane.showMessageDialog(null,
                            "The Member with Id = "+data[0]+" already exists!",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                if(!data[5].equalsIgnoreCase("active") && !data[5].equalsIgnoreCase("expired")) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid status!",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                trainerRole.addMember(data[0], data[1], data[2], data[3], data[4], data[5]);
                JOptionPane.showMessageDialog(null,
                        "The Member with Id = "+data[0]+" has added successfully");
                addMember.getIdField().setText("");
                addMember.getEmailField().setText("");
                addMember.getPhoneNumberField().setText("");
                addMember.getStatusFeild().setText("");
                addMember.getNameField().setText("");
                addMember.getMembershipField().setText("");
            }
        });
    }

    private void addClass() {
        trainerRoleMenu.setVisible(false);
        AddClass addClass = new AddClass();
        addClass.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                trainerRoleMenu.setVisible(true);
            }
        });
        addClass.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] data = new String[5];
                data[1] = addClass.getClassNameField().getText();
                data[2] = addClass.getEmailField().getText();
                data[0] = addClass.getClassIdField().getText();
                data[3] = addClass.getDurationField().getText();
                data[4] = addClass.getMaxparticipantsFeild().getText();
                for(String str : data) {
                    if (Objects.equals(str, "")) {
                        JOptionPane.showMessageDialog(null, "Please fill all the fields",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                Optional<Class> result = trainerRole.getListOfClasses().stream().
                        filter(record -> record.getSearchKey().equals(data[0])).findFirst();
                if(result.isPresent()) {
                    JOptionPane.showMessageDialog(null,
                            "The Class with Id = "+data[0]+" already exists!",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                if (!data[3].matches("\\d+")) {
                    JOptionPane.showMessageDialog(null,
                            "Duration should be an integer!",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                if (!data[4].matches("\\d+")) {
                    JOptionPane.showMessageDialog(null,
                            "Max Participants should be an integer!",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                trainerRole.addClass(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                JOptionPane.showMessageDialog(null,
                        "The Class with Id = "+data[0]+" has added successfully");
                addClass.getClassIdField().setText("");
                addClass.getClassNameField().setText("");
                addClass.getDurationField().setText("");
                addClass.getTrainerIdField().setText("");
                addClass.getMaxparticipantsFeild().setText("");
                addClass.getEmailField().setText("");
            }
        });
    }
    private void register() {
        trainerRoleMenu.setVisible(false);
        RegisterMember registerMember = new RegisterMember();
        registerMember.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                trainerRoleMenu.setVisible(true);
            }
        });
        registerMember.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] data = new String[2];
                data[0] = registerMember.getMemberIdField().getText();
                data[1] = registerMember.getClassIdField().getText();
                for(String str : data) {
                    if (Objects.equals(str, "")) {
                        JOptionPane.showMessageDialog(null, "Please fill all the fields",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                Optional<Member> result = trainerRole.getListOfMembers().stream().
                        filter(record -> record.getSearchKey().equals(data[0])).findFirst();
                if(result.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "The Member with Id = "+data[0]+" doesn't exists!",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                Optional<Class> result2 = trainerRole.getListOfClasses().stream().
                        filter(record -> record.getSearchKey().equals(data[1])).findFirst();
                if(result2.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "The Class with Id = "+data[1]+" doesn't exists!",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                Class c = result2.get();
                if(c.getAvailableSeats()==0){
                    JOptionPane.showMessageDialog(null,
                            "The class has no available seats!",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                Date d = (Date) registerMember.getDatePicker().getModel().getValue();
                LocalDate date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                boolean b = trainerRole.registerMemberForClass(data[0], data[1],date);
                if (!b){
                    JOptionPane.showMessageDialog(null,
                            "Error occurred try a again later",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                JOptionPane.showMessageDialog(null,
                        "The Member with Id = "+data[0]+" has been added successfully to class "+data[1]);
                registerMember.getMemberIdField().setText("");
                registerMember.getClassIdField().setText("");
            }
        });
    }

    private void cancelRegistration(){
        trainerRoleMenu.setVisible(false);
        CancelRegistration cancelRegistration = new CancelRegistration();
        cancelRegistration.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                trainerRoleMenu.setVisible(true);
            }
        });
        cancelRegistration.getCancelRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] data = new String[2];
                data[0] = cancelRegistration.getMemberIdField().getText();
                data[1] = cancelRegistration.getClassIdField().getText();
                for(String str : data) {
                    if (Objects.equals(str, "")) {
                        JOptionPane.showMessageDialog(null, "Please fill all the fields",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                Optional<MemberClassRegistration> result2 = trainerRole.getListOfRegistrations().stream().
                        filter(record -> record.getSearchKey().equals(data[0]+"+"+data[1])).findFirst();
                if(result2.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "No registration found with this data",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                boolean b = trainerRole.cancelRegistration(data[0], data[1]);
                if (!b){
                    JOptionPane.showMessageDialog(null,
                            "Error occurred try a again later",
                            "Message", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                JOptionPane.showMessageDialog(null,
                        "The Member with Id = "+data[0]+" has been unregistered from class "+data[1]);
                cancelRegistration.getMemberIdField().setText("");
                cancelRegistration.getClassIdField().setText("");

            }
    });
    }

    public void logout(){
        trainerRole.logout();
        trainerRoleMenu.dispose();
    }
    public TrainerRoleMenu getFrame() {
        return trainerRoleMenu;
    }
}
