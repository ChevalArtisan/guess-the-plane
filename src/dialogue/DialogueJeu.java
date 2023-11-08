package dialogue;

import java.awt.EventQueue;

import affichage.JFrameGuessThePlane;
import jeu.Jeu;


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
	
	public void handle_reponse(String reponseType,String reponseVariante,String reponseSurnom) {
		//TODO dialogue reponse
	}
public static void main(String[] args) {
		
		//Create dialogReservation
		DialogueJeu dialogueJeu = new DialogueJeu();
				
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
