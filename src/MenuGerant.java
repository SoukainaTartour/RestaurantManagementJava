import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuGerant extends JFrame {
	
	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGerant frame = new MenuGerant();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuGerant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 357);
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setForeground(new Color(175, 238, 238));
		panel.setBounds(0, 0, 557, 401);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton Button_1 = new JButton("Afficher les commandes");
		Button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierData md = new ModifierData();
				md.setVisible(true);
				MenuGerant.this.setVisible(false);
				
			}
		});
		Button_1.setBackground(new Color(204, 0, 0));
		Button_1.setForeground(SystemColor.textHighlightText);
		Button_1.setBounds(50, 62, 347, 63);
		panel.add(Button_1);
		
		JButton Button_2 = new JButton("Exporter les commandes");
		Button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExportData ed = new ExportData();
				ed.setVisible(true);
				MenuGerant.this.setVisible(false);
			}
		});
		Button_2.setBackground(new Color(204, 0, 0));
		Button_2.setForeground(SystemColor.textHighlightText);
		Button_2.setBounds(50, 180, 347, 63);
		panel.add(Button_2);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(418, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("O");
		lblNewLabel_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_1.setBounds(393, 11, 14, 14);
		panel.add(lblNewLabel_1);
		
		
		
		
			
		
			
		
		
		
	
		
		
		
		
		
		
		
	
}	
}
