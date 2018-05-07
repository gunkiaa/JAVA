package ����;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
	static Scanner sc = new Scanner(System.in);
	static Random ran = new Random();
	static int[][] userPan = new int[5][5];
	static int[][] comPan = new int[5][5];
	static List<Integer> list;
	static List<Integer> comList;
	static int cn = 0;

	public static void main(String[] args) {
		takeNum(userPan);
		takeNum(comPan);
		while (true) {
			int checkNum = inputCoin();

			if (checkNum == 2) {
				continue;
			}
			boolean isPlay = check(checkNum);
			while (true) {
				kicker(isPlay);
				bingoCheck();
				if (isPlay) {
					isPlay = false;
				} else {
					isPlay = true;
				}
			}
			// System.out.println("====user bingo======");
			// viewPan(userPan);
			// System.out.println("=====com bingo======");
			// viewPan(comPan);
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

	public static void takeNum(int[][] pan) {
		list = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++) {
			list.add(i + 1);
		}
		Collections.shuffle(list);
		int cnt = 0;
		for (int i = 0; i < pan.length; i++) {
			for (int j = 0; j < pan.length; j++) {
				cnt++;

				pan[i][j] = list.get(cnt);
			}
		}
		comList = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				comList.add(comPan[i][j]);

			}
		}
		Collections.shuffle(comList);
	}

	public static void kicker(boolean isKick) {
		if (isKick) {// ŰĿ
			// goalKeeper(isKick);
			System.out.println("====user bingo======");
			viewPan(userPan);
			System.out.println("=====com bingo======");
			viewPan(comPan);
			System.out.println("Pan �ȿ� ��ȣ�� �������ּ���.");
			int kNum = 0;
			while (true) {
				try {
					kNum = sc.nextInt();
					if (kNum <= 0 || kNum > 30) {
						System.out.println("1~30�� ���� �߿��� �Է����ּ���.");
						continue;
					}
					break;
				} catch (Exception e) {
					sc = new Scanner(System.in);
					System.out.println("1~30�� ���� �߿��� �Է����ּ���.");
				}
			}
			execute(kNum);
		} else {// ��Ű��
			System.out.println("====user bingo======");
			viewPan(userPan);
			System.out.println("=====com bingo======");
			viewPan(comPan);

			execute(comList.get(cn));
			System.out.println("��ǻ�Ͱ� ������ ����:" + comList.get(cn));
			System.out.println("=====================");
			cn++;
		}
	}

	// public static void goalKeeper(boolean isKick) {
	// if (isKick) {
	// for (int i = 0; i < comGoal.length; i++) {
	// comGoal[i] = ran.nextInt(9) + 1;
	// for (int j = 0; j < i; j++) {
	// if (comGoal[i] == comGoal[j]) {
	// i--;
	// break;
	// }
	// }
	// }
	// } else {
	// int comKick = 0;
	// comKick = ran.nextInt(10);
	// System.out.println("������ ��ȣ�� 3�� �������ּ���.");
	// while (true) {
	// try {
	// for (int i = 0; i < userGoal.length; i++) {
	// userGoal[i] = sc.nextInt(10);
	// if (userGoal[i] <= 0 || userGoal[i] >= 10) {
	// System.out.println("1~9�� ���� �߿��� �Է����ּ���.");
	// i--;
	// }
	// }
	// break;
	// } catch (Exception e) {
	// sc = new Scanner(System.in);
	// System.out.println("1~9�� ���� �߿��� �Է����ּ���.");
	// }
	// }
	//
	// int guardCnt = 0;
	// for (int i = 0; i < userPan.length; i++) {
	// if (comKick == userPan[i]) {
	// guardCnt++;
	// }
	// }
	// if (guardCnt != 0) {
	// System.out.println("���ҽ��ϴ�!!\n");
	// } else {
	// System.out.println("�������ϴ�!!\n");
	// }
	// }
	// }
	public static void execute(int num) {
		for (int i = 0; i < userPan.length; i++) {
			for (int j = 0; j < userPan.length; j++) {
				if (userPan[i][j] == num) {
					userPan[i][j] = 0;
				}
				if (comPan[i][j] == num) {
					comPan[i][j] = 0;
				}
			}
		}
	}

	public static void bingoCheck() {
		int cnt = 0;
		int bCnt = 0;
		for (int i = 0; i < userPan.length; i++) {
			for (int j = 0; j < userPan.length; j++) {
				if(userPan[i][j] == 0) {
					bCnt++;
				}
//				if(userPan[j][i] == 0) {
//					bCnt++;
//				}
				if(cnt == 5) {
					System.out.println("5���� �÷��̾��� �¸��Դϴ�.");
					return;
				}
				if(bCnt == 5) {
					cnt++;
					bCnt = 0;
					System.out.println(cnt+"�����Դϴ�!");
				}
				// 0,0 0,1 0,2 0,3 0,4
				// 1,0 1,1 1,2 1,3 1,4
				// 2,0 2,1 2,2 2,3 2,4
				// 3,0 3,1 3,2 3,3 3,4
				// 4,0 4,1 4,2 4,3 4,4
			}
		}
	}

	public static void viewPan(int[][] pan) {
		for (int i = 0; i < pan.length; i++) {
			for (int j = 0; j < 5; j++) {
				if (pan[i][j] < 10 && pan[i][j] > 0) {
					System.out.print("|0" + pan[i][j] + "|");
				} else if (pan[i][j] == 0) {
					System.out.print("|" + "**" + "|");
				} else {
					System.out.print("|" + pan[i][j] + "|");
				}
			}
			System.out.println("");
		}
		System.out.println("====================");

	}
}
