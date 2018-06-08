package card;
import javax.swing.ImageIcon;
public class Caster extends Player{
	Caster(int hp){
		super("Caster",hp);
		setIcon(new ImageIcon(getClass().getResource("/Images/caster.png")));
	}
}
