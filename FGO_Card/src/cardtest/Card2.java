package cardtest;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;
import java.awt.Point;
import battle.Battle;
import menu.MainWindow;

public class Card2 extends JButton{
	

	public Card2(String scientificName) {
		// TODO Auto-generated constructor stub
		super(scientificName);
		setIcon(new ImageIcon(MainWindow.class.getResource("/image/Gold_Amount.png")));
		setSize(150,200);
		//setMargin(new Insets(0, 0, 0, 0));
	}
}
