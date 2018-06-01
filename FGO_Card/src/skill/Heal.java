package skill;
import character.Character;

public class Heal extends Skill {
	public static int ID = 4;
	public static int level = 1;

	public Heal() {
		super.maxCD = 10;
		super.CD = maxCD;
	}

	public static void levelup() {
		if(Heal.level < 5) {
			++Heal.level;
		}
	}
	
	public void interact(Character character) {
		character.HP += 2*Heal.level;
		if(character.HP > character.maxHP)
			character.HP  = character.maxHP;
		CD = maxCD;
	}
}
