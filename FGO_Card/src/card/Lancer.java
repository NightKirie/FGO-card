package card;
import javax.swing.ImageIcon;
public class Lancer extends Player{
	Lancer(int hp){
		super("Lancer",hp);
		setIcon(new ImageIcon(getClass().getResource("/Images/lancer.png")));
	}
}
