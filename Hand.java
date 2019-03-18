/*
In this project you will be using the knowledge you gained from lectures and homeworks and applying them to a lengthier programming assignment. The answers to some of your questions do not strictly reside in this document. You are encouraged to look at other sources for inspiration. This semester¡¯s project will involve the the game of poker. This is an individual project, and as such you will be held to the University¡¯s academic integrity policies. You are welcome to discuss strategies and ideas with other students (and will be encouraged to in recitation), but you must code the project on your own.

 

This project is what you make of it. Listed below are point guidelines as to how they relate to the number of points given to the project (total 100). However, you should not be limited by what we suggest the minimum work required here is. To get the most out of this project, I urge you all to push yourselves to find your limits. You might surprise yourself! Good luck!

 

Milestone 1 

In your textbook reading on object oriented programming, you have come across examples of how to represent playing cards in code. You have also seen how decks and hands of cards are represented in code. Please take a moment or two to review the code and the descriptions of the code. Before continuing, you MUST understand the code that is already written. We have attached simplified versions of that source code to this project for your convenience. Refer to the following textbook chapters for further explanation.



Textbook description: http://math.hws.edu/eck/cs124/javanotes6/c5/s4.html

The hand attached is a modified version of the textbook version. This one is wholly understandable to the CS111 student, using arrays instead of arraylists. Use the attached version for your extensions.



Next, review the Wikipedia page on poker hands: https://en.wikipedia.org/wiki/List_of_poker_hands





Finally, implement the following new instance methods inside Hand.java.

//Returns the number of pairs this hand contains

public int numPairs()



//Returns true if this hand has 3 cards that are of the same value

public boolean hasTriplet()

 

//Returns true if this hand has all cards that are of the same suit

public boolean hasFlush()



//Returns true if this hand has 5 consecutive cards of any suit

public boolean hasStraight()

 

//Returns true if this hand has a triplet and a pair of different //values

public boolean hasFullHouse()

 

//Returns true if this hand has 4 cards that are of the same value

public boolean hasFourOfAKind()

 

//Returns the card with the highest value in the hand. When there is

//more than one highest value card, you may return any one of them

public Card highestValue() 

 

//Returns the highest valued Card of any pair or triplet found, null if

// none. When values are equal, you may return either

public Card highestDuplicate()

 

//Returns -1 if the instance hand loses to the parameter hand, 0 if //the hands are equal, and +1 if the instance hand wins over the //parameter hand. Hint: you might want to use some of the methods //above

public int compareTo(Hand h) 
 */










/**
 * An object of type Hand represents a hand of cards.  The
 * cards belong to the class Card.  A hand is empty when it
 * is created, and any number of cards can be added to it.
 */

import java.util.ArrayList;

public class Hand {

   private Card[] hand;   // The cards in the hand.
   private int count; 
   
   /**
    * Create a hand that is initially empty.
    */
   public Hand() {
      hand = new Card[5];
	  count = 0;
   }
   
   /**
    * Remove all cards from the hand, leaving it empty.
    */
   public void clear() {
      for(int i=0 ; i<hand.length; i++){ hand[i] = null; }
	  count = 0;
   }
   
   /**
    * Add a card to the hand.  It is added at the end of the current hand.
    * @param c the non-null card to be added.
    * @throws NullPointerException if the parameter c is null.
    */
   public void addCard(Card c) {
      
	  for(int i=0 ; i<hand.length; i++){ 
		if (hand[i] == null){
			hand[i] = c;
			count = count + 1;
			break;
		}
	 }

	  
   }
   
   /**
    * Remove a card from the hand, if present.
    * @param c the card to be removed.  If c is null or if the card is not in 
    * the hand, then nothing is done.
    */
   public void removeCard(Card c) {

	for(int i=0 ; i<hand.length; i++){ 
		if (hand[i].equals(c)){
			hand[i] = null;
			count = count-1;
		}
	}

   }
   
   /**
    * Remove the card in a specified position from the hand.
    * @param position the position of the card that is to be removed, where
    * positions are starting from zero.
    * @throws IllegalArgumentException if the position does not exist in
    * the hand, that is if the position is less than 0 or greater than
    * or equal to the number of cards in the hand.
    */
   public void removeCard(int position) {
      if (position < 0 || position >= hand.length)
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
      hand[position] = null;
   }

   /**
    * Returns the number of cards in the hand.
    */
   public int getCardCount() {
      return count;
   }
   
   /**
    * Gets the card in a specified position in the hand.  (Note that this card
    * is not removed from the hand!)
    * @param position the position of the card that is to be returned
    * @throws IllegalArgumentException if position does not exist in the hand
    */
   public Card getCard(int position) {
      if (position < 0 || position >= hand.length)
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
       return hand[position];
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same suit are
    * grouped together, and within a suit the cards are sorted by value.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortBySuit() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;
	  
      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
		 
         for (int i = nonnull+1; i < hand.length; i++) {
            Card c1 = hand[i];
			if (c1 != null){
				if ( c1.getSuit() < c.getSuit() ||
						(c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same value are
    * grouped together.  Cards with the same value are sorted by suit.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortByValue() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;
	  
      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
		 
         for (int i = nonnull+1; i < hand.length; i++) {
            
			Card c1 = hand[i];
            if (c1 != null){
				if ( c1.getValue() < c.getValue() ||
						(c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }
   
   public void printHand(){
	   
	   for(int i=0; i<hand.length; i++){
		   if (hand[i] != null){
			   System.out.println(hand[i]);
		   }
	   }
	   System.out.println();
   }
   

   /******************************** Implement your methods here ****************************************/
   //Returns the number of pairs this hand contains
   public int numPairs() {
	   int num = 0;
	   int [] arr = transToValue();
	   
	   if(count==2) {
		   if (arr[0]==arr[1]) {
			   num++;
		   }
	   }else if (count >2) {
		   for (int i =0;i<arr.length-1;i++) {
			   if(arr[i]==arr[i+1]) {
				   num++;
				   i++;
			   }
		   }
	   }
	   
	   return num;
	   
   }

   //Returns true if this hand has 3 cards that are of the same value
   public boolean hasTriplet() {
	   boolean check = false;
	   int [] arr = transToValue();
	   
	   if(count>3) {
		   for (int i =1; i<arr.length-1;i++) {
			   if(arr[i-1]==arr[i] && arr[i]==arr[i+1]) {
				   check = true;
			   }
		   }
	   }
	   
	   return check;
   }
    
   //Returns true if this hand has all cards that are of the same suit
   public boolean hasFlush() {
	   boolean check = true;
	   sortBySuit();
	   
	   for (int i=0;i<count-1;i++) {
		   if(hand[i].getSuit()!=hand[i+1].getSuit()) {
			   check = false;
		   }
	   }

	   return check;
   }

   //Returns true if this hand has 5 consecutive cards of any suit
   public boolean hasStraight() {
	   boolean check = true;
	   int [] arr = transToValue();
	   
	   if(count==5) {
		   if (arr[0]!=1) {
			   for (int i=0;i<arr.length-1;i++) {
				   if (arr[i]!=arr[i+1]-1) {
					   check = false;
				   }
			   }
		   }else {
			   if((arr[0]==1 && arr[1]==2 && arr[2]==3 && arr[3]==4 && arr[4]==5) ||
					   (arr[0]==1 && arr[1]==10 && arr[2]==11 && arr[3]==12 && arr[4]==13)) {
				   check = true;
			   }else {
				   check = false;
			   }
		   }
	   }else {
		   check = false;
	   }

	   return check;
	   
   }
    
   //Returns true if this hand has a triplet and a pair of different //values
   public boolean hasFullHouse() {
	   int [] arr = rewrite(this.transToValue());
	   
	   return (arr[0]==arr[1] && arr[1]==arr[2]) && (arr[3]==arr[4])||
			   (arr[0]==arr[1]) && (arr[3]==arr[2] && arr[3]==arr[4]);
   }
    
   //Returns true if this hand has 4 cards that are of the same value
   public boolean hasFourOfAKind() {
	   boolean check = false;
	   int [] arr = transToValue();
	   
	   if (arr.length==4) {
		   check = (arr[0]==arr[1]) && (arr[1]==arr[2]) && (arr[2]==arr[3]);
	   }else if (arr.length==5) {
		   check = ((arr[0]==arr[1]) && (arr[1]==arr[2]) && (arr[2]==arr[3])) ||
				   ((arr[3]==arr[4]) && (arr[1]==arr[2]) && (arr[2]==arr[3]));
	   }
	   
	   return check;
   }
    
   //Returns the card with the highest value in the hand. When there is
   //more than one highest value card, you may return any one of them
   public Card highestValue() {
	   int [] arr = transToValue();
	   arr = rewrite(arr);
	   Card c= null;
	   
	   if(arr[4]==14) {
		   c = hand[0];
	   }else {
		   c = hand[4];
	   }
	   
	   return c;
   }
    
   //Returns the highest valued Card of any pair or triplet found, null if
   // none. When values are equal, you may return either
   public Card highestDuplicate() {
	   int [] arr = transToValue();
	   int index = 0;
	   boolean check = false;
	   
	   if(arr[0]==arr[1] && arr[0]==1) {
		   index = 0;
		   check = true;
	   }
	   else {
		   for (int i=arr.length-1;i>0;i--) {
			   if (!check) {
				   for (int j=0;j<i;j++) {
					   if(arr[i]==arr[j]) {
						   index = i;
						   check = true;
						   break;
					   }
				   }
			   }
		   }
	   }
	   
	   if(check==true) {
		   return hand[index];
	   }
	   else {
		   return null;
	   }
   }
    
   //Returns -1 if the instance hand loses to the parameter hand, 0 if 
   //the hands are equal, and +1 if the instance hand wins over the 
   //parameter hand. Hint: you might want to use some of the methods 
   //above
   public int compareTo(Hand h) {
	   int i = this.rank();
	   int j = h.rank();
	   int result = 0;
	   int duA;
	   int duB;
	   int [] a = rewrite(this.transToValue());
	   int [] b = rewrite(h.transToValue());	   
	   
	   if(this.highestDuplicate()==null) {
		   duA = 0;
	   }else {
		   if (this.highestDuplicate().getValue()==1) {
			   duA = 14;
		   }else {
		   duA = this.highestDuplicate().getValue();
		   }
	   }
	   
	   if(h.highestDuplicate()==null) {
		   duB = 0;
	   }else {
		   if(h.highestDuplicate().getValue()==1) {
			   duB = 14;
		   }else {
		   duB = h.highestDuplicate().getValue();
		   }
	   }
	   
	   if(i>j) {
		   result = 1;
	   }else if (i<j) {
		   result = -1;
	   }else if (i==j) {
		   if (i==7||i==3||i==1) {				// rank 7, rank 3 and rank 1
			   if(duA>duB) {
				   result = 1;
			   }else if (duA<duB) {
				   result = -1;
			   }
			   else {
				   if(i==1) {
					   if (a[4]>b[4]) {
						   result = 1;
					   }else if (a[4]<b[4]) {
						   result = -1;
					   }
				   }
			   } 
		   }else if (i==6) {					//rank 6
			   if (a[2]>b[2]) {
				   result = 1;
			   }else if (a[2]<b[2]){
				   result = -1;
			   }
		   }else if (i==5||i==0) {				//rank 5 and rank 0
			   result = check(a,b);
			   
		   }else if (i==8||i==4) {				//rank 8 and rank 4
			   if (a[4]==14 && b[4]!=14) {
				   if (a[3]<b[4]) {
					   result = -1;
				   }else if (a[3]>b[4]) {
					   result = 1;
				   }
			   }else if (b[4]==14 && a[4]!=14) {
				   if (b[3]>a[4]) {
					   result = 1;
				   }else if (b[3]<a[4]){
					   result = -1;
				   }
			   }else {
				   if (a[4]>b[4]) {
					   result = 1;
				   }else if (a[4]<b[4]) {
					   result = -1;
				   }
			   }
		   }else if (i==2) {
			   if(a[3]>b[3]) {
				   result = 1;
			   }else if (a[3]<b[3]) {
				   result = -1;
			   }else {
				   if (a[1]>b[1]) {
					   result = 1;
				   }else if (a[1]<b[1]) {
					   result = -1;
				   }else {
					   if (a[4]>b[4]) {
						   result =1;
					   }else if (a[4]<b[4]) {
						   result = -1;
					   }else {
						   if (a[2]>b[2]) {
							   result = 1;
						   }else if (a[2]<b[2]) {
							   result = -1;
						   }else {
							   if (a[0]>b[0]) {
								   result = 1;
							   }else if (a[0]<b[0]) {
								   result = -1;
							   }
						   }
					   }
				   }
			   }
		   }
		   
	   }
	   
	   return result;
   }
   
   public int[] transToValue() {
	   int [] arr = new int [count];
	   int index=0;
	   
	   sortByValue();
	   
	  for (int i=0; i<count;i++ ) {
			  arr[index] = hand[i].getValue();
			  index ++;
	  }
	  
	  return arr;
   }

   public int rank() {
	   int rank = 0;
	   int num = this.numPairs();
	   boolean tri = this.hasTriplet();
	   boolean flush = this.hasFlush();
	   boolean full = this.hasFullHouse();
	   boolean str = this.hasStraight();
	   boolean four = this.hasFourOfAKind();
	   
	   if (flush && str) {
		   rank = 8;
	   }else {
		   if (four) {
			   rank = 7;
		   }else {
			   if (full) {
				   rank = 6;
			   }else {
				   if (flush){
					   rank = 5;
				   }else {
					   if (str) {
						   rank = 4; 
					   }else {
						   if (tri) {
							   rank = 3;
						   }else {
							   if (num==2) {
								   rank = 2;
							   }else {
								   if (num==1) {
									   rank = 1;
								   }else {
									   rank = 0;
								   }
							   }
						   }
					   }
				   }
			   }
		   }
	   }
	   
	   return rank;
   }
  
   
   public int[] rewrite(int [] arr) {
	   
	   while (arr[0]==1) {
		   arr[0]=arr[1];
		   arr[1]=arr[2];
		   arr[2]=arr[3];
		   arr[3]=arr[4];
		   arr[4]=14;
	   }
	   return arr;
   }
   
   public int check(int [] a,int [] b) {
	   int check = 0;
	   for (int i =a.length-1;i>=0;i--) {
		   if(a[i]>b[i]) {
			   check = 1;
			   break;
		   }
		   else if (a[i]<b[i]) {
			   check = -1;
			   break;
		   }
	   }
	   return check;
   }
   
}