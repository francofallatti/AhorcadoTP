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
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;

public class InterfazJuego extends JFrame {

	Ahorcado ahorcado;
	
	
	private JPanel contentPane;
	private JTextField letraArriesgada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ahorcado ahorcado = Ahorcado.iniciarJuego(null, null);
					InterfazJuego frame = new InterfazJuego(ahorcado);
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
	public InterfazJuego(Ahorcado ahorcado) {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("AHORCADO");
		lblNewLabel.setFont(new Font("Joystix", Font.PLAIN, 12));
		lblNewLabel.setBounds(177, 41, 72, 14);
		contentPane.add(lblNewLabel);

		JLabel encriptada = new JLabel(ahorcado.getPalabraEncriptada().toString());
		encriptada.setBounds(80, 115, 287, 14);
		contentPane.add(encriptada);
		
		JLabel vidasText = new JLabel("vidas:");
		vidasText.setFont(new Font("Joystix", Font.PLAIN, 11));
		vidasText.setBounds(321, 11, 46, 14);
		contentPane.add(vidasText);
		
		// ------------------------------------------------------------------------------------------------
		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setFont(new Font("Joystix", Font.PLAIN, 11));
		lblLetra.setBounds(164, 153, 41, 14);
		contentPane.add(lblLetra);

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
		contentPane.add(letraArriesgada);
		letraArriesgada.setColumns(10);

		// String palabraString = Ahorcado.getPalabraString();
		JLabel lbPalabra = new JLabel(ahorcado.getPalabraEnJuego().toString());
		lbPalabra.setBounds(146, 66, 135, 38);
		contentPane.add(lbPalabra);
		lbPalabra.setVisible(false);
		
		JLabel vidas = new JLabel(ahorcado.getIntentos().toString());
		vidas.setBounds(366, 11, 46, 14);
		contentPane.add(vidas);

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
				}
				if(ahorcado.juegoPerdido()) {
					LooseInterface perdiste = new LooseInterface(true,ahorcado.getPalabraEnJuego().toString2() );
				}
			}
		});
		btnNewButton.setBounds(146, 178, 131, 23);
		contentPane.add(btnNewButton);
	}

	private void setVisible() {
		this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

	}
}
