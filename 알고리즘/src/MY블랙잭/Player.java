package MY∫Ì∑¢¿Ë;

public class Player {
	String card = "";
	int total = 0;

	public void setNum(int num) {
		total += num;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getCard() {
		return this.card;
	}
	public int getTotal() {
		return total;
	}
}
