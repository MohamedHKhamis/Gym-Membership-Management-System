package Frontend;

import Backend.ClassDatabase;
import Backend.Class;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;

public class ClassesTable extends JFrame{
    JTable t;
    public ClassesTable(List<Class> database)
    {
        setTitle("View members");
        String[][] data = new String[database.size()][];
        int i = 0;
        for(Class m : database)
            data[i++] = m.lineRepresentation().split(",");
        String[] columnNames = { "Class Id","Class Name", "Trainer Id", "Duration", "Max Participants"};
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
    }

}
