package shapeJump;

import java.awt.Polygon;
import java.util.ArrayList;

public class CustomPolygon extends Polygon {

	public static void main(String[] args) {
		CustomPolygon runIt = new CustomPolygon();
		runIt.runFromMain();
	}

	public void runFromMain() {

	}
	
	public CustomPolygon() {
		
		
		
		
	}

	public CustomPolygon(int xCoord) {
		
		newRandomShape(xCoord);
		
		
	}
	
	public void newRandomShape(int xCoord) {

		ArrayList<Integer> xCoordVals = new ArrayList<Integer>();
		ArrayList<Integer> yCoordVals = new ArrayList<Integer>();

		int col = (int) (Math.random() * 3 + 1);
		int prevRow = 0;
		for (int c = 1; c < col + 1; c++) {

			int row = (int) (Math.random() * 3 + 1);
			addColumn(c, row, prevRow, xCoordVals, yCoordVals, xCoord);
			prevRow = row;
		}

		xCoordVals.add((col) * 22 + xCoord);
		yCoordVals.add(400);

		Integer[] xC = new Integer[xCoordVals.size()];
		xCoordVals.toArray(xC);
		int[] x = new int[xC.length];

		Integer[] yC = new Integer[yCoordVals.size()];
		yCoordVals.toArray(yC);
		int[] y = new int[yC.length];

		for (int i = 0; i < xC.length; i++) {

			x[i] = xC[i];
			y[i] = yC[i];

		}

		this.xpoints = x;
		this.ypoints = y;
		this.npoints = x.length;
		

	}

	public void addColumn(int col, int row, int prevRow,
			ArrayList<Integer> xCoordVals, ArrayList<Integer> yCoordVals,
			int xCoord) {

		if (prevRow > row) {

			for (int r = prevRow; r >= row; r--) {

				if (r >= row) {
					xCoordVals.add((col - 1) * 22 + xCoord);
					yCoordVals.add(400 - r * 22);

				}

			}

		}

		for (int r = prevRow; r < row + 1; r++) {

			xCoordVals.add((col - 1) * 22 + xCoord);
			yCoordVals.add(400 - r * 22);

		}
		xCoordVals.add((col) * 22 + xCoord);
		yCoordVals.add(400 - row * 22);

	}

}
