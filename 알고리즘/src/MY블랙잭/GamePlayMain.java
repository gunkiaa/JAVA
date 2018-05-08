package MY블랙잭;

import java.util.Random;
import java.util.Scanner;

public class GamePlayMain {
	public GamePlayMain() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int power = 0;
			System.out.println("1.Rule 2.Play");
			try {
				power = scan.nextInt();
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("정수형의 값만 입력해주세요.");
				continue;
			}
			if (power == 1) {
				rule();
				continue;
			} else if (power == 2) {
				break;
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
		}
		System.out.println("====BlackJack Play====");
		CardDeck deck = new CardDeck();
		Player player = new Player();
		Player dealer = new Player();
		Card card = new Card();

		System.out.println("Draw Card");
		player.setNum(deck.draw());
		System.out.println(player.getCard());
		player.setNum(deck.draw());
		System.out.println(player.getCard());
		System.out.println("카드의 총 합계:" + player.getTotal());
		if (result(player)) {
			System.out.println("플레이어의 패배!");
			return;
		}
		dealer.setNum(deck.draw(1));
		dealer.setNum(deck.draw(1));
		if (result(dealer)) {
			System.out.println("딜러의 아웃!");
			System.out.println("플레이어의 승리!");
			return;
		}

		System.out.println("OPEN or DRAW");
		while (true) {
			String check = scan.next();
			if (check.equals("open") || check.equals("OPEN")) {

				if (dealer.getTotal() < 16) {
					System.out.println("딜러의 draw!");
					dealer.setNum(deck.draw(1));
					if (result(dealer)) {
						System.out.println("플레이어의 패배!");
						break;
					}
				}

				System.out.println("player Score:" + player.getTotal() + "\ndealer Score:" + dealer.getTotal());
				if (dealer.getTotal() > player.getTotal()) {
					System.out.println("딜러 승!");
				} else if (dealer.getTotal() == player.getTotal()) {
					System.out.println("무승부!");
				} else {
					System.out.println("플레이어 승!");
				}
				break;
			} else if (check.equals("draw") || check.equals("DRAW")) {
				System.out.println("DRAW!");
				player.setNum(deck.draw());
				System.out.println(player.getCard());
				System.out.println("카드의 총 합계:" + player.getTotal());
				if (result(player)) {
					System.out.println("플레이어의 패배!");
					break;
				}
				if (dealer.getTotal() < 16) {
					System.out.println("딜러의 draw!");
					dealer.setNum(deck.draw(1));
					if (result(dealer)) {
						System.out.println("딜러가 21점을 넘으므로 딜러의 패배!");
						break;
					}
				}

				System.out.println("player Score:" + player.getTotal() + "\ndealer Score:" + dealer.getTotal());
				if (dealer.getTotal() > player.getTotal() && dealer.getTotal() <= 21) {
					System.out.println("딜러 승!");
				} else if (dealer.getTotal() == player.getTotal()) {
					System.out.println("무승부!");
				} else {
					System.out.println("플레이어 승!");
				}
			}else {
				System.out.println("OPEN or DRAW 중 1택");
				continue;
			}
		}
	}

	public static boolean result(Player player) {
		if (player.getTotal() > 21) {
			return true;
		}
		return false;
	}

	public static Player playerTun(Player player, CardDeck deck) {

		return player;
	}
	public static void rule() {
		System.out.println("========================BlackJack Rule===========================");
		System.out.println("1.딜러와 플레이어는 2장을 뽑는다.");
		System.out.println("2.카드를 뽑은 후 한번, 딜러와 플레이어는 오픈, 드로우 중에 선택한다.");
		System.out.println("3.카드의 총합이 21이 넘으면 패배하고, 아닐 경우엔 카드의 총합이 높은 쪽이 승리한다.");
		System.out.println("************* K,Q,J 는 10점, ACE는 11점으로 계산한다. ****************");
		System.out.println("=================================================================");
	}
}
