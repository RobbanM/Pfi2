import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.util.Calendar;
import java.util.Random;

public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField clockH;
	private JTextField clockMin;
	final JLabel labelMessage = new JLabel("");

	ClockLogic clockLogic;

	JLabel labelTime = new JLabel("00:00:00");
	JLabel labelAlarmAt = new JLabel("");
	JLabel labelAlarmNotice = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		setType(Type.POPUP);
		setTitle("AlarmClock");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				DigitalClockGUI.class.getResource("/images/clock-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		clockLogic = new ClockLogic(this);

		labelTime.setHorizontalAlignment(SwingConstants.CENTER);
		labelTime.setForeground(Color.WHITE);
		labelTime.setFont(new Font("OCR A Std", Font.PLAIN, 55));
		labelTime.setBounds(28, 13, 392, 80);
		contentPane.add(labelTime);

		clockH = new JTextField();
		clockH.setText("00");
		clockH.setBounds(40, 127, 86, 20);
		contentPane.add(clockH);
		clockH.setColumns(10);

		clockMin = new JTextField();
		clockMin.setText("00");
		clockMin.setBounds(147, 127, 86, 20);
		contentPane.add(clockMin);
		clockMin.setColumns(10);

		JLabel label_1 = new JLabel(":");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(130, 120, 18, 34);
		contentPane.add(label_1);

		labelMessage.setForeground(Color.RED);
		labelMessage.setFont(new Font("Arial", Font.BOLD, 14));
		labelMessage.setBounds(78, 102, 155, 23);
		contentPane.add(labelMessage);
		labelAlarmNotice.setForeground(Color.WHITE);

		labelAlarmNotice.setFont(new Font("Arial", Font.BOLD, 20));
		labelAlarmNotice.setBounds(38, 79, 165, 34);
		contentPane.add(labelAlarmNotice);

		JButton btnSetAlarm = new JButton("Set");
		btnSetAlarm.setFont(new Font("Arial", Font.BOLD, 11));
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hourCheck = Integer.parseInt(clockH.getText());
				int minuteCheck = Integer.parseInt(clockMin.getText());

				if (hourCheck < 0 || hourCheck > 23 || minuteCheck < 0
						|| minuteCheck > 59) {
					labelMessage.setText("Not a valid time.");
				} else {
					String addZero = "";
					String addZero1 = "";

					if (hourCheck < 10) {
						addZero = "0";
					}
					if (minuteCheck < 10) {
						addZero1 = "0";
					}

					contentPane.setBackground(Color.RED);
					clockLogic.setAlarm(hourCheck, minuteCheck);
					labelAlarmAt.setText(addZero + hourCheck + ":" + addZero1
							+ minuteCheck);
					
					addZero = "";
					addZero1 = "";

					labelMessage.setText("");
					labelAlarmNotice.setText("");

				}

			}
		});
		btnSetAlarm.setBounds(257, 128, 68, 23);
		contentPane.add(btnSetAlarm);

		JLabel lblAlarmAt = new JLabel("Alarm at:");
		lblAlarmAt.setForeground(Color.WHITE);
		lblAlarmAt.setFont(new Font("Arial", Font.BOLD, 18));
		lblAlarmAt.setBounds(228, 79, 97, 28);
		contentPane.add(lblAlarmAt);

		labelAlarmAt.setHorizontalAlignment(SwingConstants.RIGHT);
		labelAlarmAt.setForeground(Color.WHITE);
		labelAlarmAt.setFont(new Font("OCR A Std", Font.PLAIN, 20));
		labelAlarmAt.setBounds(268, 82, 111, 23);
		contentPane.add(labelAlarmAt);

		JButton btnClearAlarm = new JButton("Clear");
		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.DARK_GRAY);
				labelAlarmAt.setText(null);
				labelAlarmNotice.setText(null);
				clockH.setText("00");
				clockMin.setText("00");
			}
		});
		btnClearAlarm.setFont(new Font("Arial", Font.BOLD, 11));
		btnClearAlarm.setBounds(335, 127, 68, 25);
		contentPane.add(btnClearAlarm);

	}

	public void setTimeOnLabel(String time) {
		labelTime.setText(time);
	}

	public void alarm(boolean activate) {

		if (true) {
			labelAlarmNotice.setText("Beep Boop");
		}
	}
}