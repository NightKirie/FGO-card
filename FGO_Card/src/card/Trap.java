package card;

import javax.swing.ImageIcon;

public class Trap extends Item {
	public Trap(int hp){
		super("Trap");
		this.hp=hp;
		updateCard();
	}
	public boolean hurttag=true;
	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub
		
	}
	public void updateStatus()
	{
		hurttag=!hurttag;
	}
	public void updateUI()
	{
		hpShow.setText(Integer.toString(hp));
		if(hurttag) this.setIcon(new ImageIcon(this.getClass().getResource("/image/Icon.png")));
		else this.setIcon(new ImageIcon(this.getClass().getResource("/image/Icon.png")));
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
