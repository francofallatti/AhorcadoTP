package Interface;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WinInterface extends JFrame {

	public JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinInterface window = new WinInterface(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WinInterface(boolean b) {
		frame = new JFrame();
		frame.setVisible(b);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00A1GANASTE!");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Joystix", Font.PLAIN, 16));
		lblNewLabel.setBounds(167, 51, 93, 14);
		frame.add(lblNewLabel);
		
		Button button = new Button("Juego Nuevo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainInterface volverAJugar = new MainInterface();
				volverAJugar.SetVisibleTrue();
				frame.setVisible(false);
			}
		});
		button.setBounds(179, 164, 70, 22);
		frame.add(button);
	}
}
