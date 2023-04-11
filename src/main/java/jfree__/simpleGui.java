package jfree__;

import javax.swing.*;
import java.awt.*;

public class simpleGui extends JFrame {

    public static JFrame frameDefault(String nameTable, int width, int height) {
        JFrame frame = new JFrame(nameTable);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        return frame;
    }

    public static void scrollDefault(JTable table, JFrame frame, int width, int height) {
        JScrollPane scroll = new JScrollPane(table);
        frame.setLocationRelativeTo(null);
        table.setPreferredScrollableViewportSize(new Dimension(width, height));
        frame.getContentPane().add(scroll);
        frame.setVisible(true);

    }
}
