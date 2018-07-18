package games;

import java.util.Scanner;

public class Pendu_simple {
	
	public static String mysteryWord; //mot à trouver
	public static String underscore = "_ "; //permet de créer le mot caché
	public static String hiddenWord = ""; //permet de stocker le mot caché
	
	public static int remainingTries = 10; //nombre d'essais au départ
	public static int points = 500;//nombre de points max
	public static int score = 0;//score du joueur
	
	public static Scanner inputMysteryWord;
	public static Scanner inputLetter;//permet d'entrer une lettre
	public static String userLetter;//lettre entrée
	public static char userChar;//lettre entrée type char
	public static int wordLength;//longueur du mot
	public static int hiddenWordLength;//longueur du mot caché
	
	public static int i;//itérateur pour remplacer underscore par la lettre
	public static int position = 0;//position charAt
	public static Scanner inputSolution;//permet d'entrer une solution
	public static String solution;//solution proposée
	
	public static void inputMysteryWord() {//permet à l'utilisateur d'entrer le mot mystère de son choix
		
		inputMysteryWord = new Scanner(System.in);
		System.out.println("Tapez un mot mystère :");
		mysteryWord = inputMysteryWord.next();
		
	}
	
	public static void displayInfos() {//affiche les infos essais restants et score possible
		
		System.out.println("Il vous reste " + remainingTries + " essais.");
		System.out.println("Vous pouvez marquer " + points + " points.");
		
	}
	
	public static void displayScore() {//affiche le score
		
		System.out.println("Votre score est de " + score + " points.");
		
	}
	
	public static String createHiddenWord() {//permet de cacher le mot mystère sous forme d'underscores
		
		wordLength = mysteryWord.length();
		
		for (hiddenWordLength = 0; hiddenWordLength < wordLength; hiddenWordLength++){
			
			hiddenWord = hiddenWord + underscore;		
		}

		System.out.println(hiddenWord);
		return hiddenWord;
				
	}
	
	public static String replaceCharAt(String s, int pos, char c) {//remplacer les underscores par les lettres
		
		   return s.substring(0,pos) + c + s.substring(pos+1);
		}
	
	public static String inputLetter(String hiddenWord) throws InterruptedException {
				
		for (remainingTries = 9; remainingTries >= 0; remainingTries--) {//permet 10 essais
			
			inputLetter = new Scanner(System.in);//permet d'entrer une lettre
			System.out.println("Tapez une lettre :");
			userLetter = inputLetter.next();
			
			while(!userLetter.matches("[a-z]{1}")) {//vérifie que l'utilisateur n'entre qu'une seule lettre en minuscule
				
				inputLetter = new Scanner(System.in);
				System.out.println("Tapez une lettre valide :");
				userLetter = inputLetter.next();
			}
			
			userChar = userLetter.charAt(0);//transforme l'input string en char
			
			if (mysteryWord.contains(userLetter)) {
				
				System.out.println("Cette lettre fait partie du mot mystère.");
				
				for (i = 0; i < wordLength; i++) {
					
					if (userChar == mysteryWord.charAt(i)) {//si la lettre entrée correspond à une lettre du mot mystère, elle remplace un underscore du mot caché
						
						position = (2 * i);
						hiddenWord = replaceCharAt(hiddenWord, position, userChar);
												
					}				
				}
				
				if (!hiddenWord.contains("_")) {//si toutes les lettres sont trouvées, la partie est gagnée
					
					System.out.println(hiddenWord);
					System.out.println("Vous avez gagné!");
					score += points;
					System.out.println("Votre score est de " + score + " points.");
					System.exit(0);
					
				}
				
			
				System.out.println(hiddenWord);
				Thread.sleep(2000);
				inputSolution(mysteryWord);
			}
			
			else {
					
				System.out.println("Cette lettre ne fait pas partie du mot mystère.");
										
			}
			
			System.out.println(hiddenWord);
			points -= 10;
			displayInfos();
				
			}
			
		System.out.println(hiddenWord);
		System.out.println("Vous avez perdu.");
		return hiddenWord;
				
	}
	
	public static void inputSolution(String mysteryWord) {//permet à l'utilisateur d'entrer une solution
		
		inputSolution = new Scanner(System.in);
		System.out.println("Entrez une solution :");
		solution = inputSolution.next();
		
		if (solution.equals(mysteryWord)) {// si la solution est correcte, le joueur a gagné et le jeu est terminé
			
			System.out.println("Vous avez gagné!");
			score += points;
			System.out.println("Votre score est de " + score + " points.");
			System.exit(0);
		}
		
		else {
			
			System.out.println("Ce n'est pas le mot mystère, la partie continue.");
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		inputMysteryWord();
		displayScore();
		displayInfos();
		Thread.sleep(2000);
		String hiddenWord = createHiddenWord();
		inputLetter(hiddenWord);

	}
}
