package battle;

import card.*;
import java.util.Random;
public class randomCard extends Random{
	static int difficulty=0,typeSize=8;
	int[] probability;
	public randomCard(int gameDifficulty){
		difficulty=gameDifficulty;
		probability=new int[typeSize];
		setDifficulty(difficulty);
	}
	public int getDifficulty(){return difficulty;}
	private void setDifficulty(int d){
		int[] rate=new int[typeSize];
		//0:minion,1:boss,2:sword,3:wond,4:red_potion,5:green_potion,6:bomb,7:treasure
		switch(d){
			case 1:rate[0]=30;rate[1]=1;rate[2]=15;rate[3]=15;rate[4]=15;rate[5]=7;rate[6]=10;rate[7]=10;break;
		}
		probability[0]=rate[0];
		for(int i=1;i<typeSize;++i){
			probability[i]=probability[i-1]+rate[i];
		}
	}
	public Card nextCard(){
		int r=nextInt(probability[typeSize-1]);
		Card newCard=null;
		if(r<probability[0]) newCard=new Minion(difficulty*5+nextInt(5));
		else if(r<probability[1]) newCard=new Boss(difficulty*20+nextInt(10));
		else if(r<probability[2]) newCard=new Sword(difficulty*5);
		else if(r<probability[3]) newCard=new Wand(difficulty*5);
		else if(r<probability[4]) newCard=new RedPotion(3+nextInt(5));
		else if(r<probability[5]) newCard=new GreenPotion(1);
		else if(r<probability[6]) newCard=new Bomb(difficulty*5+nextInt(3));
		else if(r<probability[7]) newCard=new Chest(nextInt(5)+5);
		return newCard;
	}
}
