package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.text.AttributedCharacterIterator;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**********
	  Launch the application.
	 ****/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void CreateMenuButton() {
		JButton skillButton = new JButton("")
		{
		    protected void paintComponent(Graphics g)
		    {
		    	
		    	g.setColor(getBackground());
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};	
		skillButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/Skill_Btn.png")));
		skillButton.setBounds(255, 152, 125, 159);
		skillButton.setBackground(new Color(255, 255, 255, 0));
		skillButton.setOpaque(false);
		skillButton.setBorderPainted(false);
		skillButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		skillButton.setFocusPainted(false);
		skillButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {	
				skillButton.setBackground(new Color(255, 255, 255, 100));
			}
			@Override
			public void mouseExited(MouseEvent e) {				
				skillButton.setBackground(new Color(255, 255, 255, 0));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("skill");
			}
		});
		contentPane.add(skillButton);

		JButton startButton = new JButton("")
		{
		    protected void paintComponent(Graphics g)
		    {
		    	
		    	g.setColor(getBackground());
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};	
		startButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/Start_Btn.png")));
		startButton.setBounds(255, 340, 125, 145);
		startButton.setBackground(new Color(255, 255, 255, 0));
		startButton.setOpaque(false);
		startButton.setBorderPainted(false);
		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {	
				startButton.setBackground(new Color(255, 255, 255, 100));
			}
			@Override
			public void mouseExited(MouseEvent e) {				
				startButton.setBackground(new Color(255, 255, 255, 0));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("start");
			}
		});
		contentPane.add(startButton);

		
		JButton chararcterButton = new JButton("")
		{
		    protected void paintComponent(Graphics g)
		    {
		    	
		    	g.setColor(getBackground());
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};	
		chararcterButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/Character_Btn.png")));
		chararcterButton.setBounds(95, 152, 125, 159);
		chararcterButton.setBackground(new Color(255, 255, 255, 0));
		chararcterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chararcterButton.setFocusPainted(false);	
		chararcterButton.setOpaque(false);
		chararcterButton.setBorderPainted(false);
		chararcterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {	
				chararcterButton.setBackground(new Color(255, 255, 255, 100));
			}
			@Override
			public void mouseExited(MouseEvent e) {				
				chararcterButton.setBackground(new Color(255, 255, 255, 0));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("character");
			}
		});
		contentPane.add(chararcterButton);

		JButton achievementButton = new JButton("")
		{
		    protected void paintComponent(Graphics g)
		    {
		    	
		    	g.setColor(getBackground());
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};	
		achievementButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/Reward_Btn.png")));
		achievementButton.setBounds(95, 340, 125, 145);
		achievementButton.setBackground(new Color(255, 255, 255, 0));
		achievementButton.setOpaque(false);
		achievementButton.setBorderPainted(false);
		achievementButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		achievementButton.setFocusPainted(false);
		achievementButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {	
				achievementButton.setBackground(new Color(255, 255, 255, 100));
			}
			@Override
			public void mouseExited(MouseEvent e) {				
				achievementButton.setBackground(new Color(255, 255, 255, 0));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("achievement");
			}
		});
		contentPane.add(achievementButton);

		JLabel Menu_BackGround = new JLabel("");
		Menu_BackGround.setIcon(new ImageIcon(MainWindow.class.getResource("/Image/MainBackgroun.png")));
		Menu_BackGround.setBounds(0, 0, 464, 681);
		contentPane.add(Menu_BackGround);
		
	}
	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("FGO Card");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/Image/Icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 480, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		CreateMenuButton();
	}
}
