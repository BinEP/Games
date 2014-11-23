package chooseYourOwnAdventure;

import java.util.Scanner;

public class ChooseYourOwnAdventureRunner {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("");
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
		String answer = "";
		int choice = 0;
		System.out.println("You just celebrated your 21st birthday in the year 1153. ");
		System.out.println("Stumbling along after a night of traditional celebrations consisting of");
		System.out.println("events you don't remember, but without a doubt, most definitely happened,");
		System.out.println("you notice the sky darken for a split second. ");
		System.out.println("You look up and exclaim \"Is it a bird?! Is it a plane?! Is it a train?!\"");
		System.out.println("\"No! It's a dragon!!!\" You figure \"hmmm, pretty...\" ");
		System.out.println("After stumbling back to your village many hours later, you notice something is slightly off.");
		System.out.println("with your muddled hearing you notice screams of torment throughout the village,");
		System.out.println("As fire burns everything within sight, you hear a scream unlike the others,");
		System.out.println("The dragon destroying your village is plunging to the ground");
		System.out.println("in the jaws of a larger, scarier looking dragon.");
		System.out.println("Thinking you had fallen out of the frying pan and into the fire, you begin fleeing for your");
		System.out.println("life tripping over baskets and small children in your drunken stupor.");
		System.out.println("After falling hard over a particularely small child, you turn to see your savior.");
		System.out.println("The scarier looking dragon is putting out the fires with his wings and rescueing many helpless people");
		System.out.println("As it flies off into the sunset, you realize that this moment will determine your fate.");
		System.out.println("Do you wish to become a dragon slayer to make all of dragon kind pay for the actions of one,");
		System.out.println("Or do you wish to become a companion of the dragons forever seeking the dragon who was the savior of you village");
		System.out.println("Destroyer of dragons(a) or Savior of the dragons (b)");
		answer = console.next();
		choice = (answer.toLowerCase().equals("b")) ? 2 : 1;
		switch (choice) {
		
		case 1:
			
			System.out.println("Congratulations! You are now a dragon slayer. You figure that your first act should be to slay a dragon");
			System.out.println("How fitting would it be if the first dragon you slayed was the last dragon that would ever cause you harm?");
			System.out.println("You mount your galliant steed and ride off toward the place where the two dragons plummeted from the sky.");
			System.out.println("As you approach you hear a mighty roar and you know the dragon is still alive.");
			System.out.println("Upon you arrival, the dragon squirms about, but due to an injury to its wings, he is not able to flee.");
			System.out.println("As you approach the dragon smuggly knowing that he cannot escape, you forget one tiny detail,");
			System.out.println("Dragons have a tendency to breath fire theior attackers.");
			System.out.println("Your once galliant steed is now a galliant and fabulous meal fir for a king (or dragon).");
			System.out.println("You leap from your slightly warmed horse and land on the dragons back.");
			System.out.println("If you have you have ever tried to jump on a dragon, you will recall the ridges that run down it's back.");
			System.out.println("The area between your legs burns with a fury and you begin to understand the pain of your poor horse.");
			System.out.println("Somewhere between the burning and the groaning, you manage to get your sword into the dragons back.");
			System.out.println("When you finally stop seeing double and regain your stomach, you realized you have vanquished your foe.");
			System.out.println("This starts you on your path to where excatly? Hmmm...");
			System.out.println("Do you wish to study the ways of the dragon slayer(a),");
			System.out.println("Or do you continue on your quest with a burning fervor and renewed vengence(b).");
			answer = console.next();
			choice = (answer.toLowerCase().equals("a")) ? 2 : 1;
			
			switch (choice) {
			
			case 1:
				System.out.println("Congrats on following the burning passion that rages inside of you");
				Thread.sleep(2500);
				System.out.println("Apparently experience doesn't count for much when you were barely conscience when you gained it");
				Thread.sleep(3500);
				System.out.println("The result of your next encounter leaves you crispier than your horse.");
				Thread.sleep(2000);
				System.out.println("Way to go!");
				Thread.sleep(1700);
				System.out.println("Jerk!");
				
				break;
			case 2:
				
				System.out.println("So apparently you don't actually get to slay dragons in a dragon slaying school.");
				System.out.println("You waste four years of your life sleeping through classes about dragon fighting etiquette.");
				System.out.println("You are about to quit quit dragon school when the professors assure you that grad school will");
				System.out.println("have real dragons.");
				System.out.println("You pass your final by one point, but it was probably because you had a cool sword");
				System.out.println("Do you continue onto grad school? yes(a), no(b)");
				answer = console.next();
				choice = (answer.toLowerCase().equals("a")) ? 2 : 1;
				
				switch (choice) {
				
				case 1:
					
					System.out.println("You have quit dragon slaying school after having slept through four years of classes");
					Thread.sleep(3000);
					System.out.println("You now realize you can follow your passion even though you lack the brain cells to follow a map");
					Thread.sleep(3200);
					System.out.println("Apparently experience doesn't count for much when you were barely conscience when you gained it");
					Thread.sleep(3200);
					System.out.println("The result of your next encounter leaves you crispier than your horse.");
					Thread.sleep(2000);
					System.out.println("Way to go!");
					Thread.sleep(1700);
					System.out.println("Jerk!");
					
					
					break;
					
				case 2:
					
					System.out.println("On your first day of grad school, your professor expects that you know everything from your college years");
					System.out.println("You don't.");
					System.out.println("You find yourself in the middle of an arena with an angry dragon staring at you");
					System.out.println("You spend the first ten minutes of the fight trying not to get your rear end toasted, like your horse");
					System.out.println("As the battle continues, you recall one class in particular, Physical Science");
					System.out.println("Apparently metal conducts heat very well, ");
					System.out.println("The battle has to end soon or the thing that was supposed to save you will be the death of you");
					System.out.println("Your armor");
					System.out.println("Seeig as you have absolutley no skill, do you wish to");
					System.out.println("(a) Discard your armour and avoid fire at all costs, or");
					System.out.println("(b) Make a mad rush at the dragon, with all guns blazing");
					answer = console.next();
					choice = (answer.toLowerCase().equals("b")) ? 2 : 1;
					
					switch (choice) {
					
					case 1:
						System.out.println("You shed your armor and run...");
						System.out.println("Bad idea");
						System.out.println("Turns out, flesh is no match for flame.");
						System.out.println("And did you really expect to outrun a dragon? Really?");
						System.out.println("You go the way of your horse, nice and crispy");
						
						
						
						
						break;
					case 2:
						
						System.out.println("The professor stops you before you kill yourself in an incredibly stupid way.");
						//(Now we need someway to get a choice. Either the next choice is 
						//after grad school which we would summarize, or he makes another 
						//choice in grad school, like a girl over his studies)
						System.out.println(" He tells you you must study in order to succeed.");
						System.out.println("It is at that point that you realize what you must do to become true dragon slayer.");
						System.out.println("You study for the better part of a year, and in your next fight, you manage to kill a dragon ");
						System.out.println("while only sustaining 2nd degree burns.  You are on the path to greatness. ");
						System.out.println("You are making great progress in getting your degree. Suddenly, a new girl arrives at the school");
						System.out.println("She wants to go slay a dragon together. Do you? Yes(a) No(b)");
						answer = console.next();
						choice = (answer.toLowerCase().equals("b")) ? 2 : 1;
						
						switch (choice) {
						
						case 1:
							
							System.out.println("You and the girl go to slay the biggest dragon you can find.");
							System.out.println("When you get there you realize how big the dragon is. You wake up several hours later after having passed out.");
							System.out.println("Your girl had to rescue you on her own to keep you from becoming like your horse.");
							System.out.println("You  ignore her warnings and go to try to prove yourself and make up for your embarassing situation earlier.");
							System.out.println("Well, you obviously haven't learned anything. You faint on site.");
							System.out.println("And the dragon, not \"seeing\" you, coughs in your direction.");
							System.out.println("The girl comes runnning after you after realizing how incredibly stupid you are.");
							System.out.println("When she gets there, she says \"May he be in the same meal with his horse\"");
							
							
							
							
							
							
							break;
							
						case 2:
							
							System.out.println("You continue on in your studies. You pass your classroom final with flying colors.");
							System.out.println("Probably because you have a cool sword that can shoot colors.");
							System.out.println("You now feel ready to take the second part of the final, you have to slay a dragon");
							System.out.println("As the date draws near, you acknowledge your underwhelming puniness and realize");
							System.out.println("that you have next to no chance of survival in the upcoming test.");
							System.out.println("You start to panic, knowing that your sheer inadequacy will surely be your demise.");
							System.out.println("You spend every day of the week before training your skills in the practice arena");
							System.out.println("The day before your fateful duel, you hear two of your classmates whispering in the corner");
							System.out.println("As you approach, they see you and quickly disperse. Howver, you manage to catch up to one of them");
							System.out.println("You ask him what you were doing, and after a furtive glance around, he pulls a small");
							System.out.println("package out of his pocket. He says");
							System.out.println("If you swallow the contents of this package right before your final, you can't lose.");
							System.out.println("Do you take the package (a) or do you deny his offer (b)?");
							answer = console.next();
							choice = (answer.toLowerCase().equals("b")) ? 2 : 1;
							
							
							switch (choice) {
							case 1:
								
								
								
								
								
								
								
								break;
							case 2:
								
								
								
								
								
								
								
								
								break;
							
							}
							
							
							break;
							
						}
						
						
						
						
						
						
						
						break;
					
					}
					
					
					
					
					break;
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				break;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			break;
		case 2:
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		break;
		
			
		}
		
		
		
		
		
		
		
		
	}
}