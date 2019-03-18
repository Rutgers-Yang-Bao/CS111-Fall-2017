/*Write your code in a file called Multiply.java. Use the IO module to read inputs and output answers.

Ask for 2 numbers (integers) from the user. Print out the result of multiplying the two numbers.
*/
public class Multiply {
	public static void main (String[]args) {
		int a =IO.readInt(),
			b= IO.readInt();
		int c=a*b;
		
		IO.outputIntAnswer(c);
	}
}
