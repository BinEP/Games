package shapeJump;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

public class CustomPolygon extends Polygon {

	public ArrayList<Integer> height = new ArrayList<Integer>();
	public ArrayList<Rectangle> columns = new ArrayList<Rectangle>();

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

			int rowHeight = 400 - row * 22;
			height.add(rowHeight);

			columns.add(new Rectangle((c - 1) * 22 + xCoord, rowHeight,
					22, row * 22));

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

	public int getColIndex(int xCoord) {

		int i = 0;
		for (Rectangle r : columns) {
			if (xCoord >= r.getY() && xCoord <= r.getY() + r.getWidth()) {
				break;
			}
			
			i++;
			System.out.println(i);

		}
		return i;
	}
	
	public int getColumnY(int xCoord, int ground) {
		
		if (xCoord <= columns.get(0).getX()) return ground;
		System.out.println(columns.get(0).getX());
		int index = getColIndex(xCoord);
		
		System.out.println(height.toString());
		System.out.println(columns.toString());
		
		
		return (int) height.get(index);
		
		
	}

	public void translate(int dx, int dy) {

		super.translate(dx, dy);

		for (Rectangle r : columns) {

			r.translate(dx, dy);
		}

	}

}
