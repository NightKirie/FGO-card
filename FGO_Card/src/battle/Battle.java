package battle;
import skill.*;
import character.*;

//import character.Caster;
import card_total.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
public class Battle extends JFrame{
	character.Character character;
	Skill[] skill;
	int difficulty;

	Battle(){
		character=new Caster();
		skill=new Skill[]{new Aoe(),new Boost(),new Heal()};
		difficulty=1;
	}
	Battle(character.Character c,Skill[] s,int d){
		character=c;
		skill=s;
		difficulty=d;
	
	}

}
