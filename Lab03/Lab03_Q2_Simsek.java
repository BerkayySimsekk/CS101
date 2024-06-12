package Lab03;
import java.util.Scanner;

public class Lab03_Q2_Simsek 
{
    public static void main(String[] args)
    {
        //Variables
        double children;
        double adult;
        double senior;
        double childDependency;
        double seniorDependency;
        String ageDependencyCategory;

        Scanner in = new Scanner(System.in);

        //Inputs for the number of citizens in children, adult, and senior category
        System.out.print("Enter the number of citizens under 15: ");
        children = in.nextInt();

        System.out.print("Enter the number of citizens between the age of 15 and 64: ");
        adult = in.nextInt();

        System.out.print("Enter the number of citizens over 64: ");
        senior = in.nextInt();

        //Calculation of dependency numbers for the children and seniors
        childDependency = 100 * children / adult;
        seniorDependency = 100 * senior / adult;

        //Determination of what the age dependency category of a country is
        if(seniorDependency < 15)
        {
            if(childDependency < 29)
            {
                ageDependencyCategory = "Low Overall Dependency";
            }
            else if (childDependency >= 29 && childDependency <= 45)
            {
                ageDependencyCategory = "Moderate Child Dependency";
            }
            else
            {
                ageDependencyCategory = "High Child Dependency";
            }
        }
        else
        {
            if(childDependency < 29)
            {
                ageDependencyCategory = "High Old-Age Dependency";
            }
            else
            {
                ageDependencyCategory = "Double Dependency";
            }
        }

        System.out.printf("%nChild Dependency: %.1f%nSenior Dependency: %.1f%nAge Dependency Category: %s", childDependency, seniorDependency, ageDependencyCategory);

        in.close();
    }    
}
