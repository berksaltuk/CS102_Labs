package src;
import java.util.*;

/*
 * This class for testing our methods and interfaces.
 * Author: Berk Saltuk Yýlmaz
 * 11.03.2020
 * */
public class ShapeTester{
   
   public static void main( String[] args){
      
      Scanner scan = new Scanner(System.in);
      
      // variables
      int input;
      int input2;
      int input3;
      ShapeContainer container;
      
      Circle circle;
      Rectangle rectangle;
      
      container = new ShapeContainer();
      
      System.out.println( "Welcome to \"Shape Tester\"!!!");
      System.out.println( "*******************************");
      
      do{
         System.out.println( "1. Create a new and empty shape container.");
         System.out.println( "2. Add shapes to your container.");
         System.out.println( "3. See the total area of your shapes.");
         System.out.println( "4. Display your shape container.");
         System.out.println( "5. Find a specific shape and toggle its state.");
         System.out.println( "6. Remove all selected shapes.");
         System.out.println( "7. Quit.");
         System.out.println( "*******************************");
         
         System.out.println( "Type the number to select:");
         input = scan.nextInt();
         
         if ( input == 1)
         {
            container = new ShapeContainer(); 
            System.out.println( "Container is ready to use!");
         }
         else if ( input == 2)
         {
            System.out.println( "What do you want to add?");
            System.out.println( "1. Circle");
            System.out.println( "2. Rectangle");
            input = scan.nextInt();
            
            if ( input == 1)
            {
               System.out.println( "Enter a radius:");
               input2 = scan.nextInt();
               
               circle = new Circle(input2);
               
               System.out.println( "Enter the x value.");
               input2 = scan.nextInt();
               System.out.println ( "Enter the y value.");
               input3 = scan.nextInt();
               
               circle.setLocation( input2, input3);
               container.add(circle);
               
               System.out.println( "Circle added.");
            }
            else if ( input == 2)
            {
               System.out.println( "Enter a width and height (If you write equal width and height it will be a square):");
               input3 = scan.nextInt();
               input2 = scan.nextInt();
               
               if ( input3 == input2 )
               {
               rectangle = new Square( input3 );
               }
               else
               {
               rectangle = new Rectangle( input3, input2 );
               }
               
               System.out.println( "Enter the x value.");
               input2 = scan.nextInt();
               System.out.println ( "Enter the y value.");
               input3 = scan.nextInt();
               
               rectangle.setLocation (input2, input3);
               container.add(rectangle);
               System.out.println( "Rectangle added.");
            }
            else
            {
               System.out.println( "Am I a joke to you?");
            }
         }
         else if ( input == 3)
         {
            System.out.println( "The total area is " + container.getArea());
         }
         else if ( input == 4)
         {
            System.out.println( "String display of your container:");
            System.out.println( container.toString());
            System.out.println();
         }
         else if ( input == 5)
         {
            System.out.println( "Enter the x value.");
            input2 = scan.nextInt();
            System.out.println ( "Enter the y value.");
            input3 = scan.nextInt();
            
            if ( container.contains( input2, input3) != null )
            {
               System.out.println( "The shape is selected.");
            }
            else
            {
               System.out.println( "Nothing is found...");
            }
            
         }
         else if ( input == 6)
         {
            container.removeAll();
            System.out.println( "You removed all selected shapes.");
         }
         
      }while( input != 7);
      
      System.out.println( "Thanks for using!");
      
   }
   
}