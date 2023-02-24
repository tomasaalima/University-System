package us.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Windows extends JFrame{

	private static final long serialVersionUID = 1L;
	
	ArrayList<String> temp = new ArrayList<>();
	
	public static JPanel buttonPNL;
	public static JFrame frame;
	
	public Windows(String[][] data, String[] columns) {
		super("UMS");
		
		frame = this;
		
		bodyCreate(data, columns);
		
		this.setSize(1600,800);;
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void bodyCreate(String[][] data, String[] columns) {
		setLayout(new BorderLayout());

		JPanel tittlePNL = new JPanel();
		tittlePNL.setLayout(new FlowLayout());
		
		JLabel tittleLBL = new JLabel("Listagem");
		tittleLBL.setFont(new Font("Verdana", Font.PLAIN, 16));
		tittlePNL.add(tittleLBL);
		
		JTable table = new JTable(data, columns);
		table.setEnabled(false);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
		renderer.setHorizontalAlignment(JLabel.CENTER);
		renderer.setFont(new Font("Gotham", Font.PLAIN, 16));
		
		JScrollPane scroolBar = new JScrollPane(table);
		
		buttonPNL = new JPanel();
		buttonPNL.setLayout(new FlowLayout());
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {closeFrame();}});
		
		buttonPNL.add(ok);
		
		add(tittlePNL, BorderLayout.NORTH);
		add(scroolBar);
		add(buttonPNL, BorderLayout.SOUTH);
	
	}
	
	private void closeFrame() {
		this.dispose();
	}
	
}
