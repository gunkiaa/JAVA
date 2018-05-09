package MY∫Ì∑¢¿Ë;

public class Player {
	int total = 0;
	
	public void setNum(int num) {
		total += num;
	}
	public void setCard(Card card) {
		total += card.getCardNum();
	}
	public int getTotal() {
		return total;
	}
}
