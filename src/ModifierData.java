

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifierData extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierData frame = new ModifierData();
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
	public ModifierData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 413, 375);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {                   // on précise les lignes et les colonnes pour la table
			},
			new String[] {
				"Nom", "Pr\u00E9nom", "Code","Commande","Date"
			}
		));
		
		JButton ok = new JButton("Afficher");
		ok.setBackground(new Color(204, 0, 0));
		ok.setForeground(SystemColor.textHighlightText);
		ok.setBounds(459, 146, 107, 23);
		contentPane.add(ok);
		
		lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(568, 7, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("O");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuGerant m = new MenuGerant();
				m.setVisible(true);
				ModifierData.this.setVisible(false);
				
				
			}
		});
		lblNewLabel_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_1.setBounds(549, 7, 15, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
	
	     	ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","soukaina","abcd");
					Statement stmt = con.createStatement();
					String sql = "Select * from petitdej";
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			
		}});
	}
}
