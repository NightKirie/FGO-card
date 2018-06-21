package battle;

import skill.*;
import character.*;
import javafx.scene.control.TextField;
import menu.Button;
import menu.MainWindow;
import menu.RoundedTextField;
import card.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.Timer;

public class Battle extends JPanel {
	public Timer timer=new Timer();
	int size = 3, skillSize = 3;
	int difficulty, gold=0,moves=0;
	public int skillCD[]=new int[3],skillMaxCD[]={-1,-1,-1},skillID[]={0,0,0};
	public int animationDelay=0;
	public randomCard generater;
	Skill skill=new Skill(this);
	public Card[][] map;
	public Card player;

	// frank870622 add///////////////////////////////////////////////
	private final JLabel[] chosenSkillBattle = { new JLabel(""), new JLabel(""), new JLabel("") };
	private final JLabel goldAmountIcon = new JLabel(""); // for show the gold amount icon
	private final JLabel backGround = new JLabel(""); // for menu background picture
	private final JLabel skillCDText[] = { new JLabel(), new JLabel(), new JLabel() }; //for show the skill cd
	private final JLabel goldBattleNumber = new JLabel(); // for show the gold player get in battle
	//////////////////////////////////////////

	public Battle(int difficulty) {

		// frank870622 add/////////////////////////////////////////////////////
		for (int i = 0; i < 3; ++i) {
			chosenSkillBattle[i].setBounds(100 + 70 * i, 10, 55, 55);
			this.add(chosenSkillBattle[i], 0);
		}

		for (int i = 0; i < 3; ++i) {
			skillCD[i]=ChooseSkill.getSkillMaxCD(ChooseSkill.getChooseID(i));
			skillCDText[i].setBounds(100 + 70 * i, 60, 55, 55);
			skillCDText[i].setText("0");
			skillCDText[i].setFont(new Font("MV Boli", Font.PLAIN, 28));
			skillCDText[i].setForeground(Color.LIGHT_GRAY);
			this.add(skillCDText[i], 0);
		}

		// Initial gold amount icon
		goldAmountIcon.setIcon(new ImageIcon(MainWindow.class.getResource("/image/Gold_Amount.png")));
		goldAmountIcon.setBounds(297, 0, 50, 50);
		this.add(goldAmountIcon, 0);
		// Initial gold battle number
		goldBattleNumber.setBounds(357, 0, 123, 50);
		goldBattleNumber.setText("0");
		goldBattleNumber.setFont(new Font("MV Boli", Font.PLAIN, 28));
		goldBattleNumber.setForeground(Color.LIGHT_GRAY);
		this.add(goldBattleNumber, 0);
		// Initial back ground image
		backGround.setBounds(0, 0, 480, 720);
		backGround.setIcon(new ImageIcon(MainWindow.class.getResource("/image/InGameBackground.jpg")));
		this.add(backGround);

		goldBattleNumber.setVisible(true);
		goldAmountIcon.setVisible(true);
		/////////////////////////////////////////////////////////////////////////////////

		setSize(485, 748);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.BLACK);
		setLayout(null);

		map = new Card[size][];
		generater = new randomCard(difficulty, difficulty);
		switch (character.ChooseCharacter.getChosenID()) {
			case 1:
				player = new card.Caster(character.ChooseCharacter.getChosenMaxHP());
				generater.setRate(2,0);
				generater.setRate(3,30);
				break;
			case 2:
				player = new card.Assassin(character.ChooseCharacter.getChosenMaxHP());
				break;
			case 3:
				player = new card.Lancer(character.ChooseCharacter.getChosenMaxHP());
				break;
			default:
				player = new card.Caster(10);
				break;
		}
		for (int i = 0; i < size; ++i) {
			map[i] = new Card[size];
			for (int j = 0; j < size; ++j) {
				if (i == 1 && j == 1) map[1][1] = player;
				else {
					map[i][j] = generater.nextCard();
				}
				map[i][j].setLocation(15 + 150 * i, 100 + 200 * j);
				map[i][j].setField(this);

				this.add(map[i][j], 0);
				map[i][j].setVisible(true);
			}
		}
		/*for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				System.out.println(map[i][j].getText() + i + " " + j);
			}
		}*/
		updateCard();
	}
	public void updateStatus(){
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				map[i][j].updateStatus();
			}
		}
		for(int i=0;i<skillCD.length;++i){
			if(skillCD[i]>0) --skillCD[i];
			if(skillCD[i]==0){
				skill.skillActive(skillID[i]);
				skillCD[i]=skillMaxCD[i];
			}
		}
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if(map[i][j] instanceof card.Object) ((card.Object)map[i][j]).updateHP();
			}
		}
		updateCard();
	}

	public void updateCard() {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				map[i][j].updateCard();
				//map[i][j].setLocation(15 + 150 * i, 100 + 200 * j);
			}
		}
		//set skill Cd text
		for (int i = 0; i < skillCDText.length; ++i){
			skillCDText[i].setText(Integer.toString(skillCD[i]));
		}
	}

	public void pickGold(int number) {
		gold += number;
		goldBattleNumber.setText(Integer.toString(gold));
	}

	public Point getLocation(Card target) {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j)
				if (target == map[i][j])
					return new Point(i, j);
		}
		System.out.println("error:cannot find card in map");
		return null;
	}

	public void swapCard(Point a, Point b) {
		timer.schedule(new Animation(this,a,b),0,50);
		Card tmp=map[a.x][a.y];
		map[a.x][a.y]=map[b.x][b.y];
		map[b.x][b.y]=tmp;
	}

	public static Point addPoint(Point a, Point b) {
		return new Point(a.x + b.x, a.y + b.y);
	}

	public boolean inField(Point a) {
		return a.x < size && a.x >= 0 && a.y < size && a.y >= 0;
	}

	public final static Point[] relation = { new Point(0, 1), new Point(1, 0), new Point(0, -1), new Point(-1, 0) };

	public void moveCard(Point position, int direction) {
		// 0:up,1:right,2:down,3:left
		// when use this function,the card on next direction will be remove
		if(direction<0) System.out.println("move no direction error");
		int backDirection = (direction + 2) % 4;
		Point target = addPoint(position, relation[direction]);
		remove(map[target.x][target.y]);
		for (Point i = position; inField(i); i = addPoint(i, relation[backDirection])) {
			timer.schedule(new Animation(this,map[i.x][i.y],direction),0,50);
			map[target.x][target.y]=map[i.x][i.y];
			target = i;
			System.out.println("direction1:"+direction);
		}
		if (target.equals(position)) {// need move other card if player move from side
			backDirection=direction;
			Point newPos=position;
			do {// check where the next card need to be move
				backDirection = (backDirection + 1) % 4;
				newPos = addPoint(position, relation[backDirection]);
			} while (!inField(newPos));
			direction=(backDirection+2)%4;
			for (Point i = newPos; inField(i); i = addPoint(i, relation[backDirection])){
				timer.schedule(new Animation(this,map[i.x][i.y],direction),0,50);
				map[target.x][target.y]=map[i.x][i.y];
				target = i;
				System.out.println("direction2:"+direction);
			}
		}
		addCard(generater.nextCard(),target);
		updateCard();
	}
	public void addCard(Card c,Point p){
		map[p.x][p.y]=c;
		c.setField(this);
		c.setVisible(true);
		c.setLocation(15 + 150*p.x, 100 + 200*p.y);
		add(c,0);
	}

	public void MenuToBattle() {
		// set the skill icon
		for (int i = 0; i < chosenSkillBattle.length; ++i) {
			if (ChooseSkill.getChooseID(i) != 0){
				chosenSkillBattle[i].setIcon(ChooseSkill.getSkillMenu(ChooseSkill.getChooseID(i)));
				chosenSkillBattle[i].setVisible(true);
			}
			else chosenSkillBattle[i].setIcon(null);
		}
		// set backGround visible in battle
		backGround.setVisible(true);

		for (int i = 0; i < skillCDText.length; ++i) {
			skillID[i]=ChooseSkill.getChooseID(i);
			if(skillID[i]>0){
				skillCD[i]=skillMaxCD[i]=ChooseSkill.getSkillMaxCD(skillID[i]);
				skillCDText[i].setVisible(true);
			}
			else skillCDText[i].setVisible(false);
		}
	}

	//when gameover call this function
	public void gameOver() {
		System.out.println("gameover");
		for(int i=0;i<size;++i){
			for(int j=0;j<size;++j){
				map[i][j].setVisible(false);
			}
		}
		MainWindow.goldAmount += gold;
		MainWindow.frame.GameOver();
	}
}
