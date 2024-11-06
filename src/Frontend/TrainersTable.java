package Frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;

import Backend.*;
import Inferance.*;

public class TrainersTable extends JFrame {
    private JTable t;

    public TrainersTable(List<Trainer> database) {
        setTitle("View Trainers");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String[] columnNames = { "Id", "Name", "Email", "Speciality", "Phone Number" };

        // Retrieve data from database
        String[][] rows = new String[database.size()][5];
        int i =0;
        for(Trainer trainer: database) {
            rows[i]= trainer.lineRepresentation().split(",");
            i++;
        }
        t = new JTable(rows, columnNames);

        // Set alternate row colors
        t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    component.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
                } else {
                    component.setBackground(table.getSelectionBackground());
                }
                return component;
            }
        });

        JScrollPane sp = new JScrollPane(t);
        add(sp, BorderLayout.CENTER);

        setSize(800, 400);
        setVisible(true);
    }

}
