package Lab09;
import java.time.LocalDate;

public class FitnessAssessment 
{
    //data members
    LocalDate birthDate;
    double height;
    double weight;
    int restingHeartRate;
    double waist;
    double hips;
    String gender;

    //constructor
    public FitnessAssessment(String birthDate, double height, double weight, int restingHeartRate, double waist, double hips, String gender)
    {
       this.birthDate = setBirthDate(birthDate);
       setHeight(height);
       setWeight(weight);
       setRestingHeartRate(restingHeartRate);
       setWaist(waist);
       setHips(hips);
       setGender(gender);
    }

    //getters
    public double getHeight()
    {
        return height;
    }

    public double getWeight()
    {
        return weight;
    }

    public int getRestingHeartRate()
    {
        return restingHeartRate;
    }

    public double getWaist()
    {
        return waist;
    }

    public double getHips()
    {
        return hips;
    }

    public String getGender()
    {
        return gender;
    }

    //setters
    public LocalDate setBirthDate(String birthDateAsString)
    {
        int year;
        int month;
        int day;

        year = Integer.valueOf(birthDateAsString.substring(0, 4));
        month = Integer.valueOf(birthDateAsString.substring(5, 7));
        day = Integer.valueOf(birthDateAsString.substring(8));


        LocalDate birthDateAsLocalDate = LocalDate.of(year, month, day); 
        
        return birthDateAsLocalDate;
    }

    public void setHeight(double newHeight)
    {
        if(newHeight >= 0)
        {
            height = newHeight;
        }   
    }

    public void setWeight(double newWeight)
    {
        if(newWeight >= 0)
        {
            weight = newWeight;
        }   
    }

    public void setRestingHeartRate(int newRestingHeartRate)
    {
        if(newRestingHeartRate >= 0)
        {
            restingHeartRate = newRestingHeartRate;
        }   
    }

    public void setWaist(double newWaist)
    {
        if(newWaist >= 0)
        {
            waist = newWaist;
        }
    }

    public void setHips(double newHips)
    {
        if(newHips >= 0)
        {
            hips = newHips;
        }
    }

    public void setGender(String newGender)
    {
        if(newGender.equals("f") || newGender.equals("m"))
        {
            gender = newGender;
        }
    }

    //service methods
    public double calculateTargetHeartRate()
    {
        return calculateMaxHeartRate() * 0.85;
    }

    public double calculateWaistHipRatio()
    {
        return waist / hips;
    }

    public double calculateBMI()
    {
        return weight / (height * height);
    }

    public String findBMICategory()
    {
        double BMI = calculateBMI();

        if(BMI >= 30)
        {
            return "Obese";
        }
        else if(BMI >= 25)
        {
            return "Overweight";
        }
        else if(BMI >= 20)
        {
            return "Normal";
        }
        else
        {
            return "Underweight";
        }
    }

    public String determineFitnessLevel()
    {
        int counter;

        counter = 0;

        if(restingHeartRate < 70)
        {
            counter++;
        }

        if(calculateBMI() <= 24 && calculateBMI() >= 20)
        {
            counter++;
        }

        if(gender.equals("m"))
        {
            if(calculateWaistHipRatio() < 1)
            {
                counter++;
            }
        }
        else if(gender.equals("f"))
        {
            if(calculateWaistHipRatio() < 0.9)
            {
                counter++;
            }
        }

        if(counter == 0)
        {
            return "POOR";
        }
        else if(counter == 1)
        {
            return "AVERAGE";
        }
        else if(counter == 2)
        {
            return "GOOD";
        }
        else
        {
            return "EXCELLENT";
        }     
    }

    //helper private methods
    private int calculateAge()
    {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    private int calculateMaxHeartRate()
    {
        return 220 - calculateAge();
    }

}
