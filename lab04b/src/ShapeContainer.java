package src;
import java.util.*;
/*
 * This class for our shape container.
 * Author: Berk Saltuk Y?lmaz
 * 11.03.2020
 * */
import java.util.ArrayList;

public class ShapeContainer implements Iterable{
   
   // properties
   ArrayList<Shape> container;

   
   // collection constructor
   public ShapeContainer(){
      
      container = new ArrayList<Shape>();
      
   }
   
   // methods
   
   /*
    * This method setting selected all shapes at specific x, y coordinates.
    * param x and y
    * return the number of shapes
    * */
   public int selectAllAt( int x, int y)
   {
      int count = 0;
      
      for( int i = 0; i < size(); i++ )
      {
         if( ( (Selectable)container.get(i) ).contains( x, y) != null)
         {
            count++;
            
            ( (Selectable)container.get(i) ).setSelected( true);
         }
      }
      
      return count;
   }
   
   /*
    * This method returns the size of container.
    * return size of container.
    * */
   public int size(){
      
      return container.size();
      
   }
   
   /*
    * This method overrides the iterator.
    * return shapeIterator
    * */
   public Iterator<Shape> iterator(){
      
      Iterator<Shape> shapeIterator = new Iterator<Shape>() {
         
         int index = 0;
         
         @Override
         public boolean hasNext() {
            return index < container.size();
         }
         
         @Override
         public Shape next() {
            Shape shape;
            shape = container.get( index );
            
            index++;
            
            return shape;
         }
         
         @Override
         public void remove()
         {
            container.remove(index);
         }
      };
      return shapeIterator;
      
   }
   
   /*
    * This method adds shapes to collection.
    * param a shape
    * */
   public void add( Shape s){
      
      container.add(s);
      
   }
   
   /*
    * This method for computing the sum of areas.
    * return the sum of areas
    * */
   public double getArea(){
      
      double areaSum = 0;
      
      for ( int i = 0; i < container.size(); i++)
      {
         areaSum += container.get(i).getArea();
      }
      
      return areaSum;
   }
   
   /*
    * This method for finding a shape and toggle its selection.
    * param x and y
    * return a selected shape
    * */
   public Shape contains( int x, int y)
   {
      boolean contains = true;
      
      Selectable selected;
      
      Shape returnShape = null;
      
      for ( int i = 0; i < container.size() && contains; i++)
      {
         selected = (Selectable)container.get(i);
         
         if( selected.contains( x, y) != null )
         {
            contains = false;
            
            if ( selected.getSelected())
            {
               selected.setSelected(false);
            }
            else
            {
               selected.setSelected(true);
            }
            returnShape = container.get(i);
         }
      }
      
      return returnShape;
      
   }
   
   /*
    * This method for finding selected shapes and removing them.
    * */
   public void removeAll(){
      
      Selectable removeSelected;
      
      for ( int i = container.size() - 1; 0 <= i; i--)
      {
         removeSelected = ( Selectable )container.get(i);
         if ( removeSelected.getSelected() == true)
         {
            container.remove(i);
         }
      }
   }
   
   /*
    * This method for displaying the container as string.
    * return string representation
    * */
   public String toString(){
      
      String display = "";
      int count1 = 0;
      int count2 = 0;
      
      for ( int i = 0; i < container.size(); i++)
      {
         display = "" + container.get(i);
         
         if ( display.charAt(0) == 'C')
         {
            count1++;
         }
         else if ( display.charAt(0) == 'R')
         {
            count2++;
         }
         
      }
      display = "The size of this container is " + container.size() + "\nThis container contains " + count1 + " circles and " + count2 + " rectangles.\n";
      
      for ( int i = 0; i < container.size(); i++)
      {
         display = display+ "\n" + container.get(i);
      }
      
      return display;
   } 
}