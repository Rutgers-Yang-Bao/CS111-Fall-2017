/*Write your code in the file TwoLargest.java.

We wish to write a program that takes a set of numbers and determines which are the two largest.

Ask the user for the following information, in this order:

	1.A terminating value (real number). The user will enter this value again later, to indicate that he or she is finished providing input.
	2.A sequence of real numbers. Keep asking for numbers until the terminating value is entered.
Compute and output the largest and second-largest real number, in that order. It is possible for the largest and second-largest numbers to be the same (if the sequence contains duplicate numbers).
*/
public class TwoLargest{
    public static void main(String [] args){

	int counter = 0; 
	double term = IO.readDouble();
	counter++;

	double input = IO.readDouble();
	double s1, s2;
	if(input!=term){
	    s1 = input;
	    s2 = input;
	    counter++; 
	}
	else{ 
	    do{
		IO.reportBadInput();
		input = IO.readDouble();
		}
	    while(input==term);
	    s1 = input;
	    s2 = input;
	    counter++; 
	}

	input = IO.readDouble();
	
	if(input==term){
	    do{
		IO.reportBadInput();
		input = IO.readDouble();
	    }
	    while(input==term);
	    counter++; 
	}
	else
	    counter++; 

	if(input >= s1){
	    double temp = s1;
	    s1 = input;
	    s2 = temp;
	}
	else
		s2 = input;

	if(counter == 3){
	    input = IO.readDouble();
	    while(input != term){
		if(input >= s1){
		    double temp = s1;
		    s1 = input;
		    s2 = temp;
		}
		else{
		    if(input >= s2)
			s2 = input;
		}
		input = IO.readDouble();
	    }
	}

	else
	    System.out.println("FATAL ERROR");

	IO.outputDoubleAnswer(s1);
	IO.outputDoubleAnswer(s2);
	
    }
}
