/*
Write your code in the file Compress.java. Your code should go into a method with the following signature. You may write your own main method to test your code. The graders will ignore your main method:

public static String compress (String original){}
 

Run-length encoding (RLE) is a simple "compression algorithm" (an algorithm which takes a block of data and reduces its size, producing a block that contains the same information in less space). It works by replacing repetitive sequences of identical data items with short "tokens" that represent entire sequences. Applying RLE to a string involves finding sequences in the string where the same character repeats. Each such sequence should be replaced by a "token" consisting of:

	1.the number of characters in the sequence
	2.the repeating character
If a character does not repeat, it should be left alone.

For example, consider the following string:

qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT

After applying the RLE algorithm, this string is converted into:

q9w5e2rt5y4qw2Er3T

In the compressed string, "9w" represents a sequence of 9 consecutive lowercase "w" characters. "5e" represents 5 consecutive lowercase "e" characters, etc.

Write a method called compress that takes a string as input, compresses it using RLE, and returns the compressed string. Case matters - uppercase and lowercase characters should be considered distinct. You may assume that there are no digit characters in the input string. There are no other restrictions on the input - it may contain spaces or punctuation. There is no need to treat non-letter characters any differently from letters.


 */
public class Compress {
	
	public static void main(String [] args) {

	}

	
	public static String compress (String original){
		String result="";
		int count=0, term=0;
		String [] arr = new String [original.length()];
		
		for (int i=0;i<original.length();i++) {
			if (i!=original.length()-1) {
				if (original.charAt(i)!=original.charAt(i+1)) {
					arr[count]=original.substring(term, i+1);
					term =i+1;
					count++;
				}
			}else {
					arr[count]=original.substring(term);
				
			}
		}
		for (int j=0;j<arr.length;j++) {
			result+=transfer(arr[j]);
		}
		
		return result;
		
	}
	
	public static String transfer(String a) {
		if(a!=null) {
			int i = a.length();
			
			if (i>0) {
				if(i==1) {
					return a;
				}
				else {
					a=i+a.substring(0, 1);
					return a;
				}
			}
			else {
				return "";
			}
		}else {
			return "";
		}
		
	}
	
	}
	
	

