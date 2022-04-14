package fr.nnyimc.cardgame.model;

public class Joueur {
	private String nom;
	private Jeu jeu;
	
	public Joueur(String nom) {
		this.nom = nom;
		jeu = new Jeu();
	}
	
	public void ajouterCarte( CarteAJouer carte ) {
		jeu.ajouter(carte);
	}
	
	public CarteAJouer poserCarte( ) {
		return jeu.poser();
	}
	
	public CarteAJouer lireCarte( int number ) {
		return jeu.lire(number);
	}

	public String getNom() {
		return nom;
	}
}
