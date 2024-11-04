package Frontend;// Packages to import
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import Backend.*;

public class MembersTable extends JFrame {
    JFrame f;
    JTable t;
    public MembersTable(MemberDatabase database)
    {
        f = new JFrame();
        f.setTitle("View members");
        String[][] data = new String[database.returnAllRecords().size()][];
        int i = 0;
        for(Member m : database.returnAllRecords())
            data[i++] = m.lineRepresentation().split(",");
        String[] columnNames = { "Id","Name", "Email", "Membership Type", "Phone Number", "Status" };
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
        f.add(sp);
        f.setSize(800, 400);
        f.setVisible(true);
    }

    // Driver method
    public static void main(String[] args)
    {
        MemberDatabase database = new MemberDatabase("Members.txt");
        database.readFromFile();
        new MembersTable(database);

    }
}
