package ����;

import java.util.Scanner;

public class BlackJackPlay {

	public BlackJackPlay() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			BlackJack player = new BlackJack();
			BlackJack dealer = new BlackJack();
			System.out.println("����� �д�");
			player.generatorRandom();
			player.cardMarked();
			player.setPoint();
			player.display();
			player.generatorRandom();
			player.cardMarked();
			player.setPoint();
			player.display();
			System.out.println("����� ���� ������:  " + player.getPoint());
			System.out.println("������ �� �����Ͻ÷��� Y �������� �����÷��� N�� �Է� �ϼ���. ");
			String userType = sc.nextLine();
			userType.toLowerCase();

			while (userType.equals("Y") || userType.equals("y") && (player.getPoint() <= 21)) {
				player.generatorRandom();
				player.cardMarked();
				player.setPoint();
				player.display();
				System.out.println("����� ���� ������: " + player.getPoint());
				System.out.println("������ �� �����Ͻ÷��� Y �������� �����÷��� N�� �Է��ϼ���. ");
				userType = sc.nextLine();
			}

			if (player.getPoint() > 21) {
				System.out.println("21������ �����ϴ�. ");
				System.out.println("21������ ���� ������ ���� �˴ϴ�. ");
			}

			else {
				System.out.println("����� ���� " + player.getPoint());
				System.out.println("������ �д� ");
				dealer.generatorRandom();
				dealer.cardMarked();
				dealer.setPoint();
				dealer.display();
				dealer.generatorRandom();
				dealer.cardMarked();
				dealer.setPoint();
				dealer.display();
				System.out.println("===========");
				System.out.println("������ ������: " + dealer.getPoint());

				while (dealer.getPoint() <= 14) {
					dealer.generatorRandom();
					dealer.cardMarked();
					System.out.println("������ ���� ��");
					dealer.display();
					dealer.setPoint();
					System.out.println("������ ����: " + dealer.getPoint());

				}

				if (dealer.getPoint() > 21)
					System.out.println("�÷��̾ �¸� �Ͽ����ϴ�. ");
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

					System.out.println("\n�ٽ� �Ͻðڽ��ϱ�? Y/N");
	
				String power = sc.nextLine();
				if (power.equals("y") || power.equals("Y") || power.equals("n") || power.equals("N")) {
					if (power.equals("y") || power.equals("Y")) {
						break;
					} else {
						System.out.println("����Ǿ����ϴ�.");
						return;
					}
				} else {
					System.out.println("�ٽ� �Է����ּ���.");
				}
			}
		}
	}
}