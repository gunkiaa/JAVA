package 원카드;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	String[] pattern = { "♠", "♣", "♥", "◈" };
	int cardNum = 13;
	int drawNum = 0;
	List<Card> deck;

	public CardDeck() {
		deck = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				Card card = new Card();
				card.setPattern(pattern[i]);
				card.setNum(j + 1);
				deck.add(card);
			}
			System.out.println("");
		}

	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card drawCard() {
		int draw = drawNum;
		drawNum++;
		return deck.get(draw);
	}
}
