package EmployeeManagementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RemoveEmployee extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Choice choiceempid;
	JButton delete,back;
	RemoveEmployee(){
		JLabel label = new JLabel("Employee Id");
		label.setBounds(50,50,100,30);
		label.setFont(new Font ("Tahoma",Font.BOLD,15));
		add(label);
		
		choiceempid=new Choice();
		choiceempid.setBounds(200,50,150,30);
		add(choiceempid);
		
		try {
			conn c =new conn();
			ResultSet resultset =c.statement.executeQuery("select*from employee");
			while(resultset.next()) {
				choiceempid.add(resultset.getString("empid"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel labelName = new JLabel("Name");
		labelName.setBounds(50,100,100,30);
		labelName.setFont(new Font ("Tahoma",Font.BOLD,15));
		add(labelName);
		
		JLabel textName=new JLabel();
		textName.setBounds(200,100,100,30);
		add(textName);
		
		JLabel labelphone = new JLabel("Phone");
		labelphone.setBounds(50,150,100,30);
		labelphone.setFont(new Font ("Tahoma",Font.BOLD,15));
		add(labelphone);
		
		JLabel textPhone=new JLabel();
		textPhone.setBounds(200,150,100,30);
		add(textPhone);
		
		JLabel labelemail = new JLabel("Phone");
		labelemail.setBounds(50,200,100,30);
		labelemail.setFont(new Font ("Tahoma",Font.BOLD,15));
		add(labelemail);
		
		JLabel textemail=new JLabel();
		textemail.setBounds(200,200,100,30);
		add(textemail);
		
		try {
			conn c =new conn();
			ResultSet resultset =c.statement.executeQuery("select *from employee where empid ='"+choiceempid.getSelectedItem()+"'");
			while(resultset.next()) {
				textName.setText(resultset.getString("name"));
				textPhone.setText(resultset.getString("phone"));
				textemail.setText(resultset.getString("email"));

			
			
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		choiceempid.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				try {
					
					conn c =new conn();
					ResultSet resultset =c.statement.executeQuery("select *from employee where empid ='"+choiceempid.getSelectedItem()+"'");
					while(resultset.next()) {
						textName.setText(resultset.getString("name"));
						textPhone.setText(resultset.getString("phone"));
						textemail.setText(resultset.getString("email"));
					}
					
				}catch(Exception E) {
					E.printStackTrace();
				}
		}
		});
		
		delete =new JButton ("delete");
		delete.setBounds(80,300,100,30);
		delete.setBackground(Color.black);
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		add(delete);
		
		
		back =new JButton ("Back");
		back.setBounds(220,300,100,30);
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
	    back.addActionListener(this);
		add(back);
		ImageIcon i1 =new ImageIcon("C:/Users/lenovo/eclipse-workspace/EmployeeManagementSystem/src/icons/delete.png");
		Image i2 =i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img =new JLabel(i3);
		img.setBounds(700,80,200,200);
		add(img);
		
		
		setSize(1000,400);
		setLocation(300,150);
		setLayout(null);
		setVisible(true);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==delete) {
			try {
				conn c =new conn();
				String query ="delete from employee where empid ='"+choiceempid.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee deleted successfully");
                setVisible(false);
                new Main_class();
			
			}catch (Exception E) {
				E.printStackTrace();
			}
		}
		else {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		
		new RemoveEmployee();
	}

}
