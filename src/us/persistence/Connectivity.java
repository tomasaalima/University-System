package us.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Connectivity {
	private String url;
	private String user;
	private String password;
	private Connection con;
	
	public Connectivity(){
		url = "jdbc:postgresql://localhost:5432/postgres";
		user = "bd_project";
		password = "sweetpie";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão Realizada com Sucesso!! ");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public int sqlExec(String sql) {
		try {
			Statement stm = con.createStatement();
			int ans = stm.executeUpdate(sql);
			con.close();
			return ans;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public 	ResultSet search(String sql) {
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			con.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
	