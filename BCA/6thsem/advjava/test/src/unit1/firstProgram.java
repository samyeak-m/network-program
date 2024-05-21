package unit1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//creating basic swing controls
//in gui there should be one

class Controls {
    //    label shows the text in window
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1;
    JFrame j1;

    public void setControls(){
        l1 = new JLabel("First Number");
        l2 = new JLabel("Second Number");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        b1 = new JButton("Find Sum");
        j1 = new JFrame();
//        adding component (control) into window

        j1.add(l1);j1.add(t1);
        add(l2);add(t2);
        add(b1);

//        setting the window (jframe) properties

        setVisible(true);//to show the window
        setSizr(200,200);//to set the size of window
        setLayout(new FlowLayout());//describes how content should be show in window (wrap)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to close the window
    }
}

public class firstProgram {
    public static void main(String[] args) {
        Controls c1 = new Controls();
        c1.setControls();

    }
}
