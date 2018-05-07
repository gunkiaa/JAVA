package 숫자야구게임;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
	private Scanner sc = new Scanner(System.in);
	private Random ran = new Random();

	private int[] rNum = new int[3];
	private int[] iNum = new int[3];

	private int strikeCnt;
	private int ballCnt;

	public boolean getClean() {
		if(strikeCnt == 3) {
			return true;
		}else {
			return false;
		}
	}
	// 랜덤 값 받기
	public void ranNum() {

		while (rNum[0] == 0) {
			rNum[0] = ran.nextInt(10);
		}
		while (rNum[0] == rNum[1] || rNum[1] == 0) {
			rNum[1] = ran.nextInt(10);
		}
		while (rNum[0] == rNum[2] || rNum[1] == rNum[2] || rNum[2] == 0) {

			rNum[2] = ran.nextInt(10);

		}
		//System.out.println("정답 공개 : " + rNum[0] + "," + rNum[1] + "," + rNum[2]);
	}

	// 사용자에게 입력 값 받기
	public void userNum() {
		for (int i = 0; i < rNum.length; i++) {
			try {
				System.out.println((i + 1) + "번째 숫자를 입력해주세요.");
				iNum[i] = sc.nextInt();

				if (i != 0) {
					if((i-2) == 0 && iNum[i - 2] == iNum[i]) {
							i--;
							System.out.println((i) + "번째와 다른 값을 입력해주세요.");
					}
					if (iNum[i - 1] == iNum[i]) {
						i--;
						System.out.println((i + 1) + "번째와 다른 값을 입력해주세요.");
					}
				}

				if (iNum[i] < 0 || iNum[i] >= 10) {
					System.out.println("0~9의 숫자를 입력해주세요.");
					if (i == 0) {
						userNum();
						break;
					} else {
						i--;
					}
				}
			} catch (Exception e) {
				sc = new Scanner(System.in);
				System.out.println("0~9 사이의 숫자를 입력해주세요.");
				if (i == 0) {
					userNum();
					break;
				} else {
					i--;
				}
			}

		}
	}

	// 스트라이크, 볼 체크
	public void check() {
		for (int i = 0; i < rNum.length; i++) {
			for (int j = 0; j < iNum.length; j++) {
				if (rNum[i] == iNum[j]) { // 두 수가 같다면
					if (i == j) { // 두 수의 인덱스가 같다면
						strikeCnt++; // 스트라이크 개수
					} else if (i != j) {
						ballCnt++; // 볼 개수
					}
				}
			}
		}
	}

	// 스트라이크, 아웃 여부를 출력해줌
	public void resultView() {
		if (strikeCnt == 0 && ballCnt == 0) { // 만약 스트레이크와 볼이 0개라면
			System.out.println("\n아웃!!\n");
			resetCnt();
			return;
		} else if (strikeCnt == rNum.length) { // 만약 스트라이크 3개라면
			System.out.println("\n3 스트라이크!!");
			resetNum();
			return;
		} else { // 위의 두가지 조건을 충족하지 못할 경우
			System.out.println("\n" + strikeCnt + "스트라이크" + "," + ballCnt + "볼");
			
			resetCnt();
			return;
		}
	}

	// 게임이 끝난 후 랜덤 값을 초기화 해줌
	public void resetNum() {
		for (int i = 0; i < rNum.length; i++) {
			rNum[i] = 0;
		}
		resetCnt();
	}

	// 스트라이크, 볼 카운트를 초기화 해줌
	public void resetCnt() {
		strikeCnt = 0;
		ballCnt = 0;
	}
}