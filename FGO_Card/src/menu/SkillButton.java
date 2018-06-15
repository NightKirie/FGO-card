package menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SkillButton extends JButton{
	private static double volume = 1.0;
	private static int chosenSkillNumber = 0;
	private boolean onChosen;	//for double click choose the skill
	//private boolean onSelected;	//for single click see the detail or upgrade the skill
	
	public SkillButton(){
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {	
				MediaPlayer mouseEnterFX = new MediaPlayer(new Media(getClass().getResource("/audio/Btn_hoveron.mp3").toString()));
				mouseEnterFX.setVolume(volume);
				mouseEnterFX.play();
				//show the hover effect if this skill isn't be chosen and selected
				if(!onChosen && !isFocusOwner())
					setBackground(new Color(255, 255, 255, 100));
			}
			public void mouseExited(MouseEvent e) {				
				//reset the hover effect if this skill isn't be chosen and selected
				if(!onChosen && !isFocusOwner())
					setBackground(new Color(255, 255, 255, 0));
			}

			public void mousePressed(MouseEvent e) {				
				MediaPlayer mousePressFX = new MediaPlayer(new Media(getClass().getResource("/audio/Btn_Clicked.mp3").toString()));
				mousePressFX.setVolume(volume);
				mousePressFX.play();
				//double click to choose the skill
				if(e.getClickCount() == 2){
					//if the skill isn't be chosen, and there's smaller than three skill chosen, double click to choose the skill
					if(!onChosen && chosenSkillNumber < 3) { 
						onChosen = true;
						setBackground(new Color(255, 0, 0, 255));
						++chosenSkillNumber;
					}
					//if the skill is be chosen, double click to unchoose
					else if(onChosen) {
						onChosen = false;
						//after double click, the skill must be focus on, set the background color to onSelect color
						setBackground(new Color(255, 255, 255, 255));
						--chosenSkillNumber;
					}
				}
			}
		});	
		addFocusListener(new FocusAdapter() {
			//if the skill isn't be chosen, single click to show detail
			public void focusGained(FocusEvent e) {
				if(!onChosen) {
					setBackground(new Color(255, 255, 255, 255));
				}
			}
			//if the skill is be chosen, single click other skill, reset this skill 
			public void focusLost(FocusEvent e) {
				if(!onChosen) {
					setBackground(new Color(255, 255, 255, 0));
				}
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