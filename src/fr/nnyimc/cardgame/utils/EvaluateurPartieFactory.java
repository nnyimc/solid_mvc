package fr.nnyimc.cardgame.utils;

import java.util.List;

import fr.nnyimc.cardgame.model.Joueur;

public interface EvaluateurPartieFactory {
	public Joueur designerGagnant(List<Joueur> joueurs);
}
