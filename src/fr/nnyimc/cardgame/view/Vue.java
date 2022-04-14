package fr.nnyimc.cardgame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.nnyimc.cardgame.controller.JeuControleur;

public class Vue {
	JeuControleur jeuControleur;
	InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	
	public Vue() {
		parametrerControleur(jeuControleur);
	}
	
	public void parametrerControleur( JeuControleur jeuControleur) {
		this.jeuControleur = jeuControleur;
	}
	
	public void afficher() {}

	public void demanderNomJoueur() {
		displayOrder("Saisir le nom du joueur: ");
		activateKeyboardReader();
	}
	
	private void activateKeyboardReader() {
		String sample = null;
		try {
			sample = bufferedReader.readLine();
			if (sample.isEmpty()) {
				jeuControleur.demarrerPartie();
			} else {
				jeuControleur.ajouterJoueur(sample);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void displayOrder(String string) {
		System.out.println(string);
	}

	public void afficherNom(int size, String nomJoueur) {
		System.out.println(size + " " + nomJoueur);
		
	}
	
	public void afficherGagnant( String nomJoueur) {
		System.out.println("GAGNANT:" + nomJoueur);
		
	}

	public void afficherDosCarte(int i, String nom) {
		System.out.println(i + " " + nom);
		
	}
	
	public void afficherCarteJoueur(int i, String nomJoueur, String rang, String couleur) {
		System.out.println(i + " " + nomJoueur + " " + rang + " " + couleur);
	}

	public void demanderRetournement() {
		System.out.println("Appuyer sur ENTREE pour retourner les cartes");
		try {
			bufferedReader.readLine();
			jeuControleur.retournerCartes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void demanderNouvellePartie() {
		System.out.println("Appuyer sur ENTREE pour rejouer");
		try {
			bufferedReader.readLine();
			jeuControleur.lancerJeu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

