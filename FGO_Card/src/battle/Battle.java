package battle;
import skill.*;
import character.*;
import card.*;

//import character.Caster;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class Battle extends JFrame{
	int size;
	public static Card map[][];
	Battle(){
		this(1);
	}
	Battle(int difficulty){
		size=3;
		map=new Card[size][];
		for(int i=0;i<size;++i){
			map[i]=new Card[size];
			for(int j=0;j<size;++j){
				if(i==1&&j==1){
					switch(character.ChooseCharacter.getID()){
						case 1:map[1][1]=new card.Caster(character.ChooseCharacter.getMaxHP());break;
						case 2:map[1][1]=new card.Assassin(character.ChooseCharacter.getMaxHP());break;
						case 3:map[1][1]=new card.Lancer(character.ChooseCharacter.getMaxHP());break;
					}
				}
			
			}
		}
	}
}
