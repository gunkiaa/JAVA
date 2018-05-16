package RPG;

import java.util.Random;

public class Play {
	String name = "P";
	int health = 100;
	int damage = 20;
	int level = 1;
	int posX = 0;
	int posY = 0;

	public Play(String name, int health, int damage) {
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

	public void setLevel() {

	}

	public int getLevel() {
		return level;
	}
}
