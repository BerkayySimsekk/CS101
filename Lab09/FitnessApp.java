package Lab09;
import java.util.Scanner;

public class FitnessApp 
{
    public static void main(String[] args) 
    {
        //variables
        String birthDate;
        String gender;
        double weight;
        double height;
        double waist;
        double hips;
        int restingHeartRate;
        int choice;
        
        //objects
        Scanner in = new Scanner(System.in);

        //getting input
        System.out.print("Enter birthdate (YYYY-MM-DD): ");
        birthDate = in.next();

        System.out.print("Enter gender (f)emale/(m)ale: ");
        gender = in.next();

        System.out.print("Enter height(m) weight(kg): ");
        height = in.nextDouble();
        weight = in.nextDouble();

        System.out.print("Enter waist and hip measurements (cm): ");
        waist = in.nextDouble();
        hips = in.nextDouble();

        System.out.print("Enter resting heart rate: ");
        restingHeartRate = in.nextInt();

        //creating an object according the input variables
        FitnessAssessment fitnessAssessment = new FitnessAssessment(birthDate, height, weight, restingHeartRate, waist, hips, gender);

        choice = -1;

        //a loop that continues until the user enters "5" which indicates exiting
        while(choice != 5)
        {
            //printing the menu
            System.out.println("\n--------------MENU--------------\n1 - Calculate Target Heart Rate\n2 - Calculate Waist/Hip Ratio\n3 - Body Mass Index\n4 - Display Fitness Level\n5 - Quit");

            //getting input regarding which option to choose
            System.out.print("Enter choice: ");
            choice = in.nextInt();

            System.out.println("");

            //printing target heart rate
            if(choice == 1)
            {
                System.out.printf("Target Heart Rate: %.1f\n", fitnessAssessment.calculateTargetHeartRate());
            }

            //printing waist/hip ratio
            if(choice == 2)
            {
                System.out.printf("Waist/Hip Ratio: %.1f\n", fitnessAssessment.calculateWaistHipRatio());
            }

            //printing BMI
            if(choice == 3)
            {
                System.out.printf("Your BMI is: %.1f Category: %s\n", fitnessAssessment.calculateBMI(), fitnessAssessment.findBMICategory());
            }

            //printing fitness level
            if(choice == 4)
            {
                System.out.println("Your fitness level is: " + fitnessAssessment.determineFitnessLevel());
            }
        }

        in.close();
    }
}
