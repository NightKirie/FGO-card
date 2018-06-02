package battle;
import skill.*;
import character.*;
import battle.card.*;

//import character.Caster;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
public class Battle extends JFrame{
	Card map[][];
	Battle(){
		this(new Caster(),new Skill[]{new Aoe(),new Boost(),new Heal()},1);
	}
	Battle(character.Character c,Skill[] s,int d){
		map=new Card[3][];
		for(int i=0;i<3;++i) map[i]=new Card[3];
		map[1][1]=new battle.card.object.creature.Player(c);
	}

}
