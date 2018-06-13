package card;
import javax.swing.ImageIcon;
public class Assassin extends Player{
	public Assassin(int hp){
		super("Assassin",hp);
		name="Assassin";
		this.hp=hp;
		this.maxHP=hp;
		setIcon(new ImageIcon(this.getClass().getResource("/Images/Assassin.png")));
	}
}
