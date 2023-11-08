package jeu;

public class Jeu {
	
	private Avion avions[];
	private Avion avionEnCours;
	
	public Jeu(Avion avions[]) {
		this.avions=avions;
	}
	
	public void newAvion() {
		avionEnCours=avions[0];
	}
	
	
	public boolean isReponseJuste(String reponseType,String reponseVariante) {
		return avionEnCours.getType().contains(reponseType.toLowerCase())&&avionEnCours.getVariante().contains(reponseVariante.toLowerCase());
	}
}
