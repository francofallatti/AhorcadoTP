package Interface;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LooseInterface extends JFrame {

	public JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LooseInterface window = new LooseInterface(true, "test");
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
		
		JLabel lblPalabra = new JLabel("La palabra era: "+ palabraJugada);// +Ahorcado.getPalabraEnJuego().toString()
		lblPalabra.setForeground(Color.WHITE);
		lblPalabra.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalabra.setFont(new Font("Joystix", Font.PLAIN, 16));
		lblPalabra.setBounds(52, 106, 326, 41);
		frame.getContentPane().add(lblPalabra);
		
		Button button = new Button("Juego Nuevo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainInterface volverAJugar = new MainInterface();
				volverAJugar.SetVisibleTrue();
				frame.setVisible(false);
			}
		});
		button.setBounds(179, 164, 70, 22);
		frame.getContentPane().add(button);
	}

}
