package Com.symboisis.BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class pinchange extends JFrame implements ActionListener
{
	
	JLabel pintext,repintext,text;
	JTextField pin,repin;
	JButton back,change;
	String pinnumber;
	
pinchange(String pinnumber)

	{
	this.pinnumber=pinnumber;
		setLayout(null);
		 
	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3= new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);

      text =new JLabel("Change Your PIN");
	  text.setForeground(Color.WHITE);
	  text.setFont(new Font("System",Font.BOLD,16));
	  text.setBounds(250, 280,500,35); 
	  image.add(text);
	  
	  
	  pintext=new JLabel("New PIN"); 
	  pintext.setForeground(Color.WHITE);
	  pintext.setFont(new Font("Raleway",Font.BOLD,16));
	  pintext.setBounds(165,320,180,25); 
	  image.add(pintext);
	  
      pin=new JTextField();
	  pin.setFont(new Font("Raleway",Font.BOLD,16));
	  pin.setBounds(330,320,180,25);
	  image.add(pin);
	  
	  repintext=new JLabel("Re-Enter New PIN");
	  repintext.setForeground(Color.WHITE);
	  repintext.setFont(new Font("System",Font.BOLD,16));
	  repintext.setBounds(165,360,180,25);
	  image.add(repintext);
	 
	  repin=new JTextField();
	  repin.setFont(new Font("Raleway",Font.BOLD,16));
	  repin.setBounds(330,360,180,25);
	  image.add(repin);
	  
	  change=new JButton("CHANGE");
	  change.setBounds(355,485,150, 30);
	  change.addActionListener(this);
	  image.add(change);
	  
	  back=new JButton("BACK");
	  back.setBounds(355,520,150, 30);
	  back.addActionListener(this);
	  image.add(back);
	  
	    setSize(900, 900);
		setLocation(0,0);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
	    if(e.getSource()==change)
		{
		  try 
		   {
			  String npin=pin.getText();
			  String rpin=repin.getText();
			
			    if(!npin.equals(rpin)) {JOptionPane.showMessageDialog(null,"Enterred PIN Does Nor Matched");}
			    
			    if(npin.equals("")) {JOptionPane.showMessageDialog(null,"Please Enter New PIN");}
			    if(rpin.equals("")) {JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN");}
				
			    if(npin.equals(rpin))
			    {
			    	
			      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","tejas");
			      Statement stmt=con.createStatement();
			    	System.out.println("Connection CreaTED");	    
			       String query1="update history set Pin='"+rpin+"' where Pin='"+pinnumber+"' ";
			       stmt.executeUpdate(query1);
			      
			       String query2="update login set PinNumber='"+rpin+"' where PinNumber='"+pinnumber+"' ";
			       stmt.executeUpdate(query2);
			      
			       String query3="update signup3 set PinNumber='"+rpin+"' where PinNumber='"+pinnumber+"' ";
			       stmt.executeUpdate(query3);
			       
			   
			      con.close();
			     
			     JOptionPane.showMessageDialog(null,"PIN changed Successfully");
			     setVisible(false);
		         new Transactions(pinnumber).setVisible(true);
			    }
		      } 
		       catch (Exception e2) {System.out.println(e2);}
		    }
		
		 if(e.getSource()==back)
		   {
			setVisible(false); 
			new Transactions(pinnumber).setVisible(true);
		    }
		
	}
	

	
	public static void main(String[] args) 
	{
		
		new pinchange(" ");
	}




	
}
