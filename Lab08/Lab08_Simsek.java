package Lab08;
import java.util.Scanner;

public class Lab08_Simsek
{
    public static void main(String[] args)
    {
        //variables
        int arrival;
        int departure;
        int bestTimeToAttend;
        String friendToAvoid;

        //objects
        Scanner in = new Scanner(System.in);
        int[] arrivalTimes = {7, 5, 8, 7, 9, 7, 8};
        int[] departureTimes = {12, 7 , 11, 12, 10, 9, 10};
        int[] priorities = {1, 1, 5, 2, 2, 4, 3};
        String[] names = {"Ela", "Eren", "Alona", "Jen", "Mark", "Mel", "Ender"};

        //getting necessary data from the user
        System.out.print("Enter friend you wish to avoid: ");
        friendToAvoid = in.next();

        System.out.print("Enter time interval you are available: ");
        arrival = in.nextInt();
        departure = in.nextInt();

        //finding the best time to attend and printing it
        bestTimeToAttend = bestTimeToAttend(friendToAvoid, arrival, departure, arrivalTimes, departureTimes, priorities, names);

        System.out.print("Best time to attend to avoid " + friendToAvoid + " and to see the closest friends is " + bestTimeToAttend);

        in.close();
    }

    /**
     * @param arrival: arrival time of the user
     * @param departure: departure time of the user
     * @param arrivalTimes: a list that consists of the friends' arrival time information
     * @param departureTimes: a list that consists of the friends' departure time information
     * @param priorities: a list that consists of the information regarding how close the user is to the friends
     * @return an array that includes numbers regarding the average priority for each time interval
     */
    public static double[] friendsPriority(int arrival, int departure, int[] arrivalTimes, int[] departureTimes, int[] priorities)
    {
        //constants
        final int LENGTH = priorities.length;

        //variables
        int counter;
        double prioritySum;

        //objects
        double[] priorityAverages = new double[departure - arrival];

        //assigning starting points
        counter = 0;
        prioritySum = 0;

        //finding priority average of each time interval
        for(int n = arrival, i = 0; n < departure; n++, i++)
        {
            //finding the sum of priorities and the amount of people that have suitable arrival and departure times
            for(int k = 0; k < LENGTH; k++)
            {
                //checking if arrival and departure times of friends are suitable for the given arrival and departure times
                if(n >= arrivalTimes[k] && n < departureTimes[k])
                {
                    prioritySum  += priorities[k];
                    counter++;
                }  
            }

            //adding the priority average to the array and resetting the necessary variables
            priorityAverages[i] = prioritySum / counter;
            prioritySum = 0;
            counter = 0;
        }

        return priorityAverages;
    }

    /**
     * @param friendToAvoid: name of the friend to be avoided
     * @param arrival: arrival time of the user
     * @param departure: departure time of the user
     * @param arrivalTimes: a list that consists of the friends' arrival time information 
     * @param departureTimes: a list that consists of the friends' departure time information
     * @param priorities: a list that consists of the information regarding how close the user is to the friends
     * @param names: a list that consists of the names of the friends
     * @return an integer value that reveals the best time to attend
     */
    public static int bestTimeToAttend(String friendToAvoid, int arrival, int departure, int[] arrivalTimes, int[] departureTimes, int[] priorities, String[] names)
    {
        //variables
        int bestTimeToAttend;
        boolean isFound;

        //objects
        double[] priorityAverages = friendsPriority(arrival, departure, arrivalTimes, departureTimes, priorities);
        int[] timesToAvoid = new int[priorityAverages.length];

        //finding out which time intervals should be avoided according to the given name of the friend to avoid
        for(int n = arrival, i = 0; n < departure; n++, i++)
        {
            //adding the time intervals to avoid to the array
            for(int k = 0; k < priorities.length; k++)
            {
                //checking if the time intervals are suitable and the given name of the friend to be avoided is found
                if(n >= arrivalTimes[k] && n < departureTimes[k] && names[k].equals(friendToAvoid))
                {
                    timesToAvoid[i] = n;
                }  
            }
        }

        //assigning the "bestTimeToAttend" variable to -1 which indicates no suitable time interval can be found
        bestTimeToAttend = -1;
        //a boolean variable to control the next "for" loop so that the chosen best time to attend does not include the friend to be avoided
        isFound = false;

        //finding out what the best time to attend is
        for(int i = 0; i < priorityAverages.length; i++)
        {
            //changing the boolean value if the time interval that is considered as the best time to attend includes the friend to be avoided
            for(int k = 0; k < timesToAvoid.length; k++)
            {
                if(timesToAvoid[k] == arrival)
                {
                    isFound = true;
                }
            }

            //changing the best time to attend if the necessary conditions are met
            if(priorityAverages[i] > bestTimeToAttend && !isFound)
            {
                bestTimeToAttend = arrival;
            }

            isFound = false;
            arrival++;
        }

        return bestTimeToAttend;
    }
}
