package test;

import java.util.ArrayList;
import java.util.List;

import jeu.Avion;
import jeu.Jeu;
import jeu.Pays;

public class Test {
public static void main(String[] args) {
	
	Jeu jeu = new Jeu();
	jeu.newAvion();
	System.out.println(jeu.isReponseJuste("mirage", "2000", null));
	System.out.println(jeu.isReponseJuste("prout", "bez", null));
}
}
