package Interface;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.junit.Ignore;

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
		nombreJuego.setBounds(164, 27, 112, 29);
		frame.getContentPane().add(nombreJuego);		

		JLabel encriptada = new JLabel(ahorcado.getPalabraEncriptada().toString());
		encriptada.setForeground(Color.WHITE);
		encriptada.setHorizontalAlignment(SwingConstants.CENTER);
		encriptada.setFont(new Font("Joystix", Font.PLAIN, 10));
		encriptada.setBounds(61, 101, 287, 14);
		frame.getContentPane().add(encriptada);
		
		
		JLabel vidasText = new JLabel("vidas:");
		vidasText.setForeground(Color.WHITE);
		vidasText.setFont(new Font("Joystix", Font.PLAIN, 11));
		vidasText.setBounds(321, 11, 46, 14);
		frame.getContentPane().add(vidasText);
		
		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setForeground(Color.WHITE);
		lblLetra.setFont(new Font("Joystix", Font.PLAIN, 11));
		lblLetra.setBounds(164, 126, 41, 14);
		frame.getContentPane().add(lblLetra);

		letraArriesgada = new JTextField();
		
		//limita la cantidad de caracteres ingresados
		letraArriesgada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(letraArriesgada.getText().length() >= 1 || keyConditions(e.getKeyChar())) {
					e.consume();
				}
			}

			private boolean keyConditions(char text) {
				char[] listChar = {'1','2','3','4','5','6','7','8','9','0','!','"','#','$','%','&','/','(',')',
						'=','|','°','?','¿','¡','+','*','~','´','¨','}',']','{','[','-','_',':','.',',',';','¬'};
				for (char c : listChar) {
					if(text== c) {
						return true;
					}
				}
				return false;
			}
		});
		
		letraArriesgada.setBounds(215, 123, 22, 20);
		frame.getContentPane().add(letraArriesgada);
		letraArriesgada.setColumns(10);

		JLabel lbPalabra = new JLabel(ahorcado.getPalabraEnJuego().toString());
		lbPalabra.setBounds(10, 223, 135, 38);
		frame.getContentPane().add(lbPalabra);
		lbPalabra.setVisible(false);
		
		JLabel vidas = new JLabel(ahorcado.getIntentos().toString());
		vidas.setForeground(Color.WHITE);
		vidas.setFont(new Font("Joystix", Font.PLAIN, 11));
		vidas.setBounds(366, 11, 46, 14);
		frame.getContentPane().add(vidas);
		
		JLabel lblLetrasArriesgadas = new JLabel("letras erradas:");
		lblLetrasArriesgadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetrasArriesgadas.setForeground(Color.WHITE);
		lblLetrasArriesgadas.setFont(new Font("Joystix", Font.PLAIN, 10));
		lblLetrasArriesgadas.setBounds(80, 213, 287, 14);
		frame.getContentPane().add(lblLetrasArriesgadas);
		
		JLabel letrasErradas = new JLabel(ahorcado.getLetrasErradas().toString());
		letrasErradas.setHorizontalAlignment(SwingConstants.CENTER);
		letrasErradas.setForeground(Color.WHITE);
		letrasErradas.setFont(new Font("Joystix", Font.PLAIN, 10));
		letrasErradas.setBounds(80, 223, 287, 14);
		frame.getContentPane().add(letrasErradas);
		
		JLabel lblIngresarUnaLetra = new JLabel("ingresar una letra para continuar");
		lblIngresarUnaLetra.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarUnaLetra.setForeground(Color.WHITE);
		lblIngresarUnaLetra.setFont(new Font("Joystix", Font.PLAIN, 10));
		lblIngresarUnaLetra.setBounds(80, 188, 287, 14);
		frame.getContentPane().add(lblIngresarUnaLetra);
		lblIngresarUnaLetra.setVisible(false);

		JButton btnNewButton = new JButton("Arriesgar letra!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(letraArriesgada.getText().length() == 1) {
					lblIngresarUnaLetra.setVisible(false);
					String letra = letraArriesgada.getText().toLowerCase();
					Character c = letra.charAt(0);
					ahorcado.arriesgarLetra(c);
					vidas.setText(ahorcado.getIntentos().toString());
					letrasErradas.setText(ahorcado.getLetrasErradas().toString());
					
					letraArriesgada.setText("");
					ahorcado.actualizarPalabraEncriptada(c);
					encriptada.setText(ahorcado.getPalabraEncriptada().toString());
					
					if(ahorcado.juegoGanado()) {
						WinInterface winInterface = new WinInterface(true);
						frame.setVisible(false);
					}
					if(ahorcado.juegoPerdido()) {
						LooseInterface perdiste = new LooseInterface(true,ahorcado.getPalabraEnJuego().toString2() );
						frame.setVisible(false);
					}
				} else {
					lblIngresarUnaLetra.setVisible(true);
				}
			}
		});
		lblIngresarUnaLetra.setVisible(false);
		btnNewButton.setBounds(145, 154, 131, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
