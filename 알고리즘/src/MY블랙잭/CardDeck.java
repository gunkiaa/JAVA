package MY블랙잭;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	private String[] patternDefault = { "♠︎", "♣︎", "♥︎", "♦︎" };
	private List<String> card = new ArrayList<String>();
	private int drawNum = 0;

	public CardDeck() {
		shuffle();
	}

	private void shuffle() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= 12; j++) {
				if (j == 11) {
					card.add(patternDefault[i] + "K");
				} else if (j == 12) {
					card.add(patternDefault[i] + "Q");
				} else if (j == 13) {
					card.add(patternDefault[i] + "J");
				} else if (j == 1) {
					card.add(patternDefault[i] + "A");
				} else {
					card.add(patternDefault[i] + (j + 1));
				}
			}
		}
		Collections.shuffle(card);
	}

	public int draw() {
		int num = drawNum;
		drawNum++;
		System.out.print(card.get(num));
		return replace(num);
	}

	public int draw(int a) {
		int num = drawNum;
		drawNum++;
		return replace(num);
	}

	public int replace(int num) {
		String val = card.get(num).replaceAll("♠︎", "").replaceAll("♣︎", "").replaceAll("♥︎", "").replaceAll("♦︎", "");
		if (val.equals("K") || val.equals("Q") || val.equals("J")) {
			return 10;
		}
		if(val.equals("A")) {
			return 11;
		}
		return Integer.valueOf(val);
	}
}
