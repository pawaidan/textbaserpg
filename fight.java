package TextBaseRPG;

import java.util.Random;
import java.util.Scanner;

public class Fight {

	public static void main(String[] args) {
		Player player = new Player();
		Monster monster = new Monster();
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		int choice2 = 0;
		int choice3 = 0;
		int money = 0;
		int levelOfMonster = 1;
		int weaponMax = 30;
		int weapon = random.nextInt(weaponMax) + 10;
		int price = weapon * 100 / 5;
		int weaponMax1 = 30;
		int weapon1 = random.nextInt(weaponMax1) + 30;
		int price1 = weapon * 100 / 4;
		int weaponMax2 = 60;
		int weapon2 = random.nextInt(weaponMax2) + 60;
		int price2 = weapon * 100 / 3;
		int weaponMax3 = 120;
		int weapon3 = random.nextInt(weaponMax3) + 120;
		int price3 = weapon * 100 / 2;
		int weaponMax4 = 240;
		int weapon4 = random.nextInt(weaponMax4) + 240;
		int price4 = weapon * 100;
		int price5 = 500;
		int price6 = 250;
		int weaponcombined = 0;
		int RandomHealthMax = 250;
		int RandomDammageMax = 5;
		int boost = 0;
		int playerBaseHeal = 100;
		int playerRandomHeal = 250;
		int Xp = 0;
		int XpInTillLevel = 1000;
		int playerLevel = 0;
		int LevelBonusBaseHeal = 4 * playerLevel;
		int LevelBonusRandomHeal = 10 * playerLevel;
		int LevelBonusDammage = 4 * playerLevel;
		player.health = 250;
		monster.health = 1000 + random.nextInt(RandomHealthMax) + boost;
		int monsterDammage = 10 + random.nextInt(RandomDammageMax);

		System.out.println("welcome to Text Based RPG");
		System.out.println("watch out if you die ");
		System.out
				.println("you lose all your money and 10% of your wepon dammage :(");
		System.out
				.println("also the monsters gain health every time you beat one");
		System.out.println("your ultiment goal is to beat the supper boss :D");
		System.out
				.println("if you don't have enough to heal the monster will get away :(");
		// the supper boss is not implemented yet :3
		System.out.println("make sure to heal :3");

		for (int i = 0; i < 100; i++) {
			if (Xp > XpInTillLevel) {
				Xp -= XpInTillLevel;
				playerLevel += 1;
				XpInTillLevel += (1.1 * XpInTillLevel);
			}

			if (player.health < 0) {
				System.out.println("You died you loss all your money :(");
				System.out
						.println("and also the monster has now been change beging boost one");
				System.out
						.println("all your Xp has been reset but you keep your levels");
				System.out.println("good luck");
				Xp -= Xp;
				money -= money;
				weaponcombined -= (0.1 * weaponcombined);
				boost -= boost;
				player.health += 250;
				monster.health = 0;
				monster.health += 1000 + random.nextInt(RandomHealthMax)
						+ boost;
				;
				monsterDammage = 0;
				monsterDammage += 10 + random.nextInt(RandomDammageMax);
				levelOfMonster -= levelOfMonster;
				levelOfMonster += 1;

			}

			System.out.println("your health is :D "
					+ Integer.toString(player.health));
			System.out.println("the monsters health is "
					+ Integer.toString(monster.health));
			System.out.println("you have $" + money);
			System.out.println("1 to Attack");
			System.out
					.println("2 to Heal it costs 25 for 0 to 250 hp amd with 100 garentied :3");
			// this is asking what you want to do attack or heal at the
			// price of
			// money if you want to heal
			choice = scanner.nextInt();
			// attacking
			if (choice == 1) {
				System.out.println("Attacking");
				int amountHit = monster.attack(100) + weaponcombined
						+ LevelBonusDammage;
				System.out.println("Attacked Monster for "
						+ Integer.toString(amountHit));
				// healing
			}
			if (choice == 2) {
				// nothing will happen if you do not have enough money
				if (money > 25) {
					System.out.println("Healing");
					int amountHeal = player.heal(playerRandomHeal)
							+ playerBaseHeal + LevelBonusBaseHeal
							+ player.heal(LevelBonusRandomHeal);
					System.out.println("Healed self for "
							+ Integer.toString(amountHeal));
				}
				if (money < 25) {
					System.out.println("you do not have enough money");
				}

			}
			int amountHit = player.attack(monsterDammage);
			System.out.println("PLayer hit by monster for "
					+ Integer.toString(amountHit));

			if (monster.health < 0) {
				if (levelOfMonster > 19) {
					System.out.println("you win :D the entire game :D");
				}
				if (levelOfMonster < 19) {
					System.out.println("you win the fight :3) "
							+ "your health is "
							+ Integer.toString(player.health));
					money += 100 * levelOfMonster;
					Xp += 100 * levelOfMonster;
					boost += 10;
					System.out.println("you now have $" + money);
					System.out.println("Type 1 to go to shop");
					System.out.println("Type 2 to go to fighting");
					choice = scanner.nextInt();
					if (choice == 1) {
						System.out.println("Shop");
						System.out.println("Your money is " + money);
						System.out
								.println("dont try to buy a wepon with out enough money or");
						System.out
								.println("you will be attacked and not gain any money either");
						System.out
								.println("but if you buy something you always fight a level 1 monster and take some dammage but not earn anything");

						System.out
								.println("options only show up if you have enough money");
						System.out.println("type 1 to buy this weapon "
								+ weapon + " The price is $" + price);
						System.out.println("type 2 to buy this weapon "
								+ weapon1 + " The price is $" + price1);
						System.out.println("type 3 to buy this weapon "
								+ weapon2 + " The price is $" + price2);
						System.out.println("type 4 to buy this weapon "
								+ weapon3 + " The price is $" + price3);
						System.out.println("type 5 to buy this weapon "
								+ weapon4 + " The price is $" + price4);
						System.out
								.println("type 6 to buy this +10 to base healing"
										+ " The price is $" + price5);
						System.out
								.println("type 7 to buy this +30 to random max healing"
										+ " The price is $" + price6);

						choice2 = scanner.nextInt();
						if (choice2 == 1) {
							if (money < price) {
								money -= 100 * levelOfMonster;
							}
							if (money > price) {
								weaponcombined += weapon;
								money -= price;
								System.out
										.println("your attack is now a bonus of "
												+ weaponcombined);
								price += (0.5 * price);
							}
						}
						if (choice2 == 2) {
							if (money < price1) {
								money -= 100 * levelOfMonster;

							}
							if (money > price1) {
								weaponcombined += weapon1;
								money -= price;
								System.out
										.println("your attack is now a bonus of "
												+ weaponcombined);
								price1 += (0.5 * price1);
							}

						}
						if (choice2 == 3) {
							if (money < price2) {
								money -= 100 * levelOfMonster;
							}
							if (money > price2) {
								weaponcombined += weapon2;
								money -= price2;
								System.out
										.println("your attack is now a bonus of "
												+ weaponcombined);
								price2 += (0.5 * price2);
							}

						}
						if (choice2 == 4) {
							if (money < price3) {
								money -= 100 * levelOfMonster;
							}
							if (money > price3) {
								weaponcombined += weapon3;
								money -= price3;
								System.out
										.println("your attack is now a bonus of "
												+ weaponcombined);
								price3 += (0.5 * price3);
							}

						}
						if (choice2 == 5) {
							if (money < price4) {
								money -= 100 * levelOfMonster;
							}
							if (money > price4) {
								weaponcombined += weapon4;
								money -= price4;
								System.out
										.println("your attack is now a bonus of "
												+ weaponcombined);
								price4 += (0.5 * price4);
							}
							if (choice2 == 6) {
								if (money < price5) {
									money -= 100 * levelOfMonster;
								}
								if (money > price5) {
									weaponcombined += weapon4;
									money -= price5;
									System.out.println("your base healing"
											+ playerBaseHeal);
									price5 += price5;
								}
								if (choice2 == 7) {
									if (money < price6) {
										money -= 100 * levelOfMonster;
									}
									if (money > price6) {
										weaponcombined += weapon4;
										money -= price6;
										System.out.println("your base healing"
												+ playerRandomHeal);
										price6 += price6;
									}
								}
							}
						}
					}
				}
			}
			if (choice == 2) {
				System.out.println("What level fight?");
				System.out.println("type from 1 to 10 fight normal battles");
				System.out.println("1 is weakest to level 10");
				System.out.println("type 20 to fight the ultimate boss");
				choice3 = scanner.nextInt();
				if (choice3 == 1) {
					monster.health = 0;
					monster.health += 1000 + random.nextInt(RandomHealthMax)
							+ boost;
					;
					monsterDammage = 0;
					monsterDammage += 10 + random.nextInt(RandomDammageMax);
					levelOfMonster -= levelOfMonster;
					levelOfMonster += 1;

				}
				if (choice3 == 2) {
					monster.health = 0;
					monster.health += (1000 * 2)
							+ (random.nextInt(RandomHealthMax) * 2)
							+ (boost * 2);
					monsterDammage = 0;
					monsterDammage += (10 * 2)
							+ (random.nextInt(RandomDammageMax) * 2);
					levelOfMonster -= levelOfMonster;
					levelOfMonster += 2;
				}
				if (choice3 == 3) {
					monster.health = 0;
					monster.health += (1000 * 3)
							+ (random.nextInt(RandomHealthMax) * 3)
							+ (boost * 3);
					monsterDammage = 0;
					monsterDammage += (10 * 3)
							+ (random.nextInt(RandomDammageMax) * 3);
					levelOfMonster -= levelOfMonster;
					levelOfMonster += 3;
				}
				if (choice3 == 4) {
					monster.health = 0;
					monster.health += (1000 * 4)
							+ (random.nextInt(RandomHealthMax) * 4)
							+ (boost * 4);
					monsterDammage = 0;
					monsterDammage += (10 * 4)
							+ (random.nextInt(RandomDammageMax) * 4);
					levelOfMonster -= levelOfMonster;
					levelOfMonster += 4;
				}
				if (choice3 == 5) {
					monster.health = 0;
					monster.health += (1000 * 5)
							+ (random.nextInt(RandomHealthMax) * 5)
							+ (boost * 5);
					monsterDammage = 0;
					monsterDammage += (10 * 5)
							+ (random.nextInt(RandomDammageMax) * 5);
					levelOfMonster -= levelOfMonster;
					levelOfMonster += 5;
				}
				if (choice3 == 6) {
					monster.health = 0;
					monster.health += (1000 * 6)
							+ (random.nextInt(RandomHealthMax) * 6)
							+ (boost * 6);
					monsterDammage = 0;
					monsterDammage += (10 * 6)
							+ (random.nextInt(RandomDammageMax) * 6);
					levelOfMonster -= levelOfMonster;
					levelOfMonster += 6;
				}
				if (choice3 == 7) {
					monster.health = 0;
					monster.health += (1000 * 7)
							+ (random.nextInt(RandomHealthMax) * 7)
							+ (boost * 7);
					monsterDammage = 0;
					monsterDammage += (10 * 7)
							+ (random.nextInt(RandomDammageMax) * 7);
					levelOfMonster -= levelOfMonster;
					levelOfMonster += 7;
				}
				if (choice3 == 8) {
					monster.health = 0;
					monster.health += (1000 * 8)
							+ (random.nextInt(RandomHealthMax) * 8)
							+ (boost * 8);
					monsterDammage = 0;
					monsterDammage += (10 * 8)
							+ (random.nextInt(RandomDammageMax) * 8);
					levelOfMonster -= levelOfMonster;
					levelOfMonster += 8;
				}
				if (choice3 == 9) {
					monster.health = 0;
					monster.health += (1000 * 9)
							+ (random.nextInt(RandomHealthMax) * 9)
							+ (boost * 9);
					monsterDammage = 0;
					monsterDammage += (10 * 9)
							+ (random.nextInt(RandomDammageMax) * 9);
					levelOfMonster -= levelOfMonster;
					levelOfMonster += 9;
				}
				if (choice3 == 10) {
					monster.health = 0;
					monster.health += (1000 * 10)
							+ (random.nextInt(RandomHealthMax) * 10)
							+ (boost * 10);
					monsterDammage = 0;
					monsterDammage += (10 * 10)
							+ (random.nextInt(RandomDammageMax) * 10);
					levelOfMonster -= levelOfMonster;
					levelOfMonster += 10;
				}

				if (choice3 == 20) {
					monster.health = 0;
					monster.health += (1000 * 20)
							+ (random.nextInt(RandomHealthMax) * 20)
							+ (boost * 20);
					monsterDammage = 0;
					monsterDammage += (10 * 20)
							+ (random.nextInt(RandomDammageMax) * 20);
					levelOfMonster -= levelOfMonster;
					levelOfMonster += 20;

				}
			}

		}
	}
}
