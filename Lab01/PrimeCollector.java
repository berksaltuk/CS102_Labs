import java.io.*;

/**
 * Author: Berk Saltuk Yýlmaz
 * Version: 1.0
 * 19 February 2020
 */
public class PrimeCollector {
   
   
   public static void main(String[] args) { 
      
      IntBag primes = new IntBag();
      int currentPrime;
      boolean isPrime;
      
      
      isPrime = true;
      currentPrime = 3;
      
      primes.add(2);
      
      for ( int i = 2; i <= 100; )
      {
         for ( int j = 0 ; j < primes.size() ; j++ )
         {
            if ( currentPrime % Integer.parseInt(primes.get(j)) == 0 )
            {
               isPrime = false;
            }
         }
         
         if ( isPrime)
         {
            primes.add(currentPrime);
            i++;  
         }
         
         isPrime = true;
         currentPrime++;
      }         
      
      System.out.println("The Size of the array is " + primes.size());
      System.out.println( "The string display of array: [ " + primes.toString() + " ]");
      
   }   
}
