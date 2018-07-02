package Movies;

import java.util.Random;

public class AFIMovies {
	
	/*
	class to draw a selection of random films from the American Film Institute's list
	of 100 films published in 1998. 
	Version 1.0
	Java
	Author BKD October 2017
	*/
	
	// constructor
	
	public  AFIMovies() {
	   
	   setFilmList();
	
	}; // end constructor
	
	
	
	int[] filmNumbersChosen = new int[101]; // array of numbers; // stores the selected film list numbers
    int filmNumberDrawn;  // current film number drawn
	int maxValue = 100; // highest film number to choose
	int totalFilmNumbersDrawn; // total of film numbers drawn
	Boolean filmAlreadyChosen; // flag to track if a film number has already been chosen
	int filmNumbersIndex; // loop variable for the film number array index 
	int index; // loop variable for the for loop index
	String[] filmList = new String[101];
	



// assigns the film list into an array
private void setFilmList(){

/*

The first of the American Film Institute (AFI)
100 Years series of cinematic milestones.
AFI's 100 Years…100 films is a list of
the 100 best American films, as determined by the
American Film Institute from a poll of more than 1,500
artists and leaders in the film industry who chose from
a list of 400 nominated films. 

The 100-best list was unveiled in 1998.

*/


filmList[1] = "Citizen Kane";
filmList[2]= "Casablanca";
filmList[3]= "The Godfather";
filmList[4]= "Gone with the Wind";
filmList[5]= "Lawrence of Arabia";
filmList[6]= "The Wizard of Oz";
filmList[7]= "The Graduate";
filmList[8]= "On the Waterfront";
filmList[9]= "Schindler's List";
filmList[10]= "Singin' in the Rain";
filmList[11]= "It's a Wonderful Life";
filmList[12]= "Sunset Boulevard";
filmList[13]= "The Bridge on the River Kwai";
filmList[14]= "Some Like It Hot";
filmList[15]= "Star Wars";
filmList[16]= "All About Eve";
filmList[17]= "The African Queen";
filmList[18]= "Psycho";
filmList[19]= "Chinatown";
filmList[20]= "One Flew Over the Cuckoo's Nest";
filmList[21]= "The Grapes of Wrath";
filmList[22]= "2001: A Space Odyssey";
filmList[23]= "The Maltese Falcon";
filmList[24]= "Raging Bull";
filmList[25]= "E.T. the Extra-Terrestrial";
filmList[26]= "Dr. Strangelove";
filmList[27]= "Bonnie and Clyde";
filmList[28]= "Apocalypse Now";
filmList[29]= "Mr. Smith Goes to Washington";
filmList[30]= "The Treasure of the Sierra Madre";
filmList[31]= "Annie Hall";
filmList[32]= "The Godfather Part II";
filmList[33]= "High Noon";
filmList[34]= "To Kill a Mockingbird";
filmList[35]= "It Happened One Night";
filmList[36]= "Midnight Cowboy";
filmList[37]= "The Best Years of Our Lives";
filmList[38]= "Double Indemnity";
filmList[39]= "Doctor Zhivago";
filmList[40]= "North by Northwest";
filmList[41]= "West Side Story";
filmList[42]= "Rear Window";
filmList[43]= "King Kong";
filmList[44]= "The Birth of a Nation";
filmList[45]= "A Streetcar Named Desire";
filmList[46]= "A Clockwork Orange";
filmList[47]= "Taxi Driver";
filmList[48]= "Jaws";
filmList[49]= "Snow White and the Seven Dwarfs";
filmList[50]= "Butch Cassidy and the Sundance Kid";
filmList[51]= "The Philadelphia Story";
filmList[52]= "From Here to Eternity";
filmList[53]= "Amadeus";
filmList[54]= "All Quiet on the Western Front";
filmList[55]= "The Sound of Music";
filmList[56]= "MASH";
filmList[57]= "The Third Man";
filmList[58]= "Fantasia";
filmList[59]= "Rebel Without a Cause";
filmList[60]= "Raiders of the Lost Ark";
filmList[61]= "Vertigo";
filmList[62]= "Tootsie";
filmList[63]= "Stagecoach";
filmList[64]= "Close Encounters of the Third Kind";
filmList[65]= "The Silence of the Lambs";
filmList[66]= "Network";
filmList[67]= "The Manchurian Candidate";
filmList[68]= "An American in Paris";
filmList[69]= "Shane";
filmList[70]= "The French Connection";
filmList[71]= "Forrest Gump";
filmList[72]= "Ben-Hur";
filmList[73]= "Wuthering Heights";
filmList[74]= "The Gold Rush";
filmList[75]= "Dances with Wolves";
filmList[76]= "City Lights";
filmList[77]= "American Graffiti";
filmList[78]= "Rocky";
filmList[79]= "The Deer Hunter";
filmList[80]= "The Wild Bunch";
filmList[81]= "Modern Times";
filmList[82]= "Giant";
filmList[83]= "Platoon";
filmList[84]= "Fargo";
filmList[85]= "Duck Soup";
filmList[86]= "Mutiny on the Bounty";
filmList[87]= "Frankenstein";
filmList[88]= "Easy Rider";
filmList[89]= "Patton";
filmList[90]= "The Jazz Singer";
filmList[91]= "My Fair Lady";
filmList[92]= "A Place in the Sun";
filmList[93]= "The Apartment";
filmList[94]= "Goodfellas";
filmList[95]= "Pulp Fiction";
filmList[96]= "The Searchers";
filmList[97]= "Bringing Up Baby";
filmList[98]= "Unforgiven";
filmList[99]= "Guess Who's Coming to Dinner";
filmList[100]= "Yankee Doodle Dandy";

};

// public methods
	
	
	// getFilm returns the film title held at the array position provided
	
	public String getFilm(int position){
		
		String filmName;
		
		filmName = filmList[position];
		
		return filmName;
		
	} // end getFilm
	
	
	// chooseFilmList selects 5 random film numbers and stores them into an array
	
	public void chooseFilmList(){
		
		totalFilmNumbersDrawn = 0; // total number of film numbers drawn
		filmNumberDrawn = 0; // current film number drawn
		filmNumbersIndex = 0; // current index value associated with film number being drawn
		filmNumbersChosen[0] = getRandomFilmNumber(maxValue); // get and store the first random film number
		totalFilmNumbersDrawn = 1; // increment the totalFilmNumbersDrawn
		filmNumbersIndex = 1; // increment to the next element in the filmNumbersChosen array 
		
			
		
		while (totalFilmNumbersDrawn <= 5) // loop while more film numbers to choose
		{
			filmNumberDrawn = getRandomFilmNumber(maxValue); // get the next random number
			filmAlreadyChosen = true; // assume its already been chosen
			while (filmAlreadyChosen) // loop while the statement above is not true
				{
					for (index = 0; index <= 6; index = index +1) // check the random number with those
					{											  // stored in the array		
						if (filmNumbersChosen[index] == filmNumberDrawn)
						{
							filmAlreadyChosen = true;
							filmNumberDrawn = getRandomFilmNumber(maxValue);
							
						} // end if numbersChosen
					
					    else {
							
							filmAlreadyChosen = false;
							
						} // end else
					
					} // end for 
				
				
				} // end while not alreadyChosen
		
			filmNumbersChosen[filmNumbersIndex] = filmNumberDrawn; // store new film number into array
			filmNumbersIndex = filmNumbersIndex + 1; // increment to the next array element
			totalFilmNumbersDrawn = totalFilmNumbersDrawn + 1; // increment total of numbers chosen
			
		
		} // end whileFilmNumbersDrawn
		
		
		
	}; // end chooseFilmList

	 
	 /* 
	 
	 given a number the getFilmNumber method returns the value currently 
	 stored at the corresponding array element
	 
	 */
	 
	public int getFilmNumber(int filmNumber){ 
	 
	  int element =0;
	 
	  element = filmNumber;
	 
	  return filmNumbersChosen[element];
	 
	  }; // end getFilmNumber
	

	private int getRandomFilmNumber(int maxNumber){
	
		Random randomNumber = new Random();
		
		int randomFilmNumber = 0;
	
		randomFilmNumber = randomNumber.nextInt(maxNumber)+1;
	
	   return randomFilmNumber;
 
	  } // end getRandomFilmNumber
 
}; // end AFIMovies
		

	
	
	
	
	
	
	
	
	

 
