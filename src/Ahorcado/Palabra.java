package Ahorcado;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Palabra {
	private ArrayList<Character> palabra; // ver si conviene Linked o Array

	public Palabra() {
		palabra = new ArrayList<Character>();
	}

	public Palabra(ArrayList<Character> s) {
		this.palabra = s;

	}

	public Palabra(String s) {
		this.palabra = palabraToArrayList(s);
	}

	public ArrayList<Character> palabraToArrayList(String palabra) {
		ArrayList<Character> palabraArrayList = new ArrayList<>();
		for (int i = 0; i < palabra.length(); i++) {
			palabraArrayList.add(palabra.charAt(i));
		}
		return palabraArrayList;
	}

	public boolean contieneLetra(Character c) {
		return palabra.contains(c);
	}

	public void desencriptarPalabra(Palabra palabraSinEncriptar, Character c) {
		for (Integer i : Palabra.indicesDeApariciones(c, palabraSinEncriptar)) {
			palabra.set(i, c);
		}
	}

	public static Set<Integer> indicesDeApariciones(Character c, Palabra p) {
		Set<Integer> ret = new HashSet<Integer>();
		indicesDeApariciones(c, p, ret, -1);
		return ret;
	}

	private static Set<Integer> indicesDeApariciones(Character c, Palabra p, Set<Integer> ret, Integer indiceAnterior) {
		if (!p.contieneLetra(c)) {
			return ret;
		} else {
			Integer indicePalabraSplit = p.indiceDe(c);
			Integer indiceActual = indicePalabraSplit + indiceAnterior + 1; //le sumo 1 porque se estaría perdiendo la posicion del 0
			ret.add(indiceActual);
			return indicesDeApariciones(c, p.splitPalabra(indicePalabraSplit + 1, p.longitud()), ret, indiceActual);
		}
	}

	public void reemplazarCaracter(int indice, Character c) {
		palabra.set(indice, c);
	}

	private void agregarCaracter(Character c) {
		palabra.add(c);
	}

	public Palabra encriptarPalabra() {
		Palabra palabraNueva = new Palabra();
		for (Character caracter : palabra) {
			palabraNueva.agregarCaracter('_');
		}
		return palabraNueva;
	}

	private Integer indiceDe(Character c) {
		return palabra.indexOf(c);
	}

	private Palabra splitPalabra(Integer desde, Integer hasta) {
		ArrayList<Character> split = new ArrayList<Character>(palabra.subList(desde, hasta));
		Palabra ret = new Palabra(split);
		return ret;
	}

	public Integer longitud() {
		return palabra.size();
	}

	public static Dificultad dificultad(Palabra p) {
		if (p.longitud() < 5) {
			return Dificultad.Facil;
		} else if (p.longitud() >= 5 && p.longitud() < 8) {
			return Dificultad.Intermedio;
		} else {
			return Dificultad.Dificil;
		}
	}

	public String toString() {
		return palabra.toString();
	}
	
	public String toString2() {
		String p=""; 
		for (Character character : palabra) {
			p+=character;
		}
		return p;
		
	}

}
