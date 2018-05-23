package 카드게임;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import 카드게임.Card;

public class CardDeck {
	// 카드의 문양을 저장할 배열
	private String[] pattern = { "♠", "♣", "♥", "◈" };
	// 카드가 저장될 리스트
	private List<Card> card = new ArrayList<Card>();
	// 몇번째 카드까지 뽑았는지 카운트할 변수
	private int drawNum = 0;

	// 생성자, 생성과 동시에 덱에 카드 40장이 생성됨
	public CardDeck() {
		System.out.println("총 카드");
		System.out.println("=================");
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < 10; j++) {
				// 카드 객체 생성
				Card card = new Card();
				// 콘솔에 출력을 위함
				System.out.print("[" + pattern[i] + (j + 1) + "]");
				// 카드의 패턴을 설정
				card.setPattern(pattern[i]);
				// 카드의 숫자를 설정
				card.setCardNum(j + 1);
				// 리스트에 카드를 넣음
				this.card.add(card);
			}
			System.out.println("");
		}
	}

	// 카드 섞기
	public void shuffle() {
		// 섞임
		Collections.shuffle(this.card);
		// 출력을 위한 인덱스 변수
		int num = 0;
		// 세로 줄
		for (int i = 0; i < pattern.length; i++) {
			// 가로 줄
			for (int j = 0; j < 10; j++) {
				// 카드 출력
				System.out.print("[" + card.get(num).getPattern() + card.get(num).getCardNum() + "]");
				// 인덱스 증가
				num++;
			}
			System.out.println("");
		}
	}

	// 카드 뽑기 위한 메소드
	public Card drawCard() {
		// 카드 뽑기 위한 변수
		int num = drawNum;
		// 카드 인덱스 증가
		drawNum += 1;
		// List객체에서 num번째를 리턴
		return card.get(num);
	}
}
