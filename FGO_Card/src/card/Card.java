package card;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;
import java.awt.Point;
import battle.Battle;

public class Card extends JButton{
	Battle field;
	public Card(String scientificName){
		super(scientificName);
		setSize(150,200);
		setLayout(null);
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		this.addActionListener(new buttonListener());
	}
	String name=null;
	public void setField(Battle f){field=f;}
	public void updateStatus(){}
	public void updateCard(){}
	
	//if need to change ImageIcon,use setIcon in set;(method in JButton)
	private class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Point Location=field.getLocation(Card.this);
			Point playerLocation=field.getLocation(field.player);
			int direction=-1;
			for(int i=0;i<4;++i){
				if(Location.equals(Battle.addPoint(playerLocation,Battle.relation[i]))){
					direction=i;
					break;
				}
			}
			if(direction==-1&&!(field.player instanceof Assassin)) return;
			if(Card.this instanceof Object){
				if(Card.this instanceof Monster){
					if(direction>=0){
						((Player)field.player).attack((Creature)Card.this);
						field.updateStatus();
					}
				}
				else{//Item
					if(Card.this instanceof Weapon){
						((Player)field.player).pickUpWeapon((Weapon)Card.this);
						
						if(direction>=0) field.moveCard(playerLocation,direction);
						else{
							Card.this.setVisible(false);
							field.addCard(new Empty(),Location);
						}
						field.remove(Card.this);
						field.updateStatus();
					}
					else if(Card.this instanceof Potion){
						((Potion)Card.this).effect((Player)field.player);
						
						if(direction>=0) field.moveCard(playerLocation,direction);
						else{
							Card.this.setVisible(false);
							field.addCard(new Empty(),Location);
						}
						field.remove(Card.this);
						field.updateStatus();
					}
					else if((Card.this instanceof Bomb)&&direction>=0){
						field.swapCard(Location,playerLocation);
						field.updateStatus();
					}
					else if(Card.this instanceof Coin){
						field.pickGold(((Object)Card.this).hp);
						
						if(direction>=0)field.moveCard(playerLocation,direction);
						else{
							Card.this.setVisible(false);
							field.addCard(new Empty(),Location);
						}
						field.remove(Card.this);
						field.updateStatus();
					}
					else if(Card.this instanceof Chest){
						((Chest)Card.this).open();
						field.updateStatus();
					}
				}
			}
			else if(Card.this instanceof Empty){
				if(direction>=0){
					field.remove(Card.this);
					field.moveCard(playerLocation,direction);
					field.updateStatus();
				}
			}
		}
	} 
}
