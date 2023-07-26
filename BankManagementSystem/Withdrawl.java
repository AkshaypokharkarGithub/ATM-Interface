package Com.symboisis.BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener
{

	JLabel text;
	JTextField amount;
	JButton Withdrawl,back;
	String pinnumber;
	Withdrawl(String pinnumber)
	{
		this.pinnumber=pinnumber;
	
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		text=new JLabel("Enter the Amount you want to Withdrawl");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(170,300,400,20);
		image.add(text);
		
		amount=new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(170,350,320,25);
		image.add(amount);
		
		Withdrawl=new JButton("Withdraw");
		Withdrawl.setBounds(355,485,150,30);
		Withdrawl.addActionListener(this);
		image.add(Withdrawl);
		
		 back=new JButton("Back");
		 back.setBounds(355,520,150,30);
		 back.addActionListener(this);
		 image.add(back);
		
		
		setSize (900,900);
		setLocation(100,0);
		setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
		  setVisible(false);
           new Transactions(pinnumber).setVisible(true);
		}
		
		else if(e.getSource()==Withdrawl)
		{
			String Withdrawl=amount.getText();
			Date date=new Date();
			
			if( Withdrawl.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter the Amount to Withdrawl");
			}
			else
			{
			 try{
				  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","tejas");
				  Statement stmt=con.createStatement();
				 
				  String st1="insert into history values('"+pinnumber+"','"+date +"','Withdraw','"+ Withdrawl+"')";
				 stmt.executeUpdate(st1);
				 con.close();
				 if(con.isClosed())
				 { JOptionPane.showMessageDialog(null," "+Withdrawl+"\nWithdrawl Sucessfully");
				    setVisible(false);
				    new Transactions(pinnumber).setVisible(true);
				 }
				
				} 
				catch (SQLException e1) {e1.printStackTrace();}
			
				
			}
		
		}
		
		
	}
	
	public static void main(String[] args)
	{
		
		
		
		new  Withdrawl("");
		
		
		
	}

	
	
	
	
}
