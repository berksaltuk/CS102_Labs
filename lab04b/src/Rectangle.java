package src;
/*
 * This class for our rectangle shape.
 * Author: Berk Saltuk Y?lmaz
 * 11.03.2020
 * */
public class Rectangle extends Shape implements Selectable {
   
   // properties
   int width;
   int height;
   int x;
   int y;
   
   boolean select;
   
   // rectangle constructor
   public Rectangle( int width, int height){
      this.width = width;
      this.height = height;

   }
   
   /*
    * This method for setting the state of selection.
    * param a boolean representing selection
    * */
   public void setSelected( boolean select){
      
      this.select = select;
      select = false;
   }
   
   /*
    * This method for getting the selection state.
    * return selection
    * */
   public boolean getSelected(){
      
      return select;
   }
   
   /*
    * This method for determining our rectangle's boundaries.
    * param x and y which entered by user
    * return this or null
    * */
   public Shape contains( int x, int y){
      
      if (((((width / 2) + getX()) >= x ) && (( getX() - (width / 2)) <= x )) && ((((height / 2) + getY()) >= y ) || (( getY() - ( height / 2)) <= y )))
      {
         return this;
      }
      else
      {
         return null;
      }
   }
   
    /*
    * This method for computing the area of circle.
    * return area
    * */
   public double getArea(){
      
      return width * height;
   }
   
    /*
    * String representation of our shape's selection state.
    * return selected or not
    * */
   public String toString(){
      
      if ( select )
      {
         return "Rectangle with location ( " + getX() + ", " + getY() +  " )  and with area " + getArea() + " is selected.";
      }
      else
      {
         return "Rectangle with location ( " + getX() + ", " + getY() +  " )  and with area " + getArea() + "  is not selected.";
      }
   }
   
}