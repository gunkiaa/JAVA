package 원카드;

public class Card {
	String pattern;
	int num;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setCard(Card card) {
		this.pattern = card.getPattern();
		this.num = card.getNum();
	}
}
