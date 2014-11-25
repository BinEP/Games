package shapeJump;

public class Shape {

	public int[] x;
	public int[] y;
	public int numOfShapes = 1;

	public Shape() {

		switch ((int) Math.random() * numOfShapes + 1) {

		case 1:

			break;
		case 2:

			break;
		case 3:

			break;

		}

	}

	public void OnexOne() {
		
		int[] x1 = {1};
		int[] y1 = {1};
		x = x1;
		y = y1;
		
	}

	public void OnexTwo() {

		int[] x1 = {1, 1};
		int[] y1 = {1, 2};
		x = x1;
		y = y1;
	}

	public void OnexThree() {
		int[] x1 = {1, 1, 1};
		int[] y1 = {1, 2, 3};
		x = x1;
		y = y1;
	}

	public void TwoxOne() {
		int[] x1 = {1, 2};
		int[] y1 = {1, 1};
		x = x1;
		y = y1;
	}

	public void TwoxTwo() {
		int[] x1 = {1, 2, 1, 2};
		int[] y1 = {1, 1, 2, 2};
		x = x1;
		y = y1;
	}

	public void TwoxThree() {
		int[] x1 = {1, 1, 1, 2, 2, 2};
		int[] y1 = {1, 2, 3, 1, 2, 3};
		x = x1;
		y = y1;
	}

	public void ThreexOne() {
		int[] x1 = {1, 2, 3};
		int[] y1 = {1, 1, 1};
		x = x1;
		y = y1;
	}

	public void ThreexTwo() {
		int[] x1 = {1, 2, 3, 1, 2, 3};
		int[] y1 = {1, 1, 1, 2, 2, 2};
		x = x1;
		y = y1;
	}

	public void ThreexThree() {
		int[] x1 = {1, 2, 3, 1, 2, 3, 1, 2, 3};
		int[] y1 = {1, 1, 1, 2, 2, 2, 3, 3, 3};
		x = x1;
		y = y1;
	}

	public static void main(String[] args) {

	}
}
