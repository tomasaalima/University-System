package us.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import us.gui.Windows;
import us.persistence.ReadingConnection;

public class ShowSectorsAction implements ActionListener{

	Windows windows;
	
	String[][] sectors;
	
	List<String> model = new ArrayList<>();
	
	List<String> temp = new ArrayList<>();

	String sql;
	ResultSet rs;
	
	Integer counter = 0;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		showSectors();
		counter = 0;
	}
	
	private void showSectors() {
		sql = "SELECT id, nome, n_funcionarios, data FROM setor";
		
		rs = new ReadingConnection().search(sql);
		
		try {
			int colunas = rs.getMetaData().getColumnCount();
			int linhas = 0;
		
			while(rs.next()) {
				linhas += 1;
			}
			
			rs.beforeFirst();
			
			sectors = new String[linhas][colunas];
			
			while(rs.next()) {		
				
				for(int i = 1; i <= colunas; i++){
					if(!model.contains(rs.getMetaData().getColumnName(i).toUpperCase().replaceAll("_", " "))) {
						model.add(rs.getMetaData().getColumnName(i).toUpperCase().replaceAll("_", " "));
					}
					
					temp.add(rs.getString(i));
				}
				
				for(int i = 0; i < temp.size(); i++) {
					sectors[counter][i] = temp.get(i);
				}
	
				counter ++;
				temp.clear();
			}
			
			int elements = model.size();
		
			String[] columns = new String[elements];
			
			for(int i = 0; i < model.size(); i++) {
				columns[i] = model.get(i);
			}
			
			windows = new Windows(sectors, columns);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
}
