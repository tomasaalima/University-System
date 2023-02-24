package us.actions;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import us.gui.Hall;
import us.gui.Windows;
import us.persistence.ReadingConnection;

public class SearchEmployeeAction implements ActionListener{
	
	String[][] employee;
	
	List<String> model = new ArrayList<>();
	
	List<String> temp = new ArrayList<>();
	
	String sql;
	ResultSet rs;
	
	Integer counter = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cpf = Hall.searchFLD.getText();
		
		Hall.frame.dispose();
		
		toSearch(cpf);
		
		counter = 0;
	}
	
	private void toSearch(String cpf) {
		sql = "SELECT nome, salario, email, estado, cidade, rua, numero_de_registro FROM funcionario WHERE cpf = " + cpf; 
		
		rs = new ReadingConnection().search(sql);
		
		try {
			int colunas = rs.getMetaData().getColumnCount();
			int linhas = 0;
		
			while(rs.next()) {
				linhas += 1;
			}
			
			rs.beforeFirst();
			
			employee = new String[linhas][colunas];
			
			while(rs.next()) {		
				
				for(int i = 1; i <= colunas; i++){
					if(!model.contains(rs.getMetaData().getColumnName(i).toUpperCase().replaceAll("_", " "))) {
						model.add(rs.getMetaData().getColumnName(i).toUpperCase().replaceAll("_", " "));
					}
					
					temp.add(rs.getString(i));
				}
				
				for(int i = 0; i < temp.size(); i++) {
					employee[counter][i] = temp.get(i);
				}
	
				counter ++;
				temp.clear();
			}
			
			int elements = model.size();
		
			String[] columns = new String[elements];
			
			for(int i = 0; i < model.size(); i++) {
				columns[i] = model.get(i);
			}
			
			Windows windows= new Windows(employee, columns);
			windows.frame.setSize(1500, 150);
			windows.frame.setLocation(230, 120);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
