package Com.symboisis.BankManagementSystem;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class SignUp2 extends JFrame implements ActionListener
{
String formno;
JLabel Additionaldetails,Religion,Category,Income,Educational,Qualification,Occupation,AdharNo,PanNO,SeniorCitizen,ExistingAccount;
JTextField AdharNoTextField,PanNOTextField;
JButton next;
JRadioButton eayes,eano,syes,sno;
ButtonGroup gendergroup,mstatgroup;
JComboBox Categ,relig,income,Qualifi,Occup ;

	SignUp2(String formno)
	{
		this.formno=formno;
		
		setLayout(null);
		
		 Additionaldetails=new JLabel("Additional Information-Page 2");
		 Additionaldetails.setFont(new Font("Raleway",Font.BOLD,24));
		 Additionaldetails.setBounds(250,80,500,40);
		 add(Additionaldetails);
		 
		 Religion=new JLabel("Religion:");
		 Religion.setFont(new Font("Raleway",Font.BOLD,18));
		 Religion.setBounds(170,200,100,40);
		 add(Religion);
		 
		 String[] str= {"Hindu","Muslim","Sikh","Christian","Other"};
		  relig=new JComboBox(str);
		 relig.setFont(new Font("Raleway",Font.PLAIN,14));
		 relig.setBounds(350,200,300,30);
		 relig.setBackground(Color.WHITE);
		 add(relig);
		 
		 
		 Category=new JLabel("Category:"); 
		 Category.setBounds(170,250,400,30);
		 Category.setFont(new Font("Raleway",Font.BOLD,18));
		 add(Category);
		 
		 String[] S1= {"General","OBC","Sc","ST","Other"};
		  Categ=new JComboBox(S1);
		 Categ.setFont(new Font("Raleway",Font.PLAIN,14));
		 Categ.setBounds(350,250,300,30);
		 Categ.setBackground(Color.WHITE);
		 add(Categ);
		  
		 Income=new JLabel("Income:"); 
		 Income.setBounds(170,300,150,40);
		 Income.setFont(new Font("Raleway",Font.BOLD,18));
		 add(Income);
		 
		 String[] str2= {"Null","<150000","<250000","<500000","Upto 1000000"};
		 income=new JComboBox(str2);
		 income.setFont(new Font("Raleway",Font.PLAIN,14));
		 income.setBounds(350,300,300,30);
		 income.setBackground(Color.WHITE);
		 add(income);
		
		 Educational=new JLabel("Educational"); 
		 Educational.setBounds(170,350,150,40);
		 Educational.setFont(new Font("Raleway",Font.BOLD,18));
		 add(Educational);
		 
		 Qualification=new JLabel("Qualification:"); 
		 Qualification.setBounds(170,370,150,40);
		 Qualification.setFont(new Font("Raleway",Font.BOLD,18));
		 add(Qualification);
		 
		 String[] str3= {"Non Graduation","Graduation","Post Graduation","Doctrate","Others"};
		 Qualifi=new JComboBox(str3);
		 Qualifi.setFont(new Font("Raleway",Font.PLAIN,14));
		 Qualifi.setBounds(350,370,300,30);
		 Qualifi.setBackground(Color.WHITE);
		 add(Qualifi);
		 
		 Occupation=new JLabel("Occupation:"); 
		 Occupation.setBounds(170,450,150,40);
		 Occupation.setFont(new Font("Raleway",Font.BOLD,18));
		 add(Occupation);
		 
		 String[] str4= {"Salaried","SelfEmployed","BuisnessMan","Student","Retired","Others"};
		 Occup=new JComboBox(str4);
		 Occup.setFont(new Font("Raleway",Font.PLAIN,14));
		 Occup.setBounds(350,450,300,30);
		 Occup.setBackground(Color.WHITE);
		 add(Occup );
		 
		 PanNO=new JLabel("PanNO:"); 
		 PanNO.setBounds(170,500,150,40);
		 PanNO.setFont(new Font("Raleway",Font.BOLD,18));
		 add(PanNO);
		 
		 PanNOTextField=new JTextField();
		 PanNOTextField.setFont(new Font("Raleway",Font.PLAIN,14));
		 PanNOTextField.setBounds(350,500,300,30);
		 add(PanNOTextField);
		 
		 AdharNo=new JLabel("AdharNo:"); 
		 AdharNo.setBounds(170,540,150,40);
		 AdharNo.setFont(new Font("Raleway",Font.BOLD,18));
		 add(AdharNo);
		 
		 AdharNoTextField=new JTextField();
		 AdharNoTextField.setFont(new Font("Raleway",Font.PLAIN,14));
		 AdharNoTextField.setBounds(350,540,300,30);
		 add(AdharNoTextField);
		 
		 SeniorCitizen=new JLabel("Senior Citizen:"); 
		 SeniorCitizen.setBounds(170,580,250,40);
		 SeniorCitizen.setFont(new Font("Raleway",Font.BOLD,18));
		 add(SeniorCitizen);
		  
		 syes=new JRadioButton("Yes");
		 syes.setBounds(350,580,100,30);
		 syes.setBackground(Color.WHITE);
		 add(syes);
		 
		 sno=new JRadioButton("No");
		 sno.setBounds(470,580,100,30);
		 sno.setBackground(Color.WHITE);
		 add(sno);
		 
		 ButtonGroup STButton=new ButtonGroup();
		 STButton.add(sno);
		 STButton.add(syes);
		 
		 ExistingAccount=new JLabel("Existing Account:"); 
		 ExistingAccount.setBounds(170,620,250,40);
		 ExistingAccount.setFont(new Font("Raleway",Font.BOLD,18));
		 add(ExistingAccount);
		 
		 eayes=new JRadioButton("Yes");
		 eayes.setBounds(350,620,100,30);
		 eayes.setBackground(Color.WHITE);
		 add(eayes);
		 
		 eano=new JRadioButton("No");
		 eano.setBounds(470,620,100,30);
		 eano.setBackground(Color.WHITE);
		 add( eano);
		 
		 ButtonGroup  eaButton=new ButtonGroup();
		 eaButton.add(eano);
		 eaButton.add (eayes);
		 
		
		 
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
	
	   try {
		
		   String  Religion=(String) relig.getSelectedItem();
		   String Category=(String) Categ.getSelectedItem();
		   String Income=(String) income.getSelectedItem();
		   String EducationalQualification=(String) Qualifi.getSelectedItem();
		   String Occupation=(String) Occup.getSelectedItem();
		   
		   String  AdharNo=AdharNoTextField.getText();
		   String  PanNO= PanNOTextField.getText();
		   
		   String  SeniorCitizen=null;
		   if(syes.isSelected())
		   {SeniorCitizen="Yes";}
		   else if(sno.isSelected())
		   {SeniorCitizen="No";}
		   
		   String ExistingAccount=null;
		   if(eayes.isSelected())
		   {ExistingAccount="Yes";}
		   else if(eano.isSelected())
		   {SeniorCitizen="No";}
		   
		   
               //Save Data Into The Databse
		   
		   Connection Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","tejas");
		   Statement stmt=Con.createStatement();
		   String S2="insert into signup2 values('"+formno+"','"+Religion+"','"+Category+"','"+Occupation+"','"+EducationalQualification+"','"+Income+"','"+AdharNo+"','"+PanNO+"','"+SeniorCitizen+"','"+ExistingAccount+"')";			   
			   stmt.execute(S2);
			   Con.close();
			   
			   if (Con.isClosed())
			   {
				  JOptionPane.showMessageDialog(null,"Submitted") ;
			   }
		      setVisible(false);
		      new SignUp3(formno).setVisible(true);
		
		
	       } 
	   catch (Exception e) 
	   {
	     System.out.println(e);
	   }
	   
	   System.out.println("Signup2 Details Submitted................");
	   
	}
	
	public static void main(String[]args) 
	{
		SignUp2 sinup = new SignUp2("");
		

	}
	
	
}
