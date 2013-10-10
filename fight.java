package TextBaseRPG;

import java.util.Random;
import java.util.Scanner;

public class Fight {

	public static void main(String[] args) {
		Player player = new Player();
		Monster monster = new Monster(0, 1);
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		int choice2 = 1;
		int choiceEndlis = 0;
		int boost = 0;
		int hitMiss = 0;
		player.damage = 100;

		player.health = 300;

		System.out.println("welcome to Text Based RPG");
		System.out.println("watch out if you die ");
		System.out
				.println("you lose all your money and 10% of your wepon dammage :(");
		System.out
				.println("also the monsters gain health every time you beat one");
		System.out.println("your ultiment goal is to beat the supper boss :D");
		System.out.println("make sure to heal :3");
		System.out.println("");
		System.out.println("");

		while (true) {

			if (player.health < 0) {
				System.out.println("You died you loss all your money :(");
				System.out
						.println("and also the monster has now been change beging boost one");
				System.out
						.println("all your Xp has been reset but you keep your levels");
				System.out.println("good luck");
				System.out.println("");
				System.out.println("");
				player.money -= player.money;
				boost -= boost;
				player.health += 250;
				choice2 -= choice2;
				choice2 += 1;
				monster = new Monster(boost, 1);
			}

			System.out.println("your health is :D "
					+ Integer.toString(player.health)); 
			System.out.println("your level is " + player.level);
			System.out.println("the monsters health is "
					+ Integer.toString(monster.health));
			System.out.println("you have $" + player.money);
			System.out.println("1 to Attack");
			System.out
					.println("2 to Heal it costs 25 for 0 to 250 hp amd with 100 garentied :3");
			System.out
					.println("3 to dubble attack watch out you might miss :3");
			System.out.println("4 to triple attack");
			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Attacking");
				player.attack(monster);
			}
			if (choice == 3) {
				hitMiss = random.nextInt(100);
				if (hitMiss < 40) {
					System.out.println("you missed :(");
				}
			
			if (hitMiss > 40) {
				System.out.println("Dubble Hit");
				player.attack(monster);
				player.attack(monster);
			}
			}
			if (choice == 4) {
				hitMiss = random.nextInt(100);
				if (hitMiss < 60) {
					System.out.println("you missed :(");
				}
				if (hitMiss > 60) {
					System.out.println("Triple hit Hit");
					player.attack(monster);
					player.attack(monster);
					player.attack(monster);
				}
			}

			if (choice == 2) {
				if (player.money > 24) {
					player.heal();
				}
				if (player.money < 24) {
					System.out.println("you do not have enough money");
				}

			}
			monster.attack(player);

			if (monster.health < 0) {
				player.money += (choice2 * 100);
				player.Xp += monster.level * 100;
				if (player.Xp > player.XpInTillLevel) {
					player.levelUp();
				}
				if (monster.level > 100) {
					System.out.println("you win :D the entire game :D");
					System.out.println("1 to end game 2 to contiue game");
					choiceEndlis = scanner.nextInt();
					if (choiceEndlis == 1) {
						break;
					}
					if (choiceEndlis == 2) {

					}
				}

				if (monster.level < 99) {
					System.out.println("you win the fight :3) "
							+ "your health is "
							+ Integer.toString(player.health));
					player.XpStats();
					boost += 10;
				}
				new Shop().useShop(scanner, player);
				System.out.println("What level fight?");
				System.out.println("type from 1 to 10 fight normal battles");
				System.out.println("1 is weakest to level 99");
				System.out
						.println("beat anything above level 100 and you will win :D");
				choice2 = scanner.nextInt();
				monster = new Monster(boost, choice2);

			}

		}
	}
}
