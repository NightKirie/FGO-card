package cardtest;
import javax.swing.ImageIcon;
public class Assassin2 extends Player2{
	public Assassin2(int hp){
		super("Assassin");
		this.hp=hp;
		this.maxHP=hp;
		setIcon(new ImageIcon(this.getClass().getResource("/image/Assassin_Menu.png")));
	}
}
