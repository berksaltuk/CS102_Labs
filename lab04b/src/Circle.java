package src;
/*
 * This class for our circle shape.
 * Author: Berk Saltuk Y?lmaz
 * 11.03.2020
 * */

public class Circle extends Shape implements Selectable {
   
   // properties
   public int radius;
   public int x;
   public int y;
   
   boolean select;
   
   // radius constructor
   public Circle( int radius)
   {
      this.radius = radius;
      select = false;
   }
   
   /*
    * This method for computing the area of circle.
    * return area
    * */
   public double getArea() {
      
      return Math.pow( radius, 2) * Math.PI;
   }
   
   /*
    * This method for setting the state of selection.
    * param a boolean representing selection
    * */
   public void setSelected( boolean select){
      
      this.select = select;
   }
   
   /*
    * This method for getting the selection state.
    * return selection
    * */
   public boolean getSelected(){
      
      return select;
   }
   
   
   /*
    * This method for determining our circle's boundaries.
    * param x and y which entered by user
    * return this or null
    * */
   public Shape contains( int x, int y){
      
      if ( Math.pow( x - getX(), 2) + Math.pow( y - getY(), 2) <= Math.pow( radius, 2))
      {
         return this;
      }
      else
      {
         return null;
      }
   }
   
   
   /*
    * String representation of our shape's selection state.
    * return selected or not
    * */
   public String toString(){
      
      if ( select )
      {
         return "Circle with location ( " + getX() + ", " + getY() +  " ) and with area " + getArea() + " is selected.";
      }
      else
      {
         return "Circle with location ( " + getX() + ", " + getY() +  " )  and with area " + getArea() + " is not selected.";
      }
   }
}