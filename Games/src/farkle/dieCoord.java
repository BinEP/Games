package farkle;
import java.awt.Point;
//import java.util.Scanner;
import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;

//import java.awt.Rectangle;

public class dieCoord extends Canvas {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public dieCoord() {
		
		
		
		
	}
	
	

	Point ul, ur, ml, mm, mr, ll, lr, total;
	
	public dieCoord(int n, int row) {
		
		int spacing = (114 * (n-1) + 11);
		int spacingy = (114 * (row-1) + 1);
		
		this.ul = new Point(spacing + 17, spacingy + 10 + 17);
		this.ml = new Point(spacing + 17, spacingy + 10 + 17 * 3);
		this.ll = new Point(spacing + 17, spacingy + 10 + 17 * 5);
		
		this.mm = new Point(spacing + 17 * 3, spacingy + 10 + 17 * 3);
		
		this.ur = new Point(spacing + 17 * 5, spacingy + 10 + 17);
		this.mr = new Point(spacing + 17 * 5, spacingy + 10 + 17 * 3);
		this.lr = new Point(spacing + 17 * 5, spacingy + 10 + 17 * 5);
		
		this.total = new Point(696, spacingy + 10 + 17 * 3);
		
	}
	
	
	
	public void drawDice(Graphics g, int[] dice) {
		int row = 1;
		int n = 1;
		for (int dieNum : dice) {

			if (dieNum != 0) {
				dieCoord die = new dieCoord(n, row);

				int r = 16;
				int d = r / 2;

				if (dieNum % 2 != 0) {
					g.fillOval(die.mm.x - d, die.mm.y - d, r, r);

				}
				if (dieNum != 1) {
					g.fillOval(die.ur.x - d, die.ur.y - d, r, r);
					g.fillOval(die.ll.x - d, die.ll.y - d, r, r);
				}
				if (dieNum > 3) {

					g.fillOval(die.ul.x - d, die.ul.y - d, r, r);
					g.fillOval(die.lr.x - d, die.lr.y - d, r, r);

				}
				if (dieNum == 6) {
					g.fillOval(die.ml.x - d, die.ml.y - d, r, r);
					g.fillOval(die.mr.x - d, die.mr.y - d, r, r);

				}

				g.drawRoundRect(114 * (n - 1) + 10, 114 * (row - 1) + 10, 104,
						104, 20, 20);
				g.drawRoundRect(114 * (n - 1) + 11, 114 * (row - 1) + 11, 102,
						102, 16, 16);
				n++;
			}

		}

	}
	
	
	public void paint(Graphics g) {
	    
		int [] n = {1, 2, 3, 4, 5, 6};
	    drawDice(g, n);
		
	}
	
	public static void main(String[] args) {
		
		
		JFrame frame = new JFrame("Farkle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        dieCoord game = new dieCoord();
        
        frame.setSize(696, 400);
        frame.add(game);
       
        frame.setVisible(true);
	}
}
