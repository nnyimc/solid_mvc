package fr.nnyimc.cardgame.model;

public enum Rang {
	DEUX (2),
	TROIS (3),
	QUATRE (4),
	CINQ (5),
	SIX (6),
	SEPT (7),
	HUIT (8),
	NEUF (9),
	DIX (10),
	AS (11),
	VALET (12),
	DAME (13),
	ROI (14);
	
	private int rang;
	
	private Rang (int valeur) {
		rang = valeur;	
	}
	
	public int valeur() {
		return rang;
	}
}
