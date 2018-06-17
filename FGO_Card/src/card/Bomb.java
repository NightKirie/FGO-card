package card;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import battle.*;
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
		--countdown;
		if(countdown==0)
		{
			Point location=field.getLocation(this);
			for(int i=0;i<Battle.relation.length;++i){
				Point p=Battle.addPoint(location,Battle.relation[i]);
				if(field.inField(p)) ((Object)field.map[p.x][p.y]).getBombDamage(this.hp);
			}
			field.map[location.x][location.y]=new Coin(hp);
			/*
			for(int x=-1;x<=1;x+=2)
			{
				for(int y=-1;y<=1;y+=2)
				{
					if(location.x+x>=0&&location.x+x<=2&&location.y+y>=0&&location.y+y<=2)
					{
						((Object)Battle.map[location.x+x][location.y+y]).getBombDamage(this.hp);
					}
				}
			}
			this.hp=0;
			*/
		}
	}
	public void updateUI(){
		hpShow.setText(Integer.toString(hp));
		bombcount.setText("count"+Integer.toString(this.hp));
	}
	//I'm not sure this can work or not
	//You can put it in updateStatus XD
	/*public void explosion(Object input)
	{
	}
	*/
	@Override
	public void effect(Player input) {
		// TODO Auto-generated method stub
		
	}

}
