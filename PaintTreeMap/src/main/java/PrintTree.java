import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PrintTree {
    public static void print(String path) {
        try {
            ForeachTree scan = new ForeachTree();
            File parent = new File(path);

            JTextArea textArea = new JTextArea(scan.makeForeachTree(parent, ""));
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
            JOptionPane.showMessageDialog(null, scrollPane, "TreeMap", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
