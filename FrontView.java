
package pharmacysystem;

import javax.swing.*;
import java.awt.*;

public class FrontView extends JFrame implements Runnable{
    
    Thread t;
    
    FrontView(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/welcome.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
           
        JLabel image = new JLabel(i3);
        add(image);
        
        setLocation(400,50);
        setSize(600, 600);
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        int x = 1;
        for (int i = 2; i <= 600; i+=4, x+=1) {
            setLocation(600 - ((i + x)/2), 350 - (i/2));
            setSize(i + 3*x, i + x/2);
            
            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }        
    }
    
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
            
            // Next Frame
            new Login();
        } catch (Exception e) {
            
        }
    }
          
     public static void main(String[] args){
        new FrontView();
    }
    
}
