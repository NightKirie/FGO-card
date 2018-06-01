package character;

public class Character {
	/*
	 * 這個class是主要的角色class，各個角色class涵有自己的interact function 和自己的ID,level 下方的static ID
	 * 表示使用者選擇了哪一位英靈 在進入遊戲時，需要使用下方的createCharacter 來創造一個character object
	 * createCharacter 會依據characterID 來回傳不同的英靈class
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
