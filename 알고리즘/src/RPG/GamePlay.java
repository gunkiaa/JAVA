package RPG;

import java.net.StandardSocketOptions;
import java.time.temporal.IsoFields;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class GamePlay {
	Scanner sc = new Scanner(System.in);
	Player player;
	LinkedList<Mob> mob = new LinkedList<Mob>();

	public GamePlay() {
		settingObject();
	}

	private void settingObject() {
		player = new Player("P", 100, 20);
		for (int i = 0; i < 10; i++) {
			int health = getRandom(51);
			int damage = getRandom(11);
			health++;
			damage++;
			if (i < 9) {
				Mob mo = new Mob("M" + (i + 1), 50 + health, 10 + damage);
				mo.setPosX((getRandom(10)));
				mo.setPosY((getRandom(10)));
				mob.add(mo);
			} else {
				Mob mo = new Mob("MX", 50 + health, 10 + damage);
				mo.setPosX((getRandom(10)));
				mo.setPosY((getRandom(10)));
				mob.add(mo);
			}
		}
	}

	public void start() {
		boolean isMove = false;
		while (true) {
			showPosition();
			status();
			System.out.println("이동할 방향을 입력해주세요");
			System.out.println("1.↑ 2.↓ 3.← 4.→");
			String di = sc.next();
			System.out.println("이동할 거리를 입력해주세요");
			System.out.println("1.(1칸) 2.(2칸) 3.(3칸)");
			String st = sc.next();
			int st_num = Integer.parseInt(st);
			if (st_num <= 0 || st_num > 3) {
				System.out.println("1~3칸만 이동이 가능합니다");
				continue;
			}
			int plNum = 0;
			if (di.equals("1")) {
				plNum = player.moveUp(st_num);
			} else if (di.equals("2")) {
				plNum = player.moveDown(st_num);
			} else if (di.equals("3")) {
				plNum = player.moveLeft(st_num);
			} else if (di.equals("4")) {
				plNum = player.moveRight(st_num);
			} else {
				continue;
			}

			if (plNum == 0) {
				System.out.println("이동 불가");
				System.out.println("다시 입력하세요.");
				continue;
			}
			if (isMove) {
				System.out.println("몹이 이동했어요");
				int i = 0;
				while (i < 10) {
					int diRan = getRandom(4);
					diRan += 1;
					int stRan = getRandom(3);
					stRan += 1;

					if (diRan == 1) {
						mob.get(i).moveUp(stRan);
					} else if (diRan == 2) {
						mob.get(i).moveDown(stRan);
					} else if (diRan == 3) {
						mob.get(i).moveLeft(stRan);
					} else if (diRan == 4) {
						mob.get(i).moveRight(stRan);
					}
					i++;
				}
			} else {
				System.out.println("몹이 쉬고 있어요");
			}
			ifFight();
			isMove = !isMove;
			System.out.println(player.getPosX() + "," + player.getPosY());
			System.out.println(mob.get(4).getName() + "," + mob.get(4).getPosX() + "," + mob.get(4).getPosY());
		}
	}

	public void status() {
		System.out.println("---------");
		System.out.println("이름:" + player.getName() + "   |");
		System.out.println("체력:" + player.getHealth() + " |");
		System.out.println("데미지:" + player.getDamage() + " |");
		System.out.println("레벨:" + player.getLevel() + "   |");
		System.out.println("---------");
	}

	public void showPosition() {
		System.out.println("-------------던전 스트라이커---------------");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print("|");
				int t = 0;
				while (t < 10) {
					if (mob.get(t).getPosX() == j && mob.get(t).getPosY() == i) {
						System.out.print(mob.get(t).getName());
						break;
					}
					t++;
				}
				if (player.getPosX() == j && player.getPosY() == i) {
					System.out.print(player.getName() + " ");
				} else if (t == 10) {
					System.out.print("□ ");
				}
				System.out.print("|");
			}
			System.out.println("");
		}
		System.out.println("---------------------------------------");
	}

	public void ifFight() {
		for (int i = 0; i < 10; i++) {
			if (player.getPosX() == mob.get(i).getPosY() && player.getPosY() == mob.get(i).getPosX()) {
				boolean isAttack = true;
				if (isAttack) {
					mob.get(i).setHealth(mob.get(i).getHealth() - player.getDamage());
				} else {
					player.setHealth(player.getHealth() - mob.get(i).getDamage());
				}
				isAttack = !isAttack;
				if (mob.get(i).getHealth() <= 0) {
					System.out.println("몹을 잡았습니다.");
				}
			}
		}
	}

	private int getRandom(int num) {
		Random rd = new Random();
		return rd.nextInt(num);
	}
}