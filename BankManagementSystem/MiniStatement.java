package Com.symboisis.BankManagementSystem;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MiniStatement extends JFrame{

	 	
	 		MiniStatement(String pinnumber){
	 			setTitle("Mini Statement");
	 			
	 			setLayout(null);
	 			
	 			JLabel mini= new JLabel();
	 			add(mini);
	 			
	 			JLabel bank = new JLabel();
	 			bank.setBounds(150,20,100,20);
	            add(bank);
	            
	            JLabel mini = new JLabel();
	            mini.setBounds(20,80,300,20);
	            add(mini);
	            
	            JLabel card = new JLabel();
	            card.setBounds(20,80,300,20);
	            add(card);
	            
	            JLabel balance = new JLabel();
	            balance.setBounds(20,400,300,20);
	            add(balance);
	        
	            
	            
	            
	            
	    	    setSize(900, 900);
	    		setLocation(0,0);
	    		setVisible(true);
	 		}
	 		public void actionperformed(ActionEvent e)
	 		{
	 			if(e.getSource()==ministatement)
	 			
	 			try {
	 				
	 				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb");
	 				con.s.executeQuery("select * from login where pin = ' "+pinnumber+" ' ");
	 				while(rs.next())
	 						card.setText("Card Number"+ rs.getString("cardnumber").subString(0,4)+"xxxxxxxx"+ rs.getString("cardnumber").subString(12));
	 			}catch (Exception e)
	 			{
	 				System.out.println(e);
	 			}
	 			
	 			try {
	 				
	 				Conn conn = new Conn();
	 				int bal = 0;
	 				
	 				ResultSet rs = conn.s.executeQuery("select * from bank where pin= '"+pinnumber+"'");
	 				while(rs.next()) {
	 					mini.setText(mini.getText()+ "<html> "+ rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
	 				
	 				if(rs.getString("type").equals("Deposit")) {
	 					bal+= Integer.parseInt(rs.getString("amount"));
	 				}
	 				else {
	 					bal -= Integer.parseInt(rs.getString("amount"));
	 				}
	 				}
	 				balance.setText("Your Current account balance is Rs"+ bal);
	 			}catch(Exception e) {
	 				System.out.println(e);
	 			}
	 			
	 			mini.setBounds(20,140,400,200);
	            
	            
	 			setSize(400,600);
	 			setLocation(20, 20);
	 			getContent Pane().setBackground(Color.WHITE);
	 			setVisible(true);
	 			
	 		}
	 		
	 		public static void main(String[]args)
	 		{
	 			new MiniStatement("");
	 			
	 	}
	 }

	 /* else if(ae.getsource()==ministatement){
	  * new MiniStatement(pinnumber).setVisible(true);
	  * }
	  * }



}