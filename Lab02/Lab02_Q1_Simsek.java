package Lab02;
import java.util.Scanner;

public class Lab02_Q1_Simsek 
{
    public static void main(String[] args)
    {
        //Constants
        final double MERCURY_CONSTANT = 0.38;
        final double VENUS_CONSTANT = 0.9;
        final double MARS_CONSTANT = 0.37;
        final double JUPITER_CONSTANT = 2.53;

        //Variables
        double firstWeight;
        double secondWeight;
        double firstWeightMercury; 
        double firstWeightVenus;
        double firstWeightMars;
        double firstWeightJupiter;
        double secondWeightMercury;
        double secondWeightVenus;
        double secondWeightMars;
        double secondWeightJupiter;

        Scanner in = new Scanner(System.in);
        
        //User input for the weights
        System.out.print("Enter the weight of first earthling(kg): ");
        firstWeight = in.nextDouble();
        
        System.out.print("Enter the weight of the second earthling(kg): ");
        secondWeight = in.nextDouble();

        //Initializing the variables with necessary calculations
        firstWeightMercury = firstWeight * MERCURY_CONSTANT; 
        firstWeightVenus = firstWeight * VENUS_CONSTANT;
        firstWeightMars = firstWeight * MARS_CONSTANT;
        firstWeightJupiter = firstWeight * JUPITER_CONSTANT;
        secondWeightMercury = secondWeight * MERCURY_CONSTANT;
        secondWeightVenus = secondWeight * VENUS_CONSTANT;
        secondWeightMars = secondWeight * MARS_CONSTANT;
        secondWeightJupiter = secondWeight * JUPITER_CONSTANT;

        //Printing the calculation results
        System.out.printf("%49s%12s%12s%12s%n", "MERCURY", "VENUS", "MARS", "JUPITER");
        System.out.printf("\tEARTHLING ONE(%5.1fkg) %18.1f%12.1f%12.1f%12.1f%n", firstWeight, firstWeightMercury, firstWeightVenus, firstWeightMars, firstWeightJupiter);
        System.out.printf("\tEARTHLING TWO(%5.1fkg) %18.1f%12.1f%12.1f%12.1f", secondWeight, secondWeightMercury, secondWeightVenus, secondWeightMars, secondWeightJupiter);

        in.close();
    }
}
