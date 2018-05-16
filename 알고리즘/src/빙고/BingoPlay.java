package 빙고;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BingoPlay {
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
		System.out.print("동전의 앞뒤를 선택해주세요:");
		String coin = sc.next();

		if (coin.equals("앞") || coin.equals("뒤")) {
			if (coin.equals("앞")) {
				return 1;
			} else if (coin.equals("뒤")) {
				return 0;
			}
		}
		System.out.println("****앞,뒤 중에서 선택해주세요.*****");
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
			viewPan(userPan, comPan);
			System.out.println("Pan의 숫자를 입력해주세요.");
			int kNum = 0;
			while (true) {
				try {
					kNum = sc.nextInt();
					if (kNum <= 0 || kNum > 30) {
						System.out.println("1~30숫자 중에서 입력해주세요.");
						continue;
					}
					break;
				} catch (Exception e) {
					sc = new Scanner(System.in);
					System.out.println("1~30숫자 중에서 입력해주세요.");
				}
			}
			execute(kNum);
		} else {
			System.out.println("====user bingo======");
			viewPan(userPan, comPan);
			System.out.println("=====com bingo======");
			viewPan(userPan, comPan);

			execute(comList.get(cn));
			System.out.println("상대가 선택한 숫자:" + comList.get(cn));
			System.out.println("=====================");
			cn++;
		}
	}
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
				if(cnt == 5) {
					System.out.println("5빙고입니다.");
					return;
				}
				if(bCnt == 5) {
					cnt++;
					bCnt = 0;
					System.out.println(cnt+"빙고입니다!");
				}
				// 0,0 0,1 0,2 0,3 0,4
				// 1,0 1,1 1,2 1,3 1,4
				// 2,0 2,1 2,2 2,3 2,4
				// 3,0 3,1 3,2 3,3 3,4
				// 4,0 4,1 4,2 4,3 4,4
			}
		}
	}

	public static void viewPan(int[][] pan, int[][] pan2) {
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
			System.out.print("    ");
			for (int j = 0; j < 5; j++) {
				if (pan2[i][j] < 10 && pan2[i][j] > 0) {
					System.out.print("|0" + pan2[i][j] + "|");
				} else if (pan2[i][j] == 0) {
					System.out.print("|" + "**" + "|");
				} else {
					System.out.print("|" + pan2[i][j] + "|");
				}
			}
			System.out.println("");
		}
		System.out.println("====================");

	}
}