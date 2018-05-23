package 원카드;
import 원카드.Card;
import 원카드.CardDeck;
import 원카드.Player;

public class GamePlay {
	CardDeck deck;
	Card openCard;
	Player player;
	Player enemy;
	final int defaultCard = 5;

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
		// System.out.println(player.getCard());
	}

	private void defaultCard() {
		boolean isTurn = true;
		int i = 0;
		while (i < defaultCard * 2) {
			if (isTurn) {
				Card card = new Card();
				card.setCard(deck.drawCard());
				player.setCard(card);
			} else {
				Card card = new Card();
				card.setCard(deck.drawCard());
				enemy.setCard(card);
			}
			isTurn = !isTurn;
		}
	}
}