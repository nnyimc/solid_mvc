package fr.nnyimc.cardgame.utils;

import java.util.List;

import fr.nnyimc.cardgame.model.CarteAJouer;
import fr.nnyimc.cardgame.model.Joueur;

public class EvaluateurPartie implements EvaluateurPartieFactory {
	@Override
	public Joueur designerGagnant(List<Joueur> joueurs) {
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
		return meilleurJoueur;
	}
}
