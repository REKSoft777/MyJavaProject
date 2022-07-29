import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class trtr extends JPanel
{
	

    public void paintComponent(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D) g;
    	
        
        	
        
        
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(512, 512);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

        trtr game = new trtr();
        frame.setContentPane(game);

        frame.setVisible(true);
        frame.invalidate();
    }

}