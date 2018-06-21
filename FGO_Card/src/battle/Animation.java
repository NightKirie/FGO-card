package battle;

import card.Card;
import java.util.TimerTask;
import java.awt.Point;
public class Animation extends TimerTask{
	public Animation(Battle field,Point position,int direction){//move
		this.field=field;
		a=position;
		this.direction=direction;
		moveDelay=10;
	}
	public Animation(Battle field,Point a,Point b){//swap
		this.field=field;
		this.a=a;
		this.b=b;
		s=new Point(15*(b.x-a.x),20*(b.y-a.y));
		rs=new Point(-s.x,-s.y);
		moveDelay=10;
	}
	public Animation(Battle field,int Delay){//shake
		s=field.getLocation();
		a=Battle.addPoint(s,new Point(3,4));
		b=Battle.addPoint(s,new Point(-3,-4));
		this.field=field;
		moveDelay=Delay;
	}
	int moveDelay=0,direction=-1;
	Point a=null,b=null,s=null,rs=null;
	Battle field;

	public void run(){
		if(moveDelay>0){
			if(direction>=0){//move one card
				field.map[a.x][a.y].setLocation(15*Battle.relation[direction].x,20*Battle.relation[direction].y);
			}
			else if(rs==null){//shake
				if(moveDelay%2==0) field.setLocation(a);
				else field.setLocation(b);
			}
			else{//swap
				field.map[a.x][a.y].setLocation(Battle.addPoint(field.map[a.x][a.y].getLocation(),s));
				field.map[b.x][b.y].setLocation(Battle.addPoint(field.map[b.x][b.y].getLocation(),rs));
			}
			--moveDelay;	
		}
		else{
			if(direction>=0){//move one card
				Point next=Battle.addPoint(a,Battle.relation[direction]);
				field.map[next.x][next.y]=field.map[a.x][a.y];
				field.map[next.x][next.y].setLocation(15+150*next.x,100+200*next.y);
			}
			else if(rs!=null){//swap card
				Card tmp=field.map[a.x][a.y];
				field.map[a.x][a.y]=field.map[b.x][b.y];
				field.map[b.x][b.y]=tmp;
				field.map[a.x][a.y].setLocation(15+150*a.x,100+200*a.y);
				field.map[b.x][b.y].setLocation(15+150*b.x,100+200*b.y);
			}
			cancel();
		}
	}
}
