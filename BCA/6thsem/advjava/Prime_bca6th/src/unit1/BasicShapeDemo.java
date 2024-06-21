package unit1;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;

class ShapeExample{
    JFrame fr;
    JPanel p;
    public void setShapes(){
        fr = new JFrame();
        p = new JPanel() {

            public void paint(Graphics g) {
                g.drawRect(50,50,300,300);
                g.drawOval(400,500,600,600);

                g.setColor(Color.GREEN);
                g.setFont(new Font("arial",Font.BOLD,24));
                g.drawString("Hello Bca",100,100);

            }
        };

        p.setSize(800,800);
        fr.add(p);
        fr.setVisible(true);
        fr.setSize(1200,1200);
//        fr.setLayout(new FlowLayout());
        fr.setDefaultCloseOperation(3);
    }
}

public class BasicShapeDemo {
    public static void main(String[] args) {
        ShapeExample s = new ShapeExample();
        s.setShapes();
    }
}
