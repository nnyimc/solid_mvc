package fr.nnyimc.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PaquetCartes {
	private List<CarteAJouer> paquetCartes;
	private static int TOTAL_CARTES = 52;
	
	public PaquetCartes() {
		paquetCartes = new ArrayList<>();
		initialiser();
		seMelanger();
	}

	
	
	public PaquetCartes(List<CarteAJouer> cartes) {
		paquetCartes = cartes;
	}
	
	public CarteAJouer distribuer() {
		CarteAJouer carteDistribuee = null; 
		carteDistribuee =  paquetCartes.remove(0);
		return carteDistribuee;
	}
	
	public void rendre( CarteAJouer carteRendue ) {
		paquetCartes.add(carteRendue);
	}
	
	public void seMelanger() {
		Random random = new Random();
		for ( int i = 0; i < TOTAL_CARTES; i++) {
			Collections.swap(paquetCartes, i, random.nextInt(TOTAL_CARTES));
		}
	}
	
	private void initialiser() {
		for ( Rang rang : Rang.values() ) {
			for ( Couleur couleur : Couleur.values() ) {
				CarteAJouer carte = new CarteAJouer( rang, couleur );
				paquetCartes.add( carte );
			}
		}
	}
	
}
