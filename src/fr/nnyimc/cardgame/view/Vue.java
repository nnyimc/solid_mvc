package fr.nnyimc.cardgame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.nnyimc.cardgame.controller.JeuControleur;

public class Vue implements Visible {
	JeuControleur jeuControleur;
	InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	
	public Vue() {
		parametrerControleur(jeuControleur);
	}
	
	@Override
	public void parametrerControleur( JeuControleur jeuControleur) {
		this.jeuControleur = jeuControleur;
	}
    
	@Override
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

	@Override
	public void afficherNom(int size, String nomJoueur) {
		System.out.println(size + " " + nomJoueur);
		
	}
	
	@Override
	public void afficherGagnant( String nomJoueur) {
		System.out.println("GAGNANT:" + nomJoueur);
		
	}

	@Override
	public void afficherDosCarte(int i, String nom) {
		System.out.println(i + " " + nom);
		
	}
	
	@Override
	public void afficherCarteJoueur(int i, String nomJoueur, String rang, String couleur) {
		System.out.println(i + " " + nomJoueur + " " + rang + " " + couleur);
	}

	@Override
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

	@Override
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
	
	public void quitter() {
		System.out.println("Saisir +Q pour quitter");
		try {
			jeuControleur.choisirAction(bufferedReader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

