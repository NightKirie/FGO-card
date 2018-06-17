package card;
import character.Character;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Player extends Creature{
	public Weapon weapon=new Sword(0);
	public JLabel weaponshow=new JLabel("0");
	public Player(String scientifficName)
	{
		super("Player."+scientifficName);
		//ImageIcon cardPicture=null;
		weaponshow.setBounds(0,70,50, 50);
		weaponpic.setBounds(0, 200, 50, 50);
		add(weaponshow);
		add(weaponpic);
	}
	JLabel weaponpic=null;//weapon small picture to know what kind of weapon
	public void updateStatus(){
		if(hp<=0) field.gameOver();
	}
	public void updateUI()
	{
		hpShow.setText("Hp:"+Integer.toString(hp));
		weaponshow.setText("w:"+Integer.toString(weapon.hp));
		ImageIcon icon=null;
		if(weapon.weapontype.equals("sword"))
			icon  = new ImageIcon(this.getClass().getResource("/Image/sword.png"));
		if(weapon.weapontype.equals("wand"))
			icon  = new ImageIcon(this.getClass().getResource("/Image/wand.png"));
	    Image image = icon.getImage();
	    image = image.getScaledInstance(50,50, Image.SCALE_SMOOTH);
	    icon.setImage(image);
	    weaponpic.setIcon(icon);
	}
	public void attack(Creature opponent) {
		// TODO Auto-generated method stub
		if(weapon.hp>0)
		{
			
			if(weapon.hp>=opponent.hp)
			{
				weapon.hp-=opponent.hp;
				if(weapon instanceof Sword)//sword attack
				{
					opponent.getSwordDamage(opponent.hp);
				}
				if(weapon instanceof Wand)//fire wand attack
				{
					Point enemyLocation=field.getLocation(opponent);
					Point myLocation=field.getLocation(this);
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
		else if(weapon.hp==0||weapon==null)
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
	}
	public void pickUpWeapon(Weapon newWeapon){
		if(weapon.hp<newWeapon.hp) weapon=newWeapon;
	}
	
	public void ability() {
		//default Do nothing~!
	}
	
}
