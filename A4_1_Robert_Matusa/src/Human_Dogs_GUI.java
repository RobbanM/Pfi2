import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

public class Human_Dogs_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField humanInput;
	private JTextField dogInput;
	private JTextField info;
	private JTextField error;
	Human human1;
	Dog doge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Human_Dogs_GUI frame = new Human_Dogs_GUI();
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
	public Human_Dogs_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		humanInput = new JTextField();
		humanInput.setBounds(10, 37, 113, 23);
		contentPane.add(humanInput);
		humanInput.setColumns(10);

		dogInput = new JTextField();
		dogInput.setBounds(10, 67, 113, 23);
		contentPane.add(dogInput);
		dogInput.setColumns(10);

		JButton humanBtn = new JButton("New Human");
		humanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String human = humanInput.getText();
				
				if (human.length() < 3) {
					error.setText("Namnet maste vara minst 3 bokstaver");
				} else {
					human1 = new Human(human);
				}
			}
		});

		humanBtn.setBounds(146, 37, 128, 23);
		contentPane.add(humanBtn);

		JButton dogBtn = new JButton("Buy Dog");
		dogBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String dog = dogInput.getText();

				if (human1 == null) {
					error.setText("En hund maste ha en agare");
				} else {
					doge = new Dog(dog);
					human1.buyDog(doge);
				}

			}
		});
		dogBtn.setBounds(146, 67, 128, 23);
		contentPane.add(dogBtn);

		info = new JTextField();
		info.setBounds(10, 167, 414, 32);
		contentPane.add(info);
		info.setColumns(10);

		error = new JTextField();
		error.setEditable(false);
		error.setBounds(10, 218, 414, 32);
		contentPane.add(error);
		error.setColumns(10);

		JButton printBtn = new JButton("Print Info");
		printBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setText(human1.getInfo());
			}
		});
		printBtn.setBounds(146, 103, 128, 23);
		contentPane.add(printBtn);

		JLabel lblHumansAndDogs = new JLabel("Humans and Dogs");
		lblHumansAndDogs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHumansAndDogs.setBounds(132, 1, 168, 23);
		contentPane.add(lblHumansAndDogs);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 139, 410, 2);
		contentPane.add(separator);

		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(10, 152, 56, 16);
		contentPane.add(lblInfo);

		JLabel lblError = new JLabel("ErrorMessage");
		lblError.setBounds(10, 201, 85, 16);
		contentPane.add(lblError);
	}
}
