package card;
import javax.swing.ImageIcon;
public class Assassin extends Player{
	Assassin(int hp){
		super("Assassin",hp);
		name="Assassin";
		setIcon(new ImageIcon(getClass().getResource("/Images/assassin.png")));
	}
}
