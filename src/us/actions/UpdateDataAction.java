package us.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import us.gui.Windows;
import us.persistence.Connectivity;
import us.persistence.ReadingConnection;

public class UpdateDataAction implements ActionListener{
	
	JFrame frame;
	JPanel centerPNL;
	
	String object;
	String objectValue;
	String objectType;
	
	Windows windows;
	
	String[] columns;
	String[][] data;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame = new JFrame();
		
		createBody();
		
		frame.setBounds(650,500,700,300);;
		frame.setResizable(false);
		frame.setVisible(true);

	}

	public void createBody() {
		frame.setLayout(new BorderLayout());

		JPanel tittlePNL = new JPanel();
		tittlePNL.setLayout(new FlowLayout());
		
		JLabel tittleLBL = new JLabel("Campo de Alterações");
		tittleLBL.setFont(new Font("Verdana", Font.PLAIN, 16));
		tittlePNL.add(tittleLBL);
		
		centerPNL = new JPanel();
		centerPNL.setLayout(null);
		
		JLabel objectLBL = new JLabel("MUDAR DADOS DE UM(A):");
		objectLBL.setFont(new Font("Verdana", Font.PLAIN, 12));
		objectLBL.setBounds(50, 30, 300, 20);
		
		String[] object = {"...","FUNCIONARIO", "ALUNO", "CURSO","DISCIPLINA","UNIVERSIDADE","SETOR",};
				
		JComboBox objectCBB = new JComboBox(object);
		objectCBB.setBounds(220, 30, 120, 20);
		objectCBB.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				plaster(objectCBB.getSelectedIndex(),objectCBB);
			}
			
		});
		
		centerPNL.add(objectLBL);
		centerPNL.add(objectCBB);
		
		frame.add(tittlePNL, BorderLayout.NORTH);
		frame.add(centerPNL, BorderLayout.CENTER);
		
	}
	
	private void plaster(Integer index, JComboBox cbb) {
		try {
			switch (index) {
			case 0: {
				new JOptionPane().showMessageDialog(null, "É NECESSÁRIO INFORMAR O TIPO DE OBJETO PARA EDIÇÃO");
				break;
			}
			case 1:{
				employeeEdit(cbb);
				break;
			}
			case 2:{
				studentEdit(cbb);
				break;
			}
			case 3:{
				courseEdit(cbb);
				break;
			}
			case 4:{
				disciplineEdit(cbb);
				break;
			}
			case 5:{
				universityEdit(cbb);
				break;
			}
			case 6:{
				sectorEdit(cbb);
				break;
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void employeeEdit(JComboBox cbb) {
		
		JTextField field = new JTextField("CPF");
		field.setBounds(400, 25, 200, 30);
		field.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(field);
	
		JButton verify = new JButton("✓");
		verify.setBounds(600, 25, 50, 30);
		verify.setBackground(Color.DARK_GRAY);
		verify.setForeground(Color.WHITE);
		verify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cbb.setEnabled(false);
				if(		field.getText().equals(null) ||
						field.getText().equals("")   ||
						field.getText().equals("CPF")    ) {
					new JOptionPane().showMessageDialog(null, "É NECESSÁRIO INFORMAR UM CPF VÁLIDO");;
					
				}else {
					object = "funcionario";
					objectValue = field.getText();
					objectType = "cpf";
					
					show();
				}
				
			}
			
		});
		
		centerPNL.add(field);
		centerPNL.add(verify);
		centerPNL.repaint();
	}
	
	private void sectorEdit(JComboBox cbb) {
		
		JTextField field = new JTextField("ID");
		field.setBounds(400, 25, 200, 30);
		field.setFont(new Font("Verdana", Font.ITALIC, 10));
		toFormat(field);
	
		JButton verify = new JButton("✓");
		verify.setBounds(600, 25, 50, 30);
		verify.setBackground(Color.DARK_GRAY);
		verify.setForeground(Color.WHITE);
		verify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cbb.setEnabled(false);
				if(		field.getText().equals(null) ||
						field.getText().equals("") ||
						field.getText().equals("ID")    ) {
					new JOptionPane().showMessageDialog(null, "É NECESSÁRIO INFORMAR UM ID VÁLIDO");;
					
				}else {
					object = "setor";
					objectValue = field.getText();
					objectType = "id";
					
					show();
				}
				
			}
			
		});
		
		centerPNL.add(field);
		centerPNL.add(verify);
		centerPNL.repaint();
	
		
	}

	private void studentEdit(JComboBox cbb) {
	
	JTextField field = new JTextField("MATRÍCULA");
	field.setBounds(400, 25, 200, 30);
	field.setFont(new Font("Verdana", Font.ITALIC, 10));
	toFormat(field);

	JButton verify = new JButton("✓");
	verify.setBounds(600, 25, 50, 30);
	verify.setBackground(Color.DARK_GRAY);
	verify.setForeground(Color.WHITE);
	verify.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cbb.setEnabled(false);
			if(		field.getText().equals(null) ||
					field.getText().equals("") ||
					field.getText().equals("MATRÍCULA")    ) {
				new JOptionPane().showMessageDialog(null, "É NECESSÁRIO INFORMAR UMA MATRÍCULA VÁLIDO");;
				
			}else {
				object = "aluno";
				objectValue = field.getText();
				objectType = "matricula";
				
				show();
			}
			
		}
		
	});
	
	
	centerPNL.add(field);
	centerPNL.add(verify);
	centerPNL.repaint();

	
}

	private void courseEdit(JComboBox cbb) {
	
	JTextField field = new JTextField("ID");
	field.setBounds(400, 25, 200, 30);
	field.setFont(new Font("Verdana", Font.ITALIC, 10));
	toFormat(field);

	JButton verify = new JButton("✓");
	verify.setBounds(600, 25, 50, 30);
	verify.setBackground(Color.DARK_GRAY);
	verify.setForeground(Color.WHITE);
	verify.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cbb.setEnabled(false);
			if(		field.getText().equals(null) ||
					field.getText().equals("") ||
					field.getText().equals("ID")    ) {
				new JOptionPane().showMessageDialog(null, "É NECESSÁRIO INFORMAR UM ID VÁLIDO");;
				
			}else {
				object = "curso";
				objectValue = field.getText();
				objectType = "id";
				
				show();
			}
			
		}
		
	});
	
	
	
	centerPNL.add(field);
	centerPNL.add(verify);
	centerPNL.repaint();

	
}

	private void universityEdit(JComboBox cbb) {
	
	JTextField field = new JTextField("NOME");
	field.setBounds(400, 25, 200, 30);
	field.setFont(new Font("Verdana", Font.ITALIC, 10));
	toFormat(field);

	JButton verify = new JButton("✓");
	verify.setBounds(600, 25, 50, 30);
	verify.setBackground(Color.DARK_GRAY);
	verify.setForeground(Color.WHITE);
	verify.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cbb.setEnabled(false);
			if(		field.getText().equals(null) ||
					field.getText().equals("") ||
					field.getText().equals("NOME")    ) {
				new JOptionPane().showMessageDialog(null, "É NECESSÁRIO INFORMAR UM NOME VÁLIDO");;
				
			}else {
				object = "universidade";
				objectValue = "'"+field.getText()+"'";
				objectType = "nome";
				
				show();
			}
			
		}
		
	});
	
	
	centerPNL.add(field);
	centerPNL.add(verify);
	centerPNL.repaint();

	
}

	private void disciplineEdit(JComboBox cbb) {
	
	JTextField field = new JTextField("ID");
	field.setBounds(400, 25, 200, 30);
	field.setFont(new Font("Verdana", Font.ITALIC, 10));
	toFormat(field);

	JButton verify = new JButton("✓");
	verify.setBounds(600, 25, 50, 30);
	verify.setBackground(Color.DARK_GRAY);
	verify.setForeground(Color.WHITE);
	verify.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cbb.setEnabled(false);
			if(		field.getText().equals(null) ||
					field.getText().equals("") ||
					field.getText().equals("ID")    ) {
				new JOptionPane().showMessageDialog(null, "É NECESSÁRIO INFORMAR UM ID VÁLIDO");;
				
			}else {
				object = "disciplina";
				objectValue = field.getText();
				objectType = "id";
				
				show();
			}
			
		}
		
	});
	
	
	centerPNL.add(field);
	centerPNL.add(verify);
	centerPNL.repaint();

	
}
	
	
	private void show() {
		
		List<String> model = new ArrayList<>();
		
		List<String> temp = new ArrayList<>();
		
		String sql;
		ResultSet rs;
		
		Integer counter = 0;
		
		rs = new ReadingConnection().search("SELECT * FROM "+object+" WHERE "+objectType+" = "+objectValue);
		
		try {
			if(rs.next()==false) {
				new JOptionPane().showMessageDialog(null, "NÃO HÁ NENHUM OBJETO COM ESSA REFERENCIA");
				
			}else {
				rs.beforeFirst();
				
				int colunas = rs.getMetaData().getColumnCount();
				int linhas = 0;
			
				while(rs.next()) {
					linhas += 1;
				}
				
				rs.beforeFirst();
				
				data = new String[linhas][colunas];
				
				while(rs.next()) {		
					
					for(int i = 1; i <= colunas; i++){
						if(!model.contains(rs.getMetaData().getColumnName(i).toUpperCase().replaceAll("_", " "))) {
							model.add(rs.getMetaData().getColumnName(i).toUpperCase().replaceAll("_", " "));
						}
						
						temp.add(rs.getString(i));
					}
					
					for(int i = 0; i < temp.size(); i++) {
						data[counter][i] = temp.get(i);
					}
		
					counter ++;
					temp.clear();
				}
				
				int elements = model.size();
			
				columns = new String[elements];
				
				for(int i = 0; i < model.size(); i++) {
					columns[i] = model.get(i);
				}
				
				windows = new Windows(data, columns);
				windows.setBounds(100, 350, 1800, 120);
				windows.buttonPNL.remove(0);
				
				frame.addWindowListener(new WindowAdapter() { 
			        @Override
			        public void windowClosing(WindowEvent e) { 
			                windows.dispose();
			        }
			    });
				
				String[] newArray = new String[columns.length+1];
				newArray[0] = "...";
				
				for(int i = 0; i < columns.length; i++) {
					newArray[i+1] = columns[i];	
				}
				
				update(newArray, object, objectType, objectValue);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void update(String[] columns, String table, String id, String idValue) {
		
		JLabel label = new JLabel("INSERIR EM ");
		label.setFont(new Font("Verdana", Font.PLAIN, 14));
		label.setBounds(50, 100, 150, 20);
		
		JComboBox updateCBB = new JComboBox(columns);
		updateCBB.setBounds(150, 100, 200, 20);
		updateCBB.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				JLabel labelTo = new JLabel("NOVO VALOR");
				labelTo.setFont(new Font("Verdana", Font.PLAIN, 13));
				labelTo.setBounds(50, 140, 150, 20);
				
				JTextField field = new JTextField();
				field.setBounds(150, 140, 200, 20);
				
				JButton confirmUp = new JButton("Realizar Update");
				confirmUp.setBounds(50, 180, 300, 20);
				confirmUp.setBackground(Color.DARK_GRAY);
				confirmUp.setForeground(Color.WHITE);
				confirmUp.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(updateCBB.getSelectedItem().equals("...")) {
							new JOptionPane().showMessageDialog(null, "VOCÊ PRECISA SELECIONAR NO NOME DA COLUNA QUE DESEJA FAZER MUDANÇAS");
						}else {
							registerUp(table, ((String)updateCBB.getSelectedItem()).toLowerCase().replaceAll(" ", "_"), ""+field.getText()+"", id, idValue);
						}
					}
					
				});
				
				
				centerPNL.add(labelTo);
				centerPNL.add(field);
				centerPNL.add(confirmUp);
				centerPNL.repaint();
				
				
			}
			
		});
		
		centerPNL.add(label);
		centerPNL.add(updateCBB);
		centerPNL.repaint();
	}
	
	private void registerUp(String table, String column, String newValue, String id, String idValue) {
		System.out.println("UPDATE " + table + " SET " + column + " = '" + newValue + "' WHERE " + id + " = '" + idValue +"'");
		System.out.println("SELECT * FROM " + table + " WHERE " + id + " = " + idValue + " AND " + column + " = " + newValue );
		try {
			Integer rs = new Connectivity().sqlExec("UPDATE " + table + " SET " + column + " = '" + newValue + "' WHERE " + id + " = '" + idValue +"'");
			if(new ReadingConnection().search("SELECT * FROM " + table + " WHERE " + id + " = '" + idValue + "' AND " + column + " = '" + newValue + "'").next()==false) {
				new JOptionPane().showMessageDialog(null, "ALGO DEU ERRADO");	
			}else {
				new JOptionPane().showMessageDialog(null, "ALTERAÇÃO REALIZADA COM SUCESSO");
				windows.dispose();
				
				show();
				
				
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
}











