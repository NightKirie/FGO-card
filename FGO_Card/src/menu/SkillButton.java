package menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SkillButton extends JButton{
	private static double volume = 1.0;
	private boolean selected;
	
	public SkillButton(){
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {	
				MediaPlayer mouseEnterFX = new MediaPlayer(new Media(getClass().getResource("/audio/Btn_hoveron.mp3").toString()));
				mouseEnterFX.setVolume(volume);
				mouseEnterFX.play();
				if(!selected)
					setBackground(new Color(255, 255, 255, 100));
			}
			public void mouseExited(MouseEvent e) {				
				if(!selected)
					setBackground(new Color(255, 255, 255, 0));
			}

			public void mousePressed(MouseEvent e) {				
				MediaPlayer mousePressFX = new MediaPlayer(new Media(getClass().getResource("/audio/Btn_Clicked.mp3").toString()));
				mousePressFX.setVolume(volume);
				mousePressFX.play();
				selected = !selected;
				if(selected) 				
					setBackground(new Color(255, 255, 255, 255));
				else 
					setBackground(new Color(255, 255, 255, 0));
			}
		});		
		setBackground(new Color(0, 0, 0, 0));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setFocusPainted(false);	
		setOpaque(false);
		setBorderPainted(false);
	}
	
	protected void paintComponent(Graphics g)
	{		    	
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	public static void setVolume(double volume) {
		SkillButton.volume = volume;
	}

	
}