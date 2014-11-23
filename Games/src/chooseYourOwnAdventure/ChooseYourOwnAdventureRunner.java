package chooseYourOwnAdventure;

import java.util.Scanner;

public class ChooseYourOwnAdventureRunner {

	public static void main(String[] args) throws InterruptedException {
		
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
			
			System.out.println("Congratulations! You are now a dragon slayer. You figure that your first act should be to slay a dragon.");
			System.out.println("How fitting would it be if the first dragon you slayed was the last dragon that would ever cause you harm?");
			System.out.println("You mount your galliant steed and ride off toward the place where the two dragons plummeted from the sky.");
			System.out.println("As you approach, you hear a mighty roar and know the dragon is still alive.");
			System.out.println("Upon you arrival, the dragon squirms about, but due to an injury to his wings, he is not able to flee.");
			System.out.println("As you approach the dragon smuggly, knowing that he cannot escape, you forget one tiny detail:");
			System.out.println("Dragons have a tendency to breath fire at their attackers.");
			System.out.println("Your once galliant steed is now a galliant and fabulous meal fit for a king (or dragon).");
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
				System.out.println("You are about to quit dragon school, but the professors assure you that grad school will");
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
							
							System.out.println("You and the girl go to seek the largest dragon in the land.");
							System.out.println("Little did you know that they make dragons that are quite large. You faint on sight.");
							System.out.println("The girl rescued you moments before you joined your horse in the land of the crispy.");
							System.out.println("After this monumental embaressment, you realize you only have two options.");
							System.out.println("You can (a) prove your manliness by fighting a second dragon alone,");
							System.out.println("Or (b) thank her for saving you and promise to make it up to her.");
							answer = console.next();
							choice = (answer.toLowerCase().equals("b")) ? 2 : 1;
							
							switch (choice) {
							
							case 1:
								
								System.out.println("You do remember that fighting a dragon didn't work out so well for you last time, don't you?");
								System.out.println("Upon seeing the dragon, you faint, and without a sweet girl to save you, you are fried");
								System.out.println("cripier than good old-fashioned horse on a stick.");
			
							
								break;
							
							case 2:
							 
								System.out.println("You thank the girl and promise to make it up to her. Her smile makes you feel warm and");
								System.out.println("fuzzy inside. It's a weird feeling, like you have just swallowed a kitten, but you feel");
								System.out.println("like you could definitely get used to it. She tells you that she is going to get you");
								System.out.println("ready to fight your next dragon. You train for hours each day, learning things you had");
								System.out.println("never thought of before. Training with a partner was great, but you knew she was more");
								System.out.println("than just a partner to you. You would purposely do things wrong, just to feel her hand");
								System.out.println("on your back, guiding you in the right direction. You did everything you could to make");
								System.out.println("her smile so you could get that warm fuzzy feeling inside you.");
								System.out.println("One day, after a particularly grueling training session, she asked if you wanted to");
								System.out.println("grab a drink at the pub");
								System.out.println("What do you say? (a) Yes or (b) no?");
								answer = console.next();
								choice = (answer.toLowerCase().equals("b")) ? 2 : 1;
								
								switch (choice) {
								
								case 1:
									
									System.out.println("When you get to the pub, \"a drink\" turns into many. Soon you find yourself in a drunken");
									System.out.println("stupor much like the one you had on that fateful day oh so many years ago...");
									System.out.println("Of course, like a true gentelman, you offer to walk her home, which is literally across the");
									System.out.println("street. She invites you inside and you accept, but by this point, it's more of alcohol's");
									System.out.println("choice than yours. One thing leads to the next and you find yourself laying in her bed,");
									System.out.println("half-naked, the next morning. You realize this is a change in your relation ship. Instead");
									System.out.println("of your training partner, she is now your \"sparring\" partner, if you will. As a result of");
									System.out.println("this, you find yourself spending less time training and more time \"sparring\". By the time");
									System.out.println("the final comes around, you realize you are no better prepared to fight a dragon than you");
									System.out.println("were when you first meet this girl. When you see the immense dragon, you pass out, and this");
									System.out.println("time, there is no beautiful girl to save you...");
									
									break;
									
								case 2:
									
									System.out.println("You politely decline her offer, but because you are a gentleman, you offer to meet her in the");
									System.out.println("middle and at least walk her home. On the way there, the conversation slowly drifts towards how");
									System.out.println("you have first meet, and how you had made an absolute fool out of yourself. Normally, this kind");
									System.out.println("of talk would deeply offend you, but for some reason, all you could do was laugh. As you got closer");
									System.out.println("to her house, the warm feeling started to return, and when she invited you inside, you knew that");
									System.out.println("something was about to happen. One thing lead to the next and you suddenly found yourself laying in");
									System.out.println("her bed, half-naked, the next morning. You realize that this is a change in your relation ship.");
									System.out.println("Instead of your training partner, she is now your \"sparring\" partner, if you will. As a result of");
									System.out.println("this, you find yourself spending less time training and more time \"sparring\". By the time");
									System.out.println("the final comes around, you realize you are no better prepared to fight a dragon than you");
									System.out.println("were when you first meet this girl. When you see the immense dragon, you pass out, and this");
									System.out.println("time, there is no beautiful girl to save you...");
									
									break;
									
									
								
								}
							
							
							
								break; 
						
							}
							
							
							break;
							
						case 2:
							
							System.out.println("You continue on in your studies. You pass your classroom final with flying colors.");
							System.out.println("Probably because you have a cool sword that can shoot colors.");
							System.out.println("You now feel ready to take the second part of the final,slaying a dragon.");
							System.out.println("As the date draws near, you acknowledge your underwhelming puniness and realize");
							System.out.println("that you have next to no chance of survival in the upcoming test.");
							System.out.println("You start to panic, knowing that your sheer inadequacy will surely be your demise.");
							System.out.println("You spend every day of the week before training your skills in the practice arena.");
							System.out.println("The day before your fateful duel, you hear two of your classmates whispering in the corner");
							System.out.println("As you approach, they see you and quickly disperse. However, you manage to catch up to one of them.");
							System.out.println("You ask him what he was doing, and after a furtive glance around, he pulls a small");
							System.out.println("package out of his pocket. He says");
							System.out.println("\"If you swallow the contents of this package right before your final, you can't lose.\"");
							System.out.println("Do you take the package (a) or do you deny his offer (b)?");
							answer = console.next();
							choice = (answer.toLowerCase().equals("b")) ? 2 : 1;
							
							switch (choice) {
							
								case 1:
								
								System.out.println("Surprise! No amount of drugs can help you kill a dragon. Besides, the drugs that he gave you were");
								System.out.println("hallucinogens, anyways. Now, instead of fighting one dragon, it looks like you're fighting five. You swing");
								System.out.println("your sword about, knowing that with this many dragons, your fighting skills aren't really going to matter.");
								System.out.println("And you're right. You do manage to slash a fatal wound in the side of one of the imagined dragons, but then");
								System.out.println("the real dragons swoops down and roasts you just like a chestnut:");
								System.out.println("On an open fire");
								System.out.println("It also just so happens that your horse's name was Chestnut");
								
								break;
			
							case 2:
								
								System.out.println("Congradulations! You have proved that you have some sort of moral compass! But then again, you are training to commit");
								System.out.println("genocide on an entire race of rational beings, so maybe not...");
								System.out.println("Anyways, you turn him down, saying that if you are going to beat a dragon, YOU are going to be the one to beat it, not");
								System.out.println("drugs. As you approach the arena where the final will take place, you feel a calm come over you, as if you have come to");
								System.out.println("terms with what is about to happen. When they call you into the arena, and you behold the largest dragon you have ever");
								System.out.println("seen, all you can do is smile. Fainting is as far from your mind as victory is from the realm of possibilities.");
								System.out.println("However, this state of calm is a new feeling for you when fighting a dragon. You realize you can actually think instead");
								System.out.println("of just freaking out. You recall your training and studies.");
								System.out.println("\"Scandonavian Ridged Wyvern\" you think to yourself.");
								System.out.println("\"Unusually scaly underbelly. Do not deploy usual tactics. Instead, attempt to blind it. It will thrash about attempting");
								System.out.println("to strike whoever injured it, incidentally breaking some of its scales. Use these exposed areas to kill the dragon.\"");
								System.out.println("You follow this course of actions almost as if in a trance. Within minutes, the dragon lies before your feet. You have");
								System.out.println("slayed an alive and kicking dragon. In record time too.");
								System.out.println("You feel a slight twinge of guilt for destroying so majestic of a creature, but within moments, it is gone.");
								System.out.println("This is the path that you have chosen, and you must continue on it.");
								System.out.println("Speaking of continuing on your path, your school has reccomemnded you to a guild of dragon slayers, and they want you to join");
								System.out.println("Do you (a) join the guild or (b) forge out on your own?");

								answer = console.next();
								choice = (answer.toLowerCase().equals("b")) ? 2 : 1;
								
								switch (choice) {
								
								case 1:
									
									System.out.println("Your school notifies that you wish to join, and the next thing you know, you are holding your bags in front of a big ol' building, staring");
									System.out.println("up at it like a little kid. As you walk in, you are engulfed in absolute chaos. People yelling, fighting, and even belting out drinking songs,");
									System.out.println("completely surround you. You immediately understand that part of guild life is drinking. Seeing as it isn't even noon and everyone is mad drunk,");
									System.out.println("you decide that its lots of drinking. As you slide your way through the mass of people, trying not to trip over any passed");
									System.out.println("out bodies, an unusually sober man approaches you. He asks you what your name is.");
									System.out.println("What is it again?");
									
									answer = console.next();
									
									System.out.println("\"Oh that's right!\" he says \"You\'re " + answer + "! Welcome to the Ridge Riders! We were told that you were the top");
									System.out.println("of your class back in grad school! Here! Have a drink!\" He proceeded to slap a mug almost the size of a keg into your");
									System.out.println("hand. You realize by the way that he was staring at you that he expected you to chug the whole thing. You did, but you");
									System.out.println("barely managed to keep your stomach. He bellows \"Atta boy! Have another!\" You stare at the massive mug in your hand ");
									System.out.println("than hour, you were so drunk that you couldn't even remember you name. All you saw were smudges, and you couldn't make");
									System.out.println("out any phrases over thewith a sense of despair, knowing that after you nearly drowned in this one, there would be many");
									System.out.println("more to come... In less cacophany of sound surrounding you. Except for one:");
									System.out.println("\"Now let's see what you've got, boy!");
									System.out.println("He drags you into their arena/gym where many different type of training equipment hae been set up. As you walk around");
									System.out.println("you are suddenly bashed over the head a rock. As you fasde the blsck, you hear \'You always need to watchout while slaying dagons\'");
									break;
									
								case 2:
									
									//change
									//Brady Changes are AWWWWWWWWWWWWWWWWWWWESSSSSSSOMMMMMMMMMMMMMMMMMEEEEEEEEEEEEEE!!!!!!!!!!!!!!!
									//not really
									
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
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			break;
		case 2:
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		break;
		
			
		}
		
		
		
		
		
		
		
		
	}
}