package cardtest;

import javax.swing.ImageIcon;

public class Lancer2 extends Player2 {

	public Lancer2(int hp){
		super("Lancer");
		this.hp=hp;
		this.maxHP=hp;
		setIcon(new ImageIcon(this.getClass().getResource("/image/Lancer_Menu.png")));
	}

}
