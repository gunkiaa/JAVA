package RPG;

import java.net.StandardSocketOptions;
import java.time.temporal.IsoFields;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GamePlay {
	// 필드의 가로, 세로 길이
	public static final int field = 10;
	// 남아있는 전체 몹의 갯수를 나타내는 변수
	int mob_cnt = 10;
	// 플레이어 변수
	Gamer player;
	// 몹 타입의 변수, 삭제를 용이하게 하기 위해 LinkedList타입 사용
	List<Gamer> mob = new LinkedList<Gamer>();

	public GamePlay() {
		// 인스턴스 생성과 동시에 플레이어와 몹을 준비.
		settingObject();
	}

	// 맵의 Object를 준비하는 메소드
	private void settingObject() {
		// 플레이어의 이름, 체력, 공격력을 설정
		player = new Gamer("P", 100, 20);

		// 몹을 준비
		for (int i = 0; i < mob_cnt; i++) {
			// 몹의 기본 체력
			int health = 50;
			// 몹의 기본 공격력
			int damage = 10;
			// 몹의 X좌표를 나타내는 변수
			int posX = 0;
			// 몹의 Y좌표를 나타내는 변수
			int posY = 0;

			// 몹의 X좌표를 랜덤으로 설정해줌
			posX = getRandom(10);
			// 몹의 Y좌표를 랜덤으로 설정해줌
			posY = getRandom(10);

			// 게임 시작 시, 플레이어와 겹치면 안되므로 0,0에 위치하지 못 하도록 설정
			if (posX == 0 && posY == 0) {
				if (i == 0) {
					i = 0;
					continue;
				} else {
					i--;
					continue;
				}
			}
			// 몹의 기본 체력에 랜덤으로 0 ~ 50 사이의 값을 추가해줌.
			health += getRandom(51);
			// 몹의 기본 공격력에 랜덤으로 0 ~ 20 사이의 값을 추가해줌.
			damage += getRandom(21);

			// 몹의 이름, 체력, 공격력을 설정해줌.
			Gamer mo = new Gamer("M" + i, health, damage);
			// 몹의 X좌표를 설정
			mo.setPosX(posX);
			// 몹의 Y좌표를 설정
			mo.setPosY(posY);
			// List에 저장
			mob.add(mo);
		}
	}

	// 게임 시작을 담당할 메소드
	public void start() {
		// 입력을 받을 변수
		Scanner sc = new Scanner(System.in);
		// 몹을 2턴마다 움직이게 하기 위해 움직임을 담당할 변수.
		boolean isMove = false;
		while (true) {
			// 플레이아와 몹 or 몹과 몹 싸우고 있나?
			ifFight();

			// 맵 준비.
			showPosition();
			// 플레이어의 상태 표시.
			status();

			// 맵 상의 몹이 없는지 체크, 없으면 승리로 게임이 끝남.
			if (mob.isEmpty()) {
				System.out.println("모든 몹을 잡았으므로 승리하였습니다.");
				return;
			}
			// 이동할 방향을 입력.
			System.out.println("이동할 방향을 입력해주세요");
			System.out.println("w.↑ s.↓ a.← d.→");
			String di = sc.next();

			// 움직일 거리를 입력.
			System.out.println("이동할 거리를 입력해주세요");
			System.out.println("1.(1칸) 2.(2칸) 3.(3칸)");
			String st = sc.next();

			// String타입으로 입력 받았기 때문에 int형으로 형변환
			int st_num = Integer.parseInt(st);

			// 입력 받은 거리가 0보다 작거나 같다 or 입력 받은 거리가 3보다 크다
			// 일 경우에 continue로 반복문을 다시 시작.
			if (st_num <= 0 || st_num > 3) {
				System.out.println("1~3칸만 이동이 가능합니다");
				continue;
			}
			// 플레이어의 이동이 성공하면 1을 반환, 실패하면 0을 반환, 그 값을 받기 위한 변수.
			int plNum = 0;

			if (di.equals("w") || di.equals("ㅈ")) {
				// 위로 이동
				plNum = player.moveUp(st_num);
			} else if (di.equals("s") || di.equals("ㄴ")) {
				// 아래로 이동
				plNum = player.moveDown(st_num);
			} else if (di.equals("a") || di.equals("ㅁ")) {
				// 왼쪽으로 이동
				plNum = player.moveLeft(st_num);
			} else if (di.equals("d") || di.equals("ㅇ")) {
				// 오른쪽으로 이동
				plNum = player.moveRight(st_num);
			} else {
				// 상하좌우가 아닌 다른 값이 입력되었을 경우 반복문을 다시 시작.
				continue;
			}

			// 이동이 실패하였을 경우, 반복문을 다시 시작.
			if (plNum == 0) {
				System.out.println("이동 불가");
				System.out.println("다시 입력하세요.");
				continue;
			}
			// 몹이 움직여도 되나?
			if (isMove) {
				System.out.println("몹이 이동했어요");

				// 몹의 인덱스로 사용될 변수.
				int i = 0;
				// i가 mob_cnt보다 작을 동안.
				while (i < mob_cnt) {
					// 몹이 이동할 방향을 랜덤으로 받아옴 0 ~ 3
					int diRan = getRandom(4);
					// 랜덤으로 받은 값에 1을 더해줌 1, 2, 3, 4 이어야 하기 때문
					diRan += 1;
					// 몹이 이동할 거리를 랜덤으로 받아옴 0 ~ 2
					int stRan = getRandom(3);
					// 랜덤으로 받은 값에 1을 더해줌 1, 2, 3 이어야 하기 때문
					stRan += 1;

					if (diRan == 1) {
						// 위로 이동
						mob.get(i).moveUp(stRan);
					} else if (diRan == 2) {
						// 아래로 이동
						mob.get(i).moveDown(stRan);
					} else if (diRan == 3) {
						// 왼쪽으로 이동
						mob.get(i).moveLeft(stRan);
					} else if (diRan == 4) {
						// 오른쪽으로 이동
						mob.get(i).moveRight(stRan);
					}
					// 몹의 인덱스를 증가.
					i++;
				}
			} else {
				// 몹이 이동을 안할 경우
				System.out.println("몹이 쉬고 있어요");
			}
			// true를 false로 false를 true로
			isMove = !isMove;
		}
	}

	// 플레이어의 상태를 표시할 메소드
	public void status() {
		System.out.println("---------");
		System.out.println("이름:" + player.getName() + "   |");
		System.out.println("체력:" + player.getHealth() + " |");
		System.out.println("데미지:" + player.getDamage() + " |");
		System.out.println("레벨:" + player.getLevel() + "   |");
		System.out.println("경험치:" + player.getLevelPoint());
		System.out.println("---------");
	}

	// 맵을 표시할 메소드
	public void showPosition() {
		// 세로줄 갯수
		for (int i = 0; i < field; i++) {
			// 가로줄 갯수
			for (int j = 0; j < field; j++) {
				System.out.print("|");

				// 맵에 몹 표시를 위한 몹 갯수 변수
				int mobSpawn = 0;

				// mobSpawn이 mob_cnt보다 작을때까지
				while (mobSpawn < mob_cnt) {
					// 몹의 X좌표와 Y좌표가 같나?
					if (mob.get(mobSpawn).getPosX() == j && mob.get(mobSpawn).getPosY() == i) {
						// 맵에 몹 이름 표시
						System.out.print(mob.get(mobSpawn).getName());
						break;
					}
					// 다음 몹 표시를 위한 인덱스 증가
					mobSpawn++;
				}
				// 플레이어의 X좌표와 Y좌표가 같나?
				if (player.getPosX() == j && player.getPosY() == i) {
					// 플레이어의 이름 표시
					System.out.print(player.getName() + " ");

					// 플레이어도 없고, 몹도 없을 시
				} else if (mobSpawn == mob_cnt) {
					System.out.print("□ ");
				}
				System.out.print("|");
			}
			System.out.println("");
		}
	}

	// 싸움을 처리할 메소드
	public void ifFight() {
		// 공격을 할 몹의 인덱스 i
		for (int i = 0; i < mob_cnt; i++) {
			// 공격을 받는 몹의 인덱스 j
			for (int j = i + 1; j < mob_cnt; j++) {
				// i번째 몹의 X좌표와 Y좌표가 동일한가?
				if (mob.get(i).getPosX() == mob.get(j).getPosX() && mob.get(i).getPosY() == mob.get(j).getPosY()) {
					System.out.println(mob.get(i).getName() + "과" + mob.get(j).getName() + "이 싸웁니다");
					// 공격하고 맞음을 반복하기 위한 변수
					boolean isAttack = true;
					// i번째 몹이나 j번째 몹의 체력이 0 이하일 떄까지.
					while (mob.get(i).getHealth() > 0 || mob.get(j).getHealth() > 0) {
						// i번째 몹이 j번째 몹에게 공격.
						if (isAttack) {
							// j번째 몹의 체력과 i번째 몹의 공격력을 뺀 후 그 값을 j번째 몹의 체력으로 설정해준다.
							mob.get(j).setHealth(mob.get(j).getHealth() - mob.get(i).getDamage());

							// j번째 몹의 체력이 0보다 작나?
							if (mob.get(j).getHealth() <= 0) {
								System.out.println(mob.get(i).getName() + "가 " + mob.get(j).getName() + "을 잡았습니다.");

								mob.remove(j);
								// j번째 몹을 쓰러트렸으므로 i번째 몹의 경험치를 올려준다.
								System.out.println(mob.get(i).getName() + "는 레벨업합니다.");
								mob.get(i).setLevelPoint(2);
								// 전체 몹의 갯수를 줄여줌.
								mob_cnt--;

								return;
							}
							// j번째 몹이 i번째 몹에게 공격
						} else {
							// i번째 몹의 체력에 j번째 몹의 공격력을 뺀 후 그 값을 i번째 몹의 체력으로 설정해준다.
							mob.get(i).setHealth(mob.get(i).getHealth() - mob.get(j).getDamage());
							// i번째 몹의 체력이 0보다 작나?
							if (mob.get(i).getHealth() <= 0) {
								System.out.println(mob.get(j).getName() + "가 " + mob.get(i).getName() + "을 잡았습니다.");
								// i번째 몹을 삭제
								System.out.println(mob.get(i).getName() + "는 삭제됩니다.");
								mob.remove(i);
								// i번째 몹을 쓰러트렸으므로 j번째 몹의 경험치를 올려준다.
								System.out.println(mob.get(j - 1).getName() + "는 레벨업합니다.");
								mob.get(j - 1).setLevelPoint(2);
								// 전체 몹의 갯수를 줄여줌.
								mob_cnt--;

								return;
							}
						}
						// true를 false로 false를 true로
						isAttack = !isAttack;

					}
				}
			}
			// 플레이어의 X좌표와 몹의 Y좌표가 같나?
			if (player.getPosX() == mob.get(i).getPosX() && player.getPosY() == mob.get(i).getPosY()) {
				System.out.println("싸웁니다");

				// 공격하고 맞음을 반복하기 위한 변수
				boolean isAttack = true;

				// 몹의 체력이 0 이거나, 플레이어의 체력이 0 이하일 때까지
				while (mob.get(i).getHealth() > 0 || player.getHealth() > 0) {
					// isAttack가 true인가?
					if (isAttack) {
						System.out.println(mob.get(i).getName() + "에게 피해:" + "-" + player.getDamage());
						// i번째 몹의 체력에 플레이어의 공격력을 뺀후 i번째 몹의 체력으로 설정.
						mob.get(i).setHealth(mob.get(i).getHealth() - player.getDamage());
						// 몹의 체력이 0 이하인가?
						if (mob.get(i).getHealth() <= 0) {
							System.out.println("몹을 잡았습니다.");
							// i번째 몹을 삭제
							mob.remove(i);
							// 몹을 잡았으므로 플레이어의 경험치를 상승
							player.setLevelPoint(2);
							// 몹의 갯수를 감소
							mob_cnt--;
							return;
						}
					} else {
						System.out.println(player.getName() + "에게 피해:" + "-" + mob.get(i).getDamage());
						// 플레이어의 체력에 몹의 공격력을 뺀 후 플레이어의 체력으로 설정
						player.setHealth(player.getHealth() - mob.get(i).getDamage());
						// 플레이어의 체력이 0 이하인가?
						if (player.getHealth() <= 0) {
							System.out.println("죽었습니다. 게임 오버!!");
							// 플레이어가 죽었으므로 게임 종료
							System.exit(0);
						}
					}
					// true를 false로 false를 true로
					isAttack = !isAttack;
				}
			}
		}
	}

	public void player(Gamer player1, Gamer player2) {

	}

	// 랜덤값을 받아오기 위한 메소드
	private int getRandom(int num) {
		Random rd = new Random();
		return rd.nextInt(num);
	}
}