package battle;
import skill.*;
import character.*;
import card.*;

//import character.Caster;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.util.Random;

public class Battle extends JFrame{
	int size,difficulty;
	randomCard generater;

	public static Card map[][];

	public Battle(){this(1);}
	public Battle(int difficulty){
		setSize(485,748);
		size=3;
		map=new Card[size][];
		generater=new randomCard(difficulty);
		for(int i=0;i<size;++i){
			map[i]=new Card[size];
			for(int j=0;j<size;++j){
				if(i==1&&j==1){
					switch(character.ChooseCharacter.getChosenID()){
						case 1:map[1][1]=new card.Caster(character.ChooseCharacter.getChosenMaxHP());break;
						case 2:map[1][1]=new card.Assassin(character.ChooseCharacter.getChosenMaxHP());break;
						case 3:map[1][1]=new card.Lancer(character.ChooseCharacter.getChosenMaxHP());break;
					}
				}
				else{
					map[i][j]=generater.nextCard();
					map[i][j].setLocation(5+i*160,120+j*200);
				}
			}
		}
	}

}
