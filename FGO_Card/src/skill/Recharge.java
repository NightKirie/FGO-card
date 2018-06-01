package skill;


public class Recharge extends Skill {
	public static int ID = 3;
	public static int level = 1;

	public Recharge() {
		super.maxCD = 12;
		super.CD = maxCD;
	}
	
	public static void levelup() {
		if(Recharge.level < 5) {
			++Recharge.level;
		}
	}

	public void interact(Skill skill) {
		skill.CD = skill.CD - Recharge.level;
		if(skill.CD < 0) {
			skill.CD = 0;
		}
		CD = maxCD;
		
	}
}
