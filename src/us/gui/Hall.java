package us.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import us.actions.SearchEmployeeAction;

public class Hall extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public static JTextField searchFLD;
	
	SearchEmployeeAction confirmACT = new SearchEmployeeAction();
	
	public static JFrame frame;
	
	public Hall() {
		bodyCreate();
		
		frame = this;
		
		this.setSize(500, 120);
		this.setResizable(false);
		this.setLocationRelativeTo(null);;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void bodyCreate() {
		setLayout(new BorderLayout());
		
		JPanel tittlePNL = new JPanel();
		tittlePNL.setLayout(new FlowLayout());
		
		JLabel tittleLBL = new JLabel("Pesquisa de Funcionários");
		tittleLBL.setFont(new Font("Verdana", Font.PLAIN, 16));
		tittlePNL.add(tittleLBL);
		
		JPanel inputPNL = new JPanel();
		inputPNL.setLayout(new FlowLayout());
		
		JLabel searchLBL = new JLabel("CPF:");
		searchFLD = new JTextField(30);
		
		JPanel buttonPNL = new JPanel();
		buttonPNL.setLayout(new FlowLayout());
		
		JButton confirm = new JButton("Prosseguir");
		confirm.setBackground(Color.DARK_GRAY);
		confirm.setForeground(Color.WHITE);
		confirm.addActionListener(confirmACT);
		
		JButton cancel = new JButton("Cancelar");
		cancel.setBackground(Color.DARK_GRAY);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {closeFrame();}});
		
		buttonPNL.add(confirm);
		buttonPNL.add(cancel);
		
		
		inputPNL.add(searchLBL);
		inputPNL.add(searchFLD);
		
		add(tittlePNL, BorderLayout.NORTH);
		add(inputPNL, BorderLayout.CENTER);
		add(buttonPNL, BorderLayout.SOUTH);
	
	}
	
	private void closeFrame() {
		this.dispose();
	}

}
