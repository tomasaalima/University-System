package us.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import us.gui.AdminRoom;
import us.gui.DirectorRoom;
import us.gui.Door;
import us.persistence.Connectivity;

public class LoginAction implements ActionListener{
	
	String sql;
	ResultSet rs;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String login = Door.loginFLD.getText();
		String password = new String(Door.passWordFLD.getPassword());
		
		searchInEMP(login, password);
		
		
	}
	
	private void searchInEMP(String log, String pass) {

		sql = "SELECT * FROM funcionario";
	
		rs = new Connectivity().search(sql);
		
		try {
			while(rs.next()) {
				
				String login = rs.getString("login");
				String password  = rs.getString("senha");	
				
				if(login.equals(log) && password.equals(pass)) {
					int dig = rs.getInt("dig");
					Door.frame.dispose();
				
					switch (dig) {
					case 11:{
						DirectorRoom dr = new DirectorRoom(rs.getString("nome"), rs.getString("cpf"));
						break;
						}
					case 13: {
						
					}
					case 17:{
						
					}
					case 19:{
						
					}
					case 0:{
						AdminRoom ar = new AdminRoom(rs.getString("nome"));
						break;
					}
					default:
						
					}					
				}/*else {
					new JOptionPane().showMessageDialog(null, "SENHA OU LOGIN INCORRETO");
					break;
				}*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
