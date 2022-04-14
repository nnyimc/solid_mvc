package fr.nnyimc.cardgame.model;

public enum Couleur {
	CARREAU (1),
	COEUR (2),
	PIQUE (3),
	TREFLE (4);
	
	private int couleur;
	
	private Couleur (int valeur) {
		couleur = valeur;
	}
	
	public int valeur() {
		return couleur;
	}

}
