package Frontend;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import Backend.*;

public class test {
    JFrame f;
    JTable t;
    static MemberDatabase database;
    public test() {
        String[][] data = new String[database.returnAllRecords().size()][];
        int i = 0;
        for(Member m : database.returnAllRecords())
            data[i++] = m.lineRepresentation().split(",");
        String[] columnNames = { "Id","Name", "Email", "Membership Type", "Phone Number", "Status" };
        t = new JTable(data, columnNames);
        t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
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
        f = new JFrame("Alternating Row Color Table");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JScrollPane(t));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        database = new MemberDatabase("Members.txt");
        database.readFromFile();
        new test();
    }
}
