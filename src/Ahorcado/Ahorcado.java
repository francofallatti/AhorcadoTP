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
	// k: nivel de dificultad ->  v: set de palabras para esa dificultad
	private HashMap<Dificultad,Set<Palabra> > palabras;
	private Set<Character> letrasErradas; // lista de caracteres errados
	private Integer intentos;
	private Palabra palabraEnJuego;

	
	public Ahorcado(Dificultad dificultad) {
		intentos = 6;
		
		//inicializa el hashMap de palabras
		palabras.put(Dificultad.Facil, new HashSet<Palabra>());
		palabras.put(Dificultad.Intermedio, new HashSet<Palabra>());
		palabras.put(Dificultad.Dificil, new HashSet<Palabra>());
		
		//agrega las palabras del txt segun su nivel de dificultad al set que le corresponda
		agregarPalabras();
		
		//selecciona una palabra a jugar y la inicializa en palabraEnJuego
		Palabra[] palabrasPorDificultad = palabras.get(dificultad).toArray(new Palabra[palabras.get(dificultad).size()]);
		Integer r = new Random().nextInt()*palabras.get(dificultad).size();
		palabraEnJuego = palabrasPorDificultad[r];
	}

	private void agregarPalabras() {
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
			palabras.get(Dificultad.Facil).add(p);
			break;
			
		default:
			break;
		}
	}
	
	// comprueba si el caracter se encuentra en la palabra y lo agrega a la lista en
	// caso de ser false
	private void caracterErrada(Character c) {
			letrasErradas.add(c);
			intentos--;
	}

	public Palabra getPalabra() {
		return palabraEnJuego;
	}
	
}
