package battle;
import skill.*;
import character.*;
import menu.Button;
import menu.MainWindow;
import menu.RoundedTextField;
import card.*;

//import character.Caster;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.geom.Point2D;

public class Battle extends JPanel{
	int size=3,skillSize=3;
	int difficulty,gold;
	randomCard generater;

	public Card[][] map;
	public Card player;

	//frank870622 add///////////////////////////////////////////////
	private final Button backButton = 	new Button();			//for any page to go back to the menu	
	private final JLabel[] chosenSkillBattle = {new JLabel(""), new JLabel(""), new JLabel("")};
	private final JLabel goldAmountIcon = new JLabel("");	//for show the gold amount icon
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
		this.add(goldBattleNumber);
		
		//Initial backButton in Menu
		backButton.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Back_Btn.png")));
		backButton.setBounds(0, 621, 97, 99);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	
				
			}
		});
		
		//set the skill icon 
		for(int i = 0; i < chosenSkillBattle.length; ++i) {
			if(ChooseSkill.getChooseID(i) != 0)
				chosenSkillBattle[i].setIcon(ChooseSkill.getSkillMenu(ChooseSkill.getChooseID(i)));
			else
				chosenSkillBattle[i].setIcon(null);
		}
		for(int i = 0; i < chosenSkillBattle.length; ++i)
			chosenSkillBattle[i].setVisible(true);
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
					}
					map[i][j]=player;
				}
				else{
					map[i][j]=generater.nextCard();
					map[i][j].setField(this);
				}
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
	public void gameOver(){
		/////////////set Panel back?get gold??
	}
}
