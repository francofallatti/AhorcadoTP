package Interface;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ahorcado.Ahorcado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;

public class InterfazJuego extends JFrame {

	Ahorcado ahorcado;
	
	public JFrame frame;
	private JTextField letraArriesgada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ahorcado ahorcado = Ahorcado.iniciarJuego(null, null);
					InterfazJuego window = new InterfazJuego(ahorcado, true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazJuego(Ahorcado ahorcado, boolean b) {
		frame = new JFrame();
		frame.setVisible(b);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel nombreJuego = new JLabel("AHORCADO");
		nombreJuego.setForeground(Color.WHITE);
		nombreJuego.setBackground(Color.WHITE);
		nombreJuego.setFont(new Font("Joystix", Font.PLAIN, 18));
		nombreJuego.setBounds(165, 39, 112, 29);
		frame.getContentPane().add(nombreJuego);		

		JLabel encriptada = new JLabel(ahorcado.getPalabraEncriptada().toString());
		encriptada.setForeground(Color.WHITE);
		encriptada.setHorizontalAlignment(SwingConstants.CENTER);
		encriptada.setFont(new Font("Joystix", Font.PLAIN, 14));
		encriptada.setBounds(63, 104, 287, 14);
		frame.getContentPane().add(encriptada);
		
		
		JLabel vidasText = new JLabel("vidas:");
		vidasText.setForeground(Color.WHITE);
		vidasText.setFont(new Font("Joystix", Font.PLAIN, 11));
		vidasText.setBounds(321, 11, 46, 14);
		frame.getContentPane().add(vidasText);
		
		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setForeground(Color.WHITE);
		lblLetra.setFont(new Font("Joystix", Font.PLAIN, 11));
		lblLetra.setBounds(164, 153, 41, 14);
		frame.getContentPane().add(lblLetra);

		letraArriesgada = new JTextField();
		
		//limita la cantidad de caracteres ingresados
		letraArriesgada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(letraArriesgada.getText().length() >= 1) {
					e.consume();
				}
			}
		});
		
		letraArriesgada.setBounds(215, 150, 22, 20);
		frame.getContentPane().add(letraArriesgada);
		letraArriesgada.setColumns(10);

		// String palabraString = Ahorcado.getPalabraString();
		JLabel lbPalabra = new JLabel(ahorcado.getPalabraEnJuego().toString());
		lbPalabra.setBounds(10, 223, 135, 38);
		frame.getContentPane().add(lbPalabra);
		lbPalabra.setVisible(false);
		
		JLabel vidas = new JLabel(ahorcado.getIntentos().toString());
		vidas.setForeground(Color.WHITE);
		vidas.setFont(new Font("Joystix", Font.PLAIN, 11));
		vidas.setBounds(366, 11, 46, 14);
		frame.getContentPane().add(vidas);

		JButton btnNewButton = new JButton("Arriesgar letra!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String letra = letraArriesgada.getText();
				Character c = letra.charAt(0);
				ahorcado.arriesgarLetra(c);
				vidas.setText(ahorcado.getIntentos().toString());
				letraArriesgada.setText("");
				ahorcado.getPalabraEncriptada().desencriptarPalabra(ahorcado.getPalabraEnJuego(), c);
				encriptada.setText(ahorcado.getPalabraEncriptada().toString());
				
				if(ahorcado.juegoGanado()) {
					WinInterface winInterface = new WinInterface(true);
					frame.setVisible(false);
				}
				if(ahorcado.juegoPerdido()) {
					LooseInterface perdiste = new LooseInterface(true,ahorcado.getPalabraEnJuego().toString2() );
					frame.setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(146, 178, 131, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
