package Com.symboisis.BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
public class SignUp3 extends JFrame implements ActionListener
{
	String formno;
	JLabel acctype ,card,carddetail,cardnumber,pin,pinnumber,pindetail,	ServiceRequired;
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton cancel,submit;
SignUp3(String formno)
{
	this.formno=formno;
	setLayout(null);
	 
	JLabel l1=new JLabel("Page 3: Account Details");
	l1.setFont(new Font("Relway",Font.BOLD,24));
	l1.setBounds(250,60,500,40);
	l1.setVisible(true);
	add(l1);
	
	acctype=new JLabel("Account type: ");
	acctype.setFont(new Font("Relway",Font.BOLD,22));
	acctype.setBounds(130,140,200,30);
	acctype.setVisible(true);
	add(acctype);
	
	r1=new JRadioButton("Savings Acc");
	r1.setFont(new Font("Relway",Font.BOLD,16));
	r1.setBackground(Color.WHITE);
	r1.setBounds(130,200,200,30);
	r1.setVisible(true);
	add(r1);
	
	r2=new JRadioButton("Current Acc");
	r2.setFont(new Font("Relway",Font.BOLD,16));
	r2.setBackground(Color.WHITE);
	r2.setBounds(370,200,200,30);
	r2.setVisible(true);
	add(r2);
	
	r3=new JRadioButton("Fixed Deposit");
	r3.setFont(new Font("Relway",Font.BOLD,16));
	r3.setBackground(Color.WHITE);
	r3.setBounds(130,250,200,30);
	r3.setVisible(true);
	add(r3);
	
	r4=new JRadioButton("Reccuring Acc");
	r4.setFont(new Font("Relway",Font.BOLD,16));
	r4.setBackground(Color.WHITE);
	r4.setBounds(370,250,200,30);
	r4.setVisible(true);
	add(r4);
	
	ButtonGroup g1=new ButtonGroup();
	g1.add(r1);g1.add(r2);g1.add(r3);g1.add(r4);
	
	card=new JLabel("Card Number  :");
	card.setFont(new Font("Relway",Font.BOLD,22));
	card.setBounds(130,320,200,30);
	card.setVisible(true);
	add(card);
	cardnumber=new JLabel("xxxx-xxxx-xxxx-4184");
	cardnumber.setFont(new Font("Relway",Font.BOLD,18));
	cardnumber.setBounds(370,320,300,30);
	cardnumber.setVisible(true);
	add(cardnumber);
	
	carddetail=new JLabel("This is Your 16 Digit Card Number");
	carddetail.setFont(new Font("Relway",Font.BOLD,14));
	carddetail.setBounds(200,350,600,30);
	carddetail.setVisible(true);
	add(carddetail);
	
	pin=new JLabel("Pin :");
	pin.setFont(new Font("Relway",Font.BOLD,22));
	pin.setBounds(200,400,200,30);
	pin.setVisible(true);
	add(pin);
	pinnumber=new JLabel("xxxx");
	pinnumber.setFont(new Font("Relway",Font.BOLD,18));
	pinnumber.setBounds(300,400,190,30);
	pinnumber.setVisible(true);
	add(pinnumber);
	
	pindetail=new JLabel("This is Your Pin Number");
	pindetail.setFont(new Font("Relway",Font.BOLD,14));
	pindetail.setBounds(210,430,600,30);
	pindetail.setVisible(true);
	add(pindetail);
	
	ServiceRequired=new JLabel("ServiceRequired:");
	ServiceRequired.setFont(new Font("Relway",Font.BOLD,22));
	ServiceRequired.setBounds(130,470,200,30);
	ServiceRequired.setVisible(true);
	add(ServiceRequired);
	
	c1=new JCheckBox("Atm Card");
	c1.setBackground(Color.white);
	c1.setFont(new Font("Relway",Font.BOLD,16));
	c1.setBounds(160,520,200,30);
	add(c1);
	c2=new JCheckBox("Email Alerts");
	c2.setBackground(Color.white);
	c2.setFont(new Font("Relway",Font.BOLD,16));
	c2.setBounds(370,520,200,30);
	add(c2);
	c3=new JCheckBox("NetBanking");
	c3.setBackground(Color.white);
	c3.setFont(new Font("Relway",Font.BOLD,16));
	c3.setBounds(160,550,200,30);
	add(c3);
	c4=new JCheckBox("Mobile Banking");
	c4.setBackground(Color.white);
	c4.setFont(new Font("Relway",Font.BOLD,16));
	c4.setBounds(370,550,200,30);
	add(c4);
	c5=new JCheckBox("Cheque Book");
	c5.setBackground(Color.white);
	c5.setFont(new Font("Relway",Font.BOLD,16));
	c5.setBounds(160,580,200,30);
	add(c5);
	c6=new JCheckBox("E Statement");
	c6.setBackground(Color.white);
	c6.setFont(new Font("Relway",Font.BOLD,16));
	c6.setBounds(370,580,200,30);
	add(c6);
	c7=new JCheckBox("I here by Declare that above enterd Details are correct to the best of Knowladge");
	c7.setBackground(Color.white);
	c7.setFont(new Font("Relway",Font.BOLD,16));
	c7.setBounds(100,640,900,30);
	add(c7);
	
	cancel=new JButton("Cancel");
	cancel.setFont(new Font("Relway",Font.BOLD,16));
	cancel.setForeground(Color.WHITE);
	cancel.setBackground(Color.BLACK);
	cancel.setBounds(200,690,150,30);
	cancel.addActionListener(this);
	add(cancel);
	
	 submit=new JButton("submit");
	 submit.setFont(new Font("Relway",Font.BOLD,16));
	 submit.setForeground(Color.WHITE);
	 submit.setBackground(Color.BLACK);
	 submit.setBounds(550,690,150,30);
	 submit.addActionListener(this);
	add(submit);

	getContentPane().setBackground(Color.white);
	setSize(850,800);
	setLocation(350,10);
	setVisible(true);	
}

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==submit)
	{
		//String formno=null;
		String acctype=null;
		if(r1.isSelected()) {acctype="Savings account";}
		else if(r2.isSelected()) {acctype="current account";}
		else if(r3.isSelected()) {acctype="Fixed Deposit account";}
		else if(r4.isSelected()) {acctype="Reccuring account";}

		Random random=new Random();
		String cardnumber=""+Math.abs((random.nextLong() % 90000000L) +  5040935000000000L);
		String pinnumber=""+Math.abs((random.nextLong() % 9000L)+1000L);
		
		String servicerequired="";
		if(c1.isSelected()) {servicerequired="ATM"; }
		else if(c2.isSelected()) {servicerequired="Email Alerts"; }
		else if(c3.isSelected()) {servicerequired="Net Banking"; }
		else if(c4.isSelected()) {servicerequired="Mobile BAnking"; }
		else if(c5.isSelected()) {servicerequired="Cheque Book"; }
		else if(c6.isSelected()) {servicerequired="E-Statement"; }
		
		try {
			if(acctype==null)
			{JOptionPane.showMessageDialog(null,"select Acc type");}
			else 
			{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","tejas");
			Statement stmt=con.createStatement();
			String query1="insert into signup3 values('"+formno+"','"+acctype+"','"+cardnumber+"','"+pinnumber+"','"+servicerequired+"')";
			String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
			
			stmt.executeUpdate(query1);
			stmt.executeUpdate(query2);
			
			con.close();
			System.out.println("Signup3 Details Submitted successfully");
			if(con.isClosed()) 
			{
				JOptionPane.showMessageDialog(null,"Submitted Successfully");
			    new Login().setVisible(true);
			}
			
			}
			
			if(ae.getSource()==cancel)
			{
				
				
				
			}
		    
		    } 
		
		
		     catch (Exception e)
		    {
			System.out.println(e);
		     }
	}
	
	
	
}

public static void main(String[] args) 
{
	new SignUp3("");
}

	
	
	
	
	
	
	
	
	
}
