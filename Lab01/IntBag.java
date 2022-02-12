import java.util.*;
import java.util.Scanner;

/**
 * Author : Berk Saltuk Yýlmaz
 * Version: 1.0
 * 19 February 2020
 */
public class IntBag {
   // properties
   int[] bag;
   int valid;
   final int MAX = 100;
   
   // constructors
   
   //empty collection constructor
   IntBag ()
   {
      bag = new int[MAX];
      valid = 0;
      
   }
   
   //max number of elements constructor
   IntBag (int maxDesired)
   {   
      bag = new int[ maxDesired];
      valid = 0;
   }
   
   // methods
   
   /**
    * Adds the given value to end of bag
    * @param the given value
    * @return no return
    */
   public void add(int value)
   {      
      if (valid <= MAX)
      {
         bag[valid] = value;
         valid++;
      }      
   }
   
   /**
    * Adds the given value to a specific value into the bag
    * @param the given value
    * @return no return
    */
   public void add(int i, int value)
   {
      if ( i <= valid - 1)
      {
         for ( int j = valid - 1; i <= j; j--)
         {
            bag[ j + 1] = bag[ j];
            
         }
         bag[i] = value;
         valid++;
      }
      
   }
   
   /**
    * Removes the value from a specific index
    * @param the given index
    * @return no return
    */
   public void remove(int i)
   {
      
      if ( i >= 0 && i < valid)
      {
         for ( int j = i + 1; j < valid; j++)
         {
            bag[ j - 1] = bag[ j];
         }
         valid--;
      }
      
      
   }
   
   /**
    * Checks the bag whether has the given value
    * @param the given value
    * @return true or false
    */
   public boolean contains(int value)
   {
      
      for ( int i = 0; i < MAX; i++)
      {
         if ( value == bag[i])
         {
            return true;
         }
      }
      
      return false;
   }
   
   /**
    * Shows the size of bag
    * @param no parameter
    * @return valid / size
    */
   public int size()
   {
      return valid;
   }
   
   /**
    * Gets the value from given index
    * @param the given index
    * @return value or an error message
    */
   public String get(int i)
   {
      if ( i <= valid)
      {
         return "" + bag[i];
      }
      
      return "Error!";
   }
   
   /**
    * Prints a string representation of bag
    * @param no parameter
    * @return string representation of bag
    */
   public String toString()
   {
      String result;
      result = "";
      
      for (int i = 0; i < valid; i++)
      {
         result = result + bag[i] + " ";
      }
      
      return result;
   }
   
   /**
    * Finds the locations of a value and creates a new bag which contains the location indexes
    * @param IntBag to check, given value
    * @return a new bag which contains the location indexes
    */
   public IntBag findAll( IntBag i, int value)
   {
      IntBag found = new IntBag();
      
      if ( i.contains( value))
      {
         for (int j = 0; j < i.size(); j++)
         {
            if ( Integer.parseInt( i.get(j)) == value)
            {
               found.add(j);
            }
         }
      }
      
      return found;
   }
   
}