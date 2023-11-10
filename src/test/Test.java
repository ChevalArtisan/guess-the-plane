package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jeu.Avion;
import jeu.Jeu;
import jeu.Pays;

public class Test {
public static void main(String[] args) {
	List<String> typeMirage2000=new ArrayList<>();
	typeMirage2000.add("mirage");
	List<String> varianteMirage2000=new ArrayList<>();
	varianteMirage2000.add("2000");
	List<String> surnomMirage2000=new ArrayList<>();
	
	Avion mirage2000 = new Avion(typeMirage2000,varianteMirage2000,surnomMirage2000,Pays.FRANCE,null);
	Avion[] avions= {mirage2000};
	Jeu jeu = new Jeu(avions);
	jeu.newAvion();
	System.out.println(jeu.isReponseJuste("mirage", "2000", null));
	System.out.println(jeu.isReponseJuste("prout", "bez", null));
}
}