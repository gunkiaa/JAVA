package �º�����;

import java.util.Random;
import java.util.Scanner;

public class GamePlay {
	static Scanner sc = new Scanner(System.in);
	static Random ran = new Random();

	static int[] comGoal = new int[3];
	static int[] userGoal = new int[3];

	static int playerScore = 0;
	static int comScore = 0;

	public GamePlay() {
		System.out.println("START");

		while (true) {
			int checkNum = inputCoin();

			if (checkNum == 2) {
				continue;
			}

			boolean isKick = check(checkNum);

			int i = 0;
			while (i <= 5) {
				kicker(isKick);
				if (isKick) {
					isKick = false;
				} else {
					isKick = true;
				}
				i++;
			}
			resultView();

			while (true) {
				System.out.println("�ٽ��Ͻðڽ��ϱ�? Y/N");
				String power = sc.next();
				if (power.equals("Y") || power.equals("y")) {
					playerScore = 0;
					comScore = 0;
					break;
				} else if (power.equals("N") || power.equals("n")) {
					return;
				} else {
					System.out.println("�ٽ� �Է����ּ���.");
				}
			}
		}
	}

	public static int inputCoin() {
		System.out.print("������ ��, �� �� �ϳ��� �����Ͻÿ� :");
		String coin = sc.next();

		if (coin.equals("��") || coin.equals("��")) {
			if (coin.equals("��")) {
				return 1;
			} else if (coin.equals("��")) {
				return 0;
			}
		}
		System.out.println("****��, �� �� �ϳ��� �������ּ���.*****");
		return 2;
	}

	public static boolean check(int checkCoin) {
		int ranCoin = ran.nextInt(2);
		if (checkCoin == ranCoin) {
			System.out.println("������ϴ�!");
			System.out.println("�������� �����մϴ�.");
			return true;
		} else if (checkCoin != ranCoin) {
			System.out.println("�� ������ϴ�!");
			System.out.println("�İ����� �����մϴ�.");
			return false;
		}
		return false;
	}

	public static void view() {
		System.out.println("------------------");
		System.out.println("| 1      2      3|");
		System.out.println("| 4      5      6|");
		System.out.println("| 7      8      9|");
		System.out.println("------------------");
	}

	public static void kicker(boolean isKick) {
		if (isKick) {// ŰĿ
			goalKeeper(isKick);
			System.out.println("||�����Դϴ�||");
			view();
			System.out.println("���� �� ��ȣ�� �������ּ���.");
			int kNum = 0;
			while (true) {
				try {
					kNum = sc.nextInt();
					if (kNum <= 0 || kNum >= 10) {
						System.out.println("1~9�� ���� �߿��� �Է����ּ���.");
						continue;
					}
					break;
				} catch (Exception e) {
					sc = new Scanner(System.in);
					System.out.println("1~9�� ���� �߿��� �Է����ּ���.");
				}
			}
			int guardCnt = 0;
			for (int i = 0; i < comGoal.length; i++) {
				if (kNum == comGoal[i]) {
					guardCnt++;
				}
			}
			if (guardCnt != 0) {
				System.out.println("�������ϴ�!!\n");
				comScore++;
			} else {
				System.out.println("�־����ϴ�!!\n");
				playerScore++;
			}
		} else {// ��Ű��
			System.out.println("||�����Դϴ�.||");
			view();
			goalKeeper(isKick);
		}
	}

	public static void goalKeeper(boolean isKick) {
		if (isKick) {
			for (int i = 0; i < comGoal.length; i++) {
				comGoal[i] = ran.nextInt(9) + 1;
				for (int j = 0; j < i; j++) {
					if (comGoal[i] == comGoal[j]) {
						i--;
						break;
					}
				}
			}
		} else {
			int comKick = 0;
			comKick = ran.nextInt(10);
			System.out.println("������ ��ȣ�� 3�� �������ּ���.");
			while (true) {
				try {
					for (int i = 0; i < userGoal.length; i++) {
						userGoal[i] = sc.nextInt(10);
						if (userGoal[i] <= 0 || userGoal[i] >= 10) {
							System.out.println("1~9�� ���� �߿��� �Է����ּ���.");
							i--;
						}
					}
					break;
				} catch (Exception e) {
					sc = new Scanner(System.in);
					System.out.println("1~9�� ���� �߿��� �Է����ּ���.");
				}
			}

			int guardCnt = 0;
			for (int i = 0; i < userGoal.length; i++) {
				if (comKick == userGoal[i]) {
					guardCnt++;
				}
			}
			if (guardCnt != 0) {
				System.out.println("���ҽ��ϴ�!!\n");
				playerScore++;
			} else {
				System.out.println("�������ϴ�!!\n");
				comScore++;
			}
		}
	}

	public static void resultView() {
		System.out.println("PLAYER : BOT");
		System.out.println("  " + playerScore + "    :  " + comScore);
		if (playerScore > comScore) {
			System.out.println("PLAYER WINER!!");
		} else if (playerScore == comScore) {
			System.out.println("PLAYER, COM DRAW\n");
		} else {
			System.out.println("COM WINER!!");
		}
	}
}
