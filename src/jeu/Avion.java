package jeu;

import java.awt.Image;
import java.util.Collection;

public class Avion {
	private Collection<String> type;
	private Collection<String> variante;
	private Pays pays;
	private String[] indices;
	
	
	public Avion(Collection<String> type, Collection<String> variante, Pays pays, String[] indices) {
		super();
		this.type = type;
		this.variante = variante;
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
