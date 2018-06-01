package character;

public class Character {
	/*
	 * �o��class�O�D�n������class�A�U�Ө���class�[���ۤv��interact function �M�ۤv��ID,level �U�誺static ID
	 * ��ܨϥΪ̿�ܤF���@��^�F �b�i�J�C���ɡA�ݭn�ϥΤU�誺createCharacter �ӳгy�@��character object
	 * createCharacter �|�̾�characterID �Ӧ^�Ǥ��P���^�Fclass
	 */
	public static int ID = 1;

	public void interact(int itemID) {
	}

	public int HP;
	public int maxHP;

	public static int getID() {
		return ID;
	}

	public int getHP() {
		return HP;
	}

	public int getmaxHP() {
		return maxHP;
	}

	public void setHP(int sethp) {
		HP = sethp;
	}

	public void setmaxHP(int setmaxhp) {
		maxHP = setmaxhp;
	}

	public static Character createCharacter(int characterID) {
		switch (characterID) {
		case 1:
			return (Character) new Caster();
		case 2:
			return (Character) new Assassin();
		case 3:
			return (Character) new Lancer();
		default:
			return (Character) new Caster();
		}
	}
}
