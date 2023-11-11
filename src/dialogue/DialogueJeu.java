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

	public boolean handleReponse(String reponseType,String reponseVariante,String reponseSurnom) {
		return jeu.isReponseJuste(reponseType, reponseVariante, reponseSurnom);
	}
	
	public Avion handleNewPlane() {
		jeu.newAvion();
		return jeu.getAvionEnCours();
	}

public static void main(String[] args) {
		
		//Create dialogReservation
		
		List<String> typeMirage2000=new ArrayList<>();
		typeMirage2000.add("mirage");
		List<String> varianteMirage2000=new ArrayList<>();
		varianteMirage2000.add("2000");
		List<String> surnomMirage2000=new ArrayList<>();
		surnomMirage2000.add("");
		String[] indicesM2000= {"Mirage2000.jpg","Flag_of_France.svg.png","Dassault_Mirage_2000C_3-view_line_drawing.gif"};
		Avion mirage2000 = new Avion(typeMirage2000,varianteMirage2000,surnomMirage2000,Pays.FRANCE,indicesM2000);
		
		List<String> typeF16=new ArrayList<>();
		typeF16.add("f");
		List<String> varianteF16=new ArrayList<>();
		varianteF16.add("16");
		List<String> surnomF16=new ArrayList<>();
		surnomF16.add("fighting falcon");
		String[] indicesF16= {"f16.jpeg","Flag_of_the_United_States.svg.png","F-16-view_line_drawing.svg"};
		Avion f16 = new Avion(typeF16,varianteF16,surnomF16,Pays.ETATSUNIS,indicesF16);
		Avion[] avions= {mirage2000,f16};
		Jeu jeu = new Jeu(avions);
		
		//TODO rajouter des avions PLEIN
		
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
