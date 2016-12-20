package lab12;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.text.DecimalFormat;
//Colby Underhillu

public class CoffeeMachine extends JFrame implements ActionListener
    {
    private static final long serialVersionUID = 1L;
    JLabel l1, l2, l3, l4, l5, l6;
    JButton b1, b2;
    JTextField t1, t2, t3;
    JCheckBox cream, raw, espresso;
    private JRadioButton small;
    private JRadioButton medium;
    private JRadioButton large;
    private ButtonGroup group;
    DecimalFormat df = new DecimalFormat("##,###.00");
    CoffeeMachine()
        {
        l1 = new JLabel(" Customer Name");
        l2 = new JLabel(" amount to pay");
        l3 = new JLabel("  ");
        l4 = new JLabel("  ");
        l5 = new JLabel("  ");
        l6 = new JLabel("  ");
        b1 = new JButton("COMPUTE");
        b2 = new JButton("EXIT");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        small = new JRadioButton("small", true);
        medium = new JRadioButton("medium", false);
        large = new JRadioButton("large", false);
        group = new ButtonGroup();
        group.add(small);
        group.add(medium);
        group.add(large);
        cream = new JCheckBox("cream", false);
        raw = new JCheckBox("raw sugar", false);
        espresso = new JCheckBox("espresso shot", false);
        add(l1);
        add(t1);
        add(small);
        add(cream);
        add(medium);
        add(raw);
        add(large);
        add(espresso);
        add(l2);
        add(t2);
        add(l5);
        add(l6);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(e -> System.exit(0));
        setSize(500,300);
        setLayout(new GridLayout(7,2));
        setTitle("Coffee Machine");
        
        }
    public void actionPerformed(ActionEvent ae)
        {
        double price = 0.0;
        String a = "", message = "";
        if (cream.isSelected() == true)
            {
            price += 0.00;
            message="You selected cream";
            }
        if (raw.isSelected() == true)
            {
            price += 0.00;
            message +="\nYou selected raw";
            // perform a task ...
            }
        if (espresso.isSelected() == true)
            {
            price += 0.75;
            message +="\nYou selected espresso";
            // perform a task ...
            }
        if (small.isSelected() == true)
            {
            System.out.println("small");
            message +="\nSmall coffee";
            price += 1.25;  
            // perform a task ...
            }
        if (medium.isSelected()== true)
            {
            System.out.println("medium");
            message +="\nMedium coffee";
            price += 1.75;
            //perform a task...
            }   
        if (large.isSelected() == true)
            {
            System.out.println("large");
            message +="\nLarge coffee";
            price += 2.30;
            // perform a task ...
            }  
        if(ae.getSource() == b1)
            {
            message += "\nyour total is: " + a + " $" + df.format(price);
            t2.setText(df.format(price));
            }
        JOptionPane.showMessageDialog(null, "Hello! Enjoy your beverage! \n"
            + message,
                "Order Summary", JOptionPane.PLAIN_MESSAGE);
        }
}