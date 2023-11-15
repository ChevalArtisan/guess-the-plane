package dialogue;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;


import affichage.JFrameGuessThePlane;
import jeu.Avion;
import jeu.Jeu;
import jeu.Pays;


public class DialogueJeu {
	

private JFrameGuessThePlane presentationGTP;
private Jeu jeu;
	
	public void initDialog() {
		//Create presentation frame
		presentationGTP = new JFrameGuessThePlane();
		//Associate dialogue to presentation
		presentationGTP.setDialogue(this);
		//Initialize and enable presentation frame
		presentationGTP.initPresentation();
		presentationGTP.setVisible(true);
		
	}
	
	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public int handleReponse(String reponseType,String reponseVariante,String reponseSurnom) {
		return jeu.isReponseJuste(reponseType, reponseVariante, reponseSurnom);
	}
	
	public Avion handleNewPlane() {
		jeu.newAvion();
		return jeu.getAvionEnCours();
	}

public static void main(String[] args) {
		
		//Create dialogReservation

		
		Jeu jeu = new Jeu();
		jeu.shuffle();
		
		DialogueJeu dialogueJeu = new DialogueJeu();
		dialogueJeu.setJeu(jeu);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialogueJeu.initDialog();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
}


}
