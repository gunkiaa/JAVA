package 숫자맞추기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberHit {
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	int[] ran = new int[9];
	String[] view = new String[9];

	public NumberHit() {
		while (true) {
			reset();
			inputNum();
			check();

			if (close()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void reset() {
		for (int i = 0; i < ran.length; i++) {
			view[i] = "[?]";
		}
	}

	public void inputNum() {
		for (int i = 0; i < ran.length; i++) {
			ran[i] = rd.nextInt(9) + 1;
			for (int j = 0; j < i; j++) {
				if (ran[i] == ran[j]) {
					i--;
					break;
				}
			}
		}
	}

	public void check() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			list.add(i, i + 1);
		}
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i));
		// System.out.print(",");
		// System.out.println(list.indexOf(i+1));
		// }
		Collections.shuffle(list);
		int i = 0;
		while (i < list.size()) {
			int idx = list.get(i++);
			while (true) {
				System.out.print("\n" + (idx) + "번째 수를 입력 :");
				int user = 0;
				try {
					user = sc.nextInt();
					if (user >= 10 || user <= 0) {
						System.out.println("1~9 중의 숫자로 입력해주세요.");
						continue;
					}
				} catch (Exception e) {
					sc = new Scanner(System.in);
					System.out.println("1~9 중의 숫자로 입력해주세요.");
					continue;
				}
				if (ran[idx-1] == user) {
					System.out.println("Hit!");
					for (int j = 0; j < ran.length; j++) {
						if (j < idx-1) {
							System.out.print(view[j]);
						}
						if (j == idx-1) {
							view[j] = "[" + Integer.toString(user) + "]";
							System.out.print(view[j]);
						}
						if (j > idx-1) {
							System.out.print(view[j]);
						}
					}
					break;
				} else {
					if (user > ran[idx-1]) {
						System.out.println("Down");
					} else if (user < ran[idx-1]) {
						System.out.println("Up");
					}
					continue;
				}
			}
		}
		System.out.println("\n축하합니다."+(list.size())+"개의 숫자를 모두 맞추셨습니다.");
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
}
