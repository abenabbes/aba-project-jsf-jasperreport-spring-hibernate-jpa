package aba.perso.couche.utils;

public interface ConstantesUtils {

	// Constantes des requêtes
	
		/** Req de recherche d'une liste de joueur*/
		String REQ_RECHERCHE_LISTE_JOUEUR = "rechercherListeJoueurs";
		
		/** Req de recherche d'une liste d'equipe*/
		String REQ_RECHERCHE_LISTE_EQUIPE = "rechercherListeEquipe";
		
		/** Req de recherche de l'equipe d'un joueur*/
		String REQ_RECHERCHER_EQUIPE_DU_JOUEUR = "rechercherEquipeDunJoueurParNom";
		
		/** Req de recherche de tous les joueurs l'equipe*/
		String REQ_RECHERCHE_TOUS_JOUEUR_DUNE_EQUIPE = "rechercherTousLesJoueurDuneEquipe";
		
		/** Req de recherche d'une liste des club*/
		String REQ_RECHERCHE_LISTE_CLUB = "rechercherListeClub";
		
		//Paramétres des requêtes
		/** Nom d'un joueur*/
		String NOM_JOUEUR = "nom";
		
		/** Nom d'un joueur*/
		String NOM_EQUIPE = "nom";
}
