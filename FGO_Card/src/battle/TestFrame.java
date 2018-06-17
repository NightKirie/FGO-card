package battle;

import javax.swing.JFrame;

public class TestFrame{
	public static void main(String[] args){
		JFrame frame=new JFrame();
		frame.setBounds(0,0,485,748);
		frame.setVisible(true);
		Battle b=new Battle(1);
		frame.setContentPane(b);
	}
}
