package iikh;
import java.util.*;
public class IIKH
{

    public static void main(String[] args) throws Exception
    {
        int input1,input2;
        Scanner reader = new Scanner(System.in);
        RecipeBrowser browser = new RecipeBrowser();
        MealBrowser mealBrowser = new MealBrowser();
        
        System.out.println("-----Welcome to IIKH-----");
        while(1==1)
        {
            System.out.println("Select an option");
            System.out.println("1. Browse and edit/view/add/delete Recipes");
            System.out.println("2. Browse and edit/view/add/delete Meals");
            System.out.println("0. To Exit");
            System.out.println("--------------------------------");
            input1 = reader.nextInt();
            if(input1==0)
            {
                break;
            }
            else if(input1==1)
            {
                System.out.println("--------Recipe Browser---------");
                browser.DisplayList();
                System.out.println("--------------------------------");
                System.out.println("Select any among the options");
                System.out.println("1. View a Recipe");
                System.out.println("2. Edit a Recipe");
                System.out.println("3. Add a Recipe");
                System.out.println("4. Delete a Recipe");
                System.out.println("0. To return to previous menu");
                System.out.println("--------------------------------");
                input2 = reader.nextInt();
                switch (input2) {
                    case 1:
                        browser.viewRecipe();
                        break;
                    case 2:
                        browser.editRecipe();
                        break;
                    case 3:
                        browser.addRecipe();
                        break;
                    case 4:
                        browser.deleteRecipe();
                        break;
                    default:
                        break;
                }
                browser.saveDatabase();
            }
            else if(input1==2)
            {
                System.out.println("--------Meal Browser---------");
                mealBrowser.DisplayList();
                System.out.println("--------------------------------");
                System.out.println("Select any among the options");
                System.out.println("1. Edit a Days Meal");
                System.out.println("2. Add a Days Meal");
                System.out.println("3. Delete a Days Meal");
                System.out.println("0. To return to previous menu");
                System.out.println("--------------------------------");
                input2 = reader.nextInt();
                switch (input2) {
                    case 1:
                        mealBrowser.editMeal();
                        break;
                    case 2:
                        mealBrowser.addMeal();
                        break;
                    case 3:
                        mealBrowser.deleteMeal();
                        break;
                    default:
                        break;
                }
                mealBrowser.saveDatabase();
            }
            else break;          
        }
        
        
    
    }
}
