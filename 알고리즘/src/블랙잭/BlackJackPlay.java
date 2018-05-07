package 블랙잭;

import java.util.Scanner;

public class BlackJackPlay {

	public BlackJackPlay() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			BlackJack player = new BlackJack();
			BlackJack dealer = new BlackJack();
			System.out.println("당신의 패는");
			player.generatorRandom();
			player.cardMarked();
			player.setPoint();
			player.display();
			player.generatorRandom();
			player.cardMarked();
			player.setPoint();
			player.display();
			System.out.println("당신의 최종 점수는:  " + player.getPoint());
			System.out.println("게임을 더 진행하시려면 Y 진행하지 않으시려면 N을 입력 하세요. ");
			String userType = sc.nextLine();
			userType.toLowerCase();

			while (userType.equals("Y") || userType.equals("y") && (player.getPoint() <= 21)) {
				player.generatorRandom();
				player.cardMarked();
				player.setPoint();
				player.display();
				System.out.println("당신의 최종 점수는: " + player.getPoint());
				System.out.println("게임을 더 진행하시려면 Y 진행하지 않으시려면 N을 입력하세요. ");
				userType = sc.nextLine();
			}

			if (player.getPoint() > 21) {
				System.out.println("21점보다 높습니다. ");
				System.out.println("21점보다 높기 때문에 종료 됩니다. ");
			}

			else {
				System.out.println("당신의 점수 " + player.getPoint());
				System.out.println("딜러의 패는 ");
				dealer.generatorRandom();
				dealer.cardMarked();
				dealer.setPoint();
				dealer.display();
				dealer.generatorRandom();
				dealer.cardMarked();
				dealer.setPoint();
				dealer.display();
				System.out.println("===========");
				System.out.println("딜러의 점수는: " + dealer.getPoint());

				while (dealer.getPoint() <= 14) {
					dealer.generatorRandom();
					dealer.cardMarked();
					System.out.println("딜러가 뽑은 패");
					dealer.display();
					dealer.setPoint();
					System.out.println("딜러의 점수: " + dealer.getPoint());

				}

				if (dealer.getPoint() > 21)
					System.out.println("플레이어가 승리 하였습니다. ");
			}

			if ((dealer.getPoint()) <= 21 && (player.getPoint() <= 21)) {
				if (player.getPoint() > dealer.getPoint())
					System.out.println("player wins");
				else if (player.getPoint() < dealer.getPoint())
					System.out.println("dealer wins");
				else
					System.out.println("draw");
			}
			while (true) {
				sc = new Scanner(System.in);

					System.out.println("\n다시 하시겠습니까? Y/N");
	
				String power = sc.nextLine();
				if (power.equals("y") || power.equals("Y") || power.equals("n") || power.equals("N")) {
					if (power.equals("y") || power.equals("Y")) {
						break;
					} else {
						System.out.println("종료되었습니다.");
						return;
					}
				} else {
					System.out.println("다시 입력해주세요.");
				}
			}
		}
	}
}