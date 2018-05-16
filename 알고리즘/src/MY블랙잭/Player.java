package MYºí·¢Àè;

import java.util.ArrayList;
import java.util.List;

public class Player {
	int total = 0;
	List<String> myCard = new ArrayList<String>();

	public void setNum(int num) {
		total += num;
	}

	public void setCard(Card card) {
		total += card.getCardNum();
		myCard.add(card.getCard());
	}
	public List<String> getCard(){
		return myCard;
	}
	public int getTotal() {
		return total;
	}
}
