package EmployeeManagementSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public  class Login extends JFrame implements ActionListener {
	/**
	 * 
	 */
	JTextField tusername;
	JPasswordField tpassword;
	JButton login,back;
	private static final long serialVersionUID = 1L;

	Login(){
		

		JLabel username= new JLabel("Username");
		username.setBounds(40,20,100,30);
		add(username);
		
		tusername =new JTextField();
		tusername.setBounds(150,20,150,30);
		add(tusername);
		
		JLabel password= new JLabel("Password");
		password.setBounds(40,70,100,30);
		add(password);
		
		tpassword = new JPasswordField();
		tpassword.setBounds(150,70,150,30);
		add(tpassword);
		
		login =new JButton("Login");
	    login.setBounds(150,140,150,30);
	    login.setBackground(Color.black);
	    login.setForeground(Color.WHITE);
	    login.addActionListener(this);	 
	    add(login);
		
		
	    back =new JButton("Back");
	    back.setBounds(150,180,150,30);
	    back.setBackground(Color.black);
	    back.setForeground(Color.WHITE);
	    back.addActionListener(this);
	    add(back);
	    
	    
	    ImageIcon i11 =new ImageIcon("C:/Users/lenovo/eclipse-workspace/EmployeeManagementSystem/src/icons/second.jpg");  
	    Image i22 =i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
	    ImageIcon i33 =new ImageIcon(i22);
	    JLabel imgg =new JLabel(i33);
	    imgg.setBounds(350,10,600,300);
	    add(imgg);
	    
	    ImageIcon i1 =new ImageIcon("C:/Users/lenovo/eclipse-workspace/EmployeeManagementSystem/src/icons/LoginB.jpg");  
	    Image i2 =i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
	    ImageIcon i3 =new ImageIcon(i2);
	    JLabel img =new JLabel(i3);
	    img.setBounds(0,0,600,300);
	    add(img);
	    
		setSize(600,300);
		setLocation(450,200);
		setLayout(null);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== login) {
			try {
				
				String username =tusername.getText();
				@SuppressWarnings("deprecation")
				String password=tpassword.getText();
				conn conn =new conn();
				String query="select*from login where username ='"+username+"'and password ='"+password+"'";
				ResultSet resultset = conn.statement.executeQuery(query);
				if(resultset.next()) {
					setVisible(false);
					new Main_class();
				
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
				}
				
				
			}catch(Exception E) {
				E.printStackTrace();
			}
		
	}else if  (e.getSource()==back){
	
		System.exit(90);
		
	}
	}
	
	public static void main(String[] args) {
		new Login();
		
	}

}