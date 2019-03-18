/*
In this milestone, you will create a Player class to model the behavior of a poker player. Each poker player must keep track of his/her hand, fund balance, and current bet. Implement the following methods in Player.java. We have provided you with a Player.java file to fill in.



The original Hand.java you were given had a bug in the removeCard() method. Please replace your removeCard(int position) in Hand.java method with the one that follows: 


public void removeCard(int position) {

	if (position < 0 || position >= hand.length)

		throw new IllegalArgumentException("Position does not exist in hand: " + position);

	hand[position] = null;

count--;

}	





The methods for Player.java are reproduced below for your convenience. Also for your convenience, a Driver will be released on Monday to help you test your code. (write your own program to test your code - it's good practice!)



The autograder will open on Wed of next week 12/6, and this milestone is due on Fri 12/8.





    //initialize your fields in the constructor

    public Player(double balance){

        

    }



    public void deal(Card c){

    

    }



    //Returns an array of Cards that the Player wishes to discard.

    //The game engine will call deal() on this player for each card

    //that exists in the return value. MS2 Instructions: Print the hand to

    //the terminal using System.out.println and ask the user which cards

    //they would like to discard. The user will first the number of cards they

    //wish to discard, followed by the indices, one at a time, of

    //the card(s) they would like to discard,

    //Return an array with the appropriate Card objects

    //that have been discarded, and remove the Card objects from this

    //player's hand. Use IO.readInt() for all inputs. In cases of error

    //re-ask the user for input.

    //

    // Example call to discard():

    //

    // This is your hand:

    // 0: Ace of Hearts

    // 1: 2 of Diamonds

    // 2: 5 of Hearts

    // 3: Jack of Spades

    // 4: Ace of Clubs

    // How many cards would you like to discard?

    // 2

    // 1

    // 2

    //

    // The resultant array will contain the 2 of Diamonds and the 5 of hearts in that order

    // This player's hand will now only have 3 cards

    public Card[] discard(){

    

    }



    //Returns the amount that this player would like to wager, returns

    //-1.0 to fold hand. Any non zero wager should immediately be deducted

    //from this player's balance. This player's balance can never be below

    // 0 at any time. This player's wager must be >= to the parameter min

    // MS2 Instructions: Show the user the minimum bet via the terminal

    //(System.out.println), and ask the user for their wager. Use

    //IO.readDouble() for input. In cases of error re-ask the user for

    //input.

    //

    // Example call to wager()

    //

    // How much do you want to wager?

    // 200

    //

    // This will result in this player's balance reduced by 200

    

    public double wager(double min){

        

    }



    //Returns this player's hand

    public Hand showHand(){

        

    }



    //Returns this player's current balance

    public double getBalance(){

        

    }



    //Increase player's balance by the amount specified in the parameter,

    //then reset player's hand in preparation for next round. Amount will

    //be 0 if player has lost hand

    public void winnings(double amount){

        

    }

 */

public class Player{

	//declare your fields here
	private double balance1;
	 Card[] player;
	
	
	//initialize your fields in the constructor
	public Player(double balance){
		balance1 = balance;
		player = new Card[5];
		
	}

	public void deal(Card c){
		for(int i=0 ; i<player.length; i++){ 
			if (player[i] == null){
				player[i] = c;
				break;
			}
		}
	
	}

	//Returns an array of Cards that the Player wishes to discard.
	//The game engine will call deal() on this player for each card
	//that exists in the return value. MS2 Instructions: Print the hand to
	//the terminal using System.out.println and ask the user which cards 
	//they would like to discard. The user will first the number of cards they
    //wish to discard, followed by the indices, one at a time, of
	//the card(s) they would like to discard, 
	//Return an array with the appropriate Card objects
	//that have been discarded, and remove the Card objects from this
	//player's hand. Use IO.readInt() for all inputs. In cases of error
	//re-ask the user for input.
	//
	// Example call to discard():
	//
	// This is your hand:
	// 0: Ace of Hearts
	// 1: 2 of Diamonds
	// 2: 5 of Hearts
	// 3: Jack of Spades
	// 4: Ace of Clubs
	// How many cards would you like to discard?
	// 2
	// 1
	// 2
	//
	// The resultant array will contain the 2 of Diamonds and the 5 of hearts in that order
	// This player's hand will now only have 3 cards
	public Card[] discard(){
		int num;
		Card [] discards;
		
		System.out.println("This is your hand: ");
		for (int i=0;i<player.length;i++) {
			System.out.println(i + ": " + player[i].toString());
		}
		System.out.println("How many cards would you like to discard?");
		num = IO.readInt();
		while (num<0||num>5) {
			System.out.println("Error input, please re-input: ");
			num = IO.readInt();
		}
		discards = new Card [num];
		for (int i=0;i<num;i++) {
			int index = IO.readInt();
			while (index<0||index>5) {
				System.out.println("Error input, please re-input: ");
				index = IO.readInt();
			}
			while(player[index]==null) {
				System.out.println("Error input, please re-input: ");
				index = IO.readInt();
			}
			discards[i]=player[index];
			player[index]=null;
		}
		
		return discards;
	}

	//Returns the amount that this player would like to wager, returns
	//-1.0 to fold hand. Any non zero wager should immediately be deducted
	//from this player's balance. This player's balance can never be below
	// 0 at any time. This player's wager must be >= to the parameter min
	// MS2 Instructions: Show the user the minimum bet via the terminal 
	//(System.out.println), and ask the user for their wager. Use
	//IO.readDouble() for input. In cases of error re-ask the user for 
	//input.
	// 
	// Example call to wager()
	//
	// How much do you want to wager?
	// 200
	//
	// This will result in this player's balance reduced by 200
	
	public double wager(double min){
		double bal =this.getBalance();
		double wager = 0;
		
		System.out.println("Now your balance is: " + bal);
		System.out.println("Your minimum bet is: " + min);
		System.out.println("How much do you want to wager?");
		wager = IO.readDouble();
		while((wager>bal||wager<min) && wager!=0) {
			System.out.println("Error input, please re-input: ");
			wager = IO.readDouble();
		}
		if(wager==0) {
			wager = -1.0;
			balance1 = bal;
		}else {
			balance1 = bal - wager;
		}
		return wager;
		
	}

	//Returns this player's hand
	public Hand showHand(){
		Hand handa = new Hand();
		for (int i=0;i<5;i++) {
			if (player[i]!=null) {
				handa.addCard(player[i]);
			}
		}
		
		return handa;
		
	}

	//Returns this player's current balance
	public double getBalance(){
		return balance1;
	}

	//Increase player's balance by the amount specified in the parameter,
	//then reset player's hand in preparation for next round. Amount will
	//be 0 if player has lost hand
	public void winnings(double amount){
		balance1 = balance1 +amount;
		for (int i=0;i<5;i++) {
			player[i]=null;
		}
	}

}