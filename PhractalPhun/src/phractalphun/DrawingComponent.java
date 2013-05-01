/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phractalphun;
import java.awt.Component;
import java.awt.image.*;
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
public class DrawingComponent extends JFrame {
   int width, height;
   BufferedImage image;
   
   
   public DrawingComponent(){
       super("Mandelbrot");
       width = 800;
       height = 800;
       setBounds(100, 100, width, height);
       image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
       for (int x = 0; x<width; x++){
           for (int y = 0; y<height; y++){
               int color = mandelbrot(x,y);
               image.setRGB(x,y,color | (color << 8));
           }
       }
   }
   
   
   int mandelbrot(int xPixel, int yPixel){
       double pixelWidth = 3.5/width;
       double pixelHeight = 2/height;
       double x0 = -2.5 + xPixel*pixelWidth;
       double y0 = -1 + yPixel*pixelHeight;
       //double x0 = (xPixel - 400) / 150;
       //double y0 = (yPixel - 400) / 150;
       double x = 0;
       double y = 0;
       int iteration = 0;
       int maxIteration = 3000;
       
       while (((x*x + y*y) < (2*2)) && (iteration < maxIteration)){
           double xtemp = x*x - y*y + x0;
           y = 2.0 *x*y + y0;
           x = xtemp;
           iteration = iteration + 1;
       }
       return iteration;
   }
   
   public void paint(Graphics g){
       g.drawImage(image, 0, 0, this);
   }
   public static void main(String[] args){
       new DrawingComponent().setVisible(true);
   }
}