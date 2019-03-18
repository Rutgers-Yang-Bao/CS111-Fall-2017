/*
 Write your code in the file PayFee.java. Use the IO module to read inputs and output answers.

You work for the a payment processing service called PayFee. PayFee charges money receivers the following fees


The first $500 has a flat fee of $10.
Payments over $500 (but under $5000) have a fee of 1% or $20, whichever is higher.
Payments $5,000 (but under $10,000)  and over have a fee of 2% or $120, whichever is higher.
Payments $10,000 and over are subject to fees as follows:

The first $10,000 have a fee of 2%
The next $5,000 have an additional fee of 3%
Anything more will demand an additional fee of 4%

For example, an payment of $40,000 would be subject to $1350 fee: 2% on the first $10,000 ($200 fee), 3% on the next $5,000 ($150 fee), and 4% on the last $25,000 ($1000 tax).

Ask the user for their payment amount (real number) and compute the amount of the fee that they owe (real number).
 */
public class PayFee {
	public static void main(String[]args) {
		double payment = IO.readDouble();
		double fee;
		fee = 0;
		
		if (payment>0 && payment <=500) {
			fee = 10.00;
		}
		else if (payment > 500 && payment < 5000) {
			if ((payment*0.01)>=20) {
			fee = payment*0.01;
			}
			else {
				fee = 20;
			}
		}
		else if (payment >= 5000 && payment < 10000) {
			if (payment*0.02>=120) {
				fee = payment*0.02;
			}
			else {
				fee = 120;
			}
		}
		if (payment >= 10000) {
			if (payment == 10000) {
				fee = 10000*0.02;
			}
			else if (payment <= 15000) {
				fee = 10000*0.02 + (payment-10000)*0.03;
			}
			else {
				fee = 10000*0.02 + 5000*0.03 + (payment-15000)*0.04;
			}
		}
		IO.outputDoubleAnswer(fee);	
	}

}
