package farkle;
//import java.util.Random;


public class die {

	

	
		private final int MIN_FACES = 4;
		int numFaces; // number of sides on the die
		int faceValue; // current value showing on the die

		// -----------------------------------------------------------------
		// Defaults to a six-sided die. Initial face value is 1.
		// -----------------------------------------------------------------
		public die() {
			numFaces = 6;
			faceValue = 1;
		}

		// -----------------------------------------------------------------
		// Explicitly sets the size of the die. Defaults to a size of
		// six if the parameter is invalid. Initial face value is 1.
		// -----------------------------------------------------------------
		public die(int faces) {
			if (faces < MIN_FACES){
				numFaces = 6;
			}else{
				numFaces = faces;
			}
			faceValue = 1;
		}

		// -----------------------------------------------------------------
		// Rolls the die and returns the result.
		// -----------------------------------------------------------------
		public int roll() {
			faceValue = (int) (Math.random() * numFaces) + 1;
			return faceValue;
		}
		// -----------------------------------------------------------------
		// Returns the current die value.
		// -----------------------------------------------------------------
		public int getFaceValue() {
			return faceValue;
		}
	}


