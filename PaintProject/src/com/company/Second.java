package com.company;

import com.company.NewForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Second extends JFrame {
    private int x,y,x1,y1;
    private JPanel panel1;
    private JButton drawButton;
    private JButton clearButton;
    private JButton rectButton;
    private JButton oval;

    Graphics2D g;
    int prevX,prevY;
    Point previousPoint;
    boolean draw = false;

    public Second(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800,800));
        setContentPane(panel1);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        g = (Graphics2D)panel1.getGraphics();
        previousPoint = new Point();
        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                g.setStroke(new BasicStroke(3));
                g.setColor(Color.BLACK);
                g.drawOval(previousPoint.x,previousPoint.y,getWidth(),getHeight());
               }
            @Override
            public void mouseReleased(MouseEvent e) {

              //  g.drawOval(previousPoint.x,previousPoint.y,getWidth(),getHeight());
            }
        });
        rectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewForm newForm= new NewForm();

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setContentPane(new NewForm());
                setPreferredSize(new Dimension(800,800));
                setVisible(true);
            }
        });
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FirstForm();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = getGraphics();

                Dimension d = getSize();

                Color c = getBackground();

                g.setColor(c);

                g.fillRect(0,0,d.width,d.height);

                repaint();
            }
        });
    }
}
