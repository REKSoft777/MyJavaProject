package ATM;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;

public class User extends JFrame
{
	public JFrame Mainframe;
	 public static JTextField Inputfield1;
	 public static JTextField Inputfield2;
	 public static JTextField Inputfield3;
	 public static JTextField Inputfield4;
	 public JLabel messageJLabel; 
	 public JLabel messageJLabel2; // displays message of game status
	 public JLabel messageJLabel3;
	 public JLabel messageJLabel4;
	 public JLabel messageJLabel5;
	 public JLabel messageJLabel8;
	 public JLabel messageJLabel9;
	 public JLabel messageJLabel10;
	 public JButton loginbutton; // creates new game
	 public JButton button1;
	 public JButton button2;
	 public JButton button3;
	 public JButton button4;
	 public JButton button5;
	 public JButton Exit;
	 public int accnum = 0;
	 public int PIN = 0;
	public JLabel messageJLabel6;
	public JLabel messageJLabel7;
	 
	
  
public void createmenu(){
	Mainframe.getContentPane().removeAll();
	messageJLabel = new JLabel("Welcome");
	messageJLabel2 = new JLabel("1 - Balance");
	messageJLabel3 = new JLabel("2 - Withdrawal");
	messageJLabel4 = new JLabel("3 - Deposit");
	messageJLabel5 = new JLabel("4 - Exit");
	Mainframe.setLayout( new FlowLayout() ); // set layout
	Mainframe.add(messageJLabel);
	Mainframe.add( messageJLabel2 ); // add first prompt
	Mainframe.add( messageJLabel3 ); // add second prompt
	Mainframe.add( messageJLabel4 ); // add message label 
	Mainframe.add( messageJLabel5 );
	Mainframe.repaint();
    }

}
