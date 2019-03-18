/*
Write your code in the file PigLatin.java. Your code should go into a method with the following signature. You may write your own main method to test your code. The graders will ignore your main method:

public static String translate (String original){}

"Pig Latin" is a fake language used as a children's game. A word in English is "translated" into Pig Latin using the following rules:

If the English word begins with a consonant, move the consonant to the end of the word and add "ai". The letter Y should be considered a consonant.
If the English word begins with a vowel (A, E, I, O, or U), simply add "vai" to the end of the word.
(This is a simplified dialect of Pig Latin, of course.)

Write your method so that it returns the pig latin translated original string. You may assume that the input does not contain digits, punctuation, or spaces. The input may be in any combination of uppercase or lowercase. The case of your output does not matter.
 */
public class PigLatin {

	public static String translate (String original){
		String a;
		char b =original.charAt(0);
		if (b=='a'||b=='A'||b=='E'||b=='e'||b=='i'||b=='I'||b=='o'||b=='O'||b=='u'||b=='U') {
			a=original +"vai";
		}else {
			
			a=original.substring(1) +b+ "ai";
		}
		return a;
	}
	public static void main (String [] args) {
	
		
	}

}
