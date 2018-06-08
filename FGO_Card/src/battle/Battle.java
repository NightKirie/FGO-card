package battle;
import skill.*;
import character.*;
import card.*;

//import character.Caster;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
public class Battle extends JFrame{
	Card map[][];
	Battle(){
		this(new Skill[]{new Aoe(),new Boost(),new Heal()},1);
	}
	Battle(Skill[] s,int d){
		map=new Card[3][];
		for(int i=0;i<3;++i) map[i]=new Card[3];
		switch(character.getID()){
			case 1:map[1][1]=new card.Caster(c.getHP());break;
			case 2:map[1][1]=new card.Assassin(c.getHP());break;
			case 3:map[1][1]=new card.Lancer(c.getHP());break;
		}
		
	}

}
