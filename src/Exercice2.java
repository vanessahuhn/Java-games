
import java.util.Scanner;

public class Exercice2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] tab = {'a', 'v', 'i', 'o', 'n'};
		String inputLetter;
		char inputChar;
		
		Scanner getInput = new Scanner(System.in);
		System.out.println("Tapez une lettre :");
		inputLetter = getInput.next();
		inputChar = inputLetter.charAt(0);
		
		
		if (inputChar == tab[0] || inputChar == tab[4]) {
				System.out.println("Vous avez gagné.");
			}
			else {
				System.out.println("Vous avez perdu.");
			}
		}
	}
