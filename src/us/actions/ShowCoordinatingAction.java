package us.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.gui.Windows;
import us.persistence.Connectivity;
import us.persistence.ReadingConnection;

public class ShowCoordinatingAction implements ActionListener{	
	
	String[][] coordinatings;
	
	List<String> model = new ArrayList<>();
	
	List<String> temp = new ArrayList<>();
	
	String sql;
	ResultSet rs;
	
	Integer counter = 0;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		showCoordinatings();
		counter = 0;
	}
	
	private void showCoordinatings() {
		sql = "SELECT cpf, nome, salario, email, estado, cidade, numero_de_registro FROM funcionario WHERE dig = 17";
		
		rs = new ReadingConnection().search(sql);
		
		try {
			int colunas = rs.getMetaData().getColumnCount();
			int linhas = 0;
		
			while(rs.next()) {
				linhas += 1;
			}
			
			rs.beforeFirst();
			
			coordinatings = new String[linhas][colunas];
			
			while(rs.next()) {		
				
				for(int i = 1; i <= colunas; i++){
					if(!model.contains(rs.getMetaData().getColumnName(i).toUpperCase().replaceAll("_", " "))) {
						model.add(rs.getMetaData().getColumnName(i).toUpperCase().replaceAll("_", " "));
					}
					
					temp.add(rs.getString(i));
				}
				
				for(int i = 0; i < temp.size(); i++) {
					coordinatings[counter][i] = temp.get(i);
				}
	
				counter ++;
				temp.clear();
			}
			
			int elements = model.size();
		
			String[] columns = new String[elements];
			
			for(int i = 0; i < model.size(); i++) {
				columns[i] = model.get(i);
			}
			
			Windows windows = new Windows(coordinatings, columns);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
