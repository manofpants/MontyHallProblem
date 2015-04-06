import java.util.Random;

public class MontyHallProblem
{

    public static void main(String[] args)
    {

	// car and goat counters
	int totalCars = 0;
	int totalGoat = 0;

	// number of trials
	final int trials = 100000;

	// main loop
	for (int i = 0; i < trials; i++)
	{

	    // set new door array
	    int[] door = new int[3];

	    // randomly set what's behind the doors...1 for car, 0 for goat
	    Random r = new Random();
	    door[r.nextInt(3)] = 1;

	    // player makes a choice. initial pick is door 1 (index 0)
	    int doorChoice = 0;

	    // when the player decides to change doors after one is revealed,
	    // then the (a) goat in 2 or 3 is shown to the player.
	    // he will then choose the OTHER door, which, if it's door 2,
	    // then that will be picked, same as for 3. obviously, if the
	    // car is behind 2 or 3, player will have now chosen the car.
	    // if the car was behind door 1 all along, pick a random from
	    // door or 3 because it just doesn't matter.
	    boolean change = true; // CHANGE TO FALSE TO SEE OTHER SIDE OF PROBLEM :)
	    if (change == true)
	    {
		if (door[1] == 1)
		    doorChoice = 1;

		else if (door[2] == 1)
		    doorChoice = 2;

		else
		    doorChoice = r.nextInt(2) + 1;
	    }

	    // if player wins, add to car total
	    if ((door[0] == 1 && doorChoice == 0) || (door[1] == 1 && doorChoice == 1)
		    || (door[2] == 1 && doorChoice == 2))
	    {
		totalCars++;
	    }

	    // otherwise, add to goat total
	    else
		totalGoat++;
	}

	System.out.println("total cars: " + totalCars);
	System.out.println("total goat: " + totalGoat);
	float endPercentage = (float) totalCars / (float) (totalCars + totalGoat);
	System.out.println("TOTAL WIN PERCENTAGE: " + endPercentage);

    }

}
