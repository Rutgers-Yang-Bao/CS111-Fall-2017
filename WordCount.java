/*
Write your code in the file WordCount.java. Your code should go into a method with the following signature. You may write your own main method to test your code. The graders will ignore your main method:

public static int countWords(String original, int maxLength){}
 

Your method should count the number of words in the sentence that meet or are less than maxLength (in letters). For example, if the maxLength length given is 4, your program should only count words that are at most 4 letters long.

Words will be separated by one or more spaces. Non-letter characters (spaces, punctuation, digits, etc.) may be present, but should not count towards the length of words.

Hint: write a method that counts the number of letters (and ignores punctuation) in a string that holds a single word without spaces. In your countWords method, break the input string up into words and send each one to your method.
 */
public class WordCount {
	public static void main(String [] args) {


	}
	
	public static int countWords(String original, int maxLength){
		int count = 0;
		String [] arr=original.split(" ");
		for (int i=0;i<arr.length;i++) {
			int a = countChars(arr[i]);
			
			System.out.println(arr[i]);
			System.out.println(a);
			
			if (a>0 && a<=maxLength ) {
				count++;
			}
		}
		return count;
	}
	
	public static int countChars(String a){
		int length=a.length();
		for (int j=0;j<a.length();j++) {
			int term = a.substring(j,j+1).compareTo("a");
			if ((term<-32)||(term>-7&&term<0)||(term>25)) {
				length--;
				
			}
		}
		return length;
	}
	
}
