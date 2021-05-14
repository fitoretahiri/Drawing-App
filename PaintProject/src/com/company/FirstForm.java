package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstForm extends JFrame{

    private JPanel panel1;
    private JButton rectButton;
    private JButton oval;
    private JButton clearButton;

    Graphics2D g;
    int prevX,prevY;
    Point previousPoint;
    boolean draw = false;

    public FirstForm(){
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
                prevX = e.getX();
                prevY = e.getY();
                draw = true;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                draw = false;
            }
        });
        panel1.addMouseMotionListener(new MouseMotionAdapter() {
                                          @Override
                                          public void mouseDragged(MouseEvent e) {
                                              if (draw) {
                                                  g.drawLine(prevX, prevY, e.getX(), e.getY());
                                                  prevX = e.getX();
                                                  prevY = e.getY();
                                              }
                                          }
                                      });
         /* The following code adds the rect button when you
          *click it you will be able to draw rectangles
          */
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
        oval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                new Second();
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
