package battle;
import java.awt.Point;
import card.*;
import skill.*;
public class Skill{
	Battle field;
	public Skill(Battle f){
		field=f;
	}
	public void skillActive(int ID){
		switch(ID){
			case 1:allDamage();break;
			case 2:weaponBoost();break;
			case 3:skillBoost();break;
			case 4:healing();break;
			case 5:summonSword();break;
		}
	}
	void allDamage(){
		for(int i=0;i<field.size;++i){
			for(int j=0;j<field.size;++j){
				if(field.map[i][j] instanceof Monster) ((Creature)field.map[i][j]).hp-=ChooseSkill.getSkillLevel(1);
			}
		}
	}
	void weaponBoost(){
		if(((Player)field.player).weapon!=null)	((Player)field.player).weapon.hp+=3+ChooseSkill.getSkillLevel(2);
	}
	void skillBoost(){
		for(int i=0;i<3;++i){
			if(field.skillCD[i]>0){
				field.skillCD[i]-=ChooseSkill.getSkillLevel(3);
				if(field.skillCD[i]<=0){
					field.skillCD[i]=field.skillMaxCD[i];
					skillActive(field.skillID[i]);
				}
			}
		}
	}
	void healing(){
		((Player)field.player).hp+=ChooseSkill.getSkillLevel(4)*2;
		if(((Player)field.player).hp>((Player)field.player).maxHP)
		{
			((Player)field.player).hp=((Player)field.player).maxHP;
			//heal poison?
		}
	}
	void summonSword(){
		if(field.player instanceof Caster) ((Player)field.player).pickUpWeapon(new Wand(5+2*ChooseSkill.getSkillLevel(5)*2));
		else ((Player)field.player).pickUpWeapon(new Sword(5+2*ChooseSkill.getSkillLevel(5)*2));
	}
}
