package RPG;

import java.util.Random;

public class Gamer {
	String name = "";
	int health = 100;
	int damage = 20;
	int level = 1;
	int posX = 0;
	int posY = 0;
	int levelPoint;

	public Gamer(String name, int health, int damage) {
		this.name = name;
		this.health = health;
		this.damage = damage;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public int getHealth() {
		// TODO Auto-generated method stub
		return health;
	}

	public void setHealth(int health) {
		// TODO Auto-generated method stub
		this.health = health;
	}

	public int getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}

	public void setDamage(int damage) {
		// TODO Auto-generated method stub
		this.damage = damage;
	}

	public int getPosX() {
		// TODO Auto-generated method stub
		return posX;
	}

	public void setPosX(int posX) {
		// TODO Auto-generated method stub
		this.posX = posX;
	}

	public int getPosY() {
		// TODO Auto-generated method stub
		return posY;
	}

	public void setPosY(int posY) {
		// TODO Auto-generated method stub
		this.posY = posY;
	}

	public void setLevel(int levelPoint) {
		ifLevelUp(levelPoint);
	}

	public int getLevel() {
		return level;
	}

	private void ifLevelUp(int point) {
		System.out.println("축하합니다! 레벨업을 하였습니다.");
		if (point == level + 1) {
			level += 1;
			this.levelPoint += point - (level + 1);
			this.health = 100;
			damage += 10;
		}
	}
}
