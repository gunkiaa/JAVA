package 숫자야구게임;

import java.util.Scanner;

public class BaseBallMain {

	public BaseBallMain() {
		
		BaseBallGame game = new BaseBallGame();
		boolean isTrue = true;
		while (true) {
			// 컴퓨터의 랜덤값 받기
			game.ranNum();

			// 사용자 입력
			game.userNum();
			// 스트라이크, 볼 체크
			game.check();
			
			isTrue = game.getClean();
			
			// 결과 출력
			game.resultView();
			// 안내말 부분
			if(isTrue) {
				game.resetNum();
			}
			while (true) {
				Scanner sc = new Scanner(System.in);
				
				if(isTrue) {
					System.out.println("새 게임을 시작하시겠습니까? Y/N");
				}else {
					System.out.println("다시 하시겠습니까? Y/N");
				}
				String power = sc.nextLine();
				if (power.equals("y") || power.equals("Y") || power.equals("n") || power.equals("N")) {
					if (power.equals("y") || power.equals("Y")) {
						break;
					} else {
						return;
					}
				} else {
					System.out.println("다시 입력해주세요.");
				}
			}
		}
	}
}
