import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 355);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 
		String[] ar = {"Lundi", "Mardi", "Mercredi","Jeudi","Vendredi","Samedi","Dimanche"}; // création d'un array pour les jours de la semaine
		contentPane.setLayout(null);
		JComboBox comboBox = new JComboBox(ar); // passer le array comme parametre de JCombox qui va permettre de lister les jours de la semaine
		comboBox.setBounds(5, 5, 481, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Afficher");
		btnNewButton.setBackground(new Color(204, 0, 0));
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.setBounds(5, 288, 523, 23);
		contentPane.add(btnNewButton);
		
		JCheckBox check1 = new JCheckBox("Petit d\u00E9jeuner");
		check1.setForeground(SystemColor.textHighlightText);
		check1.setBackground(new Color(51, 51, 51));
		check1.setBounds(15, 33, 165, 23);
		contentPane.add(check1);
		
		JCheckBox check2 = new JCheckBox("D\u00E9jeuner");
		check2.setForeground(SystemColor.textHighlightText);
		check2.setBackground(new Color(51, 51, 51));
		check2.setBounds(208, 33, 97, 23);
		contentPane.add(check2);
		
		JCheckBox check3 = new JCheckBox("Diner");
		check3.setForeground(SystemColor.textHighlightText);
		check3.setBackground(new Color(51, 51, 51));
		check3.setBounds(388, 32, 97, 23);
		contentPane.add(check3);
		
		JLabel Label = new JLabel("");
		Label.setBounds(5, 63, 523, 214);
		contentPane.add(Label);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // L'ajout d'une action pour le label "X" 
				System.exit(0); // fermer la fenetre
			}
		});
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(516, 8, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("O");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // ajout d'une action après click par souris sur le label 'O'
				MenuClient m = new MenuClient(); // création objet de type MenuClient
				m.setVisible(true); // afficher la fenetre MenuClient
				Menu.this.setVisible(false); // fermer la fenetre actuelle
			}
		});
		lblNewLabel_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_1.setBounds(496, 8, 16, 14);
		contentPane.add(lblNewLabel_1);
		
		
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
		if((String) comboBox.getSelectedItem() == "Lundi" && check1.isSelected() == true) { // si on choisis le Lundi le petit déjeuner 
			 // l'image correspendante va s'afficher
			// les images utilisées existe dans un dossier source du projet
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/breakfast_monday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		
		
		if((String) comboBox.getSelectedItem() == "Mardi" && check1.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/breakfast_2.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Mercredi" && check1.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/breakfast_monday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Jeudi" && check1.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/breakfast_2.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Vendredi" && check1.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/breakfast_monday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Samedi" && check1.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/breakfast_2.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Dimanche" && check1.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/breakfast_monday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Lundi" && check2.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/lunch_monday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Mardi" && check2.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/lunch_tuesday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Mercredi" && check2.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/lunch_wednesday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Jeudi" && check2.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/lunch_thursday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Vendredi" && check2.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/lunch_friday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Samedi" && check2.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/lunch_saturday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Dimanche" && check2.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/lunch_sunday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Lundi" && check3.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/dinner_monday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Mardi" && check3.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/dinner_tuesday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Mercredi" && check3.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/dinner_wednesday.jpg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Jeudi" && check3.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/dinner_thursday.jpeg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Vendredi" && check3.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/dinner_friday.jpeg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Samedi" && check3.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/dinner_saturday.jpeg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
		if((String) comboBox.getSelectedItem() == "Dimanche" && check3.isSelected() == true) {
			try {
				ImageIcon img = new ImageIcon(this.getClass().getResource("img/dinner_sunday.jpeg"));
				Label.setIcon(img);
			}
			catch(Exception e1){
				System.out.println(e1);
			}}
	}});}	
}
