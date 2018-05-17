package 카드게임;

public class Main {
	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		deck.shuffle();
		Player[] player = new Player[5];

		for (Player play : player) {
			for (int i = 0; i < player.length; i++) {
				Card card = deck.drawCard();
				play.drawCard(card);
			}
		}
	}
}
