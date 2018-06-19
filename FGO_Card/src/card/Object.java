package card;
import battle.Battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JLabel;
public class Object extends Card {
	public Object(String scientificName){
		super("Object."+scientificName);
		hpShow=new JLabel();
		hpShow.setBounds(100,0,50,50);
		hpShow.setFont(new Font("MV Boli", Font.PLAIN, 28));
		hpShow.setForeground(Color.WHITE);
		hpShow.setText(Integer.toString(hp));
		add(hpShow);
	}
	public int hp=0;	
	public JLabel hpShow=new JLabel("");
	/*
	 * object have hp,so every damage will in there first
	 * ex code:
	 public void getFireDamage(int damage){
	 	hp-=damage;
	 }
	 */
	public void updateHP(){
		if(hp<=0){
			Point p=field.getLocation((Card)this);
			if(p!=null){
				field.addCard(new Coin(10),p);
				field.remove((Card)this);
			}
		}
	}
	public void updateCard()
	{
		hpShow.setText(Integer.toString(hp));
	}
	/*public void deadAction(){
	}*/
	public void getSwordDamage(int damage)//sword damage
	{
		hp-=damage;
	}
	public void getwardDamage(int damage)//fire ward
	{
		hp-=damage;
	}
	public void getwardDamageOfMage(int damage)//ice ward
	{
		//only monster get hurt
	}
	public void getTrapDamage(int damage)//step trap
	{
		hp-=damage;
	}
	public void getBombDamage(int damage)//touch bomb 
	{
		hp-=damage;
	}
}
