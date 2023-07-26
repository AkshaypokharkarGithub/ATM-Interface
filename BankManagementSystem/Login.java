package Com.symboisis.BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{
	 private JButton signin,clear,SignUp;
	 private JTextField cardtextfield;
	 private JPasswordField pintextfield;
	

	Login ()
	{
		
		
		setTitle("Automated Teller Machine");
		
		//setting custum layout for image
		
		setLayout(null);
		
		//setting image on frame using *lable* set canot set image directly on frame 
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		add(label);
		label.setBounds(80,10,100,100);
		
		//to write the content on the frame we have to use JLabel  
		
		JLabel text=new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200, 40, 500, 40);
		add(text);
		setBounds(800,40,100,50);
		
	//to write the content on the frame we have to use JLabel-(CardNo ) 
		
	    JLabel  CardNo=new JLabel("CardNo");
	    CardNo.setFont(new Font("Raleway",Font.BOLD,25));
	    CardNo.setBounds(150, 150, 200, 40);
		add(CardNo);
		
	//to create box to enter text use JTextFeild-(CardTextfeild)	
		 cardtextfield=new JTextField();
		cardtextfield.setBounds(260,150,200,40);
		cardtextfield.setFont(new Font("Arial",Font.BOLD,18));
		add(cardtextfield);
		
	//to write the content on the frame we have to use JLabel-(Pin)
			
		JLabel  Pin=new JLabel("Pin");
		Pin.setFont(new Font("Raleway",Font.BOLD,25));
		Pin.setBounds(180,200,500, 40);
	    add(Pin);
	    
	//to create box to enter text use JTextFeild-(PinTextfeild)~~//use JPasswordfield to hide password writting
	     pintextfield=new JPasswordField();
	    pintextfield.setBounds(260,200,150,40);
	    add(pintextfield);
	    
	//create signin button using JButton
	    
	     signin=new JButton("signin");
	    signin.setBounds(250,300,110,30);
	    signin.setBackground(Color.BLACK);
	    signin.setForeground(Color.WHITE);
	    signin.addActionListener(this);
	    add(signin);
	    
    //create clear button using JButton
	    
	     clear=new JButton("clear");
	    clear.setBounds(380,300,110,30);
	    clear.setBackground(Color.BLACK);
	    clear.setForeground(Color.WHITE);
	    clear.addActionListener(this);
	    add(clear);
	    
     //create SignUp button using JButton
	    
	     SignUp=new JButton("SignUp");
	    SignUp.setBounds(250,350,240,30);
	    SignUp.setBackground(Color.BLACK);
	    SignUp.setForeground(Color.WHITE);
	    SignUp.addActionListener(this);
	    add( SignUp);
		
	 //setting /changing background
		getContentPane().setBackground(Color.white);

	 //setting Size of Frame
		setSize(700,480);
		setVisible(true);
		setLocation(350,200);
	
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == signin)
		{
		try {
			
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","tejas");
		  String cardnumber=cardtextfield.getText();
		  String pinnumber=pintextfield.getText();
		  
		  Statement stmt=con.createStatement();
		  String query="(select * from login where cardnumber='"+cardnumber+"'and pinnumber='"+pinnumber+"')";
		  
		  ResultSet rs=stmt.executeQuery(query);
		 
		  
		  if(rs.next())
		  {
			  setVisible(false);
			 
			new Transactions(pinnumber).setVisible(true);
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(null,"Incoorect CardNumber or PinNumber");
		  }
		  
		} 
		
		catch (SQLException e1)
		{
			
			e1.printStackTrace();
		}
			
			
		}
		else if (e.getSource()== clear)
		{
			cardtextfield.setText("");
			pintextfield.setText("");
		}
		else if (e.getSource()== SignUp)
		{
			
			setVisible(true);
			new SignUp1().setVisible(true);
			
			
		}
		
	}
	public static void main(String[] args)
	{
		new Login();

	}





	

}
