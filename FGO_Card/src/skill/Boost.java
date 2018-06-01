package skill;

public class Boost extends Skill {
	public static int ID = 2;
	public static int level = 1;

	public Boost() {
		super.maxCD = 8;
		super.CD = maxCD;
	}

	public static void levelup() {
		if(Boost.level < 5) {
			++Boost.level;
		}
	}
	
	public void interact(Object object) {
		// TODO Auto-generated method stub
		//object.weaponHP += 3 + Boost.level;
		CD = maxCD;
	}
}
