/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phractalphun;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.applet.*;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 *
 * @author kevin
 */
public class DrawingComponent extends JPanel {
   int width, height;

   public void init() {
      
      setBackground(Color.red );
   }
    
   public void paintComponent(Graphics g){
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       width = getSize().width;
       height = getSize().height;
       for (int x = 0; x<width; x++){
           for (int y = 0; y<height; y++){
               mandelbrot(g2d,x,y);
           }
       }
   }
   
   void mandelbrot(Graphics g, int xPixel, int yPixel){
       double pixelWidth = 3.5/width;
       double pixelHeight = 2/height;
       double x0 = -2.5 + xPixel*pixelHeight;
       double y0 = -1 + yPixel*pixelHeight;
       double x = 0;
       double y = 0;
       int iteration = 0;
       int maxIteration = 10;
       
       while (((x*x + y*y) < 2*2) && (iteration < maxIteration)){
           double xtemp = x*x - y*y + x0;
           y = 2*x*y + y0;
           x = xtemp;
           iteration = iteration + 1;
       }
       g.setColor(Color.yellow);
       if(iteration == 9){
           g.setColor(Color.black);
       }
       g.drawLine(xPixel, yPixel, xPixel, yPixel);
   }
   public static void main(String[] args){
       JFrame frame = new JFrame("Fractal");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(new DrawingComponent());
       frame.setSize(400, 400);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
   }
}