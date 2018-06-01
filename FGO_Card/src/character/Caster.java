package character;

public class Caster extends Character {
	public static int level = 1;
	public static int ID = 1;

	public Caster() {
		super.maxHP = 7 + Caster.level;
		super.HP = maxHP;
	}

	public void levelup() {
		if(Caster.level < 5) {
			++Caster.level;
		}
	}
	
	public void interact(int itemID) {

	}
}
