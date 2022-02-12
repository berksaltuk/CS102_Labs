import java.util.*;

/**
 * Practicing recursion :)
 * Author: Berk Saltuk Yýlmaz
 * Date: 29.04.2020
 * version 1.0
 */
public class Lab06{
   
   // static variables, I am aiming to access them from my methods.
   private static int count = 0;
   private static int iterate = 0;
   private static String temp;
   private static int num = 1;
   private static ArrayList<Integer> list = new ArrayList<Integer>();
   
   
   public static void main( String[] args ){
      
      // creating a string array list for checking if its lexigrographic.
      ArrayList<String> list = new ArrayList<String>();
      list.add("abcd");
      list.add("abcde");
      list.add("abcdef");
      
      // trying my methods
      System.out.println( eCounter("eebee") );
      System.out.println( decimalToBinary( 6 ) );
      System.out.println( isLexicographic( list ) );
      System.out.println( isStrictlyIncreasing( 777 ) );
      System.out.println( listedInreasing( 4 ) );
      
      strictString(1,"",8);
   }
   
   /**
    * A method for counting the number of 'e' in a string.
    * param a string.
    * return the num of 'e' char.
    */
   public static int eCounter( String str )
   {    
      if ( str.charAt( iterate) == 'e' ) // if its 'e' count is increasing
      {
         count++;
      }
      if ( iterate >= str.length() - 1 ) // if I checked all chars
      {
         iterate = 0; // setting the iterate variable to zero to use it again.
         return count; // returning the count
      }
      
      iterate++; // increasing the iterate to check the next char
      
      return eCounter( str ); // recursion!
   }
   
   /**
    * A method for converting the decimal to binary.
    * param a integer.
    * return the binary version.
    */
   public static int decimalToBinary( int n )
   {
      if ( n == 0 ) // if n is zero ( the final step ), return 0.
      {
         return 0;
      }
      
      return n % 2 + 10 * decimalToBinary( n / 2 ); // remainder + 10*step1
                                                    // remainder + 10*step2 ...
                                                    // remainder + 10*stepFinal
   }
   
   /**
    * A method for checking if the elements of an array list are lexicographic( ordered alphabetically ).
    * param a string array list.
    * return true or false.
    */
   public static boolean isLexicographic( ArrayList<String> list )
   {
      if( list.size() == 0 ) // if the size of list is zero return false
      {
         return false;
      }
      else if( list.size() == 1 ) // if size is 1 everything went well, the list is lexicographic!
      {
         return true;
      }
      else 
      {
         temp = list.get( 0 ); // temporary element
         list.remove( 0 ); // remove it
         
         if( list.size() > 0 && temp.compareTo( list.get(0) ) > 0 ) // the result of compareTo is positive, it means the
                                                                    // element at the index is comes after the index + 1 alphabetically, so it is false.
         {
            return false;
         }
         
         return isLexicographic( list ); // recursion!
      }
   }
   
   /**
    * A method for checking if the digits of a number are increasing left to right.
    * param a integer.
    * return true or false.
    */
   public static boolean isStrictlyIncreasing( int num )
   {
      if ( Integer.toString( num ).length() < 2 && num % 2 == 0 ) // if the length of integer is less than 2 for example the int is 8, return true.
      {
         return true;
      }
      else{
         if ( num % 2 == 1 ) // if the number is odd it is false!
         {
            return false;
         }
         else
         {
            String str = Integer.toString( num );
            
            if( iterate >= str.length() - 1) // if iterated all and it is not false return the result of last 2 digits' comparison.
            {
               iterate = 0; // setting it to zero to use it again.
               return str.charAt( str.length() - 2 ) < str.charAt( str.length() - 1 );
            }
            if( str.charAt( iterate ) >= str.charAt( iterate + 1 ) ) // if it is not increasing return false.
            {
               iterate = 0;
               return false;
            }
            
            iterate++;
            return isStrictlyIncreasing( num ); // recursion!
         }
      }
   }
   
   /**
    * A method for creating an array list of strictly increasing n digit numbers.
    * param a integer as digit number.
    * return the strictly increasing array list.
    */
   public static ArrayList<Integer> listedInreasing( int n )
   {
      while( Integer.toString( num ).length() < n  ) // num is 1 at beginning, multiply with 10 till reach the true digit number!
      {
         num *= 10;
      }
      
      if( Integer.toString( num ).length() == n + 1 ) // if digit number is n+1 stop the process and return the list.
      {
         num = 1;
         return list;
      }
      if( isStrictlyIncreasing( num ) ) // if the number is strictly increasing add it to the list!
      {
         list.add( num );
      }
      
      num += 2; // increment the num by 2 because it will be even.
      return listedInreasing( n ); // recursion!
   }
   
   /**
    * A method for creating a string which is representing the strictly increasing "integers". That is kind of experimental.
    * param first digit of number, empty version of string, the digit number of numbers.
    */
   public static void strictString(int startFrom, String output, int n) 
   { 
      String str = "";
      
      if (n == 0) // if all digits are done print the output string 
      { 
         System.out.print(output + " "); 
      } 
      
      // starting from the 1 and adding the digits in an increasing order.
      for (int i = startFrom; i <= 9; i++) 
      {   
         if( n != 1 ) // if it is not the last digit
         {
            str = output + Integer.toString(i);
         }
         else if( n == 1 && i % 2 == 0) // if it is last digit check it is whether even or not.
         {
            str = output + Integer.toString(i);
         }
         
         strictString(i + 1, str, n - 1);  // recursion!
      } 
   } 
}