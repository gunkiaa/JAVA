package 승부차기;

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
				System.out.println("다시하시겠습니까? Y/N");
				String power = sc.next();
				if (power.equals("Y") || power.equals("y")) {
					playerScore = 0;
					comScore = 0;
					break;
				} else if (power.equals("N") || power.equals("n")) {
					return;
				} else {
					System.out.println("다시 입력해주세요.");
				}
			}
		}
	}

	public static int inputCoin() {
		System.out.print("동전의 앞, 뒤 중 하나를 선택하시오 :");
		String coin = sc.next();

		if (coin.equals("앞") || coin.equals("뒤")) {
			if (coin.equals("앞")) {
				return 1;
			} else if (coin.equals("뒤")) {
				return 0;
			}
		}
		System.out.println("****앞, 뒤 중 하나를 선택해주세요.*****");
		return 2;
	}

	public static boolean check(int checkCoin) {
		int ranCoin = ran.nextInt(2);
		if (checkCoin == ranCoin) {
			System.out.println("맞췄습니다!");
			System.out.println("선공으로 시작합니다.");
			return true;
		} else if (checkCoin != ranCoin) {
			System.out.println("못 맞췄습니다!");
			System.out.println("후공으로 시작합니다.");
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
		if (isKick) {// 키커
			goalKeeper(isKick);
			System.out.println("||공격입니다||");
			view();
			System.out.println("슛을 찰 번호를 선택해주세요.");
			int kNum = 0;
			while (true) {
				try {
					kNum = sc.nextInt();
					if (kNum <= 0 || kNum >= 10) {
						System.out.println("1~9의 숫자 중에서 입력해주세요.");
						continue;
					}
					break;
				} catch (Exception e) {
					sc = new Scanner(System.in);
					System.out.println("1~9의 숫자 중에서 입력해주세요.");
				}
			}
			int guardCnt = 0;
			for (int i = 0; i < comGoal.length; i++) {
				if (kNum == comGoal[i]) {
					guardCnt++;
				}
			}
			if (guardCnt != 0) {
				System.out.println("막혔습니다!!\n");
				comScore++;
			} else {
				System.out.println("넣었습니다!!\n");
				playerScore++;
			}
		} else {// 골키퍼
			System.out.println("||수비입니다.||");
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
			System.out.println("수비할 번호를 3개 선택해주세요.");
			while (true) {
				try {
					for (int i = 0; i < userGoal.length; i++) {
						userGoal[i] = sc.nextInt(10);
						if (userGoal[i] <= 0 || userGoal[i] >= 10) {
							System.out.println("1~9의 숫자 중에서 입력해주세요.");
							i--;
						}
					}
					break;
				} catch (Exception e) {
					sc = new Scanner(System.in);
					System.out.println("1~9의 숫자 중에서 입력해주세요.");
				}
			}

			int guardCnt = 0;
			for (int i = 0; i < userGoal.length; i++) {
				if (comKick == userGoal[i]) {
					guardCnt++;
				}
			}
			if (guardCnt != 0) {
				System.out.println("막았습니다!!\n");
				playerScore++;
			} else {
				System.out.println("먹혔습니다!!\n");
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
