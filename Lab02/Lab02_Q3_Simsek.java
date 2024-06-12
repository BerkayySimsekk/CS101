package Lab02;
import java.util.Scanner;

public class Lab02_Q3_Simsek 
{
    public static void main(String[] args) 
    {
        //Constants
        final double PAL = 1.4;
        final double CARBS_CALORIES_PERCENTAGE = 0.45;
        final double PROTEIN_CALORIES_PERCENTAGE = 0.25;
        final double FAT_CALORIES_PERCENTAGE =  0.30;
        final int FAT_CALORIES_PER_GRAM = 9;
        final int CARBS_CALORIES_PER_GRAM = 4;
        final int PROTEIN_CALORIES_PER_GRAM = 4;

        //Variables
        double weight;
        double height;
        double bmr;
        double calories;
        double requiredProteinInGrams;
        double requiredFatInGrams;
        double requiredCarbsInGrams;
        int age;

        Scanner in = new Scanner(System.in);
        
        //User input for weight, height and age
        System.out.print("Enter your weight(kg), height(cm) and age(years): ");
        weight = in.nextDouble();
        height = in.nextDouble();
        age = in.nextInt();

        //Initiliazing variables
        bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        calories = bmr * PAL;
        requiredProteinInGrams = calories * PROTEIN_CALORIES_PERCENTAGE / PROTEIN_CALORIES_PER_GRAM;
        requiredFatInGrams = calories * FAT_CALORIES_PERCENTAGE / FAT_CALORIES_PER_GRAM;
        requiredCarbsInGrams = calories * CARBS_CALORIES_PERCENTAGE / CARBS_CALORIES_PER_GRAM;

        //Printing
        System.out.printf("Calories Required:%22.2f%n", calories);
        System.out.printf("%18s%22.2f%n", "GRAMS PROTEIN:", requiredProteinInGrams);
        System.out.printf("%18s%22.2f%n", "GRAMS FAT:", requiredFatInGrams);
        System.out.printf("%18s%22.2f%n", "GRAMS CARBS:", requiredCarbsInGrams);

        in.close();
    }   
}
