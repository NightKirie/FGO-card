package card;

import javax.swing.ImageIcon;

import menu.MainWindow;
import java.util.Random;
public class Minion extends Monster {
	private Random random = new Random();
	private static ImageIcon[] Minion = {
			new ImageIcon(MainWindow.class.getResource("/image/Minion1_Battle.jpg")),
			new ImageIcon(MainWindow.class.getResource("/image/Minion2_Battle.jpg")),
			new ImageIcon(MainWindow.class.getResource("/image/Minion3_Battle.jpg")),
			new ImageIcon(MainWindow.class.getResource("/image/Minion4_Battle.jpg")),
			new ImageIcon(MainWindow.class.getResource("/image/Minion5_Battle.jpg")),
			new ImageIcon(MainWindow.class.getResource("/image/Minion6_Battle.jpg"))
	};

	public Minion(int size) {
		super("minion");
		name="minion";
		ImageIcon cardPicture=null;
		hp=size;
		hpShow.setText(Integer.toString(hp));
		cardPicture = Minion[random.nextInt(6)];
		setIcon(cardPicture);
	}

}
