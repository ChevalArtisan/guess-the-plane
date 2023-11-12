package jeu;
public class Jeu {
	
	private Avion[] avions;
	private Avion avionEnCours;
	private int cpt=0;
	
	public Jeu() {
		//TODO rajouter des avions PLEIN

		String[] typeMirage2000={"mirage"};
		String[] varianteMirage2000={"2000"};
		String[] surnomMirage2000= {""};
		String[] indicesM2000= {"Mirage2000.jpg","Flag_of_France.svg.png","Dassault_Mirage_2000C_3-view_line_drawing.gif"};
		Avion mirage2000 = new Avion(typeMirage2000,varianteMirage2000,surnomMirage2000,Pays.FRANCE,indicesM2000);
		
		String[] typeF16={"f"};
		String[] varianteF16={"16"};
		String[] surnomF16= {"fighting falcon"};
		String[] indicesF16= {"f16.jpeg","Flag_of_the_United_States.svg.png","F-16-view_line_drawing.svg"};
		Avion f16 = new Avion(typeF16,varianteF16,surnomF16,Pays.ETATSUNIS,indicesF16);
		
		
		Avion[] avions= {mirage2000,f16};
		this.avions=avions;
	}
	
	public void newAvion() {
		avionEnCours=avions[cpt++];
		System.out.println(avionEnCours.getType());
	}
	
	
	public Avion getAvionEnCours() {
		return avionEnCours;
	}

	public int isReponseJuste(String reponseType,String reponseVariante,String reponseSurnom) {
		int result=0;
				if(avionEnCours.getType().contains(reponseType.toLowerCase())&&avionEnCours.getVariante().contains(reponseVariante.toLowerCase())) {
					result++;
					if (avionEnCours.getSurnom().contains("")) {
						
					}else if(avionEnCours.getSurnom().contains(reponseSurnom.toLowerCase())) {
						result++;
					}
				}
				return result;
				
				
	}
}
