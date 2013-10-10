package TextBaseRPG;

public class Player extends Alive {
	public int maxDamagePlayer = 100;
	public int dammageDoneToPlayer = 0;
	public int amountOfDamagePlayer = 0;
	public int playerLevel = 1;
	public int healthAdded = 0;
	public int Xp = 0;
	public int XpInTillLevel = 250;
	@Override
	public String getName() {
		return "you";
	}
	public void heal() {
		System.out.println("Healing");
		healthAdded = 100 + (playerLevel*10) + random.nextInt(playerLevel * 20) + random.nextInt(200);
		health += healthAdded;
		money -= 25;
		System.out.println("Healed self for "
				+ healthAdded);
		System.out.println("");
	}
	public void levelUp() {
		Xp -= XpInTillLevel;
		playerLevel += 1;
		XpInTillLevel += (1.2*XpInTillLevel);
		System.out.println("your level is " + level);
	}

public void XpStats() {
	System.out.println("you have " + Xp + "Xp");
	System.out.println("you level up in " + (XpInTillLevel - Xp));
	System.out.println("you are level " + playerLevel);
	System.out.println("you now have a bonus of");
	System.out.println("base healing bonus is"+(playerLevel*10));
	System.out.println("random healing bonus 0 to " + (playerLevel * 20));
}
}
