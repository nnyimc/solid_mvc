package fr.nnyimc.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import fr.nnyimc.cardgame.model.CarteAJouer;
import fr.nnyimc.cardgame.model.Joueur;
import fr.nnyimc.cardgame.model.PaquetCartes;
import fr.nnyimc.cardgame.utils.EvaluateurPartie;
import fr.nnyimc.cardgame.utils.EvaluateurPartieFactory;
import fr.nnyimc.cardgame.view.Vue;

public class JeuControleur {	
	
	PaquetCartes paquetCartes;
	List<Joueur> joueurs;
	EvaluateurPartieFactory evaluateurPartie;
	Joueur gagnant;
	Vue vue;
	StatutJeu statutJeu;
	
	public JeuControleur(Vue vue, PaquetCartes paquetCartes, EvaluateurPartieFactory evaluateurPartie) {
		this.paquetCartes = paquetCartes;
		this.evaluateurPartie = evaluateurPartie;
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
				vue.quitter();
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
		gagnant = evaluateurPartie.designerGagnant(joueurs);
	}
	
	void afficherGagnant() {
		vue.afficherGagnant(gagnant.getNom());
	}
	
	void reinitaliserPaquet() {
		for (Joueur joueur : joueurs) {
			paquetCartes.rendre(joueur.poserCarte());
		}
	}
	
	void quitterJeu() {
		System.exit(0);
	}

	public void choisirAction(String readLine) {
		if (readLine.contentEquals("+Q")) {
			quitterJeu();
		} else {
			lancerJeu();
		}
		
	}
}
