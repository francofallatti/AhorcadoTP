package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LooseInterface extends JFrame {

	public JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LooseInterface(boolean b, String palabraJugada) {
		frame = new JFrame();
		frame.setVisible(b);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PERDISTE u_u");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Joystix", Font.PLAIN, 16));
		lblNewLabel.setBounds(144, 51, 140, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPalabra = new JLabel("La palabra era: "+ palabraJugada);
		lblPalabra.setForeground(Color.WHITE);
		lblPalabra.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalabra.setFont(new Font("Joystix", Font.PLAIN, 12));
		lblPalabra.setBounds(52, 106, 326, 41);
		frame.getContentPane().add(lblPalabra);
		
		JButton button = new JButton("Juego Nuevo");
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainInterface volverAJugar = new MainInterface();
				volverAJugar.SetVisibleTrue();
				frame.setVisible(false);
			}
		});
		button.setBounds(160, 158, 111, 34);
		frame.getContentPane().add(button);
	}

}
