package 카드게임;

import java.util.ArrayList;
import java.util.List;

public class Player {
	// 플레이어가 가진 카드를 저장할 변수
	private List<Card> myCard;
	// 플레이어의 총점
	private int score = 0;

	// 플레이어가 생성됨과 동시에 초기화
	public Player() {
		myCard = new ArrayList<Card>();
	}

	// 플레이어의 카드를 설정할 메소드
	public void setCard(Card card) {
		score += card.getCardNum();
		myCard.add(card);
	}

	// 플레이어의 카드를 얻어오는 메소드
	public List<Card> getCard() {
		return myCard;
	}

	// 플레이어의 총점을 얻어오는 메소드
	public int getScore() {
		return score;
	}
}
