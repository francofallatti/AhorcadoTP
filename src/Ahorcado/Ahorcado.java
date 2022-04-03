package Ahorcado;

import java.util.HashMap;
import java.util.Set;

public class Ahorcado {
	//modela una lista e palabras cuyas keys(K) son el niver de dificultad de cada palabra
	//0-9 facil, 10-19 medio, >20 dificil
	private HashMap<Dificultad, Palabra> palabrasHashMap; 
	
	public Set<Character>letrasErradaSet; //lista de caracteres errados
	
	private Integer intentos;
	
	public Ahorcado() {
		this.intentos = 6;
	}
	
	public void agregarPalabras() {
		throw new RuntimeException("no implementado");
	}
	public static String getPalabraFacil() {
		throw new RuntimeException("no implementado");
	}
	
	//comprueba si el caracter se encuentra en la palabra y lo agrega a la lista en caso de ser false
	public void palabraErrada(Character c) { 
		if(!Palabra.contieneLetra(c)) {
			letrasErradaSet.add(c);
			intentos--;
		}
	}
}
