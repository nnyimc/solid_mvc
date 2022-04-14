package fr.nnyimc.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	private List<CarteAJouer> cartes;
	
	public Jeu() {
		this.cartes = new ArrayList<>();
	}
	
	public void ajouter(CarteAJouer carte) {
		cartes.add(carte);
	}
	
	public CarteAJouer poser() {
		return cartes.get(0);
	}
	
	public CarteAJouer lire(int number) {
		CarteAJouer carteSelectionnee = null;
		if ( number < cartes.size() ) {
			carteSelectionnee =  cartes.get(number);
		}
		return carteSelectionnee;
	}
	
	
}

