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
	private JRadioButton rdbtnNewRadioButton;
	private ImageIcon image, netflix;
	private int x, y;
	private String movieName = "Me Time";
	private String showTitle = "";
	
	public MainPanel() {
		allData = new Shows("allData","./project1/netflixAllWeeksGlobalProcessed.txt");

		netflix = new ImageIcon (this.getClass().getResource("/netflixIntro.gif"));
		
		JPanel PowerSave = new JPanel();
		PowerSave.setBackground(Color.BLACK);
		PowerSave.setForeground(Color.BLACK);
		PowerSave.setBounds(0, 33, 800, 375);
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
		movieTitle.setBounds(68, 210, 149, 20);
		add(movieTitle);
		movieTitle.setColumns(10);

		lblNewLabel = new JLabel("Enter Week:");
		lblNewLabel.setBounds(68, 198, 105, 14);
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
		Movies.setBounds(68, 282, 149, 22);
		add(Movies);

		JLabel lblNewLabel_1 = new JLabel("Shows:");
		lblNewLabel_1.setBounds(68, 270, 46, 14);
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

		btnNewButton.setBounds(68, 230, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Do Edit!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected())
				{
//					try {
//						String changeTitle = JOptionPane.showInputDialog("Enter a Title");
//						movieTitle = Integer.parseInt(delayStr);
//					} catch (Exception e) {
//						delay = -1;
//					}
				}
			}
		});
		btnNewButton_1.setBounds(128, 315, 89, 23);
		add(btnNewButton_1);
		
		rdbtnNewRadioButton = new JRadioButton("Title");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(13, 317, 109, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnWeek = new JRadioButton("Week");
		buttonGroup.add(rdbtnWeek);
		rdbtnWeek.setBounds(13, 392, 109, 23);
		add(rdbtnWeek);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Purged");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(13, 355, 109, 23);
		add(rdbtnNewRadioButton_1);
		
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
		chckbxNewCheckBox.setBounds(13, 6, 120, 21);
		add(chckbxNewCheckBox);
		
		JButton btnNewButton_2 = new JButton("Poster 1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(495, 424, 85, 21);
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Poster 2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_2_1.setBounds(590, 424, 85, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Poster 3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_2_2.setBounds(685, 424, 85, 21);
		add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Poster 4");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_2_3.setBounds(495, 455, 85, 21);
		add(btnNewButton_2_3);
		
		JButton btnNewButton_2_4 = new JButton("Poster 5");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_2_4.setBounds(590, 455, 85, 21);
		add(btnNewButton_2_4);
		
		JButton btnNewButton_2_5 = new JButton("Poster 6");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_2_5.setBounds(685, 455, 85, 21);
		add(btnNewButton_2_5);
		
		JButton btnNewButton_2_6 = new JButton("Poster 7");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_2_6.setBounds(495, 490, 85, 21);
		add(btnNewButton_2_6);
		
		JButton btnNewButton_2_7 = new JButton("Poster 8");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_2_7.setBounds(590, 490, 85, 21);
		add(btnNewButton_2_7);
		
		JButton btnNewButton_2_8 = new JButton("Poster 9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_2_8.setBounds(685, 490, 85, 21);
		add(btnNewButton_2_8);
		
		JButton btnNewButton_2_9 = new JButton("Poster 10");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton_2_9.setBounds(590, 526, 85, 21);
		add(btnNewButton_2_9);
	}

	public void doClose() {
		allData.doWrite("./textwrite.csv");
	}

	public void paintComponent (Graphics page)
	{
		super.paintComponent (page);
		//image.paintIcon (this, page, x, y);
		netflix.paintIcon (this, page, 365, -150);
	}
}
