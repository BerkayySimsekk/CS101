package Lab01;
public class Lab01_Q3 
{
    public static void main(String[] args) 
    {
        //Constants
        final long AREA_OF_EARTH = 510072000;
        final long AREA_OF_TURKEY = 783562;
        
        //Variables
        double percentageOfLandOfEarth,
            percentageOfSeaOfTurkey,
            turkeyDryLandPercentageOfEarth,
            dryLandOfEarth,
            dryLandOfTurkey,
            turkeySeaPercentageOfEarth,
            seaOfEarth,
            seaOfTurkey;
        
        //Initializing the variables
        percentageOfLandOfEarth = 0.292;
        percentageOfSeaOfTurkey = 0.013;
        dryLandOfEarth = (AREA_OF_EARTH * percentageOfLandOfEarth);
        seaOfEarth = AREA_OF_EARTH - dryLandOfEarth;
        seaOfTurkey = (AREA_OF_TURKEY * percentageOfSeaOfTurkey);
        dryLandOfTurkey = AREA_OF_TURKEY - (long)seaOfTurkey;
        turkeyDryLandPercentageOfEarth = dryLandOfTurkey / dryLandOfEarth * 100; 
        turkeySeaPercentageOfEarth = (long)seaOfTurkey / seaOfEarth * 100;

        //Printing out the necessary variables
        System.out.println("Earth has " +(long)dryLandOfEarth + "km2 dry land and " + (long)seaOfEarth + "km2 water.");
        System.out.println("Turkey has " + (long)dryLandOfTurkey + "km2 dry land and " + (long)seaOfTurkey + "km2 water.");
        System.out.println("Turkey has " + turkeyDryLandPercentageOfEarth + " percent of Earth's dry land.");
        System.out.println("And " + turkeySeaPercentageOfEarth + " percent of the Earth's water.");
    }   
}
