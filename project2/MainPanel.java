package project2;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;

import project1.ShowWeek;
import project1.Shows;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class MainPanel extends JPanel{
	private int count;
	private JTextField movieTitle;
	private JLabel lblNewLabel;
	private Shows allData;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ImageIcon image, netflix;
	private int x, y;
	ShowWeek newShow = new ShowWeek();

	private String week;
	private String category;
	private String rank;
	private String showTitle;
	private String seasonTitle;
	private String hrsViewed;
	private String weeksTop10;

	public MainPanel() {
		allData = new Shows("allData","./project1/netflixAllWeeksGlobalProcessed.txt");

		netflix = new ImageIcon (this.getClass().getResource("/netflixIntro.gif"));
		//image = new ImageIcon (this.getClass().getResource("/MeTime.jpg"));

		JPanel PowerSave = new JPanel();
		PowerSave.setBackground(Color.BLACK);
		PowerSave.setForeground(Color.BLACK);
		PowerSave.setBounds(0, 34, 800, 566);
		add(PowerSave);

		JLabel moviePoster = new JLabel(" ");
		moviePoster.setIcon(new ImageIcon("./MeTime.jpg"));
		moviePoster.setBounds(518, 127, 215, 332);
		add(moviePoster);

		count = 0;
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(800, 600));

		movieTitle = new JTextField("2022-09-04");
		movieTitle.setBounds(36, 183, 149, 20);
		add(movieTitle);
		movieTitle.setColumns(10);

		lblNewLabel = new JLabel("Enter Week:");
		lblNewLabel.setBounds(36, 171, 105, 14);
		add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(227, 143, 215, 197);
		add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(allData.toString());

		JComboBox Movies = new JComboBox();
		ArrayList<ShowWeek> moviesInWeek = allData.getOneWeek("2022-09-04");

		String [] data = new String[moviesInWeek.size()];
		int index = 0;
		for (ShowWeek sw : moviesInWeek){
			data[index] = sw.getShowTitle();
			index++;
		}

		Movies.setModel(new DefaultComboBoxModel(data));
		Movies.setBounds(36, 255, 149, 22);
		add(Movies);

		JLabel lblNewLabel_1 = new JLabel("Shows:");
		lblNewLabel_1.setBounds(36, 241, 46, 14);
		add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Get Shows");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ShowWeek> moviesInWeek = allData.getOneWeek(movieTitle.getText());
				if(moviesInWeek != null && moviesInWeek.size() > 0) {
					String [] data = new String[moviesInWeek.size()];
					int index = 0;
					for (ShowWeek sw : moviesInWeek){
						data[index] = sw.getShowTitle();
						index++;
					}
					Movies.setModel(new DefaultComboBoxModel(data));
				}
			}
		});

		btnNewButton.setBounds(36, 203, 89, 23);
		add(btnNewButton);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Power Saving Mode");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected() == true) {
					PowerSave.setVisible(true);
				}
				else 
				{
					PowerSave.setVisible(false);
				}
			}
		});
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(13, 6, 149, 21);
		add(chckbxNewCheckBox);

		JButton Poster1 = new JButton("Poster 1");
		Poster1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moviePoster.setIcon(new ImageIcon("./MeTime.jpg"));
			}
		});
		Poster1.setBounds(212, 379, 85, 21);
		add(Poster1);

		JButton Poster2 = new JButton("Poster 2");
		Poster2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moviePoster.setIcon(new ImageIcon("./LoveInTheVilla.jpg"));
			}
		});

		Poster2.setBounds(307, 379, 85, 21);
		Poster2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moviePoster.setIcon(new ImageIcon("./ICameBy.jpg"));
			}
		});

		add(Poster2);

		JButton Poster3 = new JButton("Poster 3");
		Poster3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Poster3.setBounds(402, 379, 85, 21);
		add(Poster3);

		JButton Poster4 = new JButton("Poster 4");
		Poster4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Poster4.setBounds(212, 410, 85, 21);
		add(Poster4);

		JButton Poster5 = new JButton("Poster 5");
		Poster5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Poster5.setBounds(307, 410, 85, 21);
		add(Poster5);

		JButton Poster6 = new JButton("Poster 6");
		Poster6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Poster6.setBounds(402, 410, 85, 21);
		add(Poster6);

		JButton Poster7 = new JButton("Poster 7");
		Poster7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Poster7.setBounds(212, 445, 85, 21);
		add(Poster7);

		JButton Poster8 = new JButton("Poster 8");
		Poster8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Poster8.setBounds(307, 445, 85, 21);
		add(Poster8);

		JButton Poster9 = new JButton("Poster 9");
		Poster9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Poster9.setBounds(402, 445, 85, 21);
		add(Poster9);

		JButton Poster10 = new JButton("Poster 10");
		Poster10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Poster10.setBounds(307, 481, 85, 21);
		add(Poster10);

		JRadioButton rdbtnAdd = new JRadioButton("Add");
		buttonGroup.add(rdbtnAdd);
		rdbtnAdd.setBounds(13, 345, 109, 23);
		add(rdbtnAdd);

		JRadioButton rdbtnPurge = new JRadioButton("Remove");
		buttonGroup.add(rdbtnPurge);
		rdbtnPurge.setBounds(13, 384, 109, 23);
		add(rdbtnPurge);

		JRadioButton rdbtnEdit = new JRadioButton("Edit");
		buttonGroup.add(rdbtnEdit);
		rdbtnEdit.setBounds(13, 422, 109, 23);
		add(rdbtnEdit);




		JButton editButton = new JButton("Do Edit!");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnAdd.isSelected())
				{
					week = JOptionPane.showInputDialog("Enter a Week");
					category = JOptionPane.showInputDialog("Enter a Category");
					rank = JOptionPane.showInputDialog("Enter a Rank");
					showTitle = JOptionPane.showInputDialog("Enter a Title");
					seasonTitle = JOptionPane.showInputDialog("Enter a Season Title");
					hrsViewed = JOptionPane.showInputDialog("Enter Hours");
					weeksTop10 = JOptionPane.showInputDialog("Enter Weeks in Top ");

					newShow.setWeek(week);
					newShow.setCategory(category);
					newShow.setRank(rank);
					newShow.setShowTitle(showTitle);
					newShow.setSeasonTitle(seasonTitle);
					newShow.setHrsViewed(hrsViewed);
					newShow.setWeeksTop10(weeksTop10);

					allData.addShowWeek(newShow);
				}
				else if(rdbtnPurge.isSelected())
				{
					showTitle = JOptionPane.showInputDialog("Enter a Title");
					allData.purgeShow(showTitle);
					
				}else if(rdbtnEdit.isSelected())
				{
					showTitle = JOptionPane.showInputDialog("Enter a Title");
					week = JOptionPane.showInputDialog("Enter a Week");

					ShowWeek editShowWeek = allData.find(showTitle, week);

					week = JOptionPane.showInputDialog("Enter a Week");
					category = JOptionPane.showInputDialog("Enter a Category");
					rank = JOptionPane.showInputDialog("Enter a Rank");
					showTitle = JOptionPane.showInputDialog("Enter a Title");
					seasonTitle = JOptionPane.showInputDialog("Enter a Season Title");
					hrsViewed = JOptionPane.showInputDialog("Enter Hours");
					weeksTop10 = JOptionPane.showInputDialog("Enter Weeks in Top ");

					editShowWeek.setWeek(week);
					editShowWeek.setCategory(category);
					editShowWeek.setRank(rank);
					editShowWeek.setShowTitle(showTitle);
					editShowWeek.setSeasonTitle(seasonTitle);
					editShowWeek.setHrsViewed(hrsViewed);
					editShowWeek.setWeeksTop10(weeksTop10);

					allData.addShowWeek(editShowWeek);
				}
			}
		});
		editButton.setBounds(128, 345, 89, 23);
		add(editButton);


	}

	public void doClose() {
		allData.doWrite("./textwrite.txt");
	}

	public void paintComponent (Graphics page)
	{
		super.paintComponent (page);
		//image.paintIcon (this, page, 500, 300);
		netflix.paintIcon (this, page, 365, -150);
	}
}
