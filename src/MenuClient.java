import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuClient extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuClient frame = new MenuClient();
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
	public MenuClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 355);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton menu = new JButton("Afficher le menu");
		menu.setBackground(new Color(204, 0, 0));
		menu.setForeground(SystemColor.textHighlightText);
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				
				
				m.setVisible(true);
				MenuClient.this.dispose();
			}
			
		});
		menu.setBounds(182, 71, 162, 157);
		contentPane.add(menu);
		
		JButton commande = new JButton("Passer commande");
		commande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasserCommande p = new PasserCommande();
				p.setVisible(true);
				MenuClient.this.setVisible(false);
			}
		});
		commande.setBackground(new Color(204, 0, 0));
		commande.setForeground(SystemColor.textHighlightText);
		commande.setBounds(10, 71, 162, 157);
		contentPane.add(commande);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(512, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton avis = new JButton("Avis sur le service");
		avis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonnerAvis a = new DonnerAvis();
				a.setVisible(true);
				MenuClient.this.setVisible(false);
				
			}
		});
		avis.setForeground(Color.WHITE);
		avis.setBackground(new Color(204, 0, 0));
		avis.setBounds(361, 71, 162, 157);
		contentPane.add(avis);
		
		JLabel lblO = new JLabel("O");
		lblO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l  = new Login();
				l.setVisible(true);
				MenuClient.this.setVisible(false);
			}
		});
		lblO.setForeground(Color.WHITE);
		lblO.setBounds(487, 11, 17, 14);
		contentPane.add(lblO);
	}

}
