package 원카드;

import java.util.List;

public class Player {
	List<Card> myCard;

	public void setCard(Card card) {
		this.myCard.add(card);
	}

	public List<Card> getCard() {
		return this.myCard;
	}
}
