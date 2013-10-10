package TextBaseRPG;

import java.util.Random;
import java.util.Scanner;

public class Shop {
	int price[], weapon[];

	public Shop() {
		Random random = new Random();
		int maxWeapons = 5;
		price = new int[maxWeapons];
		weapon = new int[maxWeapons];
		int weaponMax = 30;
		for (int i = 0; i < maxWeapons; i++) {
			weapon[i] = random.nextInt(weaponMax) + 10;
			price[i] = weapon[i] * 100 / (maxWeapons - i);
			weaponMax *= 2;
		}
	}

	public void useShop(Scanner scanner, Player player) {

		System.out.println("you now have $" + player.money);

		System.out.println("Shop");
		System.out.println("Your money is " + player.money);
		System.out.println("dont try to buy a wepon with out enough money or");
		System.out
				.println("you will be attacked and not gain any money either");
		System.out
				.println("but if you buy something you always fight a level 1 monster and take some dammage but not earn anything");
		System.out.println("type 0 to leave the store");

		for (int i = 0; i < price.length; i++) {
			System.out.println("type " + (i + 1) + " to buy this weapon "
					+ weapon[i] + " The price is $" + price[i]);
		}

		int choice = scanner.nextInt();
		if (choice < price.length) {
			if (player.money < price[choice])
				System.out.println("You don't have the money.");
			if (player.money > price[choice]) {
				player.weapon += weapon[choice];
				player.money -= price[choice];
				System.out.println("your attack is now a bonus of "
						+ player.weapon);
			}
		}

	}

}
