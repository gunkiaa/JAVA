package RPG;

import java.util.Random;

public class Gamer {
	// 이름
	String name = "";
	// 체력
	int health = 100;
	// 공격력
	int damage = 20;
	// 레벨
	int level = 1;
	// X좌표
	int posX = 0;
	// Y좌표
	int posY = 0;
	// 경험치
	int levelPoint;
	// 처음의 입력 받은 기본 체력
	int health_default = 0;

	// 이름, 체력, 공격력을 초기화
	public Gamer(String name, int health, int damage) {
		health_default = health;
		this.name = name;
		this.health = health;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setLevelPoint(int levelPoint) {
		this.levelPoint += levelPoint;
		ifLevelUp();
	}

	public int getLevel() {
		return level;
	}

	public int getLevelPoint() {
		return levelPoint;
	}

	private void ifLevelUp() {
		if (levelPoint >= level + 1) {
			System.out.println("레벨업을 하였습니다.");
			this.levelPoint -= (level + 1);
			level += 1;
			health_default += 10;
			health = health_default;
			damage += 3;
		}
	}

	public int moveLeft(int st) {
		int result = 0;
		if (posX > 0 && posX - st >= 0) {
			heal();
			posX -= st;
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	public int moveRight(int st) {
		int result = 0;
		if (posX < GamePlay.field-1 && posX + st < GamePlay.field) {
			heal();
			posX += st;
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	public int moveDown(int st) {
		int result = 0;
		if (posY < GamePlay.field-1 && posY + st < GamePlay.field) {
			heal();
			posY += st;
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	public int moveUp(int st) {
		int result = 0;
		if (posY >= 0 && posY - st >= 0) {
			heal();
			posY -= st;

			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	private void heal() {
		if (health < 100) {
			health += 2;
		}
	}
}
