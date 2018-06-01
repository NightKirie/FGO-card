package skill;

public class Skill {
	/*
	�o��class�O�D�n���ޯ�class�A�U�ӧޯ�class�[���ۤv��interact function �M�ۤv��ID,level
	�U�誺�T��static ID ��ܨϥΪ̿�ܤF���T�ӧޯ�
	�b�i�J�C���ɡA�ݭn�ϥΤU�誺createSkill �ӳгy�@��skill object
	createSkill �|�̾�skillID �Ӧ^�Ǥ��P���ޯ�class
	 */
	public static int ID1 = 1, ID2 = 2, ID3 = 3;
	public int CD;
	public int maxCD;

	public static int getID1() {
		return ID1;
	}
	public static int getID2() {
		return ID2;
	}
	public static int getID3() {
		return ID3;
	}
	public int getCD() {
		return CD;
	}
	public int getmaxCD() {
		return maxCD;
	}
	public void setID1(int setID) {
		ID1 = setID;
	}
	public void setID2(int setID) {
		ID2 = setID;
	}
	public void setID3(int setID) {
		ID3 = setID;
	}
	public void setCD(int setCD) {
		CD = setCD;
	}
	public void setmaxCD(int setCD) {
		maxCD = setCD;
	}
	
	public void interact() {
	}

	public static Skill createSkill(int skillID) {
		switch (skillID) {
		case 1:
			return (Skill) new Aoe();
		case 2:
			return (Skill) new Boost();
		case 3:
			return (Skill) new Recharge();
		case 4:
			return (Skill) new Heal();
		case 5:
			return (Skill) new Summon();
		default:
			return (Skill) new Aoe();
		}
	}
}
