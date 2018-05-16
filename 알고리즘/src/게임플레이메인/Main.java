 package 게임플레이메인;

import java.util.Scanner;

import MY블랙잭.GamePlayMain;
import 숫자맞추기.NumberHit;
import 숫자야구게임.BaseBallGame;
import 숫자야구게임.BaseBallMain;
import 승부차기.GamePlay;

public class Main {
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Menu==========");
			System.out.println("1.숫자 야구");
			System.out.println("2.블랙잭");
			System.out.println("3.숫자 맞추기");
			System.out.println("4.승부차기");
			System.out.println("====5.종료=====");

			BaseBallGame game = null;
			int check = 0;
			try {
				check = sc.nextInt();
			} catch (Exception e) {
				System.out.println("1~4 중에서 입력해주세요.");
				continue;
			}

			if (check == 1) {
				System.out.println("====숫자 야구 PLAY====");
				new BaseBallMain();
				if (close()) {
					System.out.println("\n\n\n\n\n\n\n\n");
					continue;
				} else {
					return;
				}
			} else if (check == 2) {
				System.out.println("====블랙잭 PLAY====");
				new GamePlayMain();
				if (close()) {
					System.out.println("\n\n\n\n\n\n\n\n");
					continue;
				} else {
					return;
				}

			} else if (check == 3) {
				System.out.println("====숫자 맞추기 PLAY====");
				new NumberHit();
				if (close()) {
					System.out.println("\n\n\n\n\n\n\n\n");
					continue;
				} else {
					return;
				}
			} else if (check == 4) {
				System.out.println("====승부 차기 PLAY====");
				new GamePlay();
				if (close()) {
					System.out.println("\n\n\n\n\n\n\n\n");
					continue;
				} else {
					return;
				}
			} else if (check == 5) {
				System.out.println("종료되었습니다.");
				return;
			} else {
				System.out.println("1~4의 정수 중에서 입력해주세요.");
			}
		}
	}

	public static boolean close() {
		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("메뉴로 돌아가시겠습니까? Y/N");

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
}
