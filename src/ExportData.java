import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExportData extends JFrame {

	private JPanel contentPane;
	private static JTextField chemin;
	
        

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExportData frame = new ExportData();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}

		
		
		  
	
		 
		   
		

	/**
	 * Create the frame.
	 */
	public ExportData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JCheckBox csv = new JCheckBox("Sous format CSV");
		csv.setForeground(SystemColor.textHighlightText);
		csv.setBackground(new Color(51, 51, 51));
		csv.setBounds(6, 21, 154, 23);
		contentPane.add(csv);
		
		JCheckBox excel = new JCheckBox("Sous format Excel");
		excel.setForeground(SystemColor.textHighlightText);
		excel.setBackground(new Color(51, 51, 51));
		excel.setBounds(234, 21, 154, 23);
		contentPane.add(excel);
		
		JButton Exporter = new JButton("Exporter");
		Exporter.setForeground(SystemColor.textHighlightText);
		Exporter.setBackground(new Color(204, 0, 0));
		Exporter.setBounds(131, 147, 154, 36);
		contentPane.add(Exporter);
		
		chemin = new JTextField();
		chemin.setBounds(157, 66, 267, 23);
		contentPane.add(chemin);
		chemin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(416, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Chemin");
		lblNewLabel_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_1.setBounds(10, 70, 46, 14);
		contentPane.add(lblNewLabel_1);
		Exporter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
		if(csv.isSelected() == true) 
				{
		     try (
		    	 FileWriter pw= new FileWriter(chemin.getText(),true)) {//Génerer un fichier dans le chemin qu'a saisi l'utilisateur
		    		    StringBuilder sb= new StringBuilder();
		    		 
		    		    Class.forName("com.mysql.jdbc.Driver");
		    			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","soukaina","abcd");
		    			String sql = "select * from petitdej";
		    			PreparedStatement ps=con.prepareStatement(sql);
		    			ResultSet rs=ps.executeQuery(sql);
		    			
		    			
		    			
		    		 
		    		    while(rs.next()){ // extraire les données de la base de données on suivant les noms de colonnes données par la suite
		    		     sb.append(rs.getString("nom"));
		    		     sb.append(","); 
		    		     sb.append(rs.getString("prenom"));
		    		     sb.append(",");
		    		     sb.append(rs.getString("code"));
		    		     sb.append(",");
		    		     sb.append(rs.getString("commande"));
		    		     sb.append("\r\n");
		    		     
		    		    }
		    		    pw.write(sb.toString());
		    		    pw.close();
		    		    
		    		    System.out.println("finished");}
		    			catch(Exception e1){
		    				
		    			}}
		    		
	}
});}}
