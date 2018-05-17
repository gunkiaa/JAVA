package 카드게임;

public class Card {
	String pattern;
	int num = 0;

	public void setNum(int num) {
		this.num = num;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public int getNum() {
		return num;
	}

	public String getPattern() {
		return pattern;
	}
}