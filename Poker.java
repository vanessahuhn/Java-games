package games;

import java.util.Scanner;

public class Poker {
	
	public static int nbPlayers;
	public static int nbCardsBoard;
	public static int nbCardsPlayers = 0;
	
	public static Scanner sc;
	public static String notValid;
	
	public static int setPlayers() {
		
		sc = new Scanner(System.in);		
		System.out.println("Veuillez entrer le nombre de joueurs :");
		
		while (!sc.hasNextInt()) {
			notValid = sc.nextLine();			
			System.out.println("Veuillez entrer un nombre valide.");
			System.out.println("Veuillez entrer le nombre de joueurs :");
		}		
		
		nbPlayers = sc.nextInt();
		
		while (nbPlayers < 2 || nbPlayers > 10) {
				System.out.println("Veuillez entrer un nombre entre 2 et 10.");
				System.out.println("Veuillez entrer le nombre de joueurs :");
				nbPlayers = sc.nextInt();
			}
		
		System.out.println("La partie commence avec " + nbPlayers + " joueurs.");
		return nbPlayers;
	}
	
	public static void shuffle() {
		System.out.println("Les cartes sont mélangées.");
	}
	
	public static void playersDeal() {
		
		while (nbCardsPlayers < 2) {
			nbCardsPlayers ++;
			if (nbCardsPlayers == 1) {
				System.out.println( nbCardsPlayers + " carte distribuée.");
			}
			else {
				System.out.println( nbCardsPlayers + " cartes distribuées.");
			}
		}
	}
	
	public static void burn() {
		System.out.println("Une carte a été brûlée.");
	}
	
	public static void boardDeal(int nbCards, String dealName) {
		nbCardsBoard += nbCards;
		
		if (dealName == "Flop") {
			System.out.println(dealName + " : " + nbCards + " carte ont été retournées.\n" + nbCardsBoard + " cartes sont au centre.");
		}
		else{
			System.out.println(dealName + " : " + nbCards + " carte a été retournée.\n" + nbCardsBoard + " cartes sont au centre.");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		setPlayers();
		Thread.sleep(2000);
		shuffle();
		Thread.sleep(2000);
		playersDeal();
		Thread.sleep(2000);
		burn();
		Thread.sleep(2000);
		boardDeal(3, "Flop");
		Thread.sleep(2000);
		burn();
		Thread.sleep(2000);
		boardDeal(1, "Turn");
		Thread.sleep(2000);
		burn();
		Thread.sleep(2000);
		boardDeal(1, "River");
	}

}
