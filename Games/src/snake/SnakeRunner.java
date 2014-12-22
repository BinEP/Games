package snake;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SnakeRunner {

	public static void main(String[] args) {

		JFrame frame = new JFrame("SNAKE!");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setAlwaysOnTop(true);

		SnakePanel SnakePanel = new SnakePanel();
		// WebSnake SnakePanel = new WebSnake();
		frame.add(SnakePanel, BorderLayout.CENTER);

//		 ImageIcon img = new ImageIcon("/Infofiles/snakeIcon.png");
//		 frame.setIconImage(img.getImage());

		
		

		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
