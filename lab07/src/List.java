import java.util.*;

/**
 * Linked List Class
 * Author: Berk Saltuk Yýlmaz
 * Date: 13.05.2020
 * version 1.0
 */
public class List{
   
   // properties
   private Node head; // a node representing the head of list
   
   // constructor
   public List() // setting head to null
   {
      
      head = null;
   }
   
   // methods
   
   /**
    * A method for adding elements to the head
    * param a string.
    */
   public void addToHead( String item) 
   {
      Node newNode = new Node( item, head); // initializing a new node representing head with the data on it.
      
      head = newNode;
   }
   
   /**
    * A method for adding elements to the tail
    * param a string.
    */
   public void addToTail( String item ) // iterative method
   {
      if ( head == null )
      {
         addToHead( item ); // if head is null adding to the head of the list ( since head == tail in this case )
      }
      
      else
      {
         tail().next = new Node( item, null ); // adding to the tail of the list.
      }
   }
   
   /**
    * A method for removing elements from the tail
    * return the new head's data
    */
   public String removeFromHead()
   {
      if ( head == null ) 
      { 
         throw new NoSuchElementException(); // if list is empty i guarantee that program will not crash
      }
      
      head = next( head ); // new head is the element next to head.
      
      return head.data; // return the new head
   }
   
   /**
    * A method for checking whether list is empty
    * return true or false
    */
   public boolean isEmpty()
   {
      return head == null; // the result of this shows the situation of list
   }
   
   /**
    * A method for getting the string at the desired index
    * param the index of element
    * return the string at the index
    */
   public String getData( int index ) // invalid index returns null
   {
      if(head == null || index < 0) // if list is empty or input invalid, return null.
      {
         return null;
      }
      
      else if(index == 0) // if index 0 return the head
      {
         return head.data;
      }
      
      else
      {
         Node temp = head;
         int count = 0;
         
         while( temp.next != null && count < index ) // until we reach the index we iterate the list, starting from head
         {
            temp = temp.next;
            count++;
         }
         
         return temp.data; // return the data at the given index
      }
   }
   
   /**
    * A method for printing forward
    */
   public void print() // iterative method
   {
      String result = "";
      
      Node temp = head;
      
      while( temp != null ){ // getting the data starting from head and printing them forward
         
         result = result + temp.data + " ";
         temp = temp.next;
         
      }
      
      System.out.println( result );
   }
   
   /**
    * A method for printing reverse
    */
   public void printReverse() // recursive method
   {
      if( head.next == null ) // if head.next is empty prints for the last time
      {
         System.out.print( head.data + " " );
      }
      else
      {   
         List temp = new List(); // initializing a new list
         
         temp.head = this.head.next; // setting my temporary list's head to next element of my list
         temp.printReverse(); // recursion ! 
         System.out.print( head.data + " " ); // printing element by element
      }
      
   }
   
   /**
    * A method for checking whether the list have the target string or not.
    * param a string.
    * return true or false.
    */
   public boolean contains( String target) // true if target is in the list, else false
   {
      boolean isContaining = false;
      
      for ( Node p = head; p != null; p = p.next ) // starting from the head checking each element
      {
         if( p.data == target ) // if target is in the list return true, false otherwise
         {
            isContaining = true;
         }
      }
      
      return isContaining;
   }
   
   /**
    * A method for checking if values are strictly ascending.
    * return true or false.
    */
   public boolean isOrdered() // true if values strictly ascending, else false 
   {
      Node temp = head.next; 
      Node forHead = head;
      if ( head == null ) // if list is empty
      {
         return true;
      }
      
      if ( temp != null) // if the next element of head is not null
      {
         
         while( forHead != null && temp != null ) // while both of forHead and temp is not null
         {
            if( forHead.data.compareTo( temp.data ) >= 0) //  true if values strictly ascending, else false 
            {
               return false;
            }
            forHead = forHead.next;
            temp = temp.next;
         }
      }
      return true;
   }
   
   @Override
   public String toString()
   {
      String result = ""; // string representation of list, works in the same way with print
      
      Node temp = head;
      
      while( temp != null ){
         
         result = result + temp.data + " ";
         temp = temp.next;
         
      }
      
      return result;
   }
   
   /**
    * A method for getting the next node.
    * param a node.
    * return the next node
    */
   public Node next( Node n ) // getting the next node
   {
      if( n.next == null )
      {
         return null;
      }
      else
      {
         return n.next;
      }
   }
   
   /**
    * A method for getting the previous node.
    * param a node.
    * return the previous node.
    */
   public Node previous( Node n ) // getting the previous node
   {
      Node temp = head;
      
      while( temp.next != null )
      {
         if( temp.next == n )
         {
            return temp;
         }
      }
      
      return null;
   }
   
   
   /**
    * A method for getting the tail of the list
    * return the list's tail.
    */
   public Node tail() // getting the last element of the list
   {
      Node temp = head;
      
      while( temp.next != null ) // getting the elements till we reach the last element
      {
         temp = temp.next;
      }
      
      return temp;
   }
   
   /**
    * Node inner class
    * Author: Berk Saltuk Yýlmaz
    * Date: 13.05.2020
    * version 1.0
    */
   private class Node {
      
      // properties
      String data;
      Node next;
      
      // constructor
      public Node( String data, Node next) {
         this.data = data;
         this.next = next;
      }
      
   } // end class Node
   
   // static methods
   
   /**
    * A method for creating a list from a string array
    * param string array
    * return new list
    */
   public static List createFrom( String[] arr )
   {
      List newList = new List();
      
      for ( int i = 0; i < arr.length; i++) // adding each element of the array to the list
      {
         newList.addToTail( arr[i] );
      }
      
      return newList;
   }
   
   /**
    * A method for creating a list from a string's chars
    * param string array
    * return new list
    */
   public static List createFrom( String str )
   {
      List newList = new List();
      
      for ( int i = 0; i < str.length(); i++) // adding each char of the string to the list
      {
         newList.addToTail( "" + str.charAt(i) );
      }
      
      return newList;
   }
   
   /**
    * A method for comparing 2 lists and find uncommon elements of them
    * param two lists
    * return a new list
    */
   public static List merger( List a, List b)
   {
      List newList = new List();
      boolean contains = false;
      
      for( Node i = a.head; i != null; i = i.next)
      {
         for( Node j = b.head; j != null; j = j.next) // first, comparing first list's elements to second list's elements
         {
            if( i.data.equalsIgnoreCase(j.data)) 
            {
               contains = true; // if both lists have the same element set the variable to true
            }
         }
         if( !contains)
         {
            newList.addToTail( i.data); // if the element is uncommon add it to the new list
         }
         contains = false;
      }
      
      for( Node i = b.head; i != null; i = i.next)
      {
         for( Node j = a.head; j != null; j = j.next) // second, comparing second list's elements to first list's elements
         {
            if( i.data.equalsIgnoreCase(j.data))
            {
               contains = true;
            }
         }
         if( !contains)
         {
            newList.addToTail( i.data); // if the element is uncommon add it to the new list
         }
         contains = false;
      }
      
      return newList;
   }
}