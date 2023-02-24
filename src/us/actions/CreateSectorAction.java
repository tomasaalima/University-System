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

import us.persistence.Connectivity;
import us.persistence.ReadingConnection;

public class CreateSectorAction implements ActionListener{
	JFrame frame;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		frame = new JFrame();
		
		createBody();
		
		frame.setSize(600,250);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void createBody() {
		frame.setLayout(new BorderLayout());
		
		JPanel tittlePNL = new JPanel();
		tittlePNL.setLayout(new FlowLayout());
		
		JLabel tittleLBL = new JLabel("Sector Insertion");
		tittleLBL.setFont(new Font("Verdana", Font.PLAIN, 16));
		tittlePNL.add(tittleLBL);
		
		JPanel formPNL = new JPanel();
		formPNL.setLayout(null);
		
		JTextField idFLD = new JTextField();
		idFLD.setText("ID*");
		idFLD.setBounds(200, 20, 200, 20);
		idFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(idFLD);
		
		JTextField nameFLD = new JTextField();
		nameFLD.setText("NOME*");
		nameFLD.setBounds(200, 40, 200, 20);
		nameFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(nameFLD);
		
		JTextField employeeFLD = new JTextField();
		employeeFLD.setText("Nº DE FUNCIONÁRIOS");
		employeeFLD.setBounds(200, 60, 200, 20);
		employeeFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(employeeFLD);
		
		JTextField dateFLD = new JTextField();
		dateFLD.setText("DATA");
		dateFLD.setBounds(200, 80, 200, 20);
		dateFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(dateFLD);
		
		JButton verifyBTN = new JButton("Enviar Dados");
		verifyBTN.setBounds(200, 120, 200, 20);
		verifyBTN.setBackground(Color.DARK_GRAY);
		verifyBTN.setForeground(Color.WHITE);
		verifyBTN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String date = (dateFLD.getText().equals("DATA") ? "0001-01-01":dateFLD.getText());
				String employee = (employeeFLD.getText().equals("Nº DE FUNCIONÁRIOS") ? "0":employeeFLD.getText());
				String name = (nameFLD.getText().equals("NOME*")? "-":nameFLD.getText());
				String id = (idFLD.getText().equals("SEXO")? "0":idFLD.getText());
				
				
				// TODO Auto-generated method stub
			if(		employeeFLD.getText().equals("Nº DE FUNCIONÁRIOS")    || 
					dateFLD.getText().equals("DATA")                      || 
					idFLD.getText().equals("ID*")                         ||
					nameFLD.getText().equals("NOME*")                          ) {
				
				JOptionPane error = new JOptionPane();
				error.showMessageDialog(null, "ALGUNS CAMPOS OBRIGATÓRIOS* ENCONTRAM-SE VÁZIOS, VERIFIQUE OS DADOS INFORMADOS", "INCOSISTÊNCIA NOS DADOS", error.ERROR_MESSAGE);
				}else {
					registerData(name,id,employee,date);
				}
			}});
		
		formPNL.add(idFLD);
		formPNL.add(nameFLD);
		formPNL.add(employeeFLD);
		formPNL.add(dateFLD);
		
		formPNL.add(verifyBTN);
		
		frame.add(tittlePNL, BorderLayout.NORTH);
		frame.add(formPNL, BorderLayout.CENTER);
	}
	
	private void registerData(String name,String id,String employee,String date) {
		try {
			new Connectivity().sqlExec("INSERT INTO setor(id,nome,n_funcionarios,data)"
					+ "VALUES("+ id +",'"+ name+"',"+ employee + ",'"+ date +"')");
			
			search(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void search(String id) {
		try {		
			if(new ReadingConnection().search("SELECT * FROM setor WHERE id ="+id).next())
				new JOptionPane().showMessageDialog(null, "SETOR CADASTRADA COM SUCESSO");
			
		} catch (Exception e) {
			// TODO: handle exception
			new JOptionPane().showMessageDialog(null, "VERIFIQUE OS DADOS INFORMADOS");
		}
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
