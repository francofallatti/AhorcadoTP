package Ahorcado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Ahorcado {
	// modela una lista e palabras cuyas keys(K) son el niver de dificultad de cada
	// palabra
	// 0-9 facil, 10-19 medio, >20 dificil
	private HashMap<Dificultad,Set<String> > palabrasHashMap; // *********cambio palabra por String
	public Set<Character> letrasErradaSet; // lista de caracteres errados
	private Integer intentos;

	
	private Set<String> palabrasFacil = new HashSet<String>();
	private Set<String> palabrasIntermedio = new HashSet<String>();
	private Set<String> palabrasDificil = new HashSet<String>();
	
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
		
		if (dificultad(palabra)==Dificultad.Facil) {
			palabrasFacil.add(palabra);
			palabrasHashMap.put(Dificultad.Facil, palabrasFacil);
		} else {
			if (dificultad(palabra)==Dificultad.Intermedio) {
				palabrasIntermedio.add(palabra);
				palabrasHashMap.put(Dificultad.Intermedio, palabrasIntermedio);
			}
			palabrasDificil.add(palabra);
			palabrasHashMap.put(Dificultad.Dificil, palabrasDificil);
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
	public void palabraErrada(Character c) {
		if (!Palabra.contieneLetra(c)) {
			letrasErradaSet.add(c);
			intentos--;
		}
	}
	
	public static Dificultad dificultad(String p) {
		if(p.length() < 5) {
			return Dificultad.Facil;
		}
		else {
			if(p.length() >= 5 && p.length() < 8) {
				return Dificultad.Intermedio;
			}
			return Dificultad.Dificil;
		}
	}
}
