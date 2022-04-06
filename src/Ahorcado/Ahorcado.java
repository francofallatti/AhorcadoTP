package Ahorcado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ahorcado {
	// modela una lista e palabras cuyas keys(K) son el niver de dificultad de cada
	// palabra
	// 0-9 facil, 10-19 medio, >20 dificil
	private HashMap<Dificultad,Set<Palabra> > palabrasHashMap; // *********cambio palabra por String
	public Set<Character> letrasErradaSet; // lista de caracteres errados
	private Integer intentos;
	private Palabra p;

	
	public Ahorcado() {
		this.intentos = 6;
		
		palabrasHashMap.put(Dificultad.Facil, new HashSet<Palabra>());
		palabrasHashMap.put(Dificultad.Intermedio, new HashSet<Palabra>());
		palabrasHashMap.put(Dificultad.Dificil, new HashSet<Palabra>());
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
		p = new Palabra(palabra);
		
		switch (Palabra.dificultad(p)) {
		case Facil:
			palabrasHashMap.get(Dificultad.Facil).add(p);
			break;
			
		case Intermedio:
			palabrasHashMap.get(Dificultad.Intermedio).add(p);
			break;
			
		case Dificil:
			palabrasHashMap.get(Dificultad.Facil).add(p);
			break;
			
		default:
			break;
		}
	}

	// selecciona palabra a jugar
	public String palabraEnJuego(Dificultad dificultad) { 
		String[] palabraEnJuego = palabrasHashMap.get(dificultad).toArray(new String[palabrasHashMap.get(dificultad).size()]);
		Integer r = new Random().nextInt()*palabraEnJuego.length;
		return palabraEnJuego[r];
	}

	public String getPalabraFacil() {
		return palabraEnJuego(Dificultad.Facil);
	}
	public String getPalabraIntermedia() {
		return palabraEnJuego(Dificultad.Intermedio);
	}
	public String getPalabraDificil() {
		return palabraEnJuego(Dificultad.Dificil);
	}

	// comprueba si el caracter se encuentra en la palabra y lo agrega a la lista en
	// caso de ser false
	public void caracterErrada(Character c) {
		if (!p.contieneLetra(c)) {
			letrasErradaSet.add(c);
			intentos--;
		}
	}
	
	
	
}
