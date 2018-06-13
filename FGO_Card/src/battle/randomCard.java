package battle;

import Card;
import java.util.Random;
public class randomCard extends Random{
	static int difficulty=0;
	int[] probability;
	public randomCard(int gameDifficulty){
		difficulty=gameDifficulty;
		probability=new int[7];
//0:minion,1:boss,2:weapon,3
		setDifficulty(difficulty);
	}
	public int getDifficulty(){return difficulty;}
	private void setDifficulty(int d){
		int[] rate=new int[7];
		//0:minion,1:boss,2:sword,3:wond,4:red_potion,5:green_potion,6:trap,7:treasure
		switch(d){
			case 1:rate[0]=30;rate[1]=1;rate[2]=15;rate[3]=15;rate[4]=15;rate[5]=7;rate[6]=10;break;
		}
		difficulty[0]=rate[0];
		for(int i=1;i<7;++i){
			difficulty[i]=difficulty[i-1]+rate[i];
		}
	}
	private Card randomCard(){
		Float r=this.nextInt();
		if(r<)
	}
}
