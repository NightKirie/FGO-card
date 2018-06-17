package cardtest;

import javax.swing.ImageIcon;

public class Trap2 extends Item2 {
	public Trap2(int hp){
		super("Trap");
		this.hp=hp;
	}
	public boolean hurttag=true;
	@Override
	public void effect(Player2 input) {
		// TODO Auto-generated method stub
		
	}
	public void updateStatus()
	{
		if(hurttag)
		{
			hurttag=false;
			this.setIcon(new ImageIcon(this.getClass().getResource("/image/Icon.png")));
		}
		if(!hurttag)
		{
			hurttag=true;
			this.setIcon(new ImageIcon(this.getClass().getResource("/image/Icon.png")));
		}
	}
	public void updateUI()
	{
		//hpShow.setText(Integer.toString(hp));
	}
	public void StepTrap(Player2 player)
	{
		if(hurttag)
		{
			//player.getTrapDamage(this.hp);
		}
		this.hp=0;
	}
}
