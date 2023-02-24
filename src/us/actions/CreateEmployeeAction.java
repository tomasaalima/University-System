package us.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import us.gui.Plaster;
import us.persistence.Connectivity;

public class CreateEmployeeAction implements ActionListener{
	
	public static JFrame frame;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame = new JFrame();
		
		createBody();
		
		frame.setSize(600,500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void createBody() {
		frame.setLayout(new BorderLayout());
		
		JPanel tittlePNL = new JPanel();
		tittlePNL.setLayout(new FlowLayout());
		
		JLabel tittleLBL = new JLabel("Employee Insertion");
		tittleLBL.setFont(new Font("Verdana", Font.PLAIN, 16));
		tittlePNL.add(tittleLBL);
		
		JPanel formPNL = new JPanel();
		formPNL.setLayout(null);
		
		JTextField cpfFLD = new JTextField();
		cpfFLD.setText("CPF*");
		cpfFLD.setBounds(150, 20, 200, 20);
		cpfFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(cpfFLD);
		
		JTextField digFLD = new JTextField();
		digFLD.setText("DIG*");
		digFLD.setBounds(400, 20, 50, 20);
		digFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(digFLD);
		
		JTextField nameFLD = new JTextField();
		nameFLD.setText("NOME*");
		nameFLD.setBounds(150, 40, 300, 20);
		nameFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(nameFLD);
		
		JTextField wageFLD = new JTextField();
		wageFLD.setText("SALÁRIO");
		wageFLD.setBounds(150, 60, 120, 20);
		wageFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(wageFLD);
		
		JTextField registerFLD = new JTextField();
		registerFLD.setText("Nº DE REGISTRO");
		registerFLD.setBounds(290, 60, 160, 20);
		registerFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(registerFLD);
		
		JTextField mailFLD = new JTextField();
		mailFLD.setText("E-MAIL");
		mailFLD.setBounds(150, 80, 300, 20);
		mailFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(mailFLD);
		
		JTextField cityFLD = new JTextField();
		cityFLD.setText("CIDADE");
		cityFLD.setBounds(150, 140, 100, 20);
		cityFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(cityFLD);
		
		JTextField stateFLD = new JTextField();
		stateFLD.setText("ESTADO");
		stateFLD.setBounds(280, 140, 70, 20);
		stateFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(stateFLD);
		
		JTextField streetFLD = new JTextField();
		streetFLD.setText("RUA");
		streetFLD.setBounds(150, 160, 200, 20);
		streetFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(streetFLD);
		
		JTextField loginFLD = new JTextField();
		loginFLD.setText("LOGIN*");
		loginFLD.setBounds(150, 200, 140, 20);
		loginFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(loginFLD);
		
		JTextField passwordFLD = new JTextField();
		passwordFLD.setText("SENHA*");
		passwordFLD.setBounds(310, 200, 140, 20);
		passwordFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(passwordFLD);
		
		JButton verifyBTN = new JButton("Enviar Dados");
		verifyBTN.setBounds(150, 240, 300, 20);
		verifyBTN.setBackground(Color.DARK_GRAY);
		verifyBTN.setForeground(Color.WHITE);
		verifyBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(		cpfFLD.getText().equals("CPF*")     || 
						digFLD.getText().equals("DIG*")         ||
						nameFLD.getText().equals("NOME*")       ||
						loginFLD.getText().equals("LOGIN*")     ||
						passwordFLD.getText().equals("SENHA*")		) {
				
				JOptionPane error = new JOptionPane();
				error.showMessageDialog(null, "ALGUNS CAMPOS OBRIGATÓRIOS* ENCONTRAM-SE VÁZIOS, VERIFIQUE OS DADOS INFORMADOS", "INCOSISTÊNCIA NOS DADOS", error.ERROR_MESSAGE);
				}else {
					Plaster plaster = new Plaster(formPNL);
				}
			}});
		
		JLabel digInfoLBL = new JLabel("DIG");
		digInfoLBL.setBounds(500, 10, 100, 20);
		digInfoLBL.setFont(new Font("Gotham", Font.PLAIN, 16));
		
		JLabel dig11LBL = new JLabel("11 - Diretor");
		dig11LBL.setBounds(500, 30, 200, 20);
		dig11LBL.setFont(new Font("Gotham", Font.PLAIN, 10));
		
		JLabel dig13LBL = new JLabel("13 - Secretário");
		dig13LBL.setBounds(500, 50, 200, 20);
		dig13LBL.setFont(new Font("Gotham", Font.PLAIN, 10));
		
		JLabel dig17LBL = new JLabel("17 - Coordenador");
		dig17LBL.setBounds(500, 70, 200, 20);
		dig17LBL.setFont(new Font("Gotham", Font.PLAIN, 10));
		
		JLabel dig19LBL = new JLabel("19 - Professor");
		dig19LBL.setBounds(500, 90, 200, 20);
		dig19LBL.setFont(new Font("Gotham", Font.PLAIN, 10));
		
		formPNL.add(digInfoLBL);
		formPNL.add(dig11LBL);
		formPNL.add(dig13LBL);
		formPNL.add(dig17LBL);
		formPNL.add(dig19LBL);
		
		formPNL.add(cpfFLD);
		formPNL.add(digFLD);
		formPNL.add(nameFLD);
		formPNL.add(wageFLD);
		formPNL.add(registerFLD);
		formPNL.add(mailFLD);
		formPNL.add(cityFLD);
		formPNL.add(stateFLD);
		formPNL.add(streetFLD);
		formPNL.add(loginFLD);
		formPNL.add(passwordFLD);
		
		formPNL.add(verifyBTN);
		
		frame.add(tittlePNL, BorderLayout.NORTH);
		frame.add(formPNL, BorderLayout.CENTER);
		
	}
	
	private void toFormat(JTextField fld) {
		fld.setFont(new Font("Verdana", Font.ITALIC, 12));
		fld.setFocusable(false);
		fld.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				fld.setFont(new Font("Verdana", Font.PLAIN, 12));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				fld.setFocusable(true);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
			fld.addFocusListener(new FocusListener(){ 
			public String text = fld.getText();
			
			public void focusGained(FocusEvent e) { 
				fld.setText("");
				}
			
			public void focusLost(FocusEvent e) {
				if(fld.getText().equals("")) {
					fld.setText(text);
				}
				
				}
			
		});
		
	}
	
}
