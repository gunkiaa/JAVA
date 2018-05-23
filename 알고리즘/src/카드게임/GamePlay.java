package 카드게임;

import java.util.List;
import java.util.Scanner;

public class GamePlay {
	// 카드 덱
	private CardDeck deck;
	// 플레이어 명 수, 변경을 못하게 하기 위해 final로 선언.
	private final int player_cnt = 5;
	// 플레이어 객체, player_cnt만큼 길이 설정.
	private Player[] player = new Player[player_cnt];

	// 나눠줄 카드 수, 변경을 못하게 하기 위해 final로 선언.
	private final int defaultCard = 5;

	// 생성자,초기화를 해줌
	public GamePlay() {
		deck = new CardDeck();

		for (int i = 0; i < player_cnt; i++) {
			player[i] = new Player();
		}
	}

	// 게임 시작
	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=================");
		System.out.println("카드를 섞으시겠습니까?");
		String daedab = sc.next();

		// 카드를 섞어줌
		if (daedab.equals("네")) {
			System.out.println("=================");
			deck.shuffle();
			System.out.println("=================");
			System.out.println("드르륵! 카드가 섞였습니다.");
		} else {
			// 다시 입력받기 귀찮음
			System.out.println("유감입니다...당신은 게임하기 싫은가 봅니다..");
			return;
		}

		// 플레이어에게 카드를 분배
		// 여기서 i는 그저 반복을 위함.
		for (int i = 0; i < defaultCard; i++) {
			// 여기서 j는 플레이어 배열의 인덱스로 쓰임
			for (int j = 0; j < player.length; j++) {
				// 카드 덱에서 카드를 뽑음
				Card card = deck.drawCard();
				// 플레이어에게 카드를 줌, 플레이어는 카드를 받고, 스코어에 더함
				player[j].setCard(card);
			}
		}
		// i는 플레이어 배열의 인덱스 변수로 사용.
		for (int i = 0; i < player.length; i++) {
			System.out.println("=======");
			System.out.println("플레이어" + (i + 1) + "의 카드");
			// player i가 가지고 있는 모든 카드를 가지고 옴
			List<Card> card = player[i].getCard();

			// 가지고 온 플레이어의 모든 카드를 출력.
			for (int j = 0; j < defaultCard; j++) {
				// 0부터,패턴+숫자 를 출력
				System.out.println(card.get(j).getPattern() + card.get(j).getCardNum());
			}
			// 플레이어의 총점을 출력
			System.out.println("=======" + player[i].getScore());
		}
		// 1등을 가려내기 위한 변수
		int max = 0;
		// i는 플레이어의 인덱스 변수로 사용
		for (int i = 0; i < 5; i++) {
			// i번째 플레이어의 총점이 max보다 큰가?
			if (player[i].getScore() > max) {
				// 크다면 max에 저장
				max = player[i].getScore();
			}
		}
		// i는 플레이어의 인덱스 변수로 사용
		for (int i = 0; i < player.length; i++) {
			// i번째 플레이어의 총점이 max랑 같나?
			if (player[i].getScore() == max) {
				// 같다면 출력
				System.out.println((i + 1) + "번째 플레이어의 승리입니다.");
				return;
			}
		}
	}
}