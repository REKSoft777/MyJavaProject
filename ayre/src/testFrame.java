import java.awt.event.*;  
import javax.swing.*;   

public class testFrame {

	public static void main(String[] args) {  
	    JFrame f=new JFrame("Button Example");  
	    final JTextField tf=new JTextField();  
	    tf.setBounds(50,50, 150,20);  
	    JButton b=new JButton("Click Here");  
	    b.setBounds(200,200,100,100);  
	    b.addActionListener(new ActionListener(){  
	public void actionPerformed(ActionEvent e){  
	            tf.setText("Welcome to Javatpoint.");  
	        }  
	    });  
	    f.add(b);f.add(tf);  
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
	}  

