package card;
import javax.swing.ImageIcon;
public class Caster extends Player{
	public Caster(int hp){
		super("Caster",hp);
		name="caster";
		this.hp=hp;
		this.maxHP=hp;
		setIcon(new ImageIcon(this.getClass().getResource("/Images/Caster.png")));
	}
}
