package fr.nnyimc.cardgame.app;

import fr.nnyimc.cardgame.controller.JeuControleur;
import fr.nnyimc.cardgame.model.PaquetCartes;
import fr.nnyimc.cardgame.utils.EvaluateurPartie;
import fr.nnyimc.cardgame.view.Vue;

public class Main {
	public static void main(String[] args) {
		JeuControleur jeuControleur = new JeuControleur(new Vue(), new PaquetCartes(), new EvaluateurPartie());
		jeuControleur.lancerJeu();
	}
}
