package 카드게임;

public class Card {
	//카드의 패턴을 저장할 변수
	private String pattern = "";
	//카드의 숫자를 저장할 변수
	private int cardNum = 0;
	
	//패턴을 넘겨줄 메소드
	public String getPattern() {
		return pattern;
	}
	//패턴을 설정하는 메소드
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	//카드의 숫자를 넘겨줄 메소드 
	public int getCardNum() {
		return cardNum;
	}
	//카드의 숫자를 설정할 메소드
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
}
