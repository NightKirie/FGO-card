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
	}
	String name=null;
	public void setField(Battle f){field=f;}
	public void updateStatus(){}
	public void updateCard(){}
	//public String scientificName=null;
	//use getUIClassID() to get scientificName;(method in JButton)
	//the scientificName should be in type:"class.class.name"
	//ex:Object.Creature.Player.Lancer
	
	//public ImageIcon cardPicture=null;
	//if need to change ImageIcon,use setIcon in set;(method in JButton)
	private class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Point Location=field.getLocation(Card.this);
			Point playerLocation=field.getLocation(field.player);
			if(Math.abs(Location.x-playerLocation.x)+Math.abs(Location.y-playerLocation.y)!=1) return;
			String[] scientificName=getUIClassID().split(".");
			if(scientificName[0].equals("Object")){
				if(scientificName[1].equals("Creature")&&scientificName[2].equals("Monster")){
					((Creature)field.player).attack((Creature)Card.this);
				}
			}
			else{//Item
				switch(scientificName[2]){
					case "Weapon":
						((Player)field.player).pickUpWeapon((Weapon)Card.this);
						break;
					case "Potion":
						break;
					case "Trap":
						break;
					case "Bomb":
						field.swapCard(Location,playerLocation);
						break;
					case "Coin":
						break;
				}
			}
		}
	} 
}
