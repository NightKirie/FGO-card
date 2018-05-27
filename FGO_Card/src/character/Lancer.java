package character;

public class Lancer extends Character {
	public static int level = 1;
	public static int ID = 3;

	public Lancer() {
		super.maxHP = 9 + Lancer.level;
		super.HP = maxHP;
	}

	public void interact(int itemID) {
		// TODO Auto-generated method stub

	}
}
