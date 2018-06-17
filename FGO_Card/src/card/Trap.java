package card;

import javax.swing.ImageIcon;

public class Trap extends Item {
	public Trap(int hp){
		super("Trap");
		this.hp=hp;
	}
	public boolean hurttag=true;
	@Override
	public void effect(Player input) {
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
	public void StepTrap(Player player)
	{
		if(hurttag)
		{
			player.getTrapDamage(this.hp);
		}
		this.hp=0;
	}
}
