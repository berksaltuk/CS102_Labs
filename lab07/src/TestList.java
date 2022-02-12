import java.util.*;

/**
 * Testing the list class
 * Author: Berk Saltuk Yýlmaz
 * Date: 13.05.2020
 * version 1.0
 */
public class TestList{

   public static void main( String[] args)
   {
      List myList = new List();
      System.out.println( "--------------------------------------------");
      System.out.println("List is empty: " + myList.isEmpty());
      
      System.out.println( "--------------------------------------------");
      
      myList.addToHead("Saltuk");
      myList.addToTail("Yýlmaz");
      myList.addToHead("Berk");
      
      System.out.println("List is ordered: " + myList.isOrdered());
      System.out.println( "--------------------------------------------");
     
      System.out.println(myList);
      myList.print();
      myList.printReverse();
      
      System.out.println( "\n--------------------------------------------");
      
      System.out.println( myList.getData(1));
     
      System.out.println( "--------------------------------------------");
      
      myList.removeFromHead();
      System.out.println(myList);
      
      System.out.println( "--------------------------------------------");
     
      System.out.println("List is empty: " + myList.isEmpty());
      
      System.out.println( "--------------------------------------------");
      
      String[] arr = { "Berk", "Burcu", "Gülçin"};
      System.out.println( List.createFrom( arr));
      
      System.out.println( "--------------------------------------------");
      
      String str = "ABDF";
      String str2 = "ABCD";
         
      System.out.println( List.createFrom( str));
      System.out.println( List.createFrom( str2));
      System.out.println( List.merger(List.createFrom( str), List.createFrom( str2)));
      
      System.out.println( "--------------------------------------------");
   }
   
}