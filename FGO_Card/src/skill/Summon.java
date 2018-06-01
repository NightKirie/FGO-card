package skill;

public class Summon extends Skill {
	public static int ID = 5;
	public static int level = 1;

	public Summon() {
		super.maxCD = 15;
		super.CD = maxCD;
	}

	public static void levelup() {
		if (Aoe.level < 5) {
			++Aoe.level;
		}
	}

	public void interact(Object object) {
		CD = maxCD;
	}
}
