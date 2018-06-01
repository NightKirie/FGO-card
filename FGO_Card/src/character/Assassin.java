package character;

public class Assassin extends Character {
	public static int level = 1;
	public static int ID = 2;

	public Assassin() {
		super.maxHP = 5 + Assassin.level;
		super.HP = maxHP;
	}
	
	public void levelup() {
		if(Assassin.level < 5) {
			++Assassin.level;
		}
	}

	public void interact(int itemID) {
	}
}
