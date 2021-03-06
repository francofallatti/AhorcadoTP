package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import Ahorcado.Ahorcado;
import Ahorcado.Dificultad;
import Ahorcado.Lenguaje;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterface {

	public JFrame frame;

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

		JComboBox<Dificultad> comboBoxDificultad = new JComboBox<Dificultad>();
		comboBoxDificultad.setForeground(Color.WHITE);
		comboBoxDificultad.setBackground(Color.BLACK);
		comboBoxDificultad.setBounds(161, 115, 90, 20);
		frame.getContentPane().add(comboBoxDificultad);
		comboBoxDificultad.setModel(new DefaultComboBoxModel<Dificultad>(new Dificultad[] {Dificultad.Facil,Dificultad.Intermedio, Dificultad.Dificil}));
		
		JComboBox<Lenguaje> comboBoxLenguaje = new JComboBox<Lenguaje>();
		comboBoxLenguaje.setForeground(Color.WHITE);
		comboBoxLenguaje.setBackground(Color.BLACK);
		comboBoxLenguaje.setBounds(161, 160, 90, 20);
		frame.getContentPane().add(comboBoxLenguaje);
		comboBoxLenguaje.setModel(new DefaultComboBoxModel<Lenguaje>(new Lenguaje[] {Lenguaje.Espa?ol,Lenguaje.Ingles,Lenguaje.Frances}));

		
		JButton btnJugar = new JButton("Jugar!");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				Dificultad dificultad = (Dificultad)comboBoxDificultad.getSelectedItem();
				Lenguaje lenguaje = (Lenguaje) comboBoxLenguaje.getSelectedItem();
				Ahorcado ahorcado = Ahorcado.iniciarJuego(dificultad, lenguaje);
				InterfazJuego interfaz = new InterfazJuego(ahorcado, true);
				frame.setVisible(false);
			}
		});
		btnJugar.setBounds(161, 207, 91, 23);
		frame.getContentPane().add(btnJugar);
	}
	
	public void SetVisibleTrue() {
		frame.setVisible(true);
	}
}

