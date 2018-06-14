package battle;
import skill.*;
import character.*;
import card.*;

//import character.Caster;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.geom.Point2D;

public class Battle extends JPanel{
	static int size;
	int difficulty;
	randomCard generater;

	public static Cardi[][] map;
	public static Card player;
	static image

	public Battle(){this(1);}
	public Battle(int difficulty){
		setSize(485,748);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.BLACK);
		setLayout(null);

		size=3;
		map=new Card[size][];
		generater=new randomCard(difficulty);
		for(int i=0;i<size;++i){
			map[i]=new Card[size];
			for(int j=0;j<size;++j){
				if(i==1&&j==1){
					switch(character.ChooseCharacter.getChosenID()){
						case 1:player=new card.Caster(character.ChooseCharacter.getChosenMaxHP());break;
						case 2:player=new card.Assassin(character.ChooseCharacter.getChosenMaxHP());break;
						case 3:player=new card.Lancer(character.ChooseCharacter.getChosenMaxHP());break;
					}
					map[i][j]=player;
				}
				else{
					map[i][j]=generater.nextCard();
					map[i][j].setLocation(5+i*160,120+j*200);
				}
			}
		}
	}
	public static Point getLocation(Card target){
		for(int i=0;i<size;++i){
			for(int j=0;j<size;++j) if(target==map[i][j]) return new Point(i,j);
		}
		return null;
	}
}
