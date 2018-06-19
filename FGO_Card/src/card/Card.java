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
		//setBorderPainted(false); 
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
			System.out.println("hello");
			Point Location=field.getLocation(Card.this);
			Point playerLocation=field.getLocation(field.player);
			int direction=-1;
			for(int i=0;i<4;++i){
				if(Location.equals(Battle.addPoint(playerLocation,Battle.relation[i]))) direction=i;
			}
			if(direction==-1&&!(field.player instanceof Assassin)) return;
			String[] scientificName=Card.this.getText().split(".");
			System.out.println(Card.this.getText());
			if(scientificName[0].equals("Object")){
				if(scientificName[1].equals("Creature")&&scientificName[2].equals("Monster")){
					((Creature)field.player).attack((Creature)Card.this);
				}
			}
			else{//Item
				switch(scientificName[2]){
					case "Weapon":
						((Player)field.player).pickUpWeapon((Weapon)Card.this);
						if(direction>=0) field.moveCard(playerLocation,direction);
						else field.map[Location.x][Location.y]=new Empty();
						break;
					case "Potion":
						((Potion)Card.this).effect((Player)field.player);
						if(direction>=0) field.moveCard(playerLocation,direction);
						else field.map[Location.x][Location.y]=new Empty();
						break;
					case "Trap":
						break;
					case "Bomb":
						field.swapCard(Location,playerLocation);
						break;
					case "Coin":
						field.pickGold(((Object)Card.this).hp);
						break;
				}
			}
		}
	} 
}
