package fr.nnyimc.cardgame.view;

import fr.nnyimc.cardgame.controller.JeuControleur;

public interface Visible {
	
	public void parametrerControleur( JeuControleur jeuControleur);
	public void demanderNomJoueur();
	public void afficherNom(int size, String nomJoueur);
	public void afficherGagnant( String nomJoueur);
	public void afficherDosCarte(int i, String nom);
	public void afficherCarteJoueur(int i, String nomJoueur, String rang, String couleur);
	public void demanderRetournement();
	public void demanderNouvellePartie();

}
