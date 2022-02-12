import java.util.*;

/**
 * Exercise for recursion :)
 * Author: Berk Saltuk Yýlmaz
 * Date: 29.04.2020
 * version 1.0
 */
public class Exercise01
{
   public static int max = -10000;
   public static int iterate = 0;
   public static ArrayList<Integer> nums = new ArrayList<Integer>();
   public static ArrayList<Integer> indexes = new ArrayList<Integer>();
   
   
   public static void main( String[] args )
   {
      int[] num = {1,4,8,9,1,1,27,1};
      System.out.println( power( 3, 5 ) );
      System.out.println( largest( num, 2 ) );
      System.out.println( startToEnd( 15, 30 ) );
      printForward( "berksaltukyilmaz" );
      System.out.println();
      printReverse( "berksaltukyilmaz" );
      System.out.println( firstSeen( num, 1, 0) );
      System.out.println( firstSeen( num, 1, num.length - 1) );
      System.out.println( allSeen( num, 1, 0) );
   }
   
   public static void printForward( String str)
   {
      System.out.printf("%s", str);
   }
   
   public static void printReverse( String str )
   {
      if ( str == null || str.length() <= 1 ) 
      {
         System.out.println(str);
      }
      else
      { 
         System.out.print( str.charAt( str.length() - 1 ) ); 
         printReverse( str.substring( 0, str.length() - 1 ) ); 
      }  
   }
   
   public static double power( int x, int y )
   {   
      
      if( y == 0 )
      {
         return 1;
      }
      
      return x * power( x, y - 1 ) ;
   }
   
   public static int largest( int[] nums, int n)
   {
      if( iterate == n )
      {
         iterate = 0;
         return max;
      }
      
      if( nums[iterate] > max)
      {
         max = nums[iterate];
      }
      
      iterate++;
      return largest( nums, n );
   }
   
   public static ArrayList<Integer> startToEnd( int start, int end )
   {
      if( start == end )
      {
         nums.add(start);
         return nums;
      }
      nums.add(start);
      return startToEnd( start + 1, end);
   }
   
   public static int firstSeen( int[] nums, int target, int index )
   {
      if( index >= nums.length )
      {
         return -1;
      }
      if( nums[index] == target)
      {
         return index;
      }
      return firstSeen( nums, target, index + 1);
   }
   public static int lastSeen( int[] nums, int target, int index )
   {
      if ( index < 0)
      {
         return -1;
      }
      if( nums[ index ] == target )
      {
         return index;
      }
      
      return lastSeen( nums, target, index - 1 );
   }
   public static ArrayList<Integer> allSeen( int[] nums, int target, int index )
   {
      if( index < nums.length )
      {
         if( nums[ index ] == target )
         {
         indexes.add( index );
         }
         return allSeen( nums, target, index + 1);
      }
      return indexes;
   }
}