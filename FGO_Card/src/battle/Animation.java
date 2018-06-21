package battle;

import card.Card;
import java.util.TimerTask;
import java.awt.Point;
public class Animation extends TimerTask{
	public Animation(Battle field,Card c,int direction){//move
		this.field=field;
		ca=c;
		this.direction=direction;
		s=new Point(15*Battle.relation[direction].x,20*Battle.relation[direction].y);
		moveDelay=10;
		++field.animationDelay;
	}
	public Animation(Battle field,Point a,Point b){//swap
		this.field=field;
		this.a=new Point(a);
		ca=field.map[a.x][a.y];
		this.b=new Point(b);
		cb=field.map[b.x][b.y];
		s=new Point(15*(b.x-a.x),20*(b.y-a.y));
		rs=new Point(-s.x,-s.y);
		moveDelay=10;
		++field.animationDelay;
	}
	public Animation(Battle field,int Delay){//shake
		this.field=field;
		s=field.getLocation();
		a=Battle.addPoint(s,new Point(3,4));
		b=Battle.addPoint(s,new Point(-3,-4));
		moveDelay=Delay;
		++field.animationDelay;
	}
	int moveDelay=0,direction=-1;
	Point a=null,b=null,s=null,rs=null;
	Card ca,cb;
	Battle field;

	public void run(){
		if(moveDelay>0){
			if(direction>=0){//move one card
				ca.setLocation(Battle.addPoint(ca.getLocation(),s));
			}
			else if(rs==null){//shake
				if(moveDelay%2==0) field.setLocation(a);
				else field.setLocation(b);
			}
			else{//swap
				ca.setLocation(Battle.addPoint(ca.getLocation(),s));
				cb.setLocation(Battle.addPoint(cb.getLocation(),rs));
			}
			--moveDelay;	
		}
		else{
			System.out.println(a+" "+b+" "+s+" "+rs+" "+direction);
			if(direction>=0){//move one card
				//Point next=Battle.addPoint(a,Battle.relation[direction]);
				//field.map[next.x][next.y].setLocation(15+150*next.x,100+200*next.y);
			}
			else if(rs!=null){//swap card
				//field.map[a.x][a.y].setLocation(15+150*a.x,100+200*a.y);
				//field.map[b.x][b.y].setLocation(15+150*b.x,100+200*b.y);
			}
			--field.animationDelay;
			cancel();
		}
	}
}
