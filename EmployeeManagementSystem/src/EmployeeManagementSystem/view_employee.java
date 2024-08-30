package EmployeeManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class view_employee extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Choice choiceemp;
	JTable table;
	JButton searchbt,print,update,back;
	
	view_employee(){
		
		getContentPane().setBackground(new Color(255,131,122));
		
		JLabel search =new JLabel("search by employee id");
		search.setBounds(20, 20, 150, 20);
		add(search);
		
		choiceemp = new Choice();
		choiceemp.setBounds(180, 20, 150, 20);
		add(choiceemp);
		
		try {
			
			conn c =new conn();
			ResultSet resultset =c.statement.executeQuery("select*from employee");
			while(resultset.next()) {
				choiceemp.add(resultset.getString("empid"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		try {
			
			conn c =new conn();
			ResultSet resultset=c.statement.executeQuery("select*from employee");
			table.setModel(DbUtils.resultSetToTableModel(resultset));
			
			
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane jp =new JScrollPane(table);
		jp.setBounds(0,100,900,600);
		add(jp);
		
		searchbt = new JButton("search");
		searchbt.setBounds(20,70,80,20);
		searchbt.addActionListener(this);
		add(searchbt);
		
		print = new JButton("Print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
		
		update = new JButton("Update");
		update.setBounds(220,70,80,20);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(320,70,80,20);
		back.addActionListener(this);
		add(back);
		
		setSize(900,700);
		setLayout(null);
		setLocation(300,100);
		setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchbt) {
			String query ="select*from employee where empid='"+choiceemp.getSelectedItem()+"'";
			try {
				conn c =new conn();
				ResultSet resultset=c.statement.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(resultset));
				
			}
			catch(Exception E) {
				E.printStackTrace();
			}
			
			
		}else if (e.getSource()==print) {
			try {
				table.print();
			}catch (Exception E) {
				E.printStackTrace();
			}
		}
		else if(e.getSource()==update) {
			setVisible(false);
			new update(choiceemp.getSelectedItem());
			
		}
		else {
			setVisible(false);
		}
		
	}
	
	
	public static void main(String[] args) {
		new view_employee();
	}

}
