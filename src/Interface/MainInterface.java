package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Color;

public class MainInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface window = new MainInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainInterface() {
		/*
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nombreJuego = new JLabel("AHORCADO");
		nombreJuego.setForeground(Color.WHITE);
		nombreJuego.setBackground(Color.WHITE);
		nombreJuego.setFont(new Font("Joystix", Font.PLAIN, 18));
		nombreJuego.setBounds(151, 50, 108, 14);
		frame.getContentPane().add(nombreJuego);
		
		JLabel lblTextDificultad = new JLabel("Seleccione el nivel de dificultad");
		lblTextDificultad.setForeground(Color.WHITE);
		lblTextDificultad.setFont(new Font("Joystix", Font.PLAIN, 11));
		lblTextDificultad.setBounds(85, 90, 244, 14);
		frame.getContentPane().add(lblTextDificultad);

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.BLACK);
		comboBox.setBounds(161, 141, 90, 20);
		frame.getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Facil","Intermedio","Dificil"}));

	}
}
