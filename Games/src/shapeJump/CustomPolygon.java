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

		int rh = 0;
		int r = 0;
		int col = (int) (Math.random() * 3 + 1);
		int prevRow = 0;
		for (int c = 1; c < col + 1; c++) {

			int row = (int) (Math.random() * 3 + 1);
			r = row;
			addColumn(c, row, prevRow, xCoordVals, yCoordVals, xCoord);

			int rowHeight = 400 - row * 22;
			rh = rowHeight;
			height.add(rowHeight);

			columns.add(new Rectangle((c - 1) * 22 + xCoord, rowHeight, 22,
					row * 22));

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
			if (xCoord >= r.getX() && xCoord < r.getX() + r.getWidth()) {

				System.out.print(xCoord + "\t");
				System.out.print(r.getX() + "\t");
				System.out.print(r.getX() + r.getWidth() + "\t");
				System.out.println(i);

				break;
			}

			i++;

		}
		return i;
	}

	public int getColumnY(int xCoord, int ground) {

		int index;
		int index1;
		if (xCoord <= columns.get(0).getX()
				|| xCoord > 22 * (columns.size() + 1) + columns.get(0).getX())
			return ground;
		if ((xCoord > 22 * (columns.size()) + columns.get(0).getX()
				&& xCoord < 22 * (columns.size() + 1) + columns.get(0).getX())) {

			index = getColIndex(xCoord - 22);

		} else {
			
			index = getColIndex(xCoord);
			index1 = getColIndex(xCoord - 22);
			if (index1 < index) index = index1;
		}
		return (int) height.get(index);

	}

	public void translate(int dx, int dy) {

		super.translate(dx, dy);

		for (Rectangle r : columns) {

			r.translate(dx, dy);
		}

	}

}
