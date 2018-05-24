package 원카드;

import java.util.List;

import 원카드.Card;
import 원카드.CardDeck;
import 원카드.Player;

public class GamePlay {
	private CardDeck deck;
	private Card openCard;
	private Player player;
	private Player enemy;
	private final int defaultCard = 5;

	public GamePlay() {
		player = new Player();
		enemy = new Player();
		System.out.println("드륵!드륵! 카드가 섞였습니다!");
		deck = new CardDeck();
		deck.shuffle();
		openCard = deck.drawCard();
		System.out.println("오픈된 카드:" + openCard.getPattern() + openCard.getNum());
	}

	public void start() {
		defaultCard();
		List<Card> card = player.getCard();
		System.out.println("내가 가진 카드");
		for (int i = 0; i < player.getCard().size(); i++) {
			System.out.print(card.get(i).getPattern() + card.get(i).getNum());
			System.out.print(",");
		}
		
	}

	private void defaultCard() {
		boolean isTurn = true;
		int i = 0;
		while (i < defaultCard * 2) {
			if (isTurn) {
				Card card = deck.drawCard();
				player.setCard(card);
			} else {
				Card card = deck.drawCard();
				enemy.setCard(card);
			}
			isTurn = !isTurn;
			i++;
		}
		System.out.println("플레이어에게 모두 카드가 배분되었습니다.");
	}
}