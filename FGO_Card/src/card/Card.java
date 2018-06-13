package card;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Card extends JButton{
	public Card(String scientificName){
		super(scientificName);
		setSize(150,200);
	}
	String name=null;
	//public String scientificName=null;
	//use getUIClassID() to get scientificName;(method in JButton)
	//the scientificName should be in type:"class.class.name"
	//ex:Object.Creature.Player.Lancer
	
	//public ImageIcon cardPicture=null;
	//if need to change ImageIcon,use setIcon in set;(method in JButton)
	private class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String[] scientificName=getUIClassID().split(".");
			if(scientificName[0].equals("Object")){
				if(scientificName[1].equals("Creature")&&scientificName[2].equals("Monster")){
					
				}
				else{
					
				}
			}
			else{
				switch(scientificName[2]){
					case "Weapon":
						break;
					case "Potion":
						break;
					case "Trap":
						break;
					case "Bomb":
						break;
				}
			}
		}
	} 
}
