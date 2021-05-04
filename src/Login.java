import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class Login extends JFrame { // création de la classe login qui hérite de la classe JFrame

	private  JPanel contentPane;
	private static JTextField nom;
	private static JPasswordField code;
	private static JTextField prenom;
	public static JTextField getNom() { // creation des getters pour les utiliser dans d'autres classes
		return nom;
	}
	public static JTextField getPrenom() {
		return prenom;
	}
	public static JTextField getCode() {
		return code;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		// creation des labels, checkBox et des conteneurs à l'aide de Window Builder
		setForeground(Color.WHITE);
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 355);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel nomLabel = new JLabel("Nom");
		nomLabel.setForeground(SystemColor.textHighlightText);
		nomLabel.setBounds(10, 57, 46, 14);
		contentPane.add(nomLabel);
		
		JLabel prenomLabel = new JLabel("Pr\u00E9nom");
		prenomLabel.setForeground(SystemColor.textHighlightText);
		prenomLabel.setBounds(10, 122, 46, 14);
		contentPane.add(prenomLabel);
		
		JLabel codeLabel = new JLabel("Code");
		codeLabel.setForeground(SystemColor.textHighlightText);
		codeLabel.setBounds(10, 187, 46, 14);
		contentPane.add(codeLabel);
		
		nom = new JTextField();
		nom.setBounds(10, 82, 195, 29);
		contentPane.add(nom);
		nom.setColumns(10);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 558, 359);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(218, -93, 347, 346);
		ImageIcon img = new ImageIcon(this.getClass().getResource("img/page_principalle.jpg"));
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2.setBounds(509, 7, 168, 23);
		lblNewLabel_2.setForeground(SystemColor.controlText);
		lblNewLabel_2.setBackground(SystemColor.textHighlightText);
		panel.add(lblNewLabel_2);
		lblNewLabel.setIcon(img);
		panel.add(lblNewLabel);
		
		code = new JPasswordField();
		code.setBounds(10, 211, 198, 32);
		panel.add(code);
		
		prenom = new JTextField();
		prenom.setBounds(10, 146, 198, 32);
		panel.add(prenom);
		prenom.setColumns(10);
		
		JCheckBox gerant = new JCheckBox("G\u00E9rant");
		gerant.setBounds(121, 7, 80, 23);
		panel.add(gerant);
		gerant.setForeground(SystemColor.textHighlightText);
		gerant.setBackground(new Color(51, 51, 51));
		
		JCheckBox client = new JCheckBox("Client");
		client.setBounds(10, 7, 103, 23);
		panel.add(client);
		client.setForeground(SystemColor.textHighlightText);
		client.setBackground(new Color(51, 51, 51));
		
		
		JButton btnNewButton = new JButton("Se connecter");
		btnNewButton.setFont(UIManager.getFont("Button.font"));
		btnNewButton.setBackground(new Color(204, 0, 0));
		btnNewButton.setBounds(137, 290, 228, 23);
		panel.add(btnNewButton);
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {     //Ajouter une action au click du boutton 
				
				if(client.isSelected() == true)  // utilisation de la méthode isSelected avec des check box permet à l'utilisateur de choisir entre options
				{
				try{
					// Connection avec la base de données mysql
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","soukaina","abcd");
					Statement stmt = con.createStatement();
					String sql = "Select * from client where nom='"+nom.getText()+"' and prenom='"+prenom.getText()+"' and code='"+code.getText()+"'"; // requete sql
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) { // si requete est excecutée
						JOptionPane.showMessageDialog(null,"connecté");
						MenuClient m = new MenuClient();
						 m.setVisible(true); // la méthode setVisible() est utilisé plusieurs fois dans le projet elle permet d'afficher o cacher une interface
						                      // elle prend un parametre boolean
						 Login.this.setVisible(false);
						    
						    

					}
					
					else {
						JOptionPane.showMessageDialog(null,"non connecté");
					con.close();
					
				}}
				catch(Exception e1) { // Gérer l'exception en cas de l'echec de se connecter à la bd
					System.out.println(e1);
				}
			}
				
				if(gerant.isSelected() == true) 
				{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","soukaina","abcd");
					Statement stmt = con.createStatement();
					String sql = "Select * from gerant where nom='"+nom.getText()+"' and prenom='"+prenom.getText()+"' and code='"+code.getText()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"connected");
						MenuGerant m = new MenuGerant();
						 m.setVisible(true);
						    Login.this.setVisible(false);}
						
					else 
						JOptionPane.showMessageDialog(null,"not connected");
					con.close();
					
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
				
				
				
				else if(client.isSelected() == false && gerant.isSelected() == false) {
					JOptionPane.showMessageDialog(null,"Saisissez votre role s'il vous plait");
				}
		}});
	
		
		
		
		
	}
}
