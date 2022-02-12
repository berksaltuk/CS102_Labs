package src;
/*
 * This class for our shape.
 * Author: Berk Saltuk Yýlmaz
 * 11.03.2020
 * */
public abstract class Shape implements Locatable{
   
   // properties
   int x;
   int y;
   
   // abstract method
   public abstract double getArea();
   
   /*
    * This method for getting the x.
    * return x
    * */
   public int getX(){
      return this.x; 
   }
   
   /*
    * This method for getting the y.
    * return y
    * */
   public int getY(){
      return this.y;
   }
   
   /*
    * This method for setting the x, y location.
    * param x and y
    * */
   public void setLocation( int x, int y){
      
      this.x = x;
      this.y = y;
   }
}