 package �����÷��̸���;

import java.util.Scanner;

import MY����.GamePlayMain;
import ���ڸ��߱�.NumberHit;
import ���ھ߱�����.BaseBallGame;
import ���ھ߱�����.BaseBallMain;
import �º�����.GamePlay;

public class Main {
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Menu==========");
			System.out.println("1.���� �߱�");
			System.out.println("2.����");
			System.out.println("3.���� ���߱�");
			System.out.println("4.�º�����");
			System.out.println("====5.����=====");

			BaseBallGame game = null;
			int check = 0;
			try {
				check = sc.nextInt();
			} catch (Exception e) {
				System.out.println("1~4 �߿��� �Է����ּ���.");
				continue;
			}

			if (check == 1) {
				System.out.println("====���� �߱� PLAY====");
				new BaseBallMain();
				if (close()) {
					System.out.println("\n\n\n\n\n\n\n\n");
					continue;
				} else {
					return;
				}
			} else if (check == 2) {
				System.out.println("====���� PLAY====");
				new GamePlayMain();
				if (close()) {
					System.out.println("\n\n\n\n\n\n\n\n");
					continue;
				} else {
					return;
				}

			} else if (check == 3) {
				System.out.println("====���� ���߱� PLAY====");
				new NumberHit();
				if (close()) {
					System.out.println("\n\n\n\n\n\n\n\n");
					continue;
				} else {
					return;
				}
			} else if (check == 4) {
				System.out.println("====�º� ���� PLAY====");
				new GamePlay();
				if (close()) {
					System.out.println("\n\n\n\n\n\n\n\n");
					continue;
				} else {
					return;
				}
			} else if (check == 5) {
				System.out.println("����Ǿ����ϴ�.");
				return;
			} else {
				System.out.println("1~4�� ���� �߿��� �Է����ּ���.");
			}
		}
	}

	public static boolean close() {
		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("�޴��� ���ư��ðڽ��ϱ�? Y/N");

			String power = sc.nextLine();
			if (power.equals("y") || power.equals("Y") || power.equals("n") || power.equals("N")) {
				if (power.equals("y") || power.equals("Y")) {
					break;
				} else {
					System.out.println("����Ǿ����ϴ�.");
					return false;
				}
			} else {
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
		return true;
	}
}
