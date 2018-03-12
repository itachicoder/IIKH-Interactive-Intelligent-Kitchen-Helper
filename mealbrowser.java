package iikh;

import java.util.*;

public class MealBrowser 
{
    private ArrayList<Meal> fullDatabase = new ArrayList<>();
    private MealManager database = new MealManager();
    
    public MealBrowser() throws Exception
    {
        fullDatabase = database.readMealDatabase();
    }
    
    public int databaseSize()
    {
        return fullDatabase.size();
    }
    
    public void DisplayList() throws Exception
    {
        System.out.println("Day  ||  Breakfast "
                + " ||  Lunch  ||  Snacks  ||  Dinner");
        for(Meal meal : fullDatabase)
        {
           System.out.println(meal.dayNumber
                   +"   "+meal.dayMeal.get(0)
                   +" || "+meal.dayMeal.get(1)+" || "
                   +meal.dayMeal.get(2)+" || "
                   +meal.dayMeal.get(3));
        }
    }
    
    public void saveDatabase() throws Exception
    {
        database.writeMealDatabase(fullDatabase);
    }
    
    public void addMeal() throws Exception
    {
      int i=0,input,flag=0;
      Meal temp = new Meal();
      RecipeBrowser recipeBrowser = new RecipeBrowser();
      String inputLine;
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter the Day number to add meal: ");
      input = reader.nextInt();
      reader.nextLine();//To eliminate the \n character
      for(Meal meal : fullDatabase)
        {
            if(input==meal.dayNumber)
            {
                System.out.println("Already exists");
                flag=1;
            }
        }
      if(flag!=1)
      {
        temp.dayNumber = input; 
        System.out.println("----Adding a Meal for Day"+(temp.dayNumber)+"----");
        System.out.println("Enter 4 numbers from the list given below"
                + " corresponding to Breakfast, lunch , snacks and dinner");
        recipeBrowser.DisplayList();
        ArrayList <String> tempList = new ArrayList<>();
        while(i<4)
        {
            input = reader.nextInt();
            if(input <= recipeBrowser.databaseSize())
            {
                tempList.add(recipeBrowser.recipeName(input));
                System.out.println("Recipe "+recipeBrowser.recipeName(input)
                        +" added");
                i++;
            }
            else
            {
                System.out.println("Enter a valid number");
            } 
        }
        temp.dayMeal = (ArrayList<String>)tempList.clone();
        fullDatabase.add(temp); 
        System.out.println("Meal Added Successfully ");
        System.out.println("--------------------------------");
      }   
    }
    
    public void deleteMeal() throws Exception
    {
        int input,i=0,flag=0;
        String temp;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the Day number to delete meal: ");
        input = reader.nextInt();
        reader.nextLine();//To eliminate the \n character
        for(i=0;i<fullDatabase.size();i++)
        {
            if(input == fullDatabase.get(i).dayNumber)
            {
                fullDatabase.remove(i);
                System.out.println("Deleted Successfully ");
                flag=1;
                break;
            }
        }
        if(flag!=1)
        {
            System.out.println("Day does not exists");
        }
        System.out.println("--------------------------------");
    }
    
    public void editMeal() throws Exception
    {
 
        int input,i=0,flag=0;
        String temp;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the Day number to edit meal: ");
        input = reader.nextInt();
        reader.nextLine();//To eliminate the \n character
        for(Meal meal : fullDatabase)
        {
            if(input==meal.dayNumber)
            {
                fullDatabase.get(i).edit();
                System.out.println("Edited Successfully ");
                flag=1;
            }
            i++;
        }
        if(flag!=1)
        {
            System.out.println("Day does not exists");
        }
        System.out.println("--------------------------------");
    }
     
}
