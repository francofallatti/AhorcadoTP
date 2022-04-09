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
					InterfazJuego frame = new InterfazJuego();
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
	public InterfazJuego() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JUEGO");
		lblNewLabel.setBounds(175, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		//------------------------------------------------------------------------------------------------
		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setBounds(52, 54, 35, 14);
		contentPane.add(lblLetra);
		
		textField = new JTextField();
		textField.setBounds(91, 51, 22, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//String palabraString = Ahorcado.getPalabraString();
		JLabel lbPalabra = new JLabel("hola");
		lbPalabra.setBounds(92, 179, 129, 38);
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
		
        
