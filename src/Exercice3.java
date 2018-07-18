
import java.util.Scanner;

public class Exercice3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] tab = {'a', 'v', 'i', 'o', 'n'};
		String inputLetter;
		char inputChar = ' ';
		boolean gameOn = true;
		String playAgainLetter;
		char playAgainChar;
		
		while (gameOn == true) {
		
		Scanner getInput = new Scanner(System.in);
		System.out.println("Tapez une lettre :");
		inputLetter = getInput.next();
		inputLetter = inputLetter.toLowerCase();
		inputChar = inputLetter.charAt(0);

		if (inputChar == tab[0] || inputChar == tab[4]) {
			System.out.println("Vous avez gagné.");
			Scanner playAgain = new Scanner(System.in);
			System.out.println("Voulez-vous rejouer ? (Y/N) ");
			playAgainLetter = playAgain.next();
			playAgainLetter = playAgainLetter.toUpperCase();
			playAgainChar = playAgainLetter.charAt(0);
			
			while (playAgainChar != 'N' && playAgainChar != 'Y') {
								
				System.out.println("Veuillez entrer Y ou N.");
				playAgainLetter = playAgain.next();
				playAgainChar = playAgainLetter.charAt(0);
			}
			
			if (playAgainChar == 'N') {
				
				gameOn = false;
			}
			else {
				System.out.println("Une nouvelle partie commence.");
			}
			}
		else {
			System.out.println("Vous avez perdu.");
		}
			
	}
}
}