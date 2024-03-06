import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Calculate");
    private JButton buttonFileDialog = new JButton("Open explorer");
    private JTextField input = new JTextField("", 55);
    private JLabel label = new JLabel("Your current path");

    public SimpleGUI() {
        super("Simple Calculator");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,3,2,2));
        container.add(label);
        container.add(input);

        button.addActionListener(new ButtonEventListenerButton());
        buttonFileDialog.addActionListener(new ButtonEventListenerButtonFileDialog());
        container.add(button);
        container.add(buttonFileDialog);

    }

    class ButtonEventListenerButton implements ActionListener{
        public void actionPerformed (ActionEvent e) {
            PrintTree.print(input.getText()); //path = "D:/VISTAR/TreeSizeCount";
        }
    }

    class ButtonEventListenerButtonFileDialog implements ActionListener{
        public void actionPerformed (ActionEvent e) {
            input.setText(PrintTree.showDialog());
        }
    }
}