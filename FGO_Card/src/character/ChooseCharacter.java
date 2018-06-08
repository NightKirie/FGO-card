package character;

public class ChooseCharacter {
	public static int chooseID = 1;
	public static int CasterLevel = 1;
	public static int AssassinLevel = 1;
	public static int LancerLevel = 1;
	public static int CasterMaxHP;
	public static int AssassinMaxHP;
	public static int LancerMaxHP;
	
	public static int getID() {
		return ChooseCharacter.chooseID;
	}
	public static int getMaxHP() {
		if(ChooseCharacter.chooseID == 1) {
			ChooseCharacter.CasterMaxHP = 7 + ChooseCharacter.CasterLevel;
			return CasterMaxHP;
		}
		else if(ChooseCharacter.chooseID == 2) {
			ChooseCharacter.AssassinMaxHP = 7 + ChooseCharacter.AssassinLevel;
			return AssassinMaxHP;
		}
		else {
			ChooseCharacter.LancerMaxHP = 7 + ChooseCharacter.LancerLevel;
			return LancerMaxHP;
		}
	}
	public static void rightChooseCharacter() {
		ChooseCharacter.chooseID++;
		if(ChooseCharacter.chooseID > 3) {
			ChooseCharacter.chooseID = 1;
		}
		else if (ChooseCharacter.chooseID < 1) {
			ChooseCharacter.chooseID = 3;
		}
	}
	public static void leftChooseCharacter() {
		ChooseCharacter.chooseID--;
		if(ChooseCharacter.chooseID > 3) {
			ChooseCharacter.chooseID = 1;
		}
		else if (ChooseCharacter.chooseID < 1) {
			ChooseCharacter.chooseID = 3;
		}
	}
	public static void levelup() {
		if(ChooseCharacter.chooseID == 1 && ChooseCharacter.CasterLevel < 5) {
			ChooseCharacter.CasterLevel++;
		}
		else if(ChooseCharacter.chooseID == 1 && ChooseCharacter.AssassinLevel < 5) {
			ChooseCharacter.AssassinLevel++;
		}
		if(ChooseCharacter.chooseID == 1 && ChooseCharacter.LancerLevel < 5) {
			ChooseCharacter.LancerLevel++;
		}
	}
}
