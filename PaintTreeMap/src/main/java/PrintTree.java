import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PrintTree extends Component {
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

    public static String showDialog() {
        JPanel jPanel = new JPanel();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Select your folder");
        fileChooser.setAcceptAllFileFilterUsed(false);

        if (fileChooser.showOpenDialog(jPanel) == JFileChooser.APPROVE_OPTION) {
            //input.setText(String.valueOf(((fileChooser.getSelectedFile()))));
            return String.valueOf(((fileChooser.getSelectedFile())));
        }
        else {
            return "No Selection!";
        }
    }
}
