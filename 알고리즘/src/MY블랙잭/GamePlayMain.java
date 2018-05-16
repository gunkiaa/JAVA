package MY블랙잭;

import java.util.Scanner;

import 숫자맞추기.NumberHit;

public class GamePlayMain {
	boolean isStop = false;

	public GamePlayMain() {
		Scanner scan = new Scanner(System.in);
		while (true) {
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
			System.out.print(drawCard(card, player, deck));
			System.out.print(",");
			System.out.println(drawCard(card, player, deck));
			if (result(player)) {
				System.out.println("플레이어의 패배!");
				return;
			}
			System.out.println("딜러의 첫번째 카드");
			System.out.println(drawCard(card, dealer, deck));
			drawCard(card, dealer, deck);
			if (result(dealer)) {
				System.out.println("딜러의 점수가 21점을 넘으므로");
				System.out.println("플레이어의 승리!");
				return;
			}
			while (true) {
				System.out.println("OPEN or DRAW");
				String check = scan.next();
				if (check.equals("open") || check.equals("OPEN") || check.equals("오픈")) {
					isStop = true;
					dealDraw(card, dealer, deck);
					break;
				} else if (check.equals("draw") || check.equals("DRAW") || check.equals("드로우")) {
					System.out.println("DRAW!");
					System.out.println(drawCard(card, player, deck));
					System.out.println("뽑은 카드:" + player.getCard());
					if (result(player)) {
						System.out.println("플레이어의 점수가 21점을 넘으므로 패배!");
						isStop = false;
						break;
					} else {
						isStop = true;
						continue;
					}
				} else {
					System.out.println("OPEN or DRAW 중 1택");
					continue;
				}
			}
			if (isStop) {
				resultView(player, dealer);
			}
			if (close()) {
				continue;
			} else {
				return;
			}

		}
	}

	public static boolean close() {
		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("\n한번 더 하시겠습니까? Y/N");

			String power = sc.nextLine();
			if (power.equals("y") || power.equals("Y") || power.equals("n") || power.equals("N")) {
				if (power.equals("y") || power.equals("Y")) {
					break;
				} else {
					System.out.println("종료되었습니다.");
					return false;
				}
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}
		return true;
	}

	public static boolean result(Player player) {
		if (player.getTotal() > 21) {
			return true;
		}
		return false;
	}

	public void resultView(Player player, Player dealer) {

		System.out.println("player Card:" + player.getCard() + "\ndealer Card:" + dealer.getCard());

		if (dealer.getTotal() > player.getTotal() && dealer.getTotal() <= 21) {
			System.out.println("딜러 승!");
		} else if (dealer.getTotal() == player.getTotal()) {
			System.out.println("무승부!");
		} else {
			System.out.println("플레이어 승!");
		}
	}

	public static Player playerTun(Player player, CardDeck deck) {

		return player;
	}

	public static void rule() {
		System.out.println("========================BlackJack Rule===========================");
		System.out.println("1.딜러와 플레이어는 2장을 뽑는다.");
		System.out.println("2.딜러는 카드 한장을 공개한다.");
		System.out.println("3.플레이어는 OPEN, DRAW 중 선택한다. DRAW는 원하는 만큼 가능하다");
		System.out.println("4.플레이어가 DRAW를 모두하면 딜러는 자신의 카드의 총합이 16 이하이면 한장을 더 뽑는다.");
		System.out.println("5.플레이어와 딜러의 스코어를 비교하여 승패를 가린다.");
		System.out.println("********* 딜러와 플레이어는 스코어가 21보다 높을 시 그 즉시 패배한다.  ********");
		System.out.println("************* K,Q,J 는 10점, ACE는 11점으로 계산한다.  ****************");
		System.out.println("******************** 21점은 블랙잭으로 친다 **************************");
		System.out.println("=================================================================");
	}

	public String drawCard(Card card, Player player, CardDeck deck) {
		card.setCard(deck.draw());
		player.setCard(card);
		return card.getCard();
	}

	public void dealDraw(Card card, Player dealer, CardDeck deck) {
		if (dealer.getTotal() <= 16) {
			System.out.println("딜러의 draw!");
			drawCard(card, dealer, deck);
			if (result(dealer)) {
				System.out.println("딜러가 21점을 넘으므로 딜러의 패배!");
				isStop = false;
				return;
			}
		}
	}
}
