package shapeJump;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CustomShape extends JPanel {

	public int[] x;
	public int[] y;
	public int[] xCoord;
	public int[] yCoord;
	public int h;
	public int w;
	public int numOfShapes = 20;
	public int[][] topXY;
	public int[][] outXY;
	ArrayList<Point> outline = new ArrayList<Point>();
	ArrayList<Integer> xVals = new ArrayList<Integer>();
	ArrayList<Integer> yVals = new ArrayList<Integer>();
	
	ArrayList<Integer> xCoordVals = new ArrayList<Integer>();
	ArrayList<Integer> yCoordVals = new ArrayList<Integer>();
	
	public Polygon theShape;
	

	public CustomShape() {
		int shapeNum = (int) (Math.random() * (numOfShapes + 1));
		switch (shapeNum) {

		case 1:
			OnexOne();
			break;
		case 2:
			OnexTwo();
			break;
		case 3:
			OnexThree();
			break;
		case 4:
			TwoxOne();
			break;
		case 5:
			TwoxTwo();
			break;
		case 6:
			TwoxThree();
			break;
		case 7:
			ThreexOne();
			break;
		case 8:
			ThreexTwo();
			break;
		case 9:
			ThreexThree();
			break;
		case 10:
			TwoStep();
			break;
		case 11:
			DownTwoStep();
			break;
		case 12:
			ThreeStep();
			break;
		case 13:
			DownThreeStep();
			break;
		case 14:
			UpLittleT();
			break;
		case 15:
//			DownLittleT();
			UpLittleT();
			break;
		case 16:
			UpBigT();
			break;
		case 17:
			DownBigT();
			break;
		case 18:
			TwoxTwoPlusOne();
			break;
		case 19:
			OnePlusTwoxTwo();
			break;
		case 20:
			ThreexTwoPlusOne();
			break;
		default:
			OnexOne();
			break;

		}
		
		newRandomShape();
		
//		JFrame frame = new JFrame("Shape Jumper");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(new BorderLayout());
//		frame.setAlwaysOnTop(true);
//		
//		//CustomShape customShape = new CustomShape();
//		frame.add(this, BorderLayout.CENTER);
//		
//		frame.setSize(500, 500);
//		frame.setVisible(true);
//		setBackground(Color.BLACK);
//		
//		setFocusable(true);

		

	}

	public void OnexOne() {

		// ■
		int[] x1 = { 1 };
		int[] y1 = { 1 };
		x = x1;
		y = y1;
		h = 1;
		w = 1;
		int[][] topXYf = { { 1, 1 } };
		topXY = topXYf;
		int[][] outXYf = { { 1, 1 } };
		outXY = outXYf;

	}

	public void OnexTwo() {

		// ■
		// ■
		int[] x1 = { 1, 1 };
		int[] y1 = { 1, 2 };
		x = x1;
		y = y1;
		h = 2;
		w = 1;
		int[][] topXYf = { { 1, 2 } };
		topXY = topXYf;
		int[][] outXYf = { { 1, 1 }, { 1, 2 } };
		outXY = outXYf;
	}

	public void OnexThree() {
		// ■
		// ■
		// ■
		int[] x1 = { 1, 1, 1 };
		int[] y1 = { 1, 2, 3 };
		x = x1;
		y = y1;
		h = 3;
		w = 1;
		int[][] topXYf = { { 1, 3 } };
		topXY = topXYf;
		int[][] outXYf = { { 1, 1 }, { 1, 2 }, { 1, 3 } };
		outXY = outXYf;

	}

	public void TwoxOne() {
		// ■ ■
		int[] x1 = { 1, 2 };
		int[] y1 = { 1, 1 };
		x = x1;
		y = y1;
		h = 1;
		w = 2;
		int[][] topXYf = { { 1, 1 }, { 2, 1 } };
		topXY = topXYf;
		int[][] outXYf = { { 1, 1 }, { 2, 1 } };
		outXY = outXYf;
	}

	public void TwoxTwo() {
		// ■ ■
		// ■ ■
		int[] x1 = { 1, 1, 2, 2 };
		int[] y1 = { 1, 2, 1, 2 };
		x = x1;
		y = y1;
		h = 2;
		w = 2;
		int[][] topXYf = { { 1, 2 }, { 2, 2 } };
		topXY = topXYf;
	}

	public void TwoxThree() {
		// ■ ■
		// ■ ■
		// ■ ■
		int[] x1 = { 1, 1, 1, 2, 2, 2 };
		int[] y1 = { 1, 2, 3, 1, 2, 3 };
		x = x1;
		y = y1;
		h = 3;
		w = 2;
		int[][] topXYf = { { 1, 3 }, { 2, 3 } };
		topXY = topXYf;
		int[][] outXYf = { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, 1 }, { 2, 2 },
				{ 2, 3 } };
		outXY = outXYf;
	}

	public void ThreexOne() {
		// ■ ■ ■
		int[] x1 = { 1, 2, 3 };
		int[] y1 = { 1, 1, 1 };
		x = x1;
		y = y1;
		h = 1;
		w = 3;
		int[][] topXYf = { { 1, 1 }, { 2, 1 }, { 3, 1 } };
		topXY = topXYf;
		int[][] outXYf = { { 1, 1 }, { 2, 1 }, { 3, 1 } };
		outXY = outXYf;
	}

	public void ThreexTwo() {
		// ■ ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 1, 2, 2, 3, 3 };
		int[] y1 = { 1, 2, 1, 2, 1, 2 };
		x = x1;
		y = y1;
		h = 2;
		w = 3;
		int[][] topXYf = { { 1, 1 }, { 1, 2 }, { 2, 2 }, { 3, 2 }, { 3, 1 } };
		topXY = topXYf;
	}

	public void ThreexThree() {
		// ■ ■ ■
		// ■ ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 1, 1, 2, 2, 2, 3, 3, 3 };
		int[] y1 = { 1, 2, 3, 1, 2, 3, 1, 2, 3 };
		x = x1;
		y = y1;
		h = 3;
		w = 3;
		int[][] topXYf = { { 1, 3 }, { 2, 3 }, { 3, 3 } };
		topXY = topXYf;
		int[][] outXYf = { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, 3 }, { 3, 3 },
				{ 3, 2 }, { 3, 1 } };
		topXY = outXYf;
	}

	public void TwoStep() {

		// ■
		// ■ ■
		int[] x1 = { 1, 2, 2 };
		int[] y1 = { 1, 1, 2 };
		x = x1;
		y = y1;
		h = 2;
		w = 2;
		int[][] topXYf = { { 1, 1 }, { 2, 2 } };
		topXY = topXYf;
		int[][] outXYf = { { 1, 1 }, { 1, 2 } };
		outXY = outXYf;

	}

	public void DownTwoStep() {

		// ■
		// ■ ■
		int[] x1 = { 1, 1, 2 };
		int[] y1 = { 1, 2, 1 };
		x = x1;
		y = y1;
		h = 2;
		w = 2;
		int[][] topXYf = { { 1, 2 }, { 2, 1 } };
		topXY = topXYf;
		int[][] outXYf = { { 1, 1 }, { 1, 2 } };
		outXY = outXYf;

	}

	public void ThreeStep() {

		// ■
		// ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 2, 2, 3, 3, 3 };
		int[] y1 = { 1, 1, 2, 1, 2, 3 };
		x = x1;
		y = y1;
		h = 3;
		w = 3;
		int[][] topXYf = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
		topXY = topXYf;

	}

	public void DownThreeStep() {

		// ■
		// ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 1, 1, 2, 2, 3 };
		int[] y1 = { 1, 2, 3, 1, 2, 1 };
		x = x1;
		y = y1;
		h = 3;
		w = 3;
		int[][] topXYf = { { 1, 3 }, { 2, 2 }, { 3, 1 } };
		topXY = topXYf;

	}

	public void UpLittleT() {

		//
		// ■
		// ■ ■ ■
		int[] x1 = { 1, 2, 2, 3 };
		int[] y1 = { 1, 1, 2, 1 };
		x = x1;
		y = y1;
		h = 2;
		w = 3;
		int[][] topXYf = { { 1, 1 }, { 2, 2 }, { 3, 1 } };
		topXY = topXYf;
		int[][] outXYf = { { 1, 1 }, { 1, 2 } };
		outXY = outXYf;

	}

	public void DownLittleT() {

		//
		// ■ ■ ■
		// ■
		int[] x1 = { 1, 2, 2, 3 };
		int[] y1 = { 2, 1, 2, 2 };
		x = x1;
		y = y1;
		h = 2;
		w = 3;
		int[][] topXYf = { { 1, 2 }, { 2, 2 }, { 3, 2 } };
		topXY = topXYf;
		int[][] outXYf = { { 1, 1 }, { 1, 2 } };
		outXY = outXYf;

	}

	public void UpBigT() {

		// ■
		// ■
		// ■ ■ ■
		int[] x1 = { 1, 2, 2, 2, 3 };
		int[] y1 = { 1, 1, 2, 3, 1 };
		x = x1;
		y = y1;
		h = 3;
		w = 3;
		int[][] topXYf = { { 1, 1 }, { 2, 3 }, { 3, 1 } };
		topXY = topXYf;

	}

	public void DownBigT() {

		// ■ ■ ■
		// ■
		// ■
		int[] x1 = { 1, 2, 2, 2, 3 };
		int[] y1 = { 3, 1, 2, 3, 3 };
		x = x1;
		y = y1;
		h = 3;
		w = 3;
		int[][] topXYf = { { 1, 3 }, { 2, 3 }, { 3, 3 } };
		topXY = topXYf;

	}

	public void TwoxTwoPlusOne() {

		//
		// ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 1, 2, 2, 3 };
		int[] y1 = { 1, 2, 1, 2, 1 };
		x = x1;
		y = y1;
		h = 2;
		w = 3;
		int[][] topXYf = { { 1, 2 }, { 2, 2 }, { 3, 1 } };
		topXY = topXYf;

	}

	public void OnePlusTwoxTwo() {

		//
		// ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 2, 2, 3, 3 };
		int[] y1 = { 1, 1, 2, 1, 2 };
		x = x1;
		y = y1;
		h = 2;
		w = 3;
		int[][] topXYf = { { 1, 1 }, { 2, 2 }, { 3, 2 } };
		topXY = topXYf;

	}

	public void ThreexTwoPlusOne() {

		// ■
		// ■ ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 1, 2, 2, 2, 3, 3 };
		int[] y1 = { 1, 2, 1, 2, 3, 1, 2 };

		x = x1;
		y = y1;
		h = 3;
		w = 3;
		int[][] topXYf = { { 1, 2 }, { 2, 3 }, { 3, 2 } };
		topXY = topXYf;

	}

	public void getOutside() {

		//CustomShape cs = new CustomShape();
		System.out.println(this);
		
		outline.add(new Point(0, 0));

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		System.out.println("Point Num 1: " + x.length);
		for (int val : x) {
			switch (val) {

			case 1:
				count1++;

				break;
			case 2:
				count2++;
				break;
			case 3:

				count3++;
				break;

			}

		}
//		System.out.println("Count 1: " + count1);
//		System.out.println("Count 2: " + count2);
//		System.out.println("Count 3: " + count3);

		for (int i = 0; i < count1; i++) {

			
			outline.add(new Point(0, y[i]));

		}

		for (int i = count1; i < count2 + count1; i++) {

			
			if (y[i] >= count1 || count1 > count2) outline.add(new Point(1, y[i]));
//			System.out.println((new Point(1, y[i])).toString() + (y[i] >= count1 || count1 > count2));
		}
		
		if (count2 > count3) {
			
			
			for (int i = count1; i < count1 + count2; i++) {

				
				if (y[i] > count3 || count3 == 0) outline.add(new Point(2, y[i]));
//				System.out.println((new Point(2, y[i])).toString() + (y[i] > count3 || count3 == 0));
			}
			
			
			
		}

		for (int i = count1 + count2; i < count1 + count2 + count3; i++) {

			if (y[i] == count2 || count3 == 0 || y[i] == count3) outline.add(new Point(2, y[i]));
//			System.out.println((new Point(2, y[i])).toString() + (y[i] == count2 || count3 == 0 || y[i] == count3));

		}
		if (count3 == 0) {
			outline.add(new Point(2, 0));
			
		}
		
		for (int i = count1 + count2; i < count1 + count2 + count3; i++) {

			outline.add(new Point(3, y[i]));

		}
		
		if (count3 > 0) {
			outline.add(new Point(3, 0));
			
		}

		for (Point xys : outline) {

			System.out.println("(" + xys.x + ", " + xys.y + ")");

		}
		
		ArrayList<Point> outline1 = new ArrayList<Point>(new LinkedHashSet<Point>(outline));
		outline = outline1;
//		System.out.println(outline.toString());
	}

	@Override
	public String toString() {

		String r1 = "";
		for (int x1 : x) {

			r1 = r1.concat(x1 + ", ");
		}

		String r2 = "";
		for (int y1 : y) {

			r2 = r2.concat(y1 + ", ");
		}
		return "X = " + r1 + "\nY = " + r2 + "\nPoint Num: " + x.length;
	}

	public static void main(String[] args) {
		CustomShape cs = new CustomShape();
//		cs.getOutside();
		cs.runFromMain();
		
	}
	
	public void runFromMain() {
		
//		getOutside();
//		convertCoords();
////		Polygon shapeOutline = new Polygon(x, y, x.length);
//		Polygon shapeOutline = new Polygon(xCoord, yCoord, xCoord.length);
//		
////		System.out.println("X and Y coords: ");
////		System.out.println(Arrays.toString(xCoord));
////		System.out.println(Arrays.toString(yCoord));
////		
//		System.out.println("X and Y Polygon coords: ");
//		System.out.println(Arrays.toString(shapeOutline.xpoints));
//		System.out.println(Arrays.toString(shapeOutline.ypoints));
//		
//		System.out.println(shapeOutline.getBounds());
//		
		newRandomShape();
		
		repaint();
		
		
	}
	
	public void convertCoords() {
		
//		int[][] xyCoords = outlineToArrays();
		int[][] xyCoords = outlineToArraysT();
		xCoord = xyCoords[0];
		yCoord = xyCoords[1];
		
//		System.out.println(Arrays.toString(xCoord));
//		System.out.println(Arrays.toString(yCoord));
		
		for (int i = 0; i < xCoord.length; i++) {
			
			xCoord[i] *= 22;
			xCoord[i] += 30;
			yCoord[i] *= 22;
			yCoord[i] = 400 - yCoord[i];
//			System.out.println("(" + xCoord[i] + ", " + yCoord[i] + ")");
		}
		
//		System.out.println(Arrays.toString(xCoord));
//		System.out.println(Arrays.toString(yCoord));
		
		
	}
	
	public int[][] outlineToArrays() {
		
		int[][] xyCoords = new int[2][outline.size()];
		int i = 0;
		for (Point xy : outline) {
			
			xyCoords[0][i] = xy.x;
			xyCoords[1][i] = xy.y;
			
			i++;
			
		}
		
		return xyCoords;
		
		
	}
	
public int[][] outlineToArraysT() {
		
		int[] x1 = new int[x.length + 1];
		int i = 1;
		x1[0] = 0;
		for (int c : x) {
			x1[i] = c;
			
			i++;
		}
		
		int[] y1 = new int[y.length + 1];
		i = 1;
		y1[0] = 0;
		for (int c : y) {
			y1[i] = c;
			
			i++;
		}
		int[][] xyCoords = {x1, y1};
		
		return xyCoords;
		
		
	}


public void newRandomShape() {
	
	int col = (int) (Math.random() * 3 + 1);
	for (int c = 1; c < col + 1; c++) {
		
		int row = (int) (Math.random() * 3 + 1);
		for (int r = 0; r < row + 1; r++) {
			
			xVals.add(c - 1);
			yVals.add(r);
			
			xVals.add(c);
			yVals.add(r);
			
			
			xCoordVals.add((c - 1) * 22 + 30);
			yCoordVals.add(400 - r * 22);
			
			xCoordVals.add(c * 22 + 30);
			yCoordVals.add(400 - r * 22);
			
		}
		
	}
	
	Integer[] xC = new Integer[xCoordVals.size()];
	xCoordVals.toArray(xC);
	x = new int[xC.length];
	
	Integer[] yC = new Integer[yCoordVals.size()];
	yCoordVals.toArray(yC);
	y = new int[yC.length];
	
	
	
	for (int i = 0; i < xC.length; i++) {
		
		x[i] = xC[i];
		y[i] = yC[i];
		
		
	}
	
	theShape = new Polygon(x, y, x.length);
		
}
	
	public void paintComponent(Graphics g) {
		
		Integer[] xC = new Integer[xCoordVals.size()];
		xCoordVals.toArray(xC);
		int[] xCa = new int[xC.length];
		
		Integer[] yC = new Integer[yCoordVals.size()];
		xCoordVals.toArray(yC);
		int[] yCa = new int[yC.length];
		
		for (int i = 0; i < xC.length; i++) {
			
			xCa[i] = xC[i];
			yCa[i] = yC[i];
			
			
		}
		
		g.drawPolygon(new Polygon(xCa, yCa, xCa.length));
		
		
		
		
	}
}
