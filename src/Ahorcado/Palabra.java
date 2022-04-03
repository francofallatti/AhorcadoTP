package Ahorcado;

import java.util.ArrayList;

public class Palabra {
	static ArrayList<Character> palabra;	//ver si conviene Linked o Array
	
	public Palabra() {
	}
	
	public Palabra(ArrayList<Character> s) {
		this.palabra = s;
	}
	
	public static boolean contieneLetra(Character c) {
		return palabra.contains(c);
	}
	
	public Integer longitud() {
		return palabra.size();
	}
	
	public static Dificultad dificultad(Palabra p) {
		if(p.longitud() < 5) {
			return Dificultad.Facil;
		}
		else {
			if(p.longitud() >= 5 && p.longitud() < 8) {
				return Dificultad.Intermedio;
			}
			return Dificultad.Dificil;
		}
	}
	
	
}
