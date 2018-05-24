package 원카드;

import java.util.ArrayList;
import java.util.List;

public class Player {
	List<Card> myCard;

	public Player() {
		myCard = new ArrayList<Card>();
	}
	
	public void setCard(Card card) {
		this.myCard.add(card);
	}

	public List<Card> getCard() {
		return this.myCard;
	}
}
