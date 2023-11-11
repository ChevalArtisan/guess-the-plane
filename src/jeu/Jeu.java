package jeu;
public class Jeu {
	
	private Avion[] avions;
	private Avion avionEnCours;
	private int cpt=0;
	
	public Jeu(Avion[] avions) {
		this.avions=avions;
	}
	
	public void newAvion() {
		avionEnCours=avions[cpt++];
		System.out.println(avionEnCours.getType());
	}
	
	
	public Avion getAvionEnCours() {
		return avionEnCours;
	}

	public boolean isReponseJuste(String reponseType,String reponseVariante,String reponseSurnom) {
		return avionEnCours.getType().contains(reponseType.toLowerCase())
				&&avionEnCours.getVariante().contains(reponseVariante.toLowerCase())
				&&(reponseSurnom==null||avionEnCours.getSurnom().contains(reponseSurnom.toLowerCase()));
	}
}
