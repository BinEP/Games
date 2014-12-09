package shapeJump;

public class Shape {

	public int[] x;
	public int[] y;
	public int h;
	public int w;
	public int numOfShapes = 20;
	public int[][] topXY;

	public Shape() {
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
			DownLittleT();
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

	}

	public void OnexOne() {

		// ■
		int[] x1 = { 1 };
		int[] y1 = { 1 };
		x = x1;
		y = y1;
		h = 1;
		w = 1;
		int[][] topXYf = {{1, 1}};
		topXY = topXYf;

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
		int[][] topXYf = {{1, 2}};
		topXY = topXYf;
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
		int[][] topXYf = {{1, 3}};
		topXY = topXYf;
		
	}

	public void TwoxOne() {
		// ■ ■
		int[] x1 = { 1, 2 };
		int[] y1 = { 1, 1 };
		x = x1;
		y = y1;
		h = 1;
		w = 2;
		int[][] topXYf = {{1, 1}, {2, 1}};
		topXY = topXYf;
	}

	public void TwoxTwo() {
		// ■ ■
		// ■ ■
		int[] x1 = { 1, 2, 1, 2 };
		int[] y1 = { 1, 1, 2, 2 };
		x = x1;
		y = y1;
		h = 2;
		w = 2;
		int[][] topXYf = {{1, 2}, {2, 2}};
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
		int[][] topXYf = {{1, 3}, {2, 3}};
		topXY = topXYf;
	}

	public void ThreexOne() {
		// ■ ■ ■
		int[] x1 = { 1, 2, 3 };
		int[] y1 = { 1, 1, 1 };
		x = x1;
		y = y1;
		h = 1;
		w = 3;
		int[][] topXYf = {{1, 1}, {2, 1}, {3, 1}};
		topXY = topXYf;
	}

	public void ThreexTwo() {
		// ■ ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 2, 3, 1, 2, 3 };
		int[] y1 = { 1, 1, 1, 2, 2, 2 };
		x = x1;
		y = y1;
		h = 2;
		w = 3;
		int[][] topXYf = {{1, 2}, {2, 2}, {3, 2}};
		topXY = topXYf;
	}

	public void ThreexThree() {
		// ■ ■ ■
		// ■ ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 2, 3, 1, 2, 3, 1, 2, 3 };
		int[] y1 = { 1, 1, 1, 2, 2, 2, 3, 3, 3 };
		x = x1;
		y = y1;
		h = 3;
		w = 3;
		int[][] topXYf = {{1, 3}, {2, 3}, {3, 3}};
		topXY = topXYf;
	}

	public void TwoStep() {

		//   ■
		// ■ ■
		int[] x1 = { 1, 2, 2 };
		int[] y1 = { 1, 1, 2 };
		x = x1;
		y = y1;
		h = 2;
		w = 2;
		int[][] topXYf = {{1, 1}, {2, 2}};
		topXY = topXYf;

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
		int[][] topXYf = {{1, 2}, {2, 1}};
		topXY = topXYf;

	}

	public void ThreeStep() {

		//     ■
		//   ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 2, 2, 3, 3, 3 };
		int[] y1 = { 1, 1, 2, 1, 2, 3 };
		x = x1;
		y = y1;
		h = 3;
		w = 3;
		int[][] topXYf = {{1, 1}, {2, 2}, {3, 3}};
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
		int[][] topXYf = {{1, 3}, {2, 2}, {3, 1}};
		topXY = topXYf;

	}
	
	public void UpLittleT() {

		// 
		//   ■
		// ■ ■ ■
		int[] x1 = { 1, 2, 2, 3 };
		int[] y1 = { 1, 1, 2, 1 };
		x = x1;
		y = y1;
		h = 2;
		w = 3;
		int[][] topXYf = {{1, 1}, {2, 2}, {3, 1}};
		topXY = topXYf;

	}
	
	public void DownLittleT() {

		// 
		// ■ ■ ■
		//   ■ 
		int[] x1 = { 1, 2, 2, 3 };
		int[] y1 = { 2, 1, 2, 2 };
		x = x1;
		y = y1;
		h = 2;
		w = 3;
		int[][] topXYf = {{1, 2}, {2, 2}, {3, 2}};
		topXY = topXYf;

	}
	
	public void UpBigT() {

		//   ■
		//   ■
		// ■ ■ ■
		int[] x1 = { 1, 2, 2, 2, 3 };
		int[] y1 = { 1, 1, 2, 3, 1 };
		x = x1;
		y = y1;
		h = 3;
		w = 3;
		int[][] topXYf = {{1, 1}, {2, 3}, {3, 1}};
		topXY = topXYf;

	}
	
	public void DownBigT() {

		// ■ ■ ■
		//   ■ 
		//   ■
		int[] x1 = { 1, 2, 2, 2, 3 };
		int[] y1 = { 3, 1, 2, 3, 3 };
		x = x1;
		y = y1;
		h = 3;
		w = 3;
		int[][] topXYf = {{1, 3}, {2, 3}, {3, 3}};
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
		int[][] topXYf = {{1, 2}, {2, 2}, {3, 1}};
		topXY = topXYf;

	}
	
	public void OnePlusTwoxTwo() {

		// 
		//   ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 2, 2, 3, 3 };
		int[] y1 = { 1, 1, 2, 1, 2 };
		x = x1;
		y = y1;
		h = 2;
		w = 3;
		int[][] topXYf = {{1, 1}, {2, 2}, {3, 2}};
		topXY = topXYf;

	}
	
	public void ThreexTwoPlusOne() {

		//   ■
		// ■ ■ ■
		// ■ ■ ■
		int[] x1 = { 1, 1, 2, 2, 2, 3, 3 };
		int[] y1 = { 1, 2, 1, 2, 3, 1, 2 };
		x = x1;
		y = y1;
		h = 3;
		w = 3;
		int[][] topXYf = {{1, 2}, {2, 3}, {3, 2}};
		topXY = topXYf;

	}

	public static void main(String[] args) {

	}
}
