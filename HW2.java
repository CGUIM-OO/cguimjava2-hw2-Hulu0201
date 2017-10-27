import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here
 * B0344252 胡茹芳
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;  //private 才能避免牌被更動
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){   
		cards = new ArrayList<Card>();
		for(int i=0;i<nDeck ;i++){			//幾副牌
			for(int j=1;j<=4;j++){			//花色
				for(int k=1;k<=13;k++){		//大小
					//System.out.println(j+","+k);
					Card card = new Card(j,k);
					cards.add(card);		//將每一張牌放進ArrayList中
					//System.out.println(card); Wrong   //Card@7d4991ad
				}
			}
		}
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards,
		for(int i=0;i < cards.size();i++){
			Card printdeck = cards.get(i);
			printdeck.printCard();
			System.out.println(cards.size());
		}
	
		//TODO: please implement and reuse printCard method in Card class (5 points)
	
		
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){  //Constructor
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		String suit_s = "";
		String rank_s = "";
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		switch (suit){
		case 1: suit_s = "Clubs"; break;
		case 2: suit_s = "Diamonds"; break;
		case 3: suit_s = "Hearts"; break;
		case 4:	suit_s = "Spades"; break;
		}
		
		switch (rank){
		case 1: rank_s = "Ace"; break;
		case 2: rank_s = "2"; break;
		case 3: rank_s = "3"; break;
		case 4: rank_s = "4"; break;
		case 5: rank_s = "5"; break;
		case 6: rank_s = "6"; break;
		case 7: rank_s = "7"; break;
		case 8: rank_s = "8"; break;
		case 9:	rank_s = "9"; break;
		case 10: rank_s = "10"; break;
		case 11: rank_s = "J"; break;
		case 12: rank_s = "Q"; break;
		case 13: rank_s	= "K"; break;
		}	
		
		System.out.println(suit_s+","+rank_s);
		
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
