package fr.nnyimc.cardgame.model;

public class CarteAJouer {
	private Rang rang;
	private Couleur couleur;
	private boolean isVisible;
	
	public CarteAJouer() {
		isVisible = false;
	}
	
	public CarteAJouer(Rang rang, Couleur couleur) {
		this.rang = rang;
		this.couleur = couleur;
		isVisible = false;
	}

	public Rang getRang() {
		return rang;
	}

	public void setRang(Rang rang) {
		this.rang = rang;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public boolean getVisible() {
		return isVisible;
	}
	
	public boolean seRetourner() {
		this.isVisible = !isVisible;
		return isVisible;
	}
	
}
