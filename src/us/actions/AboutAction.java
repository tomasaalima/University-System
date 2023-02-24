package us.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AboutAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		JOptionPane.showMessageDialog(null, "Systema desenvolvido para fins acadêmicos na disciplina de Banco de Dados, Turma de Engenharia de Software, IFPE 2022.1", "About", JOptionPane.PLAIN_MESSAGE);
	}

}
