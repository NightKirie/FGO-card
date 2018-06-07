package Menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Button extends JButton{
	private double volumn = 1.0;
	
	public Button(){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {	
				setBackground(new Color(255, 255, 255, 100));
				MediaPlayer mouseEnterFX = new MediaPlayer(new Media(getClass().getResource("/Audio/Btn_hoveron.mp3").toString()));
				mouseEnterFX.setVolume(volumn);
				mouseEnterFX.play();
			}
			@Override
			public void mouseExited(MouseEvent e) {				
				setBackground(new Color(255, 255, 255, 0));
			}
			public void mousePressed(MouseEvent e) {				
				MediaPlayer mousePressFX = new MediaPlayer(new Media(getClass().getResource("/Audio/Btn_Clicked.mp3").toString()));
				mousePressFX.setVolume(volumn);
				mousePressFX.play();
			}
		});		
		setBackground(new Color(255, 255, 255, 0));
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
	public void setVolumn(double volumn) {
		this.volumn = volumn;
	}

	
}
