import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Calculate");
    private JTextField input = new JTextField("", 55);
    private JLabel label = new JLabel("Input your path");
    private JLabel text = new JLabel("");

    public SimpleGUI() {
        super("Simple Calculator");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(label);
        container.add(input);
        container.add(text);

        button.addActionListener(new ButtonEventListener());
        container.add(button);

    }

    //path = "D:/VISTAR/TreeSizeCount";

    class ButtonEventListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            try {
                ForeachTree scan = new ForeachTree();
                File parent = new File(input.getText());

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
}