
import javax.swing.*;
import java.awt.*;

public class GUI_Demo {
    public static void main(String[] args){
        JFrame f = new JFrame();
        JButton b1 = new JButton("OK");
        JButton b2 = new JButton("Cancel");
        JButton b3 = new JButton("Help");
        b1.setBounds(400,100,100,40);
        b2.setBounds(400,150,100,40);
        b3.setBounds(400,200,100,40);
        
        f.add(b1);f.add(b2);f.add(b3);
        
        JCheckBox cb1 = new JCheckBox("Snap to grid");
        JCheckBox cb2 = new JCheckBox("Show grid");
        cb1.setBounds(50, 100, 100, 50);
        cb2.setBounds(50, 150, 100, 50);
        
        f.add(cb1);f.add(cb2);
        
        JTextField tf1 = new JTextField("10");
        JTextField tf2 = new JTextField("10");
        tf1.setBounds(250,120,50,20);
        tf2.setBounds(250,160,50,20);
        
        f.add(tf1);f.add(tf2);
        
        Label l1 = new Label("X :");
        Label l2 = new Label("Y :");
        l1.setBounds(220,120,50,20);
        l2.setBounds(220,160,50,20);
        
        f.add(l1);f.add(l2);
        
        String[] course = {"MCA" , "BTECH" , "MTECH" , "BSC" , "BCA"};

        //JComboBox is a generic class. You should modify it to be something like:
        JComboBox<String> myJComboBox = new JComboBox<String>(course);
        myJComboBox.setBounds(220,250,100,20);
        f.add(myJComboBox);
        
        // celcius-farenheit conversion
        
        
        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
    }
}


