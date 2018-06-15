package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Bomb extends Item {
	public Bomb(int size){
		super("Bomb");
		hp=size;
		setIcon(new ImageIcon(getClass().getResource("/Images/Bomb_Game.png")));
		bombcount.setBounds(0, 70,50,50);
		add(bombcount);
	}
	public int countdown=5;
	public JLabel bombcount=new JLabel("0");
	
	public void updateStatus()
	{
		hpshow.setText(Integer.toString(hp));
		bombcount.setText("count"+Integer.toString(this.hp));
	}
	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub
		
	}

}
