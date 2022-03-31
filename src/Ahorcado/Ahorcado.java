package Ahorcado;

import java.util.HashMap;
import java.util.Set;

public class Ahorcado {
	//modela una lista e palabras cuyas keys(K) son el niver de dificultad de cada palabra
	//0-9 facil, 10-19 medio, >20 dificil
	private HashMap<Integer, Palabra> palabrasHashMap; 
	
	public Set<String>letrasErradaSet;
	
	public void agregarPalabras() {
		throw new RuntimeException("no implementado");
	}
	public static String getPalabraFacil() {
		throw new RuntimeException("no implementado");
	}
}
