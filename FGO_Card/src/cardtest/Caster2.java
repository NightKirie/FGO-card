package cardtest;

import javax.swing.ImageIcon;

public class Caster2 extends Player2 {

	public Caster2(int hp){
		super("Caster");
		this.hp=hp;
		this.maxHP=hp;
		setIcon(new ImageIcon(this.getClass().getResource("/image/Caster_Menu.png")));
	}
}
