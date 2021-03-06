import java.util.*;
/**
 * Author : Berk Saltuk Y?lmaz
 * Version: 1.0
 * 19 February 2020
 */

public class IntBagTest {
   
   
   public static void main(String[] args) { 
      
      // variables
      int input;
      int lengthOfArray;
      int adding;
      int index;
      IntBag bagOfInt;
      IntBag testBag;
      int toRemoveReadProblem;
      int testValue;
      
      //program code
      Scanner scan = new Scanner( System.in);
      bagOfInt = new IntBag();
      testBag = new IntBag();
      lengthOfArray = 100;
      testValue = 0;
      
      System.out.println( "******************************************************");
      System.out.println( "Welcome to the \"Bag of Integers\"!");
      
      do
      {
         // our interface / menu
         System.out.println( "***************************************************");
         
         System.out.println( "1. Create a new Integer Bag. (Max 100 Integers)");
         System.out.println( "2. Add values to existing bag.");
         System.out.println( "3. Print the bag.");
         System.out.println( "4. Add a value to the collection of values at a specified location");
         System.out.println( "5. Remove a value from a specified location.");
         System.out.println( "6. Read a single test value.");
         System.out.println( "7. Compute the set of locations of the test value within the collection");
         System.out.println( "8. Print the location set of a value.");
         System.out.println( "9. Quit!");
         
         System.out.println( "***************************************************");
         System.out.println( "Choose by typing the number of option!");
         System.out.println( "***************************************************");
         
         input = scan.nextInt();         
          
         if ( input == 1)
         {
            System.out.println( "Type the size of the bag: ");
            lengthOfArray = scan.nextInt();
            
            if ( 0 <= lengthOfArray && lengthOfArray <= 100)
            {
               bagOfInt = new IntBag(lengthOfArray);
               System.out.println( "Your bag has been created.");
            }
            else
            {
               System.out.println( "Out of bounds!");
            }
         }
         
         else if( input == 2)
         {
            if ( bagOfInt.size() < lengthOfArray)
            {
               System.out.println( "Type the integer you want to add (Type negative value to stop the session): ");
               
               adding = scan.nextInt();
               bagOfInt.add(adding);
               do
               {
                  adding = scan.nextInt();
                  bagOfInt.add(adding);
               }while ( adding > -1 && bagOfInt.size() < lengthOfArray);
            }
            else
            {
               System.out.println( "You can't add more value in this bag!");
            }
         }
         
         else if( input == 3)
         {
            if ( bagOfInt.size() == 0)
            {
               System.out.println( "There is nothing to see!");
            }
            else 
            {              
               System.out.println( "Here your array: [ " + bagOfInt.toString() + "]");
            }
         }
         
         else if( input == 4)
         {
            if ( bagOfInt.size() + 1 <= lengthOfArray)
            {
               System.out.println( "Which index you want to add?");
               index = scan.nextInt();
               if ( index <= bagOfInt.size() - 1)
               {
                  
                  System.out.println( "Which value you want to add?");
                  adding = scan.nextInt();
                  bagOfInt.add(adding);
                  
                  bagOfInt.add(index, adding);
                  System.out.println( "Value has been added.");
               }
               else
               {
                  System.out.println( "Out of bounds!");
               }
            }
            else 
            {
               System.out.println( "You can't add more!");
            }
         }
         
         else if ( input == 5)
         {
            if ( 0 < bagOfInt.size())
            {
               System.out.println( "Which index you want to remove?");
               index = scan.nextInt();
               
               bagOfInt.remove(index);
            }
            else
            {
               System.out.println( "I see nothing to remove...");
            }
         }
         
         else if ( input == 6)
         {
            System.out.println( "Type an integer to test: ");
            testValue = scan.nextInt();
            System.out.println( "Value has been obtained.");
         }
         
         else if ( input == 7)
         {
            testBag = bagOfInt.findAll( bagOfInt, testValue);
            System.out.println( "Computation completed.");
         }
         
         else if ( input == 8)
         {
            System.out.println( "Here your set of locations: [ " + testBag.toString() + "]");
         }
         
         else
         {
            System.out.println ( "I don't want to make you sad but it didn't make sense...");
         }
         
      }while( input != 9);
      System.out.println( "We are looking forward to see you using our program again. Take care!");
      
   }
}