package battle;

import skill.*;
import character.*;
import javafx.scene.control.TextField;
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

public class Battle extends JPanel {
	int size = 3, skillSize = 3;
	int difficulty, gold=0;
	randomCard generater;

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
			chosenSkillBattle[i].setBounds(10 + 70 * i, 10, 55, 55);
			this.add(chosenSkillBattle[i], 0);
		}

		for (int i = 0; i < 3; ++i) {
			skillCDText[i].setBounds(10 + 70 * i, 60, 55, 55);
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
				player = new card.Lancer(10);
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
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				System.out.println(map[i][j].getText() + i + " " + j);
			}
		}
	}

	public void updateCard() {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				map[i][j].updateStatus();
			}
		}
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if(map[i][j] instanceof card.Object) ((card.Object)map[i][j]).updateHP();
				map[i][j].updateCard();
				map[i][j].setLocation(15 + 150 * i, 100 + 200 * j);
			}
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
		Card tmp = map[a.x][a.y];
		map[a.x][a.y] = map[b.x][b.y];
		map[b.x][b.y] = tmp;
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
		int backDirection = (direction + 2) % 4;
		Point target = addPoint(position, relation[direction]);
		remove(map[target.x][target.y]);
		for (Point i = position; inField(i); i = addPoint(i, relation[backDirection])) {
			map[target.x][target.y] = map[i.x][i.y];
			target = i;
		}
		if (target.equals(position)) {// need move other card if player move from side
			do {// check where the next card need to be move
				direction = (direction + 1) % 4;
				position = addPoint(position, relation[direction]);
			} while (!inField(position));
			for (Point i = position; inField(i); i = addPoint(i, relation[backDirection])) {
				map[target.x][target.y] = map[i.x][i.y];
				target = i;
			}
		}
		addCard(generater.nextCard(),target);
		updateCard();
	}
	public void addCard(Card c,Point p){
		map[p.x][p.y]=c;
		c.setField(this);
		c.setVisible(true);
		add(c,0);
	}

	public void MenuToBattle() {
		// set the skill icon
		for (int i = 0; i < chosenSkillBattle.length; ++i) {
			if (ChooseSkill.getChooseID(i) != 0)
				chosenSkillBattle[i].setIcon(ChooseSkill.getSkillMenu(ChooseSkill.getChooseID(i)));
			else
				chosenSkillBattle[i].setIcon(null);
		}
		for (int i = 0; i < chosenSkillBattle.length; ++i)
			chosenSkillBattle[i].setVisible(true);
		// set backGround visible in battle
		backGround.setVisible(true);
		//set skill Cd text when initial
		for (int i = 0; i < skillCDText.length; ++i) {
			skillCDText[i].setVisible(true);
			skillCDText[i].setText(Integer.toString(ChooseSkill.getSkillMaxCD(ChooseSkill.getChooseID(i))));
		}
	}

	//when gameover call this function
	public void gameOver() {
		for(int i=0;i<size;++i){
			for(int j=0;j<size;++j){
				remove(map[i][j]);
				map[i][j]=null;
			}
		}
		MainWindow.frame.goldAmount += gold;
		MainWindow.frame.GameOver();
	}
}
