package srcNew;

import src.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/*
 * A class for my balloons.
 * Author: Berk Saltuk Yýlmaz
 * 08.04.2020
 * */
public class Balloon extends Circle implements Drawable{
   
   
   // properties
   public static final int FINAL_RADIUS = 100;

   int r;
   
   // constructor
   public Balloon( int r )
   {
      
      super ( r );
      this.r = 25;
   }
   
   // methods
   
   /*
    * Draws the balloons.
    * param is a graphics object
    * */
   public void draw( Graphics g )
   {
      Random num = new Random();
      
      if ( num.nextInt(4) == 1 )  // adding some to the game with using colors.
      {
         g.setColor( Color.cyan);
      }
      else if ( num.nextInt(4) == 2 )
      {
         g.setColor( Color.red);
      }
      else if ( num.nextInt(4) == 3)
      {
         g.setColor( Color.yellow);
      }
      else
      {
          g.setColor( Color.magenta);
      }
      
      g.drawOval( (getX() - this.radius), (getY() - this.radius), this.radius * 2, this.radius * 2); // drawing the balloons
   }
   
   /*
    * A method which helps balloons to grow.
    * */
   public void grow()
   {
      
      this.radius++; // increasing the radius
      
      if( this.radius >= FINAL_RADIUS) // setting all as Mr. Davenport wanted
      {
         this.radius = 0;
         this.setSelected( true );
      }
   }
   
}