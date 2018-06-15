package battle;
import skill.*;
import character.*;
import card.*;

//import character.Caster;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.geom.Point2D;

public class Battle extends JPanel{
	static int size=3;
	int difficulty;
	static randomCard generater;

	public static Card[][] map;
	public static Card player;

	public Battle(int difficulty){
		setSize(485,748);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.BLACK);
		setLayout(null);

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
				}
			}
		}
	}
	public void updateUI(){
		for(int i=0;i<size;++i){
			for(int j=0;j<size;++j){
				map[i][j].updateStatus();
				map[i][j].updateUI();
			}
		}
		
	}
	public static Point getLocation(Card target){
		for(int i=0;i<size;++i){
			for(int j=0;j<size;++j) if(target==map[i][j]) return new Point(i,j);
		}
		System.out.println("error:cannot find card in map");
		return null;
	}
	public static void swapCard(Point a,Point b){
		Card tmp=map[a.x][a.y];
		map[a.x][a.y]=map[b.x][b.y];
		map[b.x][b.y]=tmp;
	}
	static Point add(Point a,Point b){return new Point(a.x+b.x,a.y+b.y);}
	static boolean inField(Point a){return a.x<size&&a.x>=0&&a.y<size&&a.y>=0;}
	final static Point[] relation={new Point(0,1),new Point(1,0),new Point(0,-1),new Point(-1,0)}; 
	public static void moveCard(Point position,int direction){
		//0:up,1:right,2:down,3:left
		//when use this function,the card on next direction will be remove
		int backDirection=(direction+2)%4;
		Point target=add(position,relation[direction]);
		for(Point i=position;inField(i);i=add(i,relation[backDirection])){
			map[target.x][target.y]=map[i.x][i.y];
			target=i;
		}
		if(target.equals(position)){//need move other card if player move from side
			do{//check where the next card need to be move
				direction=(direction+1)%4;
				position=add(position,relation[direction]);
			}while(!inField(position));
			for(Point i=position;inField(i);i=add(i,relation[backDirection])){
				map[target.x][target.y]=map[i.x][i.y];
				target=i;
			}
		}
		map[target.x][target.y]=generater.nextCard();
	}
}
