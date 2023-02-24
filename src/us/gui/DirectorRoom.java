package us.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import us.actions.ShowCoordinatingAction;
import us.actions.ShowCoursesAction;
import us.actions.ShowDisciplinesAction;
import us.actions.ShowProfessorsAction;
import us.actions.ShowSecretariesAction;
import us.actions.ShowSectorsAction;
import us.actions.ShowStudentsAction;
import us.persistence.ReadingConnection;

public class DirectorRoom extends JFrame{
	private static final long serialVersionUID = 1L;
	
	ReadingConnection connection = new ReadingConnection();
	
	String sql;
	ResultSet rs;
	
	private String name;
	private String cpf;
	
	ShowProfessorsAction professorsACT = new ShowProfessorsAction();
	ShowCoordinatingAction coordinatingsACT = new ShowCoordinatingAction();
	ShowSecretariesAction secretariesACT = new ShowSecretariesAction();
	ShowStudentsAction studentsACT = new ShowStudentsAction();
	ShowSectorsAction sectorsACT = new ShowSectorsAction();
	ShowDisciplinesAction disciplinesACT = new ShowDisciplinesAction();
	ShowCoursesAction coursesACT = new ShowCoursesAction();
	ActionListener searchACT = new ActionListener() {public void actionPerformed(ActionEvent e) {new Hall();}};
	
	public DirectorRoom(String name, String cpf) {
		super("UMS");
		
		this.setName(name);
		this.setCpf(cpf);
		
		menuCreate();
		bodyCreate();
		
		this.setSize(600,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	private void menuCreate() {
		JMenu optMN = new JMenu("Options");
		JMenuItem optMNI = new JMenuItem("Option One");
	}
	
	private void bodyCreate() {
		setLayout(new BorderLayout());
		
		JPanel tittlePNL = new JPanel();
		tittlePNL.setLayout(new FlowLayout());

		JLabel tittleLBL = new JLabel();
		tittleLBL.setText("<html>" + breakLines(1) + getUni() + "</html>");
		tittleLBL.setFont(new Font("Verdana", Font.PLAIN, 22));
		
		tittlePNL.add(tittleLBL);
		
		JPanel feetPNL = new JPanel();
		feetPNL.setLayout(new FlowLayout());
		
		JLabel feetLBL = new JLabel();
		feetLBL.setText("~" + this.getName() + "~");
		feetLBL.setFont(new Font("Verdana", Font.PLAIN, 8));
		
		feetPNL.add(feetLBL);
		
		JPanel buttonPNL = new JPanel();
		buttonPNL.setLayout(null);
		
		JButton showProfessorsBTN = new JButton("Professores");
		showProfessorsBTN.setBackground(Color.DARK_GRAY);
		showProfessorsBTN.setForeground(Color.WHITE);
		showProfessorsBTN.setBounds(150, 40, 300, 20);
		showProfessorsBTN.addActionListener(professorsACT);
		
		JButton showCoordinatingsBTN = new JButton("Coordenadores");
		showCoordinatingsBTN.setBackground(Color.DARK_GRAY);
		showCoordinatingsBTN.setForeground(Color.WHITE);
		showCoordinatingsBTN.setBounds(150, 60, 300, 20);
		showCoordinatingsBTN.addActionListener(coordinatingsACT);
		
		JButton showSecretariesBTN = new JButton("Secretários");
		showSecretariesBTN.setBackground(Color.DARK_GRAY);
		showSecretariesBTN.setForeground(Color.WHITE);
		showSecretariesBTN.setBounds(150, 80, 300, 20);
		showSecretariesBTN.addActionListener(secretariesACT);
		
		JButton showStudentsBTN = new JButton("Alunos");
		showStudentsBTN.setBackground(Color.DARK_GRAY);
		showStudentsBTN.setForeground(Color.WHITE);
		showStudentsBTN.setBounds(150, 100, 300, 20);
		showStudentsBTN.addActionListener(studentsACT);
		
		
		JButton showSectors = new JButton("Setores");
		showSectors.setBackground(Color.DARK_GRAY);
		showSectors.setForeground(Color.WHITE);
		showSectors.setBounds(150, 140, 300, 20);
		showSectors.addActionListener(sectorsACT);
		
		JButton showDisciplines = new JButton("Disciplinas");
		showDisciplines.setBackground(Color.DARK_GRAY);
		showDisciplines.setForeground(Color.WHITE);
		showDisciplines.setBounds(150, 160, 300, 20);
		showDisciplines.addActionListener(disciplinesACT);
		
		JButton showCourses = new JButton("Cursos");
		showCourses.setBackground(Color.DARK_GRAY);
		showCourses.setForeground(Color.WHITE);
		showCourses.setBounds(150, 180, 300, 20);
		showCourses.addActionListener(coursesACT);
		
		
		JButton toOpen = new JButton("Eventos(OFF)");
		toOpen.setBackground(Color.DARK_GRAY);
		toOpen.setForeground(Color.WHITE);
		toOpen.setBounds(150, 220, 300, 20);
		//toOpen.addActionListener();
		
		JButton toMark = new JButton("Criar Evento(OFF)");
		toMark.setBackground(Color.DARK_GRAY);
		toMark.setForeground(Color.WHITE);
		toMark.setBounds(150, 240, 300, 20);
		//toMark.addActionListener();
		
		
		JButton search = new JButton("Pesquisar Funcionário");
		search.setBackground(Color.DARK_GRAY);
		search.setForeground(Color.WHITE);
		search.setBounds(150, 280, 300, 20);
		search.addActionListener(searchACT);
		
		buttonPNL.add(showProfessorsBTN);
		buttonPNL.add(showCoordinatingsBTN);
		buttonPNL.add(showSecretariesBTN);
		buttonPNL.add(showStudentsBTN);
		
		buttonPNL.add(showSectors);
		buttonPNL.add(showCourses);
		buttonPNL.add(showDisciplines);
		
		buttonPNL.add(toOpen);
		buttonPNL.add(toMark);
		
		buttonPNL.add(search);
		
		add(tittlePNL, BorderLayout.NORTH);
		add(buttonPNL, BorderLayout.CENTER);
		add(feetPNL, BorderLayout.SOUTH);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	private String breakLines(int amount) {
		String result = "<br>";
		
		for(int i = 1; i < amount; i++) {
			result += "<br>";
		}
		return result;
	}

	private String getUni() {
		String temp = "";
		
		sql = "SELECT nome_universidade FROM funcionario_diretor WHERE cpf_funcionario = " + cpf;
		
		rs = connection.search(sql);
		
		try {
			while(rs.next()) {
			temp = rs.getString("nome_universidade");
			}
			
			return temp;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
}
