package ∫Ì∑¢¿Ë;

import java.util.Scanner;
import java.util.Random;

public class BlackJack {
	private enum CardMarked {
		HEARTS, SPADES, CLOVERS, DIAMONDS
	}

	private enum CardNum {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	CardMarked mark;
	CardNum num;

	private int cardNum;
	private int cardMark;

	private int point;
	private int totalPoint = 0;

	Random generator = new Random();

	public BlackJack() {

	}

	public void generatorRandom() {
		cardMark = generator.nextInt(4); // 0~4
		cardNum = generator.nextInt(13) + 1; // 1~13

	}

	public void cardMarked() {
		switch (cardMark) {

		case 0:
			mark = CardMarked.CLOVERS;
			break;

		case 1:
			mark = CardMarked.HEARTS;
			break;

		case 2:
			mark = CardMarked.DIAMONDS;
			break;

		case 3:
			mark = CardMarked.SPADES;
			break;

		}
		switch (cardNum) {

		case 1:
			num = CardNum.ACE;
			point = 11;
			break;

		case 2:
			num = CardNum.TWO;
			point = cardNum;
			break;

		case 3:
			num = CardNum.THREE;
			point = cardNum;
			break;

		case 4:
			num = CardNum.FOUR;
			point = cardNum;
			break;

		case 5:
			num = CardNum.FIVE;
			point = cardNum;
			break;

		case 6:
			num = CardNum.SIX;
			point = cardNum;
			break;

		case 7:
			num = CardNum.SEVEN;
			point = cardNum;
			break;

		case 8:
			num = CardNum.EIGHT;
			point = cardNum;
			break;

		case 9:
			num = CardNum.NINE;
			point = cardNum;
			break;

		case 10:
			num = CardNum.TEN;
			point = cardNum;
			break;

		case 11:
			num = CardNum.JACK;
			point = 10;
			break;

		case 12:
			num = CardNum.QUEEN;
			point = 10;
			break;

		case 13:
			num = CardNum.KING;
			point = 10;
			break;

		}

	}

	public void setPoint() {

		totalPoint = totalPoint + point;

	}

	public int getPoint() {

		return totalPoint;
	}

	public void display() {

		System.out.println(num + " of " + mark);

	}
}