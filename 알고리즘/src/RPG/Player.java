package RPG;

public class Player extends Gamer {

	public Player(String name, int health, int damage) {
		super(name, health, damage);
	}

	public int moveLeft(int st) {
		if (posX > 0 && posX - st >= 0) {
			posX -= st;
			return 1;
		} else {
			return 0;
		}
	}

	public int moveRight(int st) {
		if (posX < 9 && posX + st < 10) {
			posX += st;
			return 1;
		} else {
			return 0;
		}
	}

	public int moveDown(int st) {
		if (posY < 9 && posY + st < 10) {
			posY += st;
			return 1;
		} else {
			return 0;
		}
	}

	public int moveUp(int st) {
		if (posY >= 0 && posY - st >= 0) {
			posY -= st;
			return 1;
		} else {
			return 0;
		}
	}
}
