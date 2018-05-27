package skill;

public class Aoe extends Skill {
	public static int ID = 1;
	public static int level = 1;

	public Aoe() {
		super.maxCD = 10;
		super.CD = maxCD;
	}

	public void interact() {
		// TODO Auto-generated method stub
		CD = maxCD;
	}
}
