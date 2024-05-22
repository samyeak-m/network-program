package unit1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//creating basic swing controls
//in gui there should be one

class Controls extends JFrame{
//    label shows the text in window
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1,b2;

    public void setControls(){
        l1 = new JLabel("First Number");
        l2 = new JLabel("Second Number");
        l3 = new JLabel("Result");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        b1 = new JButton("Find Sum");
        b2 = new JButton("Find Prime Sum");

//        adding component (control) into window

        add(l1);add(t1);
        add(l2);add(t2);
        add(b1);add(b2);
        add(l3);

//        setting the window (jframe) properties

        setVisible(true);//to show the window
        setSize(200,200);//to set the size of window
        setLayout(new FlowLayout());//describes how content should be show in window (wrap)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to close the window
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
//                when b1 button is clicked action event is generated. to handle such event action listener interface is used. ActionListener contains one method name as actionPerformed which should be comp override to handle action method
//              extracting form's field

                try {

                    int num1 = Integer.parseInt(t1.getText());
                    int num2 = Integer.parseInt(t2.getText());

                        int sum = num1 + num2;
                        l3.setText("sum is " + sum);

                } catch (NumberFormatException ex) {
                    l3.setText("enter number");
                    throw new RuntimeException(ex);

                }

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int num1 = Integer.parseInt(t1.getText());
                    int num2 = Integer.parseInt(t2.getText());
                    int i;
                    int p=0;

                    for (i=num1;i<=num2;i++){
                        int temp=0;
                        for(int j =1; j<=i;j++) {
                            if (i % j == 0) {
                                temp++;
                            }
                        }
                        if(temp==2){
                            p+=i;
                        }
                    }
                    l3.setText("prime sum is " + p);
                }
                catch (NumberFormatException ex){
                    l3.setText(""+ex);
                }
            }
        });
    }
}

public class firstProgram {
    public static void main(String[] args) {
        Controls c1 = new Controls();
        c1.setControls();

    }
}
