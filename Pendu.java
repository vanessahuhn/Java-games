package games;

import java.util.Scanner;

public class Pendu {
	
	public static Scanner inputWord;
	public static int notValid;
	private static String mysteryWord;
	public static int mysteryWordLength;
	private static char[] hiddenWord;
	
	public static String inputMysteryWord() {
		
		inputWord = new Scanner(System.in);		
		System.out.println("Veuillez entrer un mot à deviner :");
		
		
		/*while (!inputWord.hasNext()) {
			notValid = inputWord.nextInt();			
			System.out.println("Veuillez entrer un mot valide.");
			System.out.println("Veuillez entrer un mot à deviner :");
		}		*/
		
		String mysteryWord = inputWord.next();
		
		System.out.println("La partie commence.");
		return mysteryWord;
	}
	
	public static void gameState() {
		
		int mysteryWordLength = inputMysteryWord().length();
		for (int i=1; i<=mysteryWordLength; i++) {
			
			System.out.print("_ ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gameState();
	}

}
