package card;
import javax.swing.ImageIcon;
public class Lancer extends Player{
	public Lancer(int hp){
		super("Lancer",hp);
		name="lancer";
		this.hp=hp;
		this.maxHP=hp;
		setIcon(new ImageIcon(this.getClass().getResource("/image/Icon.png")));
	}
}
