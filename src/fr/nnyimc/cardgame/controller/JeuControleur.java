package fr.nnyimc.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import fr.nnyimc.cardgame.model.CarteAJouer;
import fr.nnyimc.cardgame.model.Joueur;
import fr.nnyimc.cardgame.model.PaquetCartes;
import fr.nnyimc.cardgame.view.Vue;

public class JeuControleur {	
	
	PaquetCartes paquetCartes;
	List<Joueur> joueurs;
	Joueur gagnant;
	Vue vue;
	StatutJeu statutJeu;
	
	public JeuControleur(Vue vue, PaquetCartes paquetCartes) {
		this.paquetCartes = paquetCartes;
		this.vue = vue;
		this.joueurs = new ArrayList<Joueur>();
		this.statutJeu = StatutJeu.JoueursAjoutes;
        vue.parametrerControleur(this);
	}
	
	public void lancerJeu() {
		while (statutJeu == statutJeu.JoueursAjoutes) {
			vue.demanderNomJoueur();
		}

		switch (statutJeu) {
			case CartesDistribuees:
				vue.demanderRetournement();
				break;
			case GagnantDesigne:
				statutJeu = StatutJeu.JoueursAjoutes;
				vue.demanderNouvellePartie();
				break;
		}
	}
	
	public void ajouterJoueur(String nomJoueur) {
		if ( statutJeu == StatutJeu.JoueursAjoutes ) {
			joueurs.add(new Joueur(nomJoueur));
			vue.afficherNom(joueurs.size(), nomJoueur);
		}
	}
	
	public void demarrerPartie() {
		if (statutJeu != StatutJeu.CartesDistribuees) {
			paquetCartes.seMelanger();
			int indexJoueur = 1;
			for (Joueur joueur : joueurs) {
				joueur.ajouterCarte(paquetCartes.distribuer());
			    vue.afficherDosCarte(indexJoueur++, joueur.getNom());
			}
			statutJeu = StatutJeu.CartesDistribuees;
		}
		this.lancerJeu();
		
	}
	
	public void retournerCartes() {
		int playerIndex = 1;
		for ( Joueur joueur: joueurs ) {
			CarteAJouer carteAJouer = joueur.lireCarte(0);
			carteAJouer.seRetourner();
			vue.afficherCarteJoueur(playerIndex++, joueur.getNom(), carteAJouer.getRang().name(), carteAJouer.getCouleur().name());
		}
		
		determinerGagnant();
		afficherGagnant();
		reinitaliserPaquet();
		statutJeu = StatutJeu.GagnantDesigne;
		this.lancerJeu();
		
	}
	
	void determinerGagnant() {
		Joueur meilleurJoueur = null;
		int meilleurRang = -1;
		int meilleureCouleur = -1;
		
		for (Joueur joueur: joueurs) {
			boolean nouveauMeilleurJoueur = false;
			
			if ( meilleurJoueur == null ) {
				nouveauMeilleurJoueur = true;
			} else {
				CarteAJouer carteAJouer = joueur.lireCarte(0);
				int rangCourant = carteAJouer.getRang().valeur();
				
				if ( rangCourant >= meilleurRang ) {
					nouveauMeilleurJoueur = true;
				} else {
					if (carteAJouer.getCouleur().valeur() > meilleureCouleur) {
						nouveauMeilleurJoueur = true;
					}
				}
			}
			
			if ( nouveauMeilleurJoueur ) {
				meilleurJoueur = joueur;
				CarteAJouer carteAJouer = joueur.lireCarte(0);
				meilleurRang = carteAJouer.getRang().valeur();
				meilleureCouleur = carteAJouer.getCouleur().valeur(); 
			}
		}
		gagnant = meilleurJoueur;
	}
	
	void afficherGagnant() {
		vue.afficherGagnant(gagnant.getNom());
	}
	
	void reinitaliserPaquet() {
		for (Joueur joueur : joueurs) {
			paquetCartes.rendre(joueur.poserCarte());
		}
	}
}
