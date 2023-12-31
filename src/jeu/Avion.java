package jeu;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public class Avion {
	private Collection<String> type;
	private Collection<String> variante;
	private Collection<String> surnom;
	private Pays pays;
	private String[] indices;
	
	
	public Avion(String[] type, String[]  variante,String[]  surnom, Pays pays, String[] indices) {
		this.type = Arrays.asList(type);
		this.variante = Arrays.asList(variante);
		this.surnom=Arrays.asList(surnom);
		this.pays = pays;
		this.indices = indices;
	}
	
	public Collection<String> getType() {
		return type;
	}
	public void setType(Collection<String> type) {
		this.type = type;
	}
	public Collection<String> getVariante() {
		return variante;
	}
	public void setVariante(Collection<String> variante) {
		this.variante = variante;
	} 
	public Collection<String> getSurnom() {
		return surnom;
	}

	public void setSurnom(Collection<String> surnom) {
		this.surnom = surnom;
	}

	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public String[] getIndices() {
		return indices;
	}
	public void setIndices(String[] indices) {
		this.indices = indices;
	}
	
	
	
}
