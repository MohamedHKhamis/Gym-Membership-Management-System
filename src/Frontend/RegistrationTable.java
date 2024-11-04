package Frontend;

import Backend.MemberClassRegistration;
import Backend.MemberClassRegistrationDatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class RegistrationTable extends JFrame {
    JTable t;
    public RegistrationTable(MemberClassRegistrationDatabase database)
    {
        setTitle("View registratons");
        String[][] data = new String[database.returnAllRecords().size()][];
        int i = 0;
        for(MemberClassRegistration m : database.returnAllRecords())
            data[i++] = m.lineRepresentation().split(",");
        String[] columnNames = { "Member Id","Class Id", "Registration Date" };
        t = new JTable(data, columnNames);
        t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (!isSelected) {
                    if (row % 2 == 0) {
                        component.setBackground(Color.LIGHT_GRAY);
                    } else {
                        component.setBackground(Color.WHITE);
                    }
                } else {
                    component.setBackground(table.getSelectionBackground());
                }
                return component;
            }
        });
        t.setBounds(30, 40, 200, 300);
        t.setGridColor(new Color(255, 255, 255));
        JScrollPane sp = new JScrollPane(t);
        add(sp);
        setSize(800, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        MemberClassRegistrationDatabase database = new MemberClassRegistrationDatabase("src/Data/Registration.txt");
        database.readFromFile();
        new RegistrationTable(database);

    }
}
