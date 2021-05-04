

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DonnerAvis extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonnerAvis frame = new DonnerAvis();
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
	public DonnerAvis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Donnez vos avis et remarques sur le service de restauration");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(10, 11, 403, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 49, 403, 168);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Envoyer");
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.setBackground(new Color(204, 0, 0));
		btnNewButton.setBounds(10, 227, 403, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         	
	
				try{ //Connecter avec la base de données
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","soukaina","abcd");
					PreparedStatement p = con.prepareStatement("insert into doléances (avis,nom,prenom) values (?,?,?)"); // requete pour inserer les données dans la bd
					p.setString(1,textField.getText());
					p.setString(2,Login.getNom().getText());
					p.setString(3,Login.getPrenom().getText());
					int rs = p.executeUpdate();
			

					if(rs>=0) {
						JOptionPane.showMessageDialog(null,"Votre remarque a été enregistré");

					}
					
					else {
						JOptionPane.showMessageDialog(null,"Votre commande n'a pas été validé");
					con.close();
					
				}}
				catch(Exception e1) {
					System.out.println(e1);
				}}});
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_1.setBounds(419, 0, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("O");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuClient m = new MenuClient();
				m.setVisible(true);
				DonnerAvis.this.setVisible(false);
			}
		});
		lblNewLabel_2.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2.setBounds(395, 0, 18, 14);
		contentPane.add(lblNewLabel_2);
	}
}
