package MY블랙잭;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	protected static String[] patternDefault = { "♠", "♣", "♥", "◈" };
	private List<String> card = new ArrayList<String>();
	private int drawNum = 0;

	public CardDeck() {
		shuffle();
	}

	private void shuffle() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= 12; j++) {
				j++;
				if (j == 11) {
					card.add(patternDefault[i] + "K");
				} else if (j == 12) {
					card.add(patternDefault[i] + "Q");
				} else if (j == 13) {
					card.add(patternDefault[i] + "J");
				} else if (j == 1) {
					card.add(patternDefault[i] + "A");
				} else {
					card.add(patternDefault[i] + (j));
				}
			}
		}
		Collections.shuffle(card);
	}

	public String draw() {
		int num = drawNum;
		drawNum++;
		return card.get(num);
	}
}
