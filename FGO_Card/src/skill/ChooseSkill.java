package skill;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import menu.MainWindow;

public class ChooseSkill {
	private static int[] chooseSkillID = {0, 0, 0};
	private static int[] skillLevel = new int[5];
	private static int[] skillPower = new int[5];
	private static int[] skillCD = new int[] {10, 8, 12, 10, 15};
	private static final int levelUpGold[] = {100, 200, 500, 1000};
	private static final ImageIcon[] skillImage = {
			new ImageIcon(MainWindow.class.getResource("/Image/Skill_AllDamage.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Skill_WeaponUp.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Skill_ReduceCharge.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Skill_HealthUp.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Skill_SumonSword.png"))
	};
	private static final ImageIcon[] skillDetail = {
			new ImageIcon(MainWindow.class.getResource("/Image/Skill_AllDamage_Detail.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Skill_WeaponUp_Detail.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Skill_ReduceCharge_Detail.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Skill_HealthUp_Detail.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Skill_SumonSword_Detail.png"))
	};
	private static final ImageIcon[] skillMenu = {
			new ImageIcon(MainWindow.class.getResource("/Image/Menu_AllDamage.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Menu_WeaponUp.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Menu_ReduceCharge.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Menu_HealthUp.png")),
			new ImageIcon(MainWindow.class.getResource("/Image/Menu_SumonSword.png"))
	};
	
	/**
	 * get the image of the skill
	 */
	public static ImageIcon getSkillImage(int ID) {
		return skillImage[ID-1];
	}
	
	/**
	 * get the skill detail
	 */	
	public static ImageIcon getSkillDetail(int ID) {
		return skillDetail[ID-1];
	}
	
	/**
	 * get the skill menu image
	 */
	public static ImageIcon getSkillMenu(int ID) {
		return skillMenu[ID-1];
	}
	
	/**
	 * get the skillID of three skill you choice
	 */
	public static int[] getChooseID() {
		return new int[] {chooseSkillID[0], chooseSkillID[1], chooseSkillID[2]};
	} 
	public static int getChooseID(int i) {
		return chooseSkillID[i];
	}
	
	/**
	 * get the skill MaxCD of three skill you choice
	 */
	public static int[] getChooseSkillMaxCD() {
		return new int[] {skillLevel[chooseSkillID[0]], skillLevel[chooseSkillID[1]], skillLevel[chooseSkillID[2]]};
	}
	
	/**
	 * get the skill level of three skill you choice
	 */
	public static int[] getChooseLevel() {
		return new int[] {skillLevel[chooseSkillID[0]], skillLevel[chooseSkillID[1]], skillLevel[chooseSkillID[2]]};
	}
	
	/**
	 * get the skill power of three skill you choice
	 */
	public static int[] getChoosePower() {
		return new int[] {skillPower[chooseSkillID[0]], skillPower[chooseSkillID[1]], skillPower[chooseSkillID[2]]};
	}
	
	/**
	 * return the maxCD of skill
	 */
	public static int getSkillMaxCD(int ID){
		return skillCD[ID-1];
	}
	
	/**
	 * return the power of skill
	 */
	public static int getSkillPower(int ID){
		return skillPower[ID-1];
	}
	
	/**
	 * return the level of skill, for initial
	 */
	public static int getSkillLevel(int ID){
		return skillLevel[ID-1];
	}
	
	/**
	 * return the level of skill after upgrade
	 */
	public static int getSkillLevel(Icon img) {
		if(img.equals(skillImage[0]))
			return skillLevel[0];
		else if(img.equals(skillImage[1]))
			return skillLevel[1];
		else if(img.equals(skillImage[2]))
			return skillLevel[2];
		else if(img.equals(skillImage[3]))
			return skillLevel[3];
		else
			return skillLevel[4];
	}
	
	/**
	 * the partition is for user choose skill 1,2,3
	 */
	public static void setChooseSkill(int ID, int i) {
		chooseSkillID[i] = ID;
	}
	
	/**
	 * to set the skill level
	 */
	public static void setLevel(int ID, int level) {
		skillLevel[ID-1] = level;
	}
	
	/**
	 * to set the skill power
	 */
	public static void setPower(int ID, int power) {
		skillPower[ID-1] = power;
	}
	/**
	 * for press the levelup button to upgrade the skill
	 */
	public static int levelUp(Icon img, int gold) {
		if(img.equals(skillImage[0]) && skillLevel[0] < 5) {
			if(levelUpGold[skillLevel[0]-1] <= gold) {
				skillLevel[0]++;
				skillPower[0] = skillLevel[0];
				return gold-levelUpGold[skillLevel[0]-2];
			}
			else
				return gold;
		}
		else if(img.equals(skillImage[1]) && skillLevel[1] < 5) {
			if(levelUpGold[skillLevel[1]-1] <= gold) {
				skillLevel[1]++;
				skillPower[1] = 3 + skillLevel[1];
				return gold-levelUpGold[skillLevel[1]-2];
			}
			else
				return gold;
		}
		else if(img.equals(skillImage[2]) && skillLevel[2] < 5) {
			if(levelUpGold[skillLevel[2]-1] <= gold) {
				skillLevel[2]++;
				skillPower[2] = skillLevel[2];
				return gold-levelUpGold[skillLevel[2]-2];
			}
			else
				return gold;
		}
		else if(img.equals(skillImage[3]) && skillLevel[3] < 5) {
			if(levelUpGold[skillLevel[3]-1] <= gold) {
				skillLevel[3]++;
				skillPower[3] = 2 * skillLevel[3];
				return gold-levelUpGold[skillLevel[3]-2];
			}
			else
				return gold;
		}
		else if(img.equals(skillImage[4]) && skillLevel[4] < 5) {
			if(levelUpGold[skillLevel[4]-1] <= gold) {
				skillLevel[4]++;
				skillPower[4] = 5 + 2 * skillLevel[4];
				return gold-levelUpGold[skillLevel[4]-2];
			}
			else
				return gold;
		}
		else 
			return gold;		
	}
	
}
