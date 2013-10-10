package TextBaseRPG;

import java.util.Random;

public class Monster extends Alive {
	private static final int VARIABLE_MONSTER_DAMAGE = 10;
	private static final int VARIABLE_MONSTER_HEALTH = 250;
	private static final String names [] = {"Bobbles", "Sartrous", "Pickles"};
	
	int maxDamageMonster = 30;
	int dammageDoneToMonster = 0;
	String name = "monster";
	
	public Monster(int boost, int level){
		Random random = new Random();
		health = (1000 + random.nextInt(VARIABLE_MONSTER_HEALTH) + boost)*level;
		damage = (10 + random.nextInt(VARIABLE_MONSTER_DAMAGE))*level;
	}
		/*
		int pickName = random.nextInt(names.length)-1;
		name = names[pickName];
		this.level = level;
	}
*/
	@Override
	public String getName() {
		return name;
	}

}
