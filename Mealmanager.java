package iikh;

import java.io.*;
import java.util.*;

public class MealManager
{
    private String databaseName = "meals.txt";

    private String convertToString(Meal meal)
    {
        String output="";
        output += String.valueOf(meal.dayNumber);
        output += "--";
        for(String recipe:meal.dayMeal)
        {
            output += recipe;
            output +=",,";
        }
        return output;
    }

    public ArrayList<Meal> readMealDatabase() throws Exception
    {
        String line;
        ArrayList<Meal> mealList = new ArrayList<>();
        Meal tempMeal;
        ArrayList<String> tempList;
        BufferedReader br;
        br = new BufferedReader(new FileReader(databaseName));
        while ((line = br.readLine()) != null)
        {
            tempMeal = new Meal();
            String[] temp = line.split("--");
            try{
                tempMeal.dayNumber = Integer.parseInt(temp[0]);
            }
            catch(NumberFormatException ex){
                //
            }
            String[] temp2 = temp[1].split(",,");
            tempList = new ArrayList<>(Arrays.asList(temp2));
            tempMeal.dayMeal = (ArrayList<String>)tempList.clone();
            mealList.add(tempMeal);
        }
        return mealList;
    }
    public void writeMealDatabase(ArrayList<Meal> mealList) throws Exception
    {
        String output = "";
        for(Meal meal : mealList)
        {
            output += convertToString(meal);
            output += '\n';
        }
        BufferedWriter writer= new BufferedWriter(new FileWriter(databaseName));
        writer.write(output);
        writer.close();
    }
}
