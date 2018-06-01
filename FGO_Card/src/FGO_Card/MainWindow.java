package FGO_Card;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
		skillButton.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/Images/Icon.png")));
		skillButton.setIcon(new ImageIcon(MainWindow.class.getResource("/Images/Skill_Btn.png")));
		skillButton.setBounds(253, 150, 127, 159);
		///skillButton.setOpaque(false);
		//skillButton.setContentAreaFilled(false);
		//skillButton.setBorderPainted(false);
		contentPane.add(skillButton);
		
		JLabel Menu_BackGround = new JLabel("");
		Menu_BackGround.setIcon(new ImageIcon(MainWindow.class.getResource("/Images/MainBackgroun.png")));
		Menu_BackGround.setBounds(0, 0, 464, 681);
		contentPane.add(Menu_BackGround);
	}
}
