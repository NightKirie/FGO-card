package card;
import javax.swing.ImageIcon;
public class Assassin extends Player{
	public Assassin(int hp){
		super("Assassin");
		name="Assassin";
		this.hp=hp;
		this.maxHP=hp;
		hpShow.setText(Integer.toString(hp));
		setIcon(new ImageIcon(this.getClass().getResource("/image/Assassin_Battle.jpg")));
	}
}
