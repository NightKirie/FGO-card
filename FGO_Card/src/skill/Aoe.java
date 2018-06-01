package skill;

import character.Assassin;

public class Aoe extends Skill {
	public static int ID = 1;
	public static int level = 1;

	public Aoe() {
		super.maxCD = 10;
		super.CD = maxCD;
	}

	public static void levelup() {
		if (Aoe.level < 5) {
			++Aoe.level;
		}
	}

	public void interact(Object object) {
		// object.hp -= Aoe.level;
		CD = maxCD;
	}
}
