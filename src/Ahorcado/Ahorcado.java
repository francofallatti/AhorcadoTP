package Ahorcado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JLabel;

public class Ahorcado {
	// k: nivel de dificultad -> v: set de palabras para esa dificultad
	private HashMap<Dificultad, Set<Palabra>> palabras;
	private Set<Character> letrasErradas; // lista de caracteres errados
	private Integer intentos;
	private Palabra palabraEnJuego;
	private Palabra palabraEncriptada;

	public Ahorcado(Dificultad dificultad, Lenguaje lenguaje) {
		intentos = 6;

		palabras = new HashMap<Dificultad, Set<Palabra>>();
		letrasErradas = new HashSet<Character>();
		// inicializa el hashMap de palabras
		palabras.put(Dificultad.Facil, new HashSet<Palabra>());
		palabras.put(Dificultad.Intermedio, new HashSet<Palabra>());
		palabras.put(Dificultad.Dificil, new HashSet<Palabra>());

		// agrega las palabras del txt segun su nivel de dificultad al set que le
		// corresponda
		agregarPalabras(lenguaje);

		// selecciona una palabra a jugar y la inicializa en palabraEnJuego
		Palabra[] palabrasPorDificultad = palabras.get(dificultad)
				.toArray(new Palabra[palabras.get(dificultad).size()]);
		Integer r = new Random().nextInt(palabras.get(dificultad).size());
		palabraEnJuego = palabrasPorDificultad[r];
		
		palabraEncriptada = palabraEnJuego.encriptarPalabra();

	}

	public static Ahorcado iniciarJuego(Dificultad dificultad, Lenguaje lenguaje) {
		Ahorcado ahorcado = new Ahorcado(dificultad, lenguaje);
		return ahorcado;
	}

	
	public void actualizarPalabraEncriptada(Character c) {
		palabraEncriptada.desencriptarPalabra(palabraEnJuego, c);
	}

	public void arriesgarLetra(Character c) {
		if (palabraEnJuego.contieneLetra(c)) {
			
		} else {
			letrasErradas.add(c);
			intentos--;
		}
	}

	private void agregarPalabras(Lenguaje lenguaje) {
		try (FileReader fr = new FileReader(seleccionarArchivoDeLenguaje(lenguaje));
				BufferedReader br = new BufferedReader(fr)) {
			String palabra;
			while ((palabra = br.readLine()) != null) {
				listaDePalabras(palabra.toLowerCase());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String seleccionarArchivoDeLenguaje(Lenguaje lenguaje) {
		switch (lenguaje) {
		case Español:
			return "palabrasEnEspañol.txt";

		case Ingles:
			return "palabrasEnIngles.txt";

		case Frances:
			return "palabrasEnFrances.txt";

		default:
			return null;
		}
	}

	private void listaDePalabras(String palabra) {
		Palabra p = new Palabra(palabra);
		switch (Palabra.dificultad(p)) {
		case Facil:
			palabras.get(Dificultad.Facil).add(p);
			break;

		case Intermedio:
			palabras.get(Dificultad.Intermedio).add(p);
			break;

		case Dificil:
			palabras.get(Dificultad.Dificil).add(p);
			break;

		default:
			break;
		}
	}
	
	//Compara los Strings de la Palabra en juego y la palabra encriptada para mostrar WinInterface
	public boolean juegoGanado() {
		return palabraEncriptada.toString().equals(palabraEnJuego.toString());
	}
	
	//Compara si los intentos son iguales a 0 para mostrar LooseInterface
	public boolean juegoPerdido() {
		return intentos.equals(0);
	}
	
	public Set<Character> getLetrasErradas() {
		return letrasErradas;
	}

	//devuelve intentos restantes
	public Integer getIntentos() {
		return intentos;
	}
	
	//devuelve la palabra en juego
	public Palabra getPalabraEnJuego() {
		return palabraEnJuego;
	}
	
	//devuelve palabra encriptada
	public Palabra getPalabraEncriptada() {
		return palabraEncriptada;
	}
}
