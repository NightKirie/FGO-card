package skill;

public class ChooseSkill {
	public static int chooseSkillID1 = 1;
	public static int chooseSkillID2 = 2;
	public static int chooseSkillID3 = 3;
	public static int chooseSkill1Level;
	public static int chooseSkill2Level;
	public static int chooseSkill3Level;
	public static int chooseSkill1MaxCD;
	public static int chooseSkill2MaxCD;
	public static int chooseSkill3MaxCD;
	public static int skill1Level = 1;
	public static int skill2Level = 1;
	public static int skill3Level = 1;
	public static int skill4Level = 1;
	public static int skill5Level = 1;
	
	//this partition is for battle
	public static int getChooseID1() {
		return chooseSkillID1;
	}
	public static int getChooseID2() {
		return chooseSkillID2;
	}
	public static int getChooseID3() {
		return chooseSkillID1;
	}
	
	public static int getCD(int ID){
		if(ID == 1) {
			return 10;
		}
		else if(ID == 2) {
			return 8;
		}
		else if(ID == 3) {
			return 12;
		}
		else if (ID == 4) {
			return 10;
		}
		else {
			return 15;
		}
	}
	
	public static int getChooseLevel1() {
		if(chooseSkillID1 == 1) {
			return skill1Level;
		}
		else if(chooseSkillID2 == 2) {
			return skill2Level;
		}
		else if(chooseSkillID3 == 3) {
			return skill3Level;
		}
		else if (chooseSkillID3 == 4) {
			return skill4Level;
		}
		else {
			return skill5Level;
		}
	}
	public static int getChooseLevel2() {
		if(chooseSkillID1 == 1) {
			return skill1Level;
		}
		else if(chooseSkillID2 == 2) {
			return skill2Level;
		}
		else if(chooseSkillID3 == 3) {
			return skill3Level;
		}
		else if (chooseSkillID3 == 4) {
			return skill4Level;
		}
		else {
			return skill5Level;
		}
	}
	public static int getChooseLevel3() {
		if(chooseSkillID1 == 1) {
			return skill1Level;
		}
		else if(chooseSkillID2 == 2) {
			return skill2Level;
		}
		else if(chooseSkillID3 == 3) {
			return skill3Level;
		}
		else if (chooseSkillID3 == 4) {
			return skill4Level;
		}
		else {
			return skill5Level;
		}
	}
	
	//the partition is for user choose
	public static void chooseSkill1(int ID) {
		chooseSkillID1 = ID;
	}
	public static void chooseSkill2(int ID) {
		chooseSkillID2 = ID;
	}
	public static void chooseSkill3(int ID) {
		chooseSkillID3 = ID;
	}
	
	public static void levelUp(int ID) {
		if(ID == 1 && skill1Level < 5) {
			skill1Level++;
		}
		else if(ID == 2 && skill2Level < 5) {
			skill2Level++;
		}
		else if(ID == 3 && skill3Level < 5) {
			skill3Level++;
		}
		else if (ID == 4 && skill4Level < 5) {
			skill4Level++;
		}
		else if(ID == 5 && skill5Level < 5){
			skill5Level++;
		}
	}
	
	
}
