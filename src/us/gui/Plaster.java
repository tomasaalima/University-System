package us.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import us.actions.CreateEmployeeAction;
import us.persistence.Connectivity;
import us.persistence.ReadingConnection;

public class Plaster {
	JButton submitBTN = new JButton("Registrar Expecificações");
	
	String sql,tcpf,tdig,tname,twage,tregister,tmail,tcity,tstate,tstreet,tlogin,tpassword;
	
	String cpf = "-";
	String dig = "0";
	String name = "-";
	String wage = "0";
	String register = "0";
	String mail = "-";
	String city = "-";
	String state = "-";
	String street = "-";
	String login = "-";
	String password = "-";
	
	ResultSet rs;
	
	String object;
	String objectID;
	String ObjectIDValue;
	
	private JPanel panel;
	
	
	public Plaster(JPanel panel) {
		submitBTN.setBackground(Color.DARK_GRAY);
		submitBTN.setForeground(Color.WHITE);
		
		tcpf =  ((JTextField) panel.getComponent(5)).getText();
		if(!tcpf.equals("CPF*"))
			this.cpf = tcpf;
		tdig =  ((JTextField) panel.getComponent(6)).getText();
		if(!tdig.equals("DIG*"))
			this.dig = tdig;
		tname =  ((JTextField) panel.getComponent(7)).getText();
		if(!tname .equals("NOME*"))
			this.name = tname;
		twage =  ((JTextField) panel.getComponent(8)).getText();
		if(!twage.equals("SALÁRIO"))
			this.wage = twage;
		tregister =  ((JTextField) panel.getComponent(9)).getText();
		if(!tregister.equals("Nº DE REGISTRO"))
			this.register = tregister;
		tmail =  ((JTextField) panel.getComponent(10)).getText();
		if(!tmail.equals("E-MAIL"))
			this.mail = tmail;
		tcity =  ((JTextField) panel.getComponent(11)).getText();
		if(!tcity.equals("CIDADE"))
			this.city = tcity;
		tstate =  ((JTextField) panel.getComponent(12)).getText();
		if(!tstate.equals("ESTADO"))
			this.state = tstate;
		tstreet =  ((JTextField) panel.getComponent(13)).getText();
		if(!tstreet.equals("RUA"))
			this.street = tstreet;
		tlogin =  ((JTextField) panel.getComponent(14)).getText();
		if(!tlogin.equals("LOGIN*"))
			this.login = tlogin;
		tpassword =  ((JTextField) panel.getComponent(15)).getText();
		if(!tpassword.equals("SENHA*"))
			this.password = tpassword;
		
		registerData("INSERT INTO funcionario(cpf,nome,salario,email,estado,cidade,rua,numero_de_registro,senha,dig,login)"
				+ "VALUES("+cpf+",'"+name+"',"+wage+",'"+mail+"','"+state+"','"+city+"','"+street+"',"+register+",'"+password+"',"+dig+",'"+login+"')");
		
		
		try {
			switch(dig) {
			case "11": {
				plasterApplyDirector(panel);
				break;
			}
			case "13": {
				plasterApplySecretary(panel);
				break;
			}
			case "17": {
				plasterApplyCoordinating(panel);
				break;
			}
			case "19": {
				plasterApplyProfessor(panel);
				break;
			}default:{
				break;
			}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
	private void plasterApplyDirector(JPanel panel){

		JTextField universityFLD = new JTextField();
		universityFLD.setText("UNIVERSIDADE*");
		universityFLD.setBounds(150, 300, 300, 20);
		universityFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(universityFLD);
		
		JTextField possessionFLD = new JTextField();
		possessionFLD.setText("DATA DE POSSE");
		possessionFLD.setBounds(150, 320, 150, 20);
		possessionFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(possessionFLD);
		
		JTextField endPossesionFLD = new JTextField();
		endPossesionFLD.setText("DATA FIM DA POSSE");
		endPossesionFLD.setBounds(300, 320, 150, 20);
		endPossesionFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(endPossesionFLD);
		
		this.object = "funcionario_diretor";
		this.objectID = "nome_universidade";
		
		submitBTN.setBounds(150, 360, 300, 20);
		submitBTN.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ObjectIDValue = universityFLD.getText();
				
				String possesion = (possessionFLD.getText().equals("DATA DE POSSE")? "0001-01-01":possessionFLD.getText());
				String endPossesion = (endPossesionFLD.getText().equals("DATA FIM DA POSSE")? "0001-01-01":possessionFLD.getText());
				
				search("SELECT * FROM universidade WHERE nome = '" + universityFLD.getText() + "'",
						"INSERT INTO funcionario_diretor(nome_universidade, data_de_posse, fim_da_posse, cpf_funcionario) "
						+ "VALUES('"+ universityFLD.getText()+"','"+ possesion+"','"+endPossesion+"',"+cpf+")");
				
			}});
		
		panel.add(universityFLD);
		panel.add(possessionFLD);
		panel.add(endPossesionFLD);
		panel.add(submitBTN);
		panel.repaint();
		
		
		
	}
	private void plasterApplySecretary(JPanel panel) {
		
		JTextField pisFLD = new JTextField();
		pisFLD.setText("PIS/PASEP");
		pisFLD.setBounds(150, 300, 300, 20);
		pisFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(pisFLD);
		
		JTextField setorFLD = new JTextField();
		setorFLD.setText("ID DO SETOR*");
		setorFLD.setBounds(150, 320, 150, 20);
		setorFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(setorFLD);
		
		this.object = "funcionario_secretario";
		this.objectID = "id_setor";
		
		submitBTN.setBounds(150, 360, 300, 20);
		submitBTN.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ObjectIDValue = setorFLD.getText();
				
				String pis = (pisFLD.getText().equals("PIS/PASEP")? "0":pisFLD.getText());
				String setor = (setorFLD.getText().equals("ID DO SETOR*")? "0":setorFLD.getText());
				
				search("SELECT * FROM setor WHERE id = " + (setorFLD.getText().equals("ID DO SETOR*") ? "0" : setorFLD.getText()) + "",
						"INSERT INTO funcionario_secretario(cpf_funcionario, pis_pasep, id_setor) VALUES("+cpf+","+pis+","+setor+")");
			}});

		panel.add(pisFLD);
		panel.add(setorFLD);
		panel.add(submitBTN);
		panel.repaint();
	}
	private void plasterApplyCoordinating(JPanel panel) {

		JTextField especFLD = new JTextField();
		especFLD.setText("ESPECIALIZAÇÃO");
		especFLD.setBounds(150, 300, 300, 20);
		especFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(especFLD);
		
		JTextField courseFLD = new JTextField();
		courseFLD.setText("ID DO CURSO*");
		courseFLD.setBounds(150, 320, 150, 20);
		courseFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(courseFLD);
		
		this.object = "funcionario_coordenador";
		this.objectID = "id_curso";
		
		submitBTN.setBounds(150, 360, 300, 20);
		submitBTN.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ObjectIDValue = courseFLD.getText();
				
				String espec = (especFLD.getText().equals("ESPECIALIZAÇÃO")? "-":especFLD.getText());
				String course = (courseFLD.getText().equals("ID DO CURSO*")? "0":courseFLD.getText());
				
				search("SELECT * FROM curso WHERE id = " + (courseFLD.getText().equals("ID DO CURSO*") ? "0" : courseFLD.getText()) + "",
						"INSERT INTO funcionario_coordenador(cpf_funcionario, especializacao, id_curso) VALUES("+cpf+",'"+espec+"',"+course+")");
			}});

		panel.add(especFLD);
		panel.add(courseFLD);
		panel.add(submitBTN);
		panel.repaint();
	}
	private void plasterApplyProfessor(JPanel panel) {
		
		JTextField formationFLD = new JTextField();
		formationFLD.setText("FORMAÇÃO");
		formationFLD.setBounds(150, 300, 300, 20);
		formationFLD.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(formationFLD);
		
		this.object = "funcionario_professor";
		this.objectID = "formacao";
		
		submitBTN.setBounds(150, 340, 300, 20);
		
		submitBTN.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ObjectIDValue = formationFLD.getText();
				
				String formation = (formationFLD.getText().equals("ESPECIALIZAÇÃO")? "-":formationFLD.getText());
				
				registerEspecific("INSERT INTO funcionario_professor(cpf_funcionario, formacao) VALUES("+cpf+",'"+formation+"')");
			}});

		panel.add(formationFLD);
		panel.add(submitBTN);
		panel.repaint();
		
	}
	
	private void search(String sql, String especific) {
		
		try {
			if(new ReadingConnection().search(sql).next() == false) {
				JOptionPane error = new JOptionPane();
				error.showMessageDialog(null, "AS ASSOCIAÇÕES FEITAS NOS CAMPOS INFERIORES APRESENTARAM INCONSISTÊNCIAS, VERIFICA A EXISTÊNCIA DESSES OBJETOS NO SISTEMA");
			}else {
				registerEspecific(especific);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void registerData(String sql) {
		
		try {
			new Connectivity().sqlExec(sql);
			
			
			if(new ReadingConnection().search("SELECT * FROM funcionario WHERE cpf ='"+cpf+"'").next())
				new JOptionPane().showMessageDialog(null, "FUNCIONÁRIO CADASTRADO COM SUCESSO");
			
		} catch (Exception e) {
			// TODO: handle exception
			new JOptionPane().showMessageDialog(null, "VERIFIQUE OS DADOS INFORMADOS");
		}
	}
	
	private void registerEspecific(String especif) {
		
		try {
			new Connectivity().sqlExec(especif);
			
			
			if(!(new ReadingConnection().search("SELECT * FROM "+object+" WHERE "+objectID+" ='"+ObjectIDValue+"'").next() == false)) {
				new JOptionPane().showMessageDialog(null, "DADOS CADASTRADOS COM SUCESSO");
				CreateEmployeeAction.frame.dispose();
			}
		} catch (Exception e) {
			// TODO: handle exception
			new JOptionPane().showMessageDialog(null, "VERIFIQUE OS DADOS INFORMADOS");
		}
		
	}
}

