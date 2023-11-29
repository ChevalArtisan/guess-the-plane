package jeu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Jeu {
	
	private Avion[] avions;
	private Avion avionEnCours;
	private int cpt=0;
	
	public Jeu() {
		//TODO rajouter des avions PLEIN

		String[] typeMirage2000={"mirage"};
		String[] varianteMirage2000={"2000"};
		String[] pasDeSurnom= {""};
		String[] indicesM2000= {"Mirage2000.jpg","Flag_of_France.svg.png","Dassault_Mirage_2000C_3-view_line_drawing.gif"};
		Avion mirage2000 = new Avion(typeMirage2000,varianteMirage2000,pasDeSurnom,Pays.FRANCE,indicesM2000);
		
		String[] typeF={"f"};
		String[] varianteF16={"16"};
		String[] surnomF16= {"fighting falcon","viper"};
		String[] indicesF16= {"f16.jpeg","Flag_of_the_United_States.svg.png","F-16-view_line_drawing.svg"};
		Avion f16 = new Avion(typeF,varianteF16,surnomF16,Pays.ETATSUNIS,indicesF16);
		
		String[] typeSU= {"soukhoi","soukhoï","su","sukhoi"};
		String[] varianteSU57= {"57"};
		String[] surnomSU57= {"felon"};
		String[] indicesSU57= {"su57.jpg","Flag_of_Russia.svg.png","Sukhoi_PAK-FA_isometric.svg.png"};
		Avion su57=new Avion(typeSU,varianteSU57,surnomSU57,Pays.URSS,indicesSU57);
		
		
		String[] typeRafale= {"rafale"};
		String[] varianteRafale= {"m"};
		String[] indicesRafale= {"rafale.jpg","Flag_of_France.svg.png","Dassault_Rafale_3-view_line_drawing.svg.png"};
		Avion rafale=new Avion(typeRafale, varianteRafale, pasDeSurnom, Pays.FRANCE, indicesRafale);
		
		String[] variante111= {"111"};
		String[] surnomF111= {"aardvark"};
		String[] indicesF111= {"f111.jpg","Flag_of_the_United_States.svg.png","General_Dynamics_F-111_Aardvark_3-view.svg"};
		Avion f111=new Avion(typeF, variante111, surnomF111, Pays.ETATSUNIS, indicesF111);
		
		String[] typeYak= {"yak","yakovlev"};
		String[] variante38= {"38"};
		String[] surnomYak38= {"forger"};
		String[] indicesYak38= {"yak38.jpg","Flag_of_the_Soviet_Union.svg.png","yak38schema.jpg"};
		Avion yak38=new Avion(typeYak, variante38, surnomYak38, Pays.URSS, indicesYak38);
		
		
		String[] typeMig= {"mig","mikoyan-gourevitch","mikoyangourevitch"};
		String[] variante29= {"29"};
		String[] surnomMig29= {"fulcrum"};
		String[] indicesMig29= {"mig29.jpg","Flag_of_the_Soviet_Union.svg.png","Mikoyan_MiG-29_3-view_line_drawing.png"};
		Avion mig29 = new Avion(typeMig,variante29,surnomMig29,Pays.URSS,indicesMig29);
		
		String[] typeTupolev= {"tupolev","tu"};
		String[] variante160= {"160"};
		String[] surnomtu160= {"blackjack"};
		String[] indicestu160= {"tu160.jpg","Flag_of_the_Soviet_Union.svg.png","Tupolev_Tu-160_3-view_graphic.svg.png"};
		Avion tu160 = new Avion(typeTupolev, variante160, surnomtu160, Pays.URSS, indicestu160);
		
		String[] variante14= {"14"};
		String[] surnomf14= {"tomcat","bombcat"};
		String[] indicesF14= {"f14.jpg","Flag_of_the_United_States.svg.png","420px-Grumman_F-14_Tomcat.png"};
		Avion f14=new Avion(typeF, variante14, surnomf14, Pays.ETATSUNIS, indicesF14);
		
		String[] typeTyphoon= {"eurofighter"};
		String[] varianteTyphoon= {"typhoon"};
		String[] indicesTyphoon= {"typhoon.jpg","Flag_of_Germany.svg.png","ef2000_1_3v.jpg"};
		Avion typhoon=new Avion(typeTyphoon,varianteTyphoon,pasDeSurnom,Pays.ALLEMAGNE,indicesTyphoon);
		
		
		String[] typeU= {"u"};
		String[] variante2= {"2"};
		String[] surnomU2= {"dragonlady"};
		String[] indicesU2= {"u2.jpg","Flag_of_the_United_States.svg.png","458px-Lockheed_U-2_0014.jpg"};
		Avion u2 = new Avion(typeU,variante2,surnomU2,Pays.ETATSUNIS,indicesU2);
		
		Avion[] avions= {mirage2000,f14,f16,su57,rafale,f111,yak38,mig29,tu160,typhoon,u2} ;
		this.avions=avions;
	}
	
	public void newAvion() {
		avionEnCours=avions[cpt++];
	}
	
	public void shuffle() {
		List<Avion> avionsList = Arrays.asList(avions);
		
		Collections.shuffle(avionsList);
		
		avionsList.toArray(avions);

	}
	public Avion getAvionEnCours() {
		return avionEnCours;
	}

	public int isReponseJuste(String reponseType,String reponseVariante,String reponseSurnom) {
		int result=0;
		System.out.println(reponseType.replaceAll("\\s",""));
				if(avionEnCours.getType().contains(reponseType.replaceAll("\\s",""))&&avionEnCours.getVariante().contains(reponseVariante.replaceAll("\\s",""))) {
					result++;
					if (avionEnCours.getSurnom().contains("")) {
						
					}else if(avionEnCours.getSurnom().contains(reponseSurnom.replaceAll("\\s",""))) {
						result++;
					}
				}
				return result;
				
				
	}
}
