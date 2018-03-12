package iikh;

import java.util.*;

public class RecipeBrowser 
{
    private ArrayList<Recipe> fullDatabase = new ArrayList<>();
    private DatabaseManager database = new DatabaseManager();
    
    public RecipeBrowser() throws Exception
    {
        fullDatabase = database.readRecipeDatabase();
    }
    
    public int databaseSize()
    {
        return fullDatabase.size();
    }
    public String recipeName(int number)
    {
        return fullDatabase.get(number-1).name;
    }
    public void DisplayList() throws Exception
    {
        int i=1;
        for(Recipe recipe : fullDatabase)
        {
            System.out.println(i+")."+recipe.name);
            i++;
        }
    }
    
    public void saveDatabase() throws Exception
    {
        database.writeRecipeDatabase(fullDatabase);
    }
    
    public void updateDatabase() throws Exception
    {
        fullDatabase = database.readRecipeDatabase();
    }
    
    public void viewRecipe() throws Exception 
    {
        int input;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the recipe number to view: ");
        input = reader.nextInt();
        if(input <= fullDatabase.size())
        {  
            fullDatabase.get((input-1)).view();
        }
        else System.out.println("Not a valid entry");
        System.out.println("--------------------------------");
    }
    
    public void addRecipe() throws Exception
    {
      Recipe temp = new Recipe();
      String inputLine;
      Scanner reader = new Scanner(System.in);
      System.out.println("----Add a Recipe----");
      System.out.println("Enter Recipe name: ");
      inputLine = reader.nextLine();
      temp.name = inputLine;
      System.out.println("Enter ingredient list one by one "
              + "and type exit when you finish: ");
      while(1==1)
      {
        inputLine = reader.nextLine();
        if(inputLine.equals("exit"))
        {
            break;
        } 
        else
        {
            temp.ingredients.add(inputLine);
        }
      }
      System.out.println("Enter method step one by one "
              + "and type exit when you finish: ");
      while(1==1)
      {
        inputLine = reader.nextLine();
        if(inputLine.equals("exit"))
        {
            break;
        } 
        else
        {
            temp.method.add(inputLine);
        }
      }
      fullDatabase.add(temp); 
      System.out.println("Added Successfully ");
      System.out.println("--------------------------------");
    }
    
    public void deleteRecipe() throws Exception
    {
        int input;
        String temp;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the recipe number to delete: ");
        input = reader.nextInt();
        reader.nextLine();//To eliminate the \n character
        if(input <= fullDatabase.size())
        {
            System.out.println("Confirm deleting "
                    +fullDatabase.get((input-1)).name
                    +"\nEnter yes to delete anything else to exit");
            temp = reader.nextLine();
            if(temp.equals("yes"))
            {
                fullDatabase.remove((input-1));
                System.out.println("Deleted Successfully ");
            }
        }
        else System.out.println("Not a valid entry");
        System.out.println("--------------------------------");
    }
    
    public void editRecipe() throws Exception
    {
        int input;
        String temp;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the recipe number to edit: ");
        input = reader.nextInt();
        reader.nextLine();//To eliminate the \n character
        if(input <= fullDatabase.size())
        {
            System.out.println("Confirm Editing "
                    +fullDatabase.get((input-1)).name
                    +"\nEnter yes to Edit and anything else to exit");
            temp = reader.nextLine();
            System.out.println(temp);
            if(temp.equals("yes"))
            {
               fullDatabase.get((input-1)).edit();
               System.out.println("Edited Successfully ");
            }
        }
        else System.out.println("Not a valid entry");
        System.out.println("--------------------------------");
    }
     
}
