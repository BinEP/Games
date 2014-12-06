package utilityClasses;

public class CopyForScores {
/*
	
	import utilityClasses.*;
	
	private boolean nameEnter = false;
	private boolean highScores = false;

	private ScoreInfo scores = new ScoreInfo("gameName");
	private String pName = "";
	private Character letter;
	
	
	Find where the game sets endGame to true and change to nameEnter
	nameEnter = true;
	
	//////////////////////////////////////////
	 
	Add this at the end of paintComponent
	
	else if (nameEnter) {

			scores.enterName(g, 500, 500, timeSeconds, pName);

		} else if (highScores) {

			//scores.setScores(timeSeconds, pName);
			scores.drawScores(g);
		}
	
	//////////////////////////////////////////
	 
	Add this to the end of keyPressed
	
	}  else if (e.getKeyLocation() == KeyEvent.KEY_LOCATION_STANDARD && nameEnter) {

			
				if (pName.length() < 10) {
					letter = e.getKeyChar();

					letter = Character.toUpperCase(letter);
					pName = pName.concat(letter.toString());
				}
			
		} 
		
		//////////////
		 Add  && !nameEnter 
		 to any keys in keyPreseed that might interfere with
		 letter entering
	//////////////////////////////////////////
	 
	 Add this at the end of the keyReleased (Enter) inside of the endGame if
	 
	startGame = false;
	playing = true;
	nameEnter = false;
	highScores = false;
	endGame = false;
	pName = "";

//////////////////////////////////////////
	
	Add this at the end of keyPressed Enter
	
	} else if (nameEnter) {
				nameEnter = false;
				highScores = true;
				scores.setScores(timeSeconds, pName);
	} else if (highScores) {
				
				
				highScores = false;
				endGame = true;
			} else {
			startGame = false;
			playing = true;

			}
	
	
*/	
}
