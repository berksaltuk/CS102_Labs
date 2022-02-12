package src;
/*
 * This class for our square shape.
 * Author: Berk Saltuk Yýlmaz
 * 11.03.2020
 * */
public class Square extends Rectangle {
  
   // properties
   int side;
   
   // square constructor
   public Square (int side)
   {
      super( side, side);
      this.side = side;
   }
   
    /*
    * This method for computing the area of square.
    * return area
    * */
   public double getArea(){
      
      super.getArea();  
      return side * side;
      
   }
   
    /*
    * String representation of square
    * return display
    * */
   public String toString(){
      
      if ( select )
      {
         return "Square with location ( " + getX() + ", " + getY() +  " )  and with area " + getArea() + " is selected.";
      }
      else
      {
         return "Square with location ( " + getX() + ", " + getY() +  " )  and with area " + getArea() + "  is not selected.";
      }
   }
}