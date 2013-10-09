package TextBaseRPG;

import java.util.Random;

public class Alive {
	public int health;
	public int mana;

	public int attack(int weaponSize) {
		int ret = new Random().nextInt(weaponSize);
		health -= ret;
		return ret;
	}

	public int heal(int healSize) {
		int ret = new Random().nextInt(healSize);
		health += ret;
		return ret;
	}
}
