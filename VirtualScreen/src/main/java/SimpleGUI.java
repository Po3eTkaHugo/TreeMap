import java.awt.*;
import java.awt.event.*;
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

    class ButtonEventListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            String message = "";
            message = "Button was pressed\n";

        }
    }


}