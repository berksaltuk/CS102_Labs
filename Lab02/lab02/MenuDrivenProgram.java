import cs1.SimpleURLReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;
/**
 * Author: Berk Saltuk Yýlmaz
 * Version: 03.03.2020
 * Menu Driven Collection
 */

public class MenuDrivenProgram {
   
   public static void main( String[] args){
      
      Scanner scan = new Scanner( System.in);
      
      // PART E
      
      // variables 
      int input;
      String poem;
      ArrayList<MySimpleURLReader> poemCollection;
      
      MySimpleURLReader poem1;
      HTMLFilteredReader poem2;
      
      // program code
      
      poemCollection = new ArrayList<MySimpleURLReader>();
      
      System.out.println( "******************************************************");
      System.out.println( "Welcome to the \"Poem Collection\"!");
      
      do
      {
         // our interface / menu
         System.out.println( "***************************************************");
         
         System.out.println( "1. Enter the url of the poem to add to collection.");
         System.out.println( "2. List all poems in the collection.");
         System.out.println( "3. Quit.");
         
         
         System.out.println( "***************************************************");
         System.out.println( "Choose by typing the number of option!");
         System.out.println( "***************************************************");
         
         
         input = scan.nextInt(); 
         if ( input == 1)
         {
            System.out.println( "Enter the URL of the poem that you want to add: ");
            scan.nextLine();
            poem = scan.nextLine();
            if ( poem.length() > 3)
            {
               if ( poem.substring( poem.length() - 3).equals( "txt"))
               {
                  poem1 = new MySimpleURLReader( poem );
                  poemCollection.add( poem1 );
               }
               else if ( poem.substring( poem.length() - 3).equals( "htm"))
               {
                  poem2 = new HTMLFilteredReader( poem );
                  poemCollection.add( poem2 );
               }
               else
               {
                  System.out.println( "This is NOT valid url!");
               }
            }
            else
            {
               System.out.println( "This is not a valid url!");
            }
            
            
            System.out.println( "Poem has been added to the collection!");
         }
         
         else if( input == 2)
         {
            if ( poemCollection.size() != 0)
            {
               do {
                  for( int i = 0; i < poemCollection.size(); i++)
                  {
                     System.out.println( "Poem at index " + i + " is " + poemCollection.get(i).getName());
                  }
                  
                  System.out.println( "Type the index of poem to display (Type last index + 1 to quit): ");
                  input = scan.nextInt();
                  
                  if ( 0 <= input && input < poemCollection.size() && poemCollection.get( input ) != null)
                  {
                     System.out.println( poemCollection.get( input ).getPageContents());
                  }
                  else if ( input == poemCollection.size() )
                  {
                     System.out.println( "Going back to main menu!");
                  }   
                  else
                  {
                     System.out.println( "Type a valid number!");
                  }
                  
               }while( input != poemCollection.size());
            }
            else
            {
               System.out.println( "The collection is empty.");
            }
         }            
      }while ( input != 3);
      
      System.out.println( "Thanks for using :)");
   }
}