package EmployeeManagementSystem;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class SplashScreen extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SplashScreen(){
	ImageIcon i1=new ImageIcon("C:/Users/lenovo/eclipse-workspace/EmployeeManagementSystem/src/icons/front.gif");
	Image i2 =i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);	
	ImageIcon i3 = new ImageIcon(i2);
	JLabel image = new JLabel(i3);
	image.setBounds(0,0,1170,650);
	add(image);
		setSize(1170,650);
		setLocation(200,50);
		setLayout(null);
		setVisible(true);
		
		try {
			Thread.sleep(5000);
			setVisible(false);
			new Login();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		new SplashScreen();
	}

}
