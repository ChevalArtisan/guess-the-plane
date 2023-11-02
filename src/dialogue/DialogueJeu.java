package dialogue;

import java.util.Random;

import jeu.Avion;

public class DialogueJeu {
	
	private Avion avions[];
	private Avion avionEnCours;
	
	public DialogueJeu(Avion avions[]) {
		this.avions=avions;
	}
	
	public void newAvion() {
		avionEnCours=avions[0];
	}
	
}
