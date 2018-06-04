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
import java.text.AttributedCharacterIterator;

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

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("FGO Card");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/Images/Icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 480, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton skillButton = new JButton("");
		skillButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Images/Skill_Btn.png")));
		skillButton.setBounds(255, 152, 125, 159);
		//skillButton.setOpaque(false);
		skillButton.setContentAreaFilled(false);
		skillButton.setBorderPainted(false);
		skillButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		skillButton.setFocusPainted(false);
		contentPane.add(skillButton);

		JButton startButton = new JButton("");
		startButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Images/Start_Btn.png")));
		startButton.setBounds(255, 352, 125, 133);
		//startButton.setOpaque(false);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		startButton.setFocusPainted(false);
		contentPane.add(startButton);

		
		JButton chararcterButton = new JButton("")
		{
		    protected void paintComponent(Graphics g)
		    {
		    	
		    	g.setColor(new Color(0, 0, 0, 100));
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};		
		chararcterButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Images/Character_Btn.png")));
		chararcterButton.setBounds(95, 152, 125, 159);
		chararcterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chararcterButton.setFocusPainted(false);	
		chararcterButton.setContentAreaFilled(false);
		chararcterButton.setBorderPainted(false);
		chararcterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {	
				chararcterButton.paintComponents(Graphics );
			}
			@Override
			public void mouseExited(MouseEvent e) {		
				chararcterButton.setContentAreaFilled(false);			
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("lol");
			}
		});
		contentPane.add(chararcterButton);

		JButton achievementButton = new JButton("");
		achievementButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Images/Reward_Btn.png")));
		achievementButton.setBounds(95, 340, 125, 159);
		//achievementButton.setOpaque(false);
		achievementButton.setContentAreaFilled(false);
		achievementButton.setBorderPainted(false);
		achievementButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		achievementButton.setFocusPainted(false);
		contentPane.add(achievementButton);

		JLabel Menu_BackGround = new JLabel("");
		Menu_BackGround.setIcon(new ImageIcon(MainWindow.class.getResource("/Images/MainBackgroun.png")));
		Menu_BackGround.setBounds(0, 0, 464, 681);
		contentPane.add(Menu_BackGround);
	}
}
