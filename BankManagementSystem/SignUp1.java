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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


public class SignUp1 extends JFrame implements ActionListener 
{
	Long random;
	JLabel formno,personaldetails,name,fathersName,dob,gen,Mstat,email,city,pincode,country,adress;
	JTextField nameTextField, fathersNameTextField,emailNameTextField,adressNameTextField,cityNameTextField,pincodeTextField,countryTextField;
	JButton next;
	JRadioButton genderChooser1,genderChooser2,genderChooser3,mstat1,mstat2,mstat3;
	ButtonGroup gendergroup,mstatgroup;
	JDateChooser dateChooser;

	SignUp1()
	{
	
		setLayout(null);
		 
		Random ran=new Random();
		
		random=Math.abs(ran.nextLong() % 9000L)+ 1000L;
		System.out.println(random);
		
		
		 formno=new JLabel("Application Form No "+random);
		 formno.setFont(new Font("Raleway",Font.BOLD,30));
		 formno.setBounds(200,20,600, 40);
		 add(formno);
		 
		 personaldetails=new JLabel("Page 1:Personal Details");
		 personaldetails.setFont(new Font("Raleway",Font.BOLD,24));
		 personaldetails.setBounds(250,80,500,40);
		 add(personaldetails);
		 
		 name=new JLabel("Name:");
		 name.setFont(new Font("Raleway",Font.BOLD,18));
		 name.setBounds(150,200,100,40);
		 add(name);
		 
		 nameTextField=new JTextField();
		 nameTextField.setFont(new Font("Raleway",Font.PLAIN,14));
		 nameTextField.setBounds(350,200,300,30);
		 add(nameTextField);
		 
		 
	     fathersName=new JLabel("Fathers Name:"); 
		 fathersName.setBounds(150,250,400,30);
		 fathersName.setFont(new Font("Raleway",Font.BOLD,18));
		 add(fathersName);
		 
		 fathersNameTextField=new JTextField();
		 fathersNameTextField.setFont(new Font("Raleway",Font.PLAIN,14));
		 fathersNameTextField.setBounds(350,250,300,30);
		 add(fathersNameTextField);
		
		  dob=new JLabel("Date Of Birth:"); 
		 dob.setBounds(150,300,150,40);
		 dob.setFont(new Font("Raleway",Font.BOLD,18));
		 add(dob);
		 
		dateChooser=new JDateChooser();
		dateChooser.setBounds(350,300,200,30);
	     add(dateChooser);
		
		  gen=new JLabel("Gender:"); 
		 gen.setBounds(150,350,150,40);
		 gen.setFont(new Font("Raleway",Font.BOLD,18));
		 add(gen);
		 
		 genderChooser1=new JRadioButton("Male");
		 genderChooser1.setBounds(350,350,70,30);
		 genderChooser1.setBackground(Color.WHITE);
		 add(genderChooser1);
		 genderChooser2=new JRadioButton("Female");
		 genderChooser2.setBounds(430,350,70,30);
		 genderChooser2.setBackground(Color.WHITE);
		 add(genderChooser2);
		 genderChooser3=new JRadioButton("Others");
		 genderChooser3.setBounds(510,350,70,30);
		 genderChooser3.setBackground(Color.WHITE);
		 add(genderChooser3);
		 
		 gendergroup=new ButtonGroup();
		 gendergroup.add(genderChooser1);
		 gendergroup.add(genderChooser2);
		 gendergroup.add(genderChooser3);
		 
		 email=new JLabel("Email:"); 
		 email.setBounds(150,400,150,40);
		 email.setFont(new Font("Raleway",Font.BOLD,18));
		 add(email);
		 
		 emailNameTextField=new JTextField();
		 emailNameTextField.setFont(new Font("Raleway",Font.PLAIN,14));
		 emailNameTextField.setBounds(350,400,300,30);
		 add(emailNameTextField);
		 
		 Mstat=new JLabel("MaritalStatus:"); 
		 Mstat.setBounds(150,450,150,40);
		 Mstat.setFont(new Font("Raleway",Font.BOLD,18));
		 add(Mstat);
		 
		 mstat1=new JRadioButton("Married");
		 mstat1.setBounds(350,450,100,40);
		 mstat1.setBackground(Color.WHITE);
		 add(mstat1);
		 mstat2=new JRadioButton("Unmarried");
		 mstat2.setBounds(460,450,100,40);
		 mstat2.setBackground(Color.WHITE);
		 add(mstat2);
		 mstat3=new JRadioButton("Other");
		 mstat3.setBounds(570,450,100,40);
		 mstat3.setBackground(Color.WHITE);
		 add(mstat3);
		 
		 
		  mstatgroup=new ButtonGroup();
		  mstatgroup.add(mstat1);
		  mstatgroup.add(mstat2);
		  mstatgroup.add(mstat3);
		 
		 adress=new JLabel("Adress:"); 
		 adress.setBounds(150,500,150,40);
		 adress.setFont(new Font("Raleway",Font.BOLD,18));
		 add(adress);
		 
		 adressNameTextField=new JTextField();
		 adressNameTextField.setFont(new Font("Raleway",Font.PLAIN,14));
		 adressNameTextField.setBounds(350,500,300,30);
		 add(adressNameTextField);
		 
		 city=new JLabel("City:"); 
		 city.setBounds(150,540,150,40);
		 city.setFont(new Font("Raleway",Font.BOLD,18));
		 add(city);
		 
		 cityNameTextField=new JTextField();
		 cityNameTextField.setFont(new Font("Raleway",Font.PLAIN,14));
		 cityNameTextField.setBounds(350,540,300,30);
		 add(cityNameTextField);
		 
	     pincode=new JLabel("Pincode:"); 
		 pincode.setBounds(150,580,250,40);
		 pincode.setFont(new Font("Raleway",Font.BOLD,18));
		 add( pincode);
		 
		 pincodeTextField=new JTextField();
		 pincodeTextField.setFont(new Font("Raleway",Font.PLAIN,14));
		 pincodeTextField.setBounds(350,580,150,30);
		 add(pincodeTextField);
		 
		 country=new JLabel("Country:"); 
		 country.setBounds(150,620,250,40);
		 country.setFont(new Font("Raleway",Font.BOLD,18));
		 add(country);
		 
		 countryTextField=new JTextField();
		 countryTextField.setFont(new Font("Raleway",Font.PLAIN,14));
		 countryTextField.setBounds(350,620,150,30);
		 add(countryTextField);
		 
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	
	
	next=new JButton("Next");
	next.setBackground(Color.BLACK);
	next.setForeground(Color.WHITE);
	next.setBounds(700,700,100,30);
	next.addActionListener(this);
	add(next);
	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String formno=""+random;
		String name=nameTextField.getText();
	   String fathersName=fathersNameTextField.getText();
	   String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
	   
	   String gen=null;
	   if(genderChooser1.isSelected()){gen="Male";}
	   else if(genderChooser2.isSelected()){gen="Female";}
	   else if(genderChooser3.isSelected()){gen="Other";}
       
	   String Mstat=null;
	   if( mstat1.isSelected()){Mstat="Married";}
	   else if (mstat2.isSelected()){ Mstat="Unmarried";} 
	   else if (mstat3.isSelected()){ Mstat="other";}
	   
	   String email=emailNameTextField.getText();
	   String city=cityNameTextField.getText();
	   String pincode=pincodeTextField.getText();
	   String country=countryTextField.getText();
	   String adress=adressNameTextField.getText();
	   
	   try {
		   if(name.equals(""))
		   {
			   JOptionPane.showMessageDialog(null,"Name is Required");
			   
		   }
		   else
		   {
			   Connection Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","tejas");
			   Statement stmt=Con.createStatement();
			   String S="insert into signup1 values('"+formno+"','"+name+"','"+fathersName+"','"+dob+"','"+gen+"','"+Mstat+"','"+email+"','"+city+"','"+pincode+"','"+country+"','"+adress+"')";			   
			   stmt.execute(S);
			   Con.close();
			   
			   if (Con.isClosed())
			   {
				  JOptionPane.showMessageDialog(null,"Submitted") ;
			   }
			   
			   setVisible(false);
				
			   new SignUp2(formno).setVisible(true);
		   }
		
	       } 
	   catch (Exception e) 
	   {
	     System.out.println(e);
	   }
	   
	   System.out.println("... SignUp1 Details Submitted ...");
	   
	}
	
	public static void main(String[]args) 
	{
		SignUp1 sinup=new SignUp1();
		

	}
	
	
	
}
