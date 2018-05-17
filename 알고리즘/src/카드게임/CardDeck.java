package 카드게임;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	private final String[] PATTERN = { "♠", "◈", "♥", "♣" };
	private final int CARD_NUM = 10;
	private List<Card> cards;
	private int drawCnt = 0;

	public CardDeck() {
		cards = new ArrayList<Card>();
		for (String pa : PATTERN) {
			for (int i = 0; i < CARD_NUM; i++) {
				Card card = new Card();
				card.setPattern(pa);
				card.setNum(i + 1);
				System.out.print(card.getPattern()+card.getNum()+" ");
				cards.add(card);
			}
			System.out.println();
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card drawCard() {
		int cnt = drawCnt;
		drawCnt += 1;
		return cards.get(cnt);
	}
}
