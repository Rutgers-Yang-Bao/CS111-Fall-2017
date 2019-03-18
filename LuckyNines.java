/*
Write your code in the file LuckyNines.java. Use the IO module for all inputs and outputs.

Your task is to write a method called

public static int countLuckyNines(int lowerEnd, int upperEnd) 
which counts and returns the number of nines that appear within a range of numbers. Your solution should make use of looping constructs.
In main method, ask the user for the following information, in this order:

The lower end of the range
The upper end of the range
Then call countLuckyNines(lowerEnd, upperEnd) with the user input values; countLuckyNines(lowerEnd, upperEnd) returns the number of nines that appear in the sequence from lower end to upper end (inclusive).
Hint: Some numbers have more than 1 nine, and not every 9 appears in the ones place.
Hint2: Nested loops are helpful

On error (i.e. upper end is less than lower end) countLuckyNines returns -1.
 */
public class LuckyNines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int low=IO.readInt();
		int large=IO.readInt();
		int a = countLuckyNines(low,large);
		IO.outputIntAnswer(a);
		
	}
	
	public static int countLuckyNines(int lowerEnd, int upperEnd) {
		
		int counter =0,number =0;
		if (upperEnd<lowerEnd) {
		return -1; 
		}	
		else {
		for (int i = lowerEnd; i<=upperEnd;i++) {
			int term =i;
			
			do {
				counter++;
				term=term/10;
			}while (term/10>=1);
			int t=i;
			for (int j=0; j<=counter;j++) {
				if (t%10==9||t%10==-9) {

					number++;
				}
				t=t/10;
			}
			
		
			
		}
		return number;
	}
	}

}
