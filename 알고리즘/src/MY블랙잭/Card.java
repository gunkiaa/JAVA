package MYºí·¢Àè;

public class Card {
	int cardNum = 0;
	String card = "";

	public int getCardNum() {
		return cardNum;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
		replace();
	}

	public void replace() {
		String val = card.replaceAll("¢¼", "").replaceAll("¢À", "").replaceAll("¢¾", "").replaceAll("¢Â", "");
		if (val.equals("K") || val.equals("Q") || val.equals("J")) {
			cardNum = 10;
			return;
		} else if (val.equals("A")) {
			cardNum = 11;
			return;
		}
		cardNum = Integer.parseInt(val);
	}
}
