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

import us.actions.CreateCourseAction;
import us.actions.CreateDisciplineAction;
import us.actions.CreateEmployeeAction;
import us.actions.CreateSectorAction;
import us.actions.CreateStudentAction;
import us.actions.DeleteCourseAction;
import us.actions.DeleteDisciplineAction;
import us.actions.DeleteEmployeeAction;
import us.actions.DeleteSectorAction;
import us.actions.DeleteStudentAction;
import us.actions.UpdateDataAction;

public class AdminRoom extends JFrame{
	
	private String name;
	
	ActionListener searchACT = new ActionListener() {public void actionPerformed(ActionEvent e) {new Hall();}};
	CreateEmployeeAction createEmpACT = new CreateEmployeeAction();
	CreateStudentAction createStudentACT = new CreateStudentAction();
	CreateCourseAction createCourseACT = new CreateCourseAction();
	CreateDisciplineAction createDisciplineACT = new CreateDisciplineAction();
	CreateSectorAction createSectorACT = new CreateSectorAction();
	DeleteEmployeeAction deleteEmployeeACT = new DeleteEmployeeAction();
	DeleteStudentAction deleteStudentACT = new DeleteStudentAction();
	DeleteCourseAction deleteCourseACT = new DeleteCourseAction();
	DeleteDisciplineAction deleteDisciplineACT = new DeleteDisciplineAction();
	DeleteSectorAction deleteSectorACT = new DeleteSectorAction();
	UpdateDataAction updateDataACT = new UpdateDataAction();
	
	
	public AdminRoom(String name) {
		super("UMS");
		
		this.setName(name);
		
		bodyCreate();
		
		this.setSize(600,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}

	private void bodyCreate() {
		setLayout(new BorderLayout());
		
		JPanel tittlePNL = new JPanel();
		tittlePNL.setLayout(new FlowLayout());

		JLabel tittleLBL = new JLabel();
		tittleLBL.setText("<html>" + breakLines(1) + "ADMINISTRADOR" + "</html>");
		tittleLBL.setFont(new Font("Verdana", Font.PLAIN, 22));
		
		tittlePNL.add(tittleLBL);
		
		JPanel feetPNL = new JPanel();
		feetPNL.setLayout(new FlowLayout());
		
		JLabel feetLBL = new JLabel();
		feetLBL.setText("~" + this.getName() + "~");
		feetLBL.setFont(new Font("Verdana", Font.PLAIN, 8));
		
		feetPNL.add(feetLBL);
		
		JPanel ButtonPNL = new JPanel();
		ButtonPNL.setLayout(null);
		
		JButton createEmployeeBTN = new JButton("Registrar Funcionário");
		createEmployeeBTN.setBackground(Color.DARK_GRAY);
		createEmployeeBTN.setForeground(Color.WHITE);
		createEmployeeBTN.setBounds(150, 40, 300, 20);
		createEmployeeBTN.addActionListener(createEmpACT);
		
		JButton createStudentBTN = new JButton("Registrar Aluno");
		createStudentBTN.setBackground(Color.DARK_GRAY);
		createStudentBTN.setForeground(Color.WHITE);
		createStudentBTN.setBounds(150, 60, 300, 20);
		createStudentBTN.addActionListener(createStudentACT);
		
		JButton createCourseBTN = new JButton("Registrar Curso");
		createCourseBTN.setBackground(Color.DARK_GRAY);
		createCourseBTN.setForeground(Color.WHITE);
		createCourseBTN.setBounds(150, 80, 300, 20);
		createCourseBTN.addActionListener(createCourseACT);
		
		JButton createDisciplineBTN = new JButton("Registrar Disciplina");
		createDisciplineBTN.setBackground(Color.DARK_GRAY);
		createDisciplineBTN.setForeground(Color.WHITE);
		createDisciplineBTN.setBounds(150, 100, 300, 20);
		createDisciplineBTN.addActionListener(createDisciplineACT);
		
		JButton createSectorBTN = new JButton("Registrar Setor");
		createSectorBTN.setBackground(Color.DARK_GRAY);
		createSectorBTN.setForeground(Color.WHITE);
		createSectorBTN.setBounds(150, 120, 300, 20);
		createSectorBTN.addActionListener(createSectorACT);
		
		
		
		JButton search = new JButton("Pesquisar Funcionário");
		search.setBackground(Color.DARK_GRAY);
		search.setForeground(Color.WHITE);
		search.setBounds(150, 280, 300, 20);
		search.addActionListener(searchACT);
		
		JButton update = new JButton("Alterar Dados");
		update.setBackground(Color.DARK_GRAY);
		update.setForeground(Color.WHITE);
		update.setBounds(150, 300, 300, 20);
		update.addActionListener(updateDataACT);
		
		
		
		JButton deleteEmployeeBTN = new JButton("Remover Funcionário");
		deleteEmployeeBTN.setBackground(Color.DARK_GRAY);
		deleteEmployeeBTN.setForeground(Color.WHITE);
		deleteEmployeeBTN.setBounds(150, 160, 300, 20);
		deleteEmployeeBTN.addActionListener(deleteEmployeeACT);
		
		JButton deleteStudentBTN = new JButton("Remover Aluno");
		deleteStudentBTN.setBackground(Color.DARK_GRAY);
		deleteStudentBTN.setForeground(Color.WHITE);
		deleteStudentBTN.setBounds(150, 180, 300, 20);
		deleteStudentBTN.addActionListener(deleteStudentACT);
		
		JButton deleteCourseBTN = new JButton("Remover Curso");
		deleteCourseBTN.setBackground(Color.DARK_GRAY);
		deleteCourseBTN.setForeground(Color.WHITE);
		deleteCourseBTN.setBounds(150, 200, 300, 20);
		deleteCourseBTN.addActionListener(deleteCourseACT);
		
		JButton deteleDisciplineBTN = new JButton("Remover Disciplina");
		deteleDisciplineBTN.setBackground(Color.DARK_GRAY);
		deteleDisciplineBTN.setForeground(Color.WHITE);
		deteleDisciplineBTN.setBounds(150, 220, 300, 20);
		deteleDisciplineBTN.addActionListener(deleteDisciplineACT);
		
		JButton deleteSectorBTN = new JButton("Remover Setor");
		deleteSectorBTN.setBackground(Color.DARK_GRAY);
		deleteSectorBTN.setForeground(Color.WHITE);
		deleteSectorBTN.setBounds(150, 240, 300, 20);
		deleteSectorBTN.addActionListener(deleteSectorACT);
		
		ButtonPNL.add(createEmployeeBTN);
		ButtonPNL.add(createStudentBTN);
		ButtonPNL.add(createSectorBTN);
		ButtonPNL.add(createCourseBTN);
		ButtonPNL.add(createDisciplineBTN);
		
		ButtonPNL.add(search);
		ButtonPNL.add(update);
		
		ButtonPNL.add(deleteEmployeeBTN);
		ButtonPNL.add(deleteStudentBTN);
		ButtonPNL.add(deleteSectorBTN);
		ButtonPNL.add(deleteCourseBTN);
		ButtonPNL.add(deteleDisciplineBTN);
		
		add(tittlePNL, BorderLayout.NORTH);
		add(ButtonPNL, BorderLayout.CENTER);
		add(feetPNL, BorderLayout.SOUTH);
	}
	
	private String breakLines(int amount) {
		String result = "<br>";
		
		for(int i = 1; i < amount; i++) {
			result += "<br>";
		}
		return result;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
