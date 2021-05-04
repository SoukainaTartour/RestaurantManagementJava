import java.sql.*;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import java.time.LocalDateTime;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.SystemColor;  
public class PasserCommande extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasserCommande frame = new PasserCommande();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});}
		
	
	

	/**
	 * Create the frame.
	 */
	public PasserCommande() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 355);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel countdown = new JLabel("");
		countdown.setForeground(SystemColor.textHighlightText);
		countdown.setBackground(SystemColor.textHighlightText);
		countdown.setBounds(2, 148, 523, 46);
		contentPane.add(countdown);
		JLabel count = new JLabel("");
		count.setBounds(188, 240, 335, 65);
		contentPane.add(count);

		
		
		JCheckBox menu = new JCheckBox("Menu");
		menu.setBackground(new Color(51, 51, 51));
		menu.setForeground(SystemColor.textHighlightText);
		menu.setBounds(114, 84, 103, 23);
		contentPane.add(menu, BorderLayout.NORTH);
		
		
		
		JCheckBox autre = new JCheckBox("Bouteille d'eau + fruits");
		autre.setForeground(SystemColor.textHighlightText);
		autre.setBackground(new Color(51, 51, 51));
		autre.setBounds(296, 84, 160, 23);
		contentPane.add(autre);
		
		JCheckBox petitdej = new JCheckBox("Petit d\u00E9jeuner");
		petitdej.setForeground(SystemColor.textHighlightText);
		petitdej.setBackground(new Color(51, 51, 51));
		petitdej.setBounds(2, 7, 125, 23);
		contentPane.add(petitdej);
		
		JCheckBox dej = new JCheckBox("D\u00E9jeuner");
		dej.setForeground(SystemColor.textHighlightText);
		dej.setBackground(new Color(51, 51, 51));
		dej.setBounds(209, 7, 97, 23);
		contentPane.add(dej);
		
		JCheckBox diner = new JCheckBox("Diner");
		diner.setForeground(SystemColor.textHighlightText);
		diner.setBackground(new Color(51, 51, 51));
		diner.setBounds(382, 7, 97, 23);
		contentPane.add(diner);
		
        JLabel countdown_1 = new JLabel("");
		countdown_1.setForeground(SystemColor.textHighlightText);
		countdown_1.setBackground(SystemColor.textHighlightText);
		countdown_1.setBounds(2, 205, 523, 46);
		contentPane.add(countdown_1);
		
		JLabel countdown_2 = new JLabel("");
		countdown_2.setForeground(SystemColor.textHighlightText);
		countdown_2.setBackground(SystemColor.textHighlightText);
		countdown_2.setBounds(2, 259, 523, 46);
		contentPane.add(countdown_2);
		    // les lignes suivantes permet de programmer un minuteur afin de calculer le temps restant 
		  // pour passer la commande pour chaque repas
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
   	    LocalDateTime now = LocalDateTime.now(); // la date actuelle afin de la saisir dans la table
	  	
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date dateobj = new Date(); 
			
	        int i = 1000;
			Timer T = new Timer(i, new ActionListener() {
	      
			int i = 1000;
			int a1 = 8 -  dateobj.getHours(); //différence entre 8H est l'heure actuelle
	        int b1 = 30 - dateobj.getMinutes(); // différence entre 30 minutes et les minutes de l'heure actuelle 
	        // on arrete la récéption des commandes du petit déjeuner à 8:30
	        int a2 = 14 -  dateobj.getHours();
	        int b2 = 30 - dateobj.getMinutes();
	        
	        int a3 = 20 -  dateobj.getHours();
	        int b3 = 30 - dateobj.getMinutes();
	        
	        
			long s1 = ((a1*60 + b1)*60*1000); // s1 est le temps restant pour paser la commande du petit déjeuner en millisecondes 
			long s2 = ((a2*60 + b2)*60*1000); //s2 est le temps restant pour paser la commande du  déjeuner en millisecondes 
			long s3 = ((a3*60 + b3)*60*1000); //s3 est le temps restant pour paser la commande du diner en millisecondes 
			
			
			public void actionPerformed(ActionEvent e) {
	             
	              if(s1>=0) { 
	            	s1--; 
	            	countdown.setText("il vous reste  " + df.format(s1) + "  pour passer votre commande de petit déjeuner");}
	              else {
	            	  countdown.setText("Vous ne pouvez pas passer la commande pour le petit déjeuner");
	              }
				 
				  if(s2>=0) {
		            	s2--;
		            	countdown_1.setText("il vous reste  " + df.format(s2) + "  pour passer votre commande de déjeuner");}
		              else {
		            	  countdown_1.setText("Vous ne pouvez pas passer la commande pour le déjeuner");
		              }
				  if(s3>=0) {
		            	s3--;
		            	countdown_2.setText("il vous reste  " + df.format(s3) + "  pour passer votre commande de diner");}
		              else {
		            	  countdown_2.setText("Vous ne pouvez pas passer la commande pour le diner");
		              }
					 
				 
				  
	              
				
				}});
			
			T.start();
		JButton insert = new JButton("Passer la commande");
		insert.setForeground(SystemColor.textHighlightText);
		insert.setBackground(new Color(204, 0, 0));
		insert.setBounds(174, 133, 188, 23);
		contentPane.add(insert);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(514, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("O");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuClient m = new MenuClient();
				m.setVisible(true);
				PasserCommande.this.setVisible(false);
			}
		});
		lblNewLabel_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_1.setBounds(483, 11, 22, 14);
		contentPane.add(lblNewLabel_1);
		
		
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         	
			       
				 
				
				if( petitdej.isSelected() == true && menu.isSelected() == true) 
				{
				try{ // Se connecter avec la base de données
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","soukaina","abcd");
					PreparedStatement p = con.prepareStatement("insert into petitdej (nom,prenom,code,commande,date) values (?,?,?,?,?)");
					p.setString(1,Login.getNom().getText()); // insérer le nom et prenom saisies dans l'interface du login
					p.setString(2,Login.getPrenom().getText());
					p.setString(3,Login.getCode().getText());
					p.setString(4,"Menu");
					p.setString(5,dtf.format(now));
					int rs = p.executeUpdate();
			

					if(rs>=0) {
						JOptionPane.showMessageDialog(null,"Votre commande a été validé");

					}
					
					else {
						JOptionPane.showMessageDialog(null,"Votre commande n'a pas été validé");
					con.close();
					
				}}
				catch(Exception e1) {
					System.out.println(e1);
				}}
				
				if( petitdej.isSelected() == true && autre.isSelected() == true) 
				{
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","soukaina","abcd");
					PreparedStatement p = con.prepareStatement("insert into petitdej (nom,prenom,code,commande,date) values (?,?,?,?,?)");
					p.setString(1,Login.getNom().getText());
					p.setString(2,Login.getPrenom().getText());
					p.setString(3,Login.getCode().getText());
					p.setString(4,"Autre");
					p.setString(5,dtf.format(now));
					int rs = p.executeUpdate();
					if(rs>=0) {
						JOptionPane.showMessageDialog(null,"Votre commande a été validé");

					}
					
					else {
						JOptionPane.showMessageDialog(null,"Votre commande n'a pas été validé");
					con.close();
					
				}}
				catch(Exception e1) {
					System.out.println(e1);
				}
				
				if( dej.isSelected() == true && menu.isSelected() == true) 
				{
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","soukaina","abcd");
					PreparedStatement p = con.prepareStatement("insert into dej (nom,prenom,code,repas,date) values (?,?,?,?,?)");
					p.setString(1,Login.getNom().getText());
					p.setString(2,Login.getPrenom().getText());
					p.setString(3,Login.getCode().getText());
					p.setString(4,"Menu");
					p.setString(5,dtf.format(now));
					int rs = p.executeUpdate();
					if(rs>=0) {
						JOptionPane.showMessageDialog(null,"Votre commande a été validé");

					}
					
					else {
						JOptionPane.showMessageDialog(null,"Votre commande n'a pas été validé");
					con.close();
					
				}}
				catch(Exception e1) {
					System.out.println(e1);
				}}
				
				if( dej.isSelected() == true && autre.isSelected() == true) 
				{
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","soukaina","abcd");
					PreparedStatement p = con.prepareStatement("insert into dej (nom,prenom,code,repas,date) values (?,?,?,?,?)");
					p.setString(1,Login.getNom().getText());
					p.setString(2,Login.getPrenom().getText());
					p.setString(3,Login.getCode().getText());
					p.setString(4,"Autre");
					p.setString(5,dtf.format(now));
					int rs = p.executeUpdate();
					if(rs>=0) {
						JOptionPane.showMessageDialog(null,"Votre commande a été validé");

					}
					
					else {
						JOptionPane.showMessageDialog(null,"Votre commande n'a pas été validé");
					con.close();
					
				}}
				catch(Exception e1) {
					System.out.println(e1);
				}}
			    
				if( diner.isSelected() == true && menu.isSelected() == true) 
				{
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","soukaina","abcd");
					PreparedStatement p = con.prepareStatement("insert into diner (nom,prenom,code,repas,date) values (?,?,?,?,?)");
					p.setString(1,Login.getNom().getText());
					p.setString(2,Login.getPrenom().getText());
					p.setString(3,Login.getCode().getText());
					p.setString(4,"Menu");
					p.setString(5,dtf.format(now));
					int rs = p.executeUpdate();
					if(rs>=0) {
						JOptionPane.showMessageDialog(null,"Votre commande a été validé");

					}
					
					else {
						JOptionPane.showMessageDialog(null,"Votre commande n'a pas été validé");
					con.close();
					
				}}
				catch(Exception e1) {
					System.out.println(e1);
				}}
			    
				if( diner.isSelected() == true && autre.isSelected() == true) 
				{
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","soukaina","abcd");
					PreparedStatement p = con.prepareStatement("insert into diner (nom,prenom,code,repas,date) values (?,?,?,?,?)");
					p.setString(1,Login.getNom().getText());
					p.setString(2,Login.getPrenom().getText());
					p.setString(3,Login.getCode().getText());
					p.setString(4,"Autre");
					p.setString(5,dtf.format(now));
					int rs = p.executeUpdate();
					if(rs>=0) {
						JOptionPane.showMessageDialog(null,"Votre commande a été validé");

					}
					
					else {
						JOptionPane.showMessageDialog(null,"Votre commande n'a pas été validé");
					con.close();
					
				}}
				catch(Exception e1) {
					System.out.println(e1);
				}}
			    
			}}});
				
		
		
		

			}	
}
		
	
