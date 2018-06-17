package cardtest;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import battle.*;
public class Bomb2 extends Item2 {
	public Bomb2(int size){
		super("Bomb");
		hp=size;
		setIcon(new ImageIcon(getClass().getResource("/image/Bomb_Game.png")));
		bombcount.setBounds(0, 70,50,50);
		add(bombcount);
	}
	public int countdown=5;
	public JLabel bombcount=new JLabel("0");
	@Override
	public void effect(Player2 input) {
		// TODO Auto-generated method stub
		
	}
	
	

}
