package iikh;

import java.util.*;

public class Recipe
{
    public String name;
    public ArrayList <String> ingredients;
    public ArrayList <String> method;

    public Recipe()
    {
        name = "";
        ingredients = new ArrayList<>();
        method = new ArrayList<>();
    }

    public void view()
    {
        System.out.println("--------------------------");
        System.out.println("Name: "+ name);
        System.out.println("Ingredients:");
        for(int i=0;i<ingredients.size();i++)
        {
            System.out.println((i+1)+")."+ingredients.get(i));
        }
        System.out.println("Method:");
        for(int i=0;i<method.size();i++)
        {
            System.out.println((i+1)+")."+method.get(i));
        }
    }
    public void edit()
    {
        Scanner reader = new Scanner(System.in);
        int input;
        String temp;
        ArrayList <String> tempList = new ArrayList <>();
        System.out.println("Type command:"
                + "\n 1:If you want to edit the recipe name "
                + "\n 2: If you want to edit ingredients"
                + "\n 3: If you want to edit method "
                + "\n 0: To save");
        OUTER:
        while (1==1) {
            System.out.println("Command: ");
            input = reader.nextInt();
            reader.nextLine();//To eliminate the \n character
            switch (input) {
                case 0:
                    break OUTER;
                    //call goes back to main 
                    //the local copy should be saved there in the file
                case 1:
                    System.out.println("Enter a new name: ");
                    temp = reader.nextLine();
                    name = temp;
                    break;
                case 2:
                    System.out.println("Enter the ingredients one by one"
                            + " and type 'end' when you finish:");
                    while(1==1)
                    {
                        temp = reader.nextLine();
                        if(temp.equals("end"))
                        {
                            break;
                        }
                        tempList.add(temp);
                    }   
                    ingredients = (ArrayList<String>) tempList.clone();
                    tempList.clear();
                    break;
                case 3:
                    System.out.println("Enter the steps of method one by one"
                            + " and type 'end' when you finish:\n");
                    while(1==1)
                    {
                        temp = reader.nextLine();
                        if(temp.equals("end"))
                        {
                            break;
                        }
                        tempList.add(temp);
                    }   
                    method = (ArrayList<String>) tempList.clone();
                    tempList.clear();
                    break;
                default:
                    break;
            }
        }
    }
}
