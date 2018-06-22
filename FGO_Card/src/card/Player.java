package card;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import battle.Battle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import menu.MainWindow;
public class Player extends Creature{
	private final MediaPlayer pickupFX = new MediaPlayer(
			new Media(getClass().getResource("/audio/PickUP_FX.mp3").toString())); // for menu BGM
	public Weapon weapon=new Sword(0);
	public JLabel weaponshow=new JLabel("0");
	public Player(String scientifficName)
	{
		super("Player."+scientifficName);
		weaponshow.setBounds(10,150,50, 50);
		weaponpic.setBounds(100, 150, 50, 50);
		weaponshow.setFont(new Font("MV Boli", Font.PLAIN, 28));
		weaponshow.setForeground(Color.WHITE);
		add(weaponshow);
		add(weaponpic);
	}
	JLabel weaponpic=new JLabel();//weapon small picture to know what kind of weapon
	public void updateStatus(){
	}
	public void updateHP(){
		if(hp<=0) field.gameOver();
	}
	public void updateCard()
	{
		hpShow.setText(Integer.toString(hp));
		ImageIcon icon=null;
		if(weapon!=null)
		{
			weaponshow.setText(Integer.toString(weapon.hp));
			if(weapon.weapontype.equals("Sword"))
				icon  = new ImageIcon(this.getClass().getResource("/image/Sword_Get.jpg"));
			if(weapon.weapontype.equals("Wand"))
				icon  = new ImageIcon(this.getClass().getResource("/image/Wand_Get.jpg"));
			//Image image = icon.getImage();
		    //image = image.getScaledInstance(50,50, Image.SCALE_SMOOTH);
		    //icon.setImage(image);
			weaponpic.setIcon(icon);
			weaponpic.setVisible(true);
			weaponshow.setVisible(true);
		}
		else{
			weaponpic.setVisible(false);
			weaponshow.setVisible(false);
		}
	}
	public void attack(Creature opponent) {
		// TODO Auto-generated method stub
		Point enemyLocation=field.getLocation(opponent);
		Point myLocation=field.getLocation(this);
		int direction=-1,damage=0;
		for(int i=0;i<4;++i){
			if(enemyLocation.equals(Battle.addPoint(myLocation,Battle.relation[i]))) direction=i;
		}
		if(weapon==null)
		{
			field.pickGold(opponent.hp);
			hp-=opponent.hp;
			field.remove(opponent);
			field.moveCard(myLocation,direction);
		}
		else{
			if(weapon.hp>opponent.hp) damage=opponent.hp;
			else damage=weapon.hp;
			weapon.hp-=damage;
			if(weapon instanceof Sword)	opponent.getSwordDamage(damage);
			else if(weapon instanceof Wand){
				for(;field.inField(enemyLocation);enemyLocation=Battle.addPoint(enemyLocation,Battle.relation[direction])){
					if(field.map[enemyLocation.x][enemyLocation.y] instanceof Object)
						((Object)field.map[enemyLocation.x][enemyLocation.y]).getwardDamage(damage);
				}
			}
		}
		if(weapon!=null&&weapon.hp<=0) weapon=null;
/*
				if(weapon instanceof Wand)//fire wand attack
				{
					int xdir=enemyLocation.x-myLocation.x;
					int ydir=enemyLocation.y-myLocation.y;
					if(xdir!=0&&(myLocation.x+2*xdir)>=0&&(myLocation.x+2*xdir)<=0)
					{
						((Object)field.map[myLocation.x+2*xdir][myLocation.y]).getwardDamage(opponent.hp);
					}
					else if(ydir!=0&&(myLocation.y+2*ydir)>=0&&(myLocation.y+2*ydir)<=0)
					{
						((Object)field.map[myLocation.x][myLocation.y+2*ydir]).getwardDamage(opponent.hp);
					}
					opponent.getwardDamage(opponent.hp);
				}
			}
			else
			{
				if(weapon instanceof Sword)//sword attack
				{
					opponent.getSwordDamage(weapon.hp);
				}
				if(weapon instanceof Wand)//wand attack
				{
					Point enemyLocation=field.getLocation(opponent);
					Point myLocation=field.getLocation(this);
					int xdir=enemyLocation.x-myLocation.x;
					int ydir=enemyLocation.y-myLocation.y;
					if(xdir!=0&&(myLocation.x+2*xdir)>=0&&(myLocation.x+2*xdir)<=0)
					{
						((Object)field.map[myLocation.x+2*xdir][myLocation.y]).getwardDamage(weapon.hp);
					}
					else if(ydir!=0&&(myLocation.y+2*ydir)>=0&&(myLocation.y+2*ydir)<=0)
					{
						((Object)field.map[myLocation.x][myLocation.y+2*ydir]).getwardDamage(weapon.hp);
					}
					opponent.getwardDamage(weapon.hp);
				}
				weapon.hp=0;
			}
		}
		else if(weapon==null||weapon.hp==0)
		{
			if(this.hp>opponent.hp)
			{
				this.hp-=opponent.hp;
				opponent.hp=0;
			}
			else
			{
				//game over!!
			}
		}
		*/
	}
	public void pickUpWeapon(Weapon newWeapon){
		pickupFX.stop();
		pickupFX.setVolume(MainWindow.getFxVolume());
		pickupFX.play();
		if(weapon==null||weapon.hp<newWeapon.hp) weapon=newWeapon;
	}
	
	public void ability() {
		//default Do nothing~!
	}
	
}
