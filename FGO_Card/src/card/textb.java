package card;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import menu.MainWindow;

public class textb extends JButton {
	public textb()
	{
		super();
		setSize(150,200);
		setIcon(new ImageIcon(MainWindow.class.getResource("/image/Caster_Menu.png")));
		setLocation(150,550);
	}
}
