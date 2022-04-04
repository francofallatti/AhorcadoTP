package Ahorcado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Ahorcado {
	// modela una lista e palabras cuyas keys(K) son el niver de dificultad de cada
	// palabra
	// 0-9 facil, 10-19 medio, >20 dificil
	private HashMap<String, Dificultad> palabrasHashMap; // *********cambio palabra por String
	public Set<Character> letrasErradaSet; // lista de caracteres errados
	private Integer intentos;

	public Ahorcado() {
		this.intentos = 6;
	}

	public void agregarPalabras() {
		try (FileReader fr = new FileReader("ListaDePalabras.txt"); BufferedReader br = new BufferedReader(fr)) {
			String palabra;
			while ((palabra = br.readLine()) != null) {
				listaDePalabras(palabra);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void listaDePalabras(String palabra) {
		if (palabra.length() < 5) {
			palabrasHashMap.put(palabra, Dificultad.Facil);
		} else {
			if (palabra.length() >= 5 && palabra.length() < 8) {
				palabrasHashMap.put(palabra, Dificultad.Intermedio);
			}
			palabrasHashMap.put(palabra, Dificultad.Dificil);
		}
	}

	// selecciona palabra a jugar
	public String palabraEnJuego(String[] palabra) {
		int random = new Random().nextInt(palabra.length);
		return palabra[random];
	}

	public static String getPalabraFacil() {
		throw new RuntimeException("no implementado");
	}
	public static String getPalabraIntermedia() {
		throw new RuntimeException("no implementado");
	}
	public static String getPalabraDificil() {
		throw new RuntimeException("no implementado");
	}

	// comprueba si el caracter se encuentra en la palabra y lo agrega a la lista en
	// caso de ser false
	public void palabraErrada(Character c) {
		if (!Palabra.contieneLetra(c)) {
			letrasErradaSet.add(c);
			intentos--;
		}
	}
}
