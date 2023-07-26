package Com.symboisis.BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Fastcash extends JFrame implements ActionListener
{

	JButton opt1,opt2,opt3,opt4,opt5,opt6,back;
	String pinnumber;
    int balance;
	 Fastcash(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		
		setLayout(null);
	
	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel image=new JLabel(i3);
	image.setBounds(0,0, 900,900);
	add(image);
	
	JLabel text=new JLabel("Please Select withdrawl Amount");
	text.setBounds(215,300,700,35);
	text.setForeground(Color.WHITE);
	text.setFont(new Font("System",Font.BOLD,16));
	
	image.add(text);
	
	
    opt1=new JButton("RS 100");
    opt1.setBounds(170, 415, 150, 30);
    opt1.addActionListener(this);
	image.add( opt1);
	

	 opt2=new JButton("RS 500");
	 opt2.setBounds(355, 415, 150, 30);
	 opt2.addActionListener(this);
	image.add(opt2);
	
	 opt3=new JButton("RS 1000");
	 opt3.setBounds(170, 450, 150, 30);
	 opt3.addActionListener(this);
	 image.add(opt3);
	
	 opt4=new JButton("RS 2000");
	 opt4.setBounds(355, 450, 150, 30);
	 opt4.addActionListener(this);
	 image.add(opt4);
	
	
	 opt5=new JButton("RS 5000");
	 opt5.setBounds(170,485,150,30);
	 opt5.addActionListener(this);
	  image.add(opt5);
	  
	  opt6=new JButton("RS 10000");
	  opt6.setBounds(355,485,150, 30);
	  opt6.addActionListener(this);
	  image.add( opt6);
	 
	  back=new JButton("back");
	  back.setBounds(355,520,150, 30);
	  back.addActionListener(this);
	  image.add(back);
	
	
	

     setSize(900,900);
     setLocation(300,0);
     setUndecorated(true);
     setVisible(true);
	
	}
	 
		
		
 public void actionPerformed(ActionEvent e) 
   {
	 if(e.getSource()==back)
		{
			setVisible(false);
			new Transactions(pinnumber);
		}
	 else 
	 {
		String fastcash=((JButton)e.getSource()).getText().substring(3);
		try  {
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","tejas");
	
			     Statement stmt=con.createStatement();
		         ResultSet rs=stmt.executeQuery("select * from history where pin='"+pinnumber+"' ");
			
		      
		           
		         while(rs.next())
		           { 
		        	     
		               if(rs.getString("Type").equals("Deposit"))
		                  {
		                     balance += (Integer.parseInt(rs.getString("amount")));  
		                     
		                  }
						else
							  {
							    balance -= (Integer.parseInt(rs.getString("amount")));
							  }
		           }
		  	        
		           if (e.getSource()!= back && balance < Integer.parseInt(fastcash))
		               {
		                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
		                   return;
		               }
		         
		        
		         Date date=new Date();
	  		     
	  		     String query2="insert into history values('"+pinnumber+"','"+date+"','Withdraw','"+fastcash+"')";
	  		     stmt.execute(query2);
	  		     
	  		     JOptionPane.showMessageDialog(null,"RS"+fastcash+"\nDebited Successfully");
	   	        
	  		     setVisible(false);
	  		     new Transactions(pinnumber).setVisible(true);
		         
	
		    
		          
	
	         }
	         catch (Exception e2)
	           {
	            System.out.println(e2);
		       }  
	
       }
		
	}
	
 public static void main(String[] args)
	   {
		   new Fastcash("");

	   }
	}

