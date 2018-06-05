package card;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Card extends JButton{
	public Card(String scientificName){
		super(scientificName);
	}
	//public String scientificName=null;
	//use getUIClassID() to get scientificName;(method in JButton)
	//the scientificName should be in type:"class.class.name"
	//ex:Object.Creature.Player.Lancer
	
	//public ImageIcon cardPicture=null;
	//if need to change ImageIcon,use setIcon in set;(method in JButton)
	private class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	} 
}
