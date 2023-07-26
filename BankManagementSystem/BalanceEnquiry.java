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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener 
{
	String pinnumber;
	JButton back;

	
	 BalanceEnquiry(String pinnumber)
	{
	    this.pinnumber=pinnumber;
	
	
	     setLayout(null);

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0, 900,900);
    add(image);



      back=new JButton("back");
	  back.setBounds(355,520,150, 30);
	  back.addActionListener(this);
	  image.add(back);
   
    
 
    

    int balance=0;
    try 
      {
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
        }
         catch (Exception e)
         {
        	 System.out.println(e);
         }
    
    
	   JLabel text=new JLabel("Your Current Acccount Balance is");
	    text.setFont(new Font("Raleway",Font.BOLD,18));	   
	    text.setForeground(Color.white);
	    text.setBounds(170,350,400,30);  
	    image.add(text);
	    
	   JLabel show=new JLabel(""+balance);
	    show.setFont(new Font("Raleway",Font.BOLD,18));
	    show.setForeground(Color.white);
	    show.setBounds(250,400,400,30);
	    image.add(show);
    
       setSize(900,900);
       setLocation(300,0);
       //setUndecorated(true);
       setVisible(true);
	}
  	        
  public void actionPerformed(ActionEvent e)
	{
		 if(e.getSource()==back)
			{
				setVisible(false);
				new Transactions(pinnumber);
			}
		
	}
	public static void main(String[] args) 
	{
		new  BalanceEnquiry("");
	}
}