package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ahorcado.Ahorcado;
import Ahorcado.Palabra;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;

public class InterfazJuego extends JFrame {
	
	Ahorcado ahorcado;

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ahorcado ahorcado = Ahorcado.jugar(null, null);
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
		lblNewLabel.setFont(new Font("Joystix", Font.PLAIN, 11));
		lblNewLabel.setBounds(173, 11, 64, 14);
		contentPane.add(lblNewLabel);
		
		//------------------------------------------------------------------------------------------------
		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setFont(new Font("Joystix", Font.PLAIN, 11));
		lblLetra.setBounds(164, 153, 41, 14);
		contentPane.add(lblLetra);
		
		textField = new JTextField();
		textField.setBounds(215, 150, 22, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//String palabraString = Ahorcado.getPalabraString();
		JLabel lbPalabra = new JLabel(ahorcado.getPalabraEnJuego());
		lbPalabra.setBounds(146, 66, 135, 38);
		contentPane.add(lbPalabra);
		
		Button button = new Button("Juego Nuevo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible();
				MainInterface interfaceMenu = new MainInterface();
				interfaceMenu.SetVisibleTrue();

			}

			
		});
		button.setBounds(354, 229, 70, 22);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("Arriesgar letra!");
		btnNewButton.setBounds(146, 178, 131, 23);
		contentPane.add(btnNewButton);
		
		
		
		eventosDelTeclado();
		
	}
	
	private void eventosDelTeclado() {
		KeyListener eventoTeclado = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getKeyChar());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		};
		
		textField.addKeyListener(eventoTeclado);
	}
	
	private void setVisible() {	
		this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

		
	}
}
		
        
