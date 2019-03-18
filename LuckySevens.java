/*Write your code in the file LuckySevens.java. Use the IO module for all inputs and outputs.

Sevens are considered lucky numbers. Your task is to count the number of sevens that appear within a range of numbers. Your solution should make use of looping constructs.

Ask the user for the following information, in this order:

The lower end of the range
The upper end of the range
Determine the number of sevens that appear in the sequence from lower end to upper end (inclusive).
Hint: Some numbers have more than 1 seven, and not every 7 appears in the ones place.
Hint2: Nested loops are helpful
*/
public class LuckySevens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int small, large,counter=0,number=0;
		small = IO.readInt();
		large = IO.readInt();
		
		if (large<small) {
		IO.reportBadInput(); 
		}	
		else {
		for (int i = small; i<=large;i++) {
			int term =i;
			
			do {
				counter++;
				term=term/10;
			}while (term/10>=1);
			int t=i;
			for (int j=0; j<=counter;j++) {
				if (t%10==7||t%10==-7) {

					number++;
				}
				t=t/10;
			}
			
		
			
		}
		
		IO.outputIntAnswer(number);

	}
	}
}
