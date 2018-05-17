package 카드게임;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Card> cards;
	private int total = 0;

	public Player() {
		cards = new ArrayList<Card>();
	}

	public void drawCard(Card card) {
		total += card.getNum();
		this.cards.add(card);
	}
}
