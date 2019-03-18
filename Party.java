/*Write your code in the file Party.java. Use the IO module to read inputs and output answers.Suppose that you are responsible for buying pizza and soda for your employer's annual company party. You must buy entire pizza pies and cases of soda (boxes of soda cans). You cannot buy individual slices of pizza or cans of soda, nor can you buy fractional numbers of pizza pies or soda cases.

Ask the user for the following information, in this order:

the number of people attending the party
the number of slices of pizza each person should be able to eat
the number of cans of soda each person should be able to drink
the cost of a pizza pie
the number of slices in a pizza pie
the cost of a case of soda
the number of cans in a case of soda
Compute the total cost of the pizza and soda you will need to buy. Do not buy more than you need to in order to supply each partygoer with the desired number of pizza slices and soda cans.

For this problem only, you may assume that the user will only enter positive numbers (you do not need to check for this).
*/

public class Party {
	public static void main (String[]args) {
		int numPeople=IO.readInt();//the number of people attending the party
		int numPizzaPer=IO.readInt();//the number of slices of pizza each person should be able to eat
		int numSodaPer=IO.readInt();//the number of cans of soda each person should be able to drink
		double costPizzaPer=IO.readDouble();//the cost of a pizza pie
		int numPizzaSlice=IO.readInt();//the number of slices in a pizza pie
		double costSodaPer=IO.readDouble();//the cost of a case of soda
		int numSodaCan=IO.readInt();//the number of cans in a case of soda
		
		double a,b,c,d,x,y;
		a = ((double)numPeople) * numPizzaPer/numPizzaSlice;
		b = ((double)numPeople) * numSodaPer/numSodaCan;
		
		if (a%1==0) {
			x = (int)a;
		}
		else {
			x = (int)a + 1;
		}
		
		if (b%1==0) {
			y = (int)b;
		}
		else {
			y=(int)b+1;
		}
		c = x * costPizzaPer;
		d = y * costSodaPer;
		IO.outputDoubleAnswer(c+d);
		
	}
}
