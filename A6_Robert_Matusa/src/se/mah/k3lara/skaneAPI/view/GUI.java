package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class GUI extends JFrame {

	private JPanel contentPane;
	JTextField textFieldSearch;
	JTextField textFieldFrom;
	JTextField textFieldTo;

	JTextArea textAreaStations = new JTextArea();
	JTextArea textAreaJourney = new JTextArea();

	GUI g = this;
	private Parser p = new Parser();

	Thread tJ = new JourneysThread(p, this);
	Thread tS = new StationsThread(p, this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 5, 247, 268);
		contentPane.add(panel);
		panel.setLayout(null);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(10, 27, 124, 20);
		panel.add(textFieldSearch);
		textFieldSearch.setColumns(10);

		JButton btnSearchStation = new JButton("Search");
		btnSearchStation.setBounds(146, 26, 89, 23);
		btnSearchStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Thread tS = new StationsThread(p, g);
				tS.start();

			}
		});
		panel.add(btnSearchStation);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 60, 247, 208);
		panel.add(scrollPane_1);
		scrollPane_1.setViewportView(textAreaStations);

		JLabel lblSearchStations = new JLabel("Search Stations");
		lblSearchStations.setBounds(10, 11, 153, 14);
		panel.add(lblSearchStations);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(271, 5, 249, 268);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textFieldFrom = new JTextField();
		textFieldFrom.setBounds(10, 30, 126, 20);
		panel_1.add(textFieldFrom);
		textFieldFrom.setColumns(10);

		textFieldTo = new JTextField();
		textFieldTo.setBounds(10, 67, 126, 20);
		panel_1.add(textFieldTo);
		textFieldTo.setColumns(10);

		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(10, 13, 46, 14);
		panel_1.add(lblFrom);

		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(10, 50, 46, 14);
		panel_1.add(lblTo);

		JButton btnSearchJourney = new JButton("Search");
		btnSearchJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Thread tJ = new JourneysThread(p, g);
				tJ.start();

			}
		});
		btnSearchJourney.setBounds(148, 63, 89, 23);
		panel_1.add(btnSearchJourney);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 100, 249, 168);
		panel_1.add(scrollPane);
		scrollPane.setViewportView(textAreaJourney);
	}
}
