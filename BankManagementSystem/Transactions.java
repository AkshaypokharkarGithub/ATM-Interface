package Com.symboisis.BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener
{
	
	JButton deposit,withdrawl,fastcash,ministatement,pinchange,enquiry,exit;
	String pinnumber;
	Transactions(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		
		setLayout(null);
	
	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel image=new JLabel(i3);
	image.setBounds(0,0, 900,900);
	add(image);
	
	JLabel text=new JLabel("Please Select Your Transaction");
	text.setBounds(215,300,700,35);
	text.setForeground(Color.WHITE);
	text.setFont(new Font("System",Font.BOLD,16));
	
	image.add(text);
	
	
    deposit=new JButton("Deposit");
	deposit.setBounds(170, 415, 150, 30);
	deposit.addActionListener(this);
	image.add(deposit);
	

	withdrawl=new JButton("Cash Withdrawl");
	withdrawl.setBounds(355, 415, 150, 30);
	withdrawl.addActionListener(this);
	image.add(withdrawl);
	
	 fastcash=new JButton("Fast Cash");
	 fastcash.setBounds(170, 450, 150, 30);
	 fastcash.addActionListener(this);
	 image.add(fastcash);
	
	 ministatement=new JButton("MiniStatement");
	 ministatement.setBounds(355, 450, 150, 30);
	 ministatement.addActionListener(this);
	 image.add(ministatement);
	
	
	  pinchange=new JButton("PinChange");
	  pinchange.setBounds(170,485,150,30);
	  pinchange.addActionListener(this);
	  image.add(pinchange);
	  
	  enquiry=new JButton("Balance Enquiry");
	  enquiry.setBounds(355,485,150, 30);
	  enquiry.addActionListener(this);
	  image.add(enquiry);
	 
	  exit=new JButton("Exit");
	  exit.setBounds(355,520,150, 30);
	  exit.addActionListener(this);
	  image.add(exit);
	
	
	

     setSize(900,900);
     setLocation(300,0);
     setUndecorated(true);
     setVisible(true);
	
	
	}

  public void actionPerformed(ActionEvent e) 
  {
	if(e.getSource()==exit)
	{
		System.exit(0);
	}
	else if(e.getSource()==deposit)
	{
		setVisible(false);
		new Deposit(pinnumber).setVisible(true);
	}
	else if(e.getSource()==withdrawl)
	{
		setVisible(false);
		new Withdrawl(pinnumber).setVisible(true);
	}
	else if(e.getSource()==fastcash)
	{
		setVisible(false);
		new Fastcash(pinnumber).setVisible(true);
	}
	else if(e.getSource()==pinchange)
	{
		setVisible(false);
		new pinchange(pinnumber).setVisible(true);
	}
	else if(e.getSource()==enquiry)
	{
		setVisible(false);
		new BalanceEnquiry(pinnumber).setVisible(true);
	}
	
	
  }
public static void main(String[] args)
   {
	new Transactions("");

   }
}
