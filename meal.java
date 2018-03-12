package iikh;

import java.io.*;
import java.util.*;

public class Meal
{
    private RecipeBrowser browser;
    public ArrayList<String> dayMeal;
    public int dayNumber;

    public Meal() throws Exception
    {
        dayMeal = new ArrayList<>();
        browser = new RecipeBrowser();
    }
    
    public void view()
    {
        System.out.println("Meal for Day"+dayNumber);
        for(String recipeName : dayMeal)
        {
            System.out.println(recipeName);
        }
    }
    
    public void edit() throws Exception
    {
      Scanner reader = new Scanner(System.in);
      int input,i;
      ArrayList<String> temp = new ArrayList<>();
      System.out.println("Enter 4 numbers of the Recipes one by one from this list given below for meals of the day");
      browser.DisplayList();
      i=0;
      while(i<4)
      {
          input = reader.nextInt();
          if(input <= browser.databaseSize())
          {
              temp.add(browser.recipeName(input));
              System.out.println("Recipe "+browser.recipeName(input)+" added");
              i++;
          }
          else
          {
              System.out.println("Enter a valid number");
          } 
      }
      dayMeal = (ArrayList<String>) temp.clone();
    }
}
