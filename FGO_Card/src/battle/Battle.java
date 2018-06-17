package battle;
import skill.*;
import character.*;
import menu.Button;
import menu.MainWindow;
import menu.RoundedTextField;
import card.*;
import java.util.Random;
//import character.Caster;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.geom.Point2D;
import cardtest.*;
public class Battle extends JPanel{
	int size=3,skillSize=3;
	int difficulty,gold;
	randomCard generater;

	public Card [][] map;
	public Card player;
	public Card2 [][]map2=new Card2[3][3];
	//frank870622 add///////////////////////////////////////////////
	private final JLabel[] chosenSkillBattle = {new JLabel(""), new JLabel(""), new JLabel("")};
	private final JLabel goldAmountIcon = new JLabel("");	//for show the gold amount icon
	private final JLabel backGround = new JLabel("");		//for menu background picture
	private final JTextField goldBattleNumber = new RoundedTextField(15);	//for show the gold player get in battle
	//////////////////////////////////////////
	
	public Battle(int difficulty){
		
		//frank870622 add/////////////////////////////////////////////////////
		for(int i=0;i<3;++i){
	        chosenSkillBattle[i].setBounds(10+70*i,10,55,55);
	        this.add(chosenSkillBattle[i]);
	    }
		
	    //Initial gold amount icon
	    goldAmountIcon.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Gold_Amount.png")));
	    goldAmountIcon.setBounds(297, 0, 50, 50);		
	    this.add(goldAmountIcon);

	    //Initial gold battle number
	    goldBattleNumber.setBounds(357, 0, 123, 50);
	    goldBattleNumber.setText("0");
	    this.add(goldBattleNumber);

	    //Initial back ground image
	    backGround.setBounds(0, 0, 480, 720);
	    backGround.setIcon(new ImageIcon(MainWindow.class.getResource("/image/InGameBackground.jpg")));
	    this.add(backGround);
	    JButton t=new textb();
	    //t.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Gold_Amount.png")));
	    //t.setSize(50, 50);
	    //t.setLocation(300, 500);
	    this.add(t,1);
	    
	    
	    
	    
	    ///////////////////////////////////////////////////////////////
	    
	    Random ran = new Random();
	    
	    for(int i=0;i<size;i++)
	    {
		    for(int j=0;j<size;j++)
		    {
		    	switch(ran.nextInt(3))
		    	{
		    	case 0:map2[i][j]=new Card2(" "+i+j);break;
		    	case 1:map2[i][j]=new Assassin2(10);break;
		    	case 2:map2[i][j]=new Caster2(10);break;
		    	case 3:map2[i][j]=new Card2(" "+i+j);break;
		    	case 4:map2[i][j]=new Card2(" "+i+j);break;
		    	}
		    	map2[i][j].setLocation(5+150*i,120+200*j);
				map2[i][j].setText(map2[i][j].getText());
				this.add(map2[i][j],1);map2[i][j].setVisible(true);
		    }
	    }
	    
	    
	    ////////////////////////////////////////////////////////////////////////////
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    goldBattleNumber.setVisible(true);
	    goldAmountIcon.setVisible(true);
		/////////////////////////////////////////////////////////////////////////////////
		
		setSize(485,748);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.BLACK);
		setLayout(null);

		map=new Card[size][];
		generater=new randomCard(difficulty,difficulty);
		for(int i=0;i<size;++i){
			map[i]=new Card[size];
			for(int j=0;j<size;++j){
				if(i==1&&j==1){
					switch(character.ChooseCharacter.getChosenID()){
						case 1:player=new card.Caster(character.ChooseCharacter.getChosenMaxHP());break;
						case 2:player=new card.Assassin(character.ChooseCharacter.getChosenMaxHP());break;
						case 3:player=new card.Lancer(character.ChooseCharacter.getChosenMaxHP());break;
						default:player=new card.Caster(10);break;
					}
					map[i][j]=player;
				}
				else{
					map[i][j]=generater.nextCard();
				}
				map[i][j].setLocation(5+150*i,120+200*j);;
				map[i][j].setField(this);
				map[i][j].setText(map[i][j].getText());
				//this.add(map[i][j],1);map[i][j].setVisible(true);
				
			}
		}
		for(int i=0;i<size;++i){
			for(int j=0;j<size;++j){
				System.out.println(map[i][j].getText()+i+" "+j);
				System.out.println(map[i][j].getUIClassID());
			}
		}
	}
	public void updateUI(){
		for(int i=0;i<size;++i){
			for(int j=0;j<size;++j){
				map[i][j].updateStatus();
			}
		}
		for(int i=0;i<size;++i){
			for(int j=0;j<size;++j){
				map[i][j].updateUI();
			}
		}
	}
	public void pickGold(int number){
		gold+=number;
		/////////////////////////////////goldNumberUI!
	}
	public Point getLocation(Card target){
		for(int i=0;i<size;++i){
			for(int j=0;j<size;++j) if(target==map[i][j]) return new Point(i,j);
		}
		System.out.println("error:cannot find card in map");
		return null;
	}
	public void swapCard(Point a,Point b){
		Card tmp=map[a.x][a.y];
		map[a.x][a.y]=map[b.x][b.y];
		map[b.x][b.y]=tmp;
	}
	public static Point addPoint(Point a,Point b){return new Point(a.x+b.x,a.y+b.y);}
	public boolean inField(Point a){return a.x<size&&a.x>=0&&a.y<size&&a.y>=0;}
	public final static Point[] relation={new Point(0,1),new Point(1,0),new Point(0,-1),new Point(-1,0)}; 
	public void moveCard(Point position,int direction){
		//0:up,1:right,2:down,3:left
		//when use this function,the card on next direction will be remove
		int backDirection=(direction+2)%4;
		Point target=addPoint(position,relation[direction]);
		for(Point i=position;inField(i);i=addPoint(i,relation[backDirection])){
			map[target.x][target.y]=map[i.x][i.y];
			target=i;
		}
		if(target.equals(position)){//need move other card if player move from side
			do{//check where the next card need to be move
				direction=(direction+1)%4;
				position=addPoint(position,relation[direction]);
			}while(!inField(position));
			for(Point i=position;inField(i);i=addPoint(i,relation[backDirection])){
				map[target.x][target.y]=map[i.x][i.y];
				target=i;
			}
		}
		map[target.x][target.y]=generater.nextCard();
		map[target.x][target.y].setField(this);
		add(map[target.x][target.y]);
	}
	public void MenuToBattle() {
	    //set the skill icon 
	    for(int i = 0; i < chosenSkillBattle.length; ++i) {
	        if(ChooseSkill.getChooseID(i) != 0)
	            chosenSkillBattle[i].setIcon(ChooseSkill.getSkillMenu(ChooseSkill.getChooseID(i)));
	        else
	            chosenSkillBattle[i].setIcon(null);
	    }
	    for(int i = 0; i < chosenSkillBattle.length; ++i)
	        chosenSkillBattle[i].setVisible(true);
	    //backGround.setVisible(true);
	}
	public void gameOver(){
		/////////////set Panel back?get gold??
	}
}
