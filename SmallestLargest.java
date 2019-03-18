/*
Write a program called SmallestLargest.java which outputs the biggest and smallest numbers in a list of numbers entered by the user. 
Ask the user for a terminating value which should be entered again when they are done inputting the list of numbers. 
First output the smallest number and then the biggest number.
There must be at least 1 number in the list. 
YOU MUST USE THE IO MODULE FOR INPUT/OUTPUT. 
Report bad input via IO.reportBadInput() and exit on erro
 */
public class SmallestLargest {

	public static void main(String[] args) {
		double end =IO.readDouble();
		double a, small,large;
		
		a=IO.readDouble();
		if (a==end) {
			IO.reportBadInput();
		}
		else {
			small=a;
			large=a;
		while (a!=end){

			
			if (a>=large) {
				large=a;
			}
			
			if(a<=small) {
				small=a;
			}
			a=IO.readDouble();
		}
		
		if (small==end || large==end) {
			IO.reportBadInput();
		}
		else {
			IO.outputDoubleAnswer(small);
			IO.outputDoubleAnswer(large);
		}
		}
	}

}
