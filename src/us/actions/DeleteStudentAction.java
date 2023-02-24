package us.actions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import us.persistence.Connectivity;
import us.persistence.ReadingConnection;

public class DeleteStudentAction implements ActionListener{
	JFrame frame;
	
	public static JTextField searchFLD;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame = new JFrame();
	
		ShowStudentsAction show = new ShowStudentsAction();
		show.actionPerformed(e);
		
		show.windows.setBounds(200,10,1600,500);
		show.windows.buttonPNL.remove(0);
		
		createBody(show.windows);
		
		frame.setBounds(750,550,500,140);
		frame.addWindowListener(new WindowAdapter() { 
	        @Override
	        public void windowClosing(WindowEvent e) { 
	                show.windows.dispose();
	        }
	    });
		frame.setVisible(true);
		
	}
	
	private void createBody(JFrame show){
		frame.setLayout(new BorderLayout());
		
		JPanel tittlePNL = new JPanel();
		tittlePNL.setLayout(new FlowLayout());
		
		JLabel tittleLBL = new JLabel("Remover Aluno");
		tittleLBL.setFont(new Font("Verdana", Font.PLAIN, 16));
		tittlePNL.add(tittleLBL);
		
		JPanel inputPNL = new JPanel();
		inputPNL.setLayout(new FlowLayout());
		
		JLabel searchLBL = new JLabel("MATRÍCULA:");
		searchFLD = new JTextField(30);
		
		JPanel buttonPNL = new JPanel();
		buttonPNL.setLayout(new FlowLayout());
		
		JButton confirm = new JButton("Prosseguir");
		confirm.setBackground(Color.DARK_GRAY);
		confirm.setForeground(Color.WHITE);
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(searchFLD.getText().equals("") || searchFLD.getText().equals(null)) {
						new JOptionPane().showMessageDialog(null, "INFORME A MATRÍCULA PRIMEIRAMENTE");
					}else if((new ReadingConnection().search("SELECT * FROM aluno WHERE matricula ="+searchFLD.getText()).next())==false){
						new JOptionPane().showMessageDialog(null, "JÁ NÃO HÁ NINGUEM COM ESSA MATRÍCULA");
					}else {
						
						new Connectivity().sqlExec("DELETE FROM aluno WHERE matricula ="+searchFLD.getText());
						show.dispose();
						
						ShowStudentsAction show = new ShowStudentsAction();
						show.actionPerformed(e);
						show.windows.setBounds(200,10,1600,500);
						show.windows.buttonPNL.remove(0);
						frame.addWindowListener(new WindowAdapter() { 
					        @Override
					        public void windowClosing(WindowEvent e) { 
					                show.windows.dispose();
					        }
					    });
						search(searchFLD.getText());
					
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
				
				}
			
		});
		
		JButton cancel = new JButton("Cancelar");
		cancel.setBackground(Color.DARK_GRAY);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {closeFrame();}});
		
		buttonPNL.add(confirm);
		buttonPNL.add(cancel);
		
		inputPNL.add(searchLBL);
		inputPNL.add(searchFLD);
		
		frame.add(tittlePNL, BorderLayout.NORTH);
		frame.add(inputPNL, BorderLayout.CENTER);
		frame.add(buttonPNL, BorderLayout.SOUTH);	
	}
	
	private void search(String matricula) {
		
		try {
				
			if((new ReadingConnection().search("SELECT * FROM aluno WHERE matricula ='"+matricula+"'").next())==false) {
				new JOptionPane().showMessageDialog(null, "ALUNO REMOVIDO COM SUCESSO");
			}else {
				new JOptionPane().showMessageDialog(null, "VERIFIQUE A MATRÍCULA INFORMADO INFORMADOS");
			}
		} catch (Exception e) {
			// TODO: handle exception
			new JOptionPane().showMessageDialog(null, "VERIFIQUE A MATRÍCULA INFORMADO INFORMADOS");
		}
	}
	
	private void closeFrame() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		//frame.dispose();
	}	
}
