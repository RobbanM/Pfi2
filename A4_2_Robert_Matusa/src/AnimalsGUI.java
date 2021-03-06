import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class AnimalsGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalsGUI frame = new AnimalsGUI();
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
	public AnimalsGUI() {
		
		//Fixed
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Snake("Shnake", true));
		animals.add(new Cat("Kittykat", "cattus", 10, 18));
		animals.add(new Dog("Doge", "canis", 16, true));
		animals.add(new Snake("SneakySnake", false));
		animals.add(new Cat("CatKitty", "cattus", 5, 20));
		animals.add(new Dog("DoggyDoge", "canis", 10, false));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 22, 388, 211);
		contentPane.add(textArea);

		for (Animal value : animals) {
			textArea.append(value.getInfo() + "\n");
		}

	}

}
