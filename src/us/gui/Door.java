package us.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import us.actions.AboutAction;
import us.actions.LoginAction;

public class Door extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public static JPasswordField passWordFLD;
	public static JTextField loginFLD;
	
	AboutAction aboutACT = new AboutAction();
	LoginAction loginACT = new LoginAction();
	
	public static JFrame frame;
	
	public Door() {
		super("UMS");
		
		frame = this;
		
		menuCreate();
		bodyCreate();
		
		this.setSize(500,240);;
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	private void menuCreate() {
		JMenu helpMN = new JMenu("Help");		            //Menu Creation
		JMenuItem helpMNI = new JMenuItem("About us");		//Item Creation	
		helpMNI.addActionListener(aboutACT);
		helpMN.add(helpMNI);
		
		JMenuBar bar = new JMenuBar();					    //Bar Creation
		setJMenuBar(bar);									//Bar Activation
		bar.add(helpMN);
	}
	
	private void bodyCreate() {
		setLayout(new BorderLayout());
		
		JPanel tittlePNL = new JPanel();					//Panel Tittle Define
		tittlePNL.setLayout(new FlowLayout());				//Layout Define
		
		JLabel tittleLBL = new JLabel("Universitary Management System");
		tittleLBL.setFont(new Font("Verdana", Font.PLAIN, 16));
		tittlePNL.add(tittleLBL);
		
		JPanel inputPNL = new JPanel();
		inputPNL.setLayout(new FlowLayout());
		
		JLabel loginIPT = new JLabel("LOG IN: ");			//Label Definition
		loginFLD = new JTextField(40);						//Field for Data Input 
		
		JLabel passWordIPT = new JLabel("PASSWORD: ");
		passWordFLD = new JPasswordField(40);
		passWordFLD.setEchoChar('*');
		
		inputPNL.add(loginIPT);
		inputPNL.add(loginFLD);
		inputPNL.add(passWordIPT);
		inputPNL.add(passWordFLD);
		
		JPanel buttonPNL = new JPanel();					
		buttonPNL.setLayout(new FlowLayout());
		
		JButton loginBTN = new JButton("LOGIN");			//Button Creation
		loginBTN.addActionListener(loginACT);
		
		buttonPNL.add(loginBTN);
		
		add(tittlePNL, BorderLayout.NORTH);
		add(inputPNL, BorderLayout.CENTER);
		add(buttonPNL, BorderLayout.SOUTH);
	}
	
}
