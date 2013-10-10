package TextBaseRPG;

import java.util.Random;

public abstract class Alive {
	static Random random = new Random();

	public int health;
	public int mana;
	public int money;
	public int weapon = 0;
	public int damage = 1;
	public int level = 1; 
	
	
	public abstract String getName();

	public void attack(Alive target) {
		int hitDamage = random.nextInt(damage);
		if(weapon>0)
			hitDamage += random.nextInt(weapon);
		System.out.println(this.getName().substring(0,1).toUpperCase() + this.getName().substring(1) + " attacks " + target.getName() + " for " + hitDamage + " damage.");
		System.out.println("");
		target.health -= hitDamage; 
	}

	public int heal(int healSize) {
		int ret = new Random().nextInt(healSize);
		health += ret;
		return ret;
	}
}
