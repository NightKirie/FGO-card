package card;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import battle.*;
public class Bomb extends Item {
	public Bomb(int size){
		super("Bomb");
		hp=size;
		ImageIcon icon  = new ImageIcon(this.getClass().getResource("/image/Bomb_Battle.jpg"));
	    Image image = icon.getImage();
	    image = image.getScaledInstance(130,200, Image.SCALE_SMOOTH);
	    icon.setImage(image);
		setIcon(icon);
		bombcount.setBounds(0, 150,50,50);
		bombcount.setFont(new Font("MV Boli", Font.PLAIN, 28));
		bombcount.setForeground(Color.WHITE);
		add(bombcount);
		updateCard();
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
				if(field.inField(p)&&(field.map[p.x][p.y] instanceof Object)) ((Object)field.map[p.x][p.y]).getBombDamage(this.hp);
			}
			field.addCard(new Coin(hp),location);
			field.remove(this);
		}
	}
	public void updateCard(){
		hpShow.setText(Integer.toString(hp));
		bombcount.setText(Integer.toString(countdown));
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
