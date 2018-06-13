package card;

import javax.swing.ImageIcon;

public class Bomb extends Item {
	public Bomb(int size){
		super("Bomb");
		hp=size;
		setIcon(new ImageIcon(getClass().getResource("/Images/Bomb_Game.png")));
	}

	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub
		
	}

}
