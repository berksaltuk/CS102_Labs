package srcNew;

import src.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

/*
 * Class which actually creates the game.
 * Author: Berk Saltuk Y?lmaz
 * 08.04.2020
 * */
public class BalloonsGamePanel extends JPanel{
   
   // properties   
   public static final int NUM_BALL = 25;
   public static final int MAX_TIME = 100;
   
   int elapsedTime = 0;
   int points = 0;
   int x;
   int y;
   
   ShapeContainer balloons;
   Timer timer;
   Balloon balloon;
   JLabel score;
   MyMouseListener mouseListener;
   
   // constructor
   public BalloonsGamePanel()
   {
      
      balloons = new ShapeContainer(); // creating a new shape container.
      setBackground( Color.black); // adding some cosmetic features
      
      for ( int i = 0; i < NUM_BALL; i++ ) // adding 25 balloons
      {
         Random number1 = new Random(); // creating random numbers ( 0-600 and 0-800 )
         Random number2 = new Random();
         
         x = number1.nextInt( 800 );
         y = number2.nextInt( 600 );
         
         balloon = new Balloon( 25 ); // creating balloons
         balloon.setLocation( x, y); // setting random locations
         balloons.add( balloon);
      }
      
      TimeListener timeListener = new TimeListener(); // adding time listener and starting it
      timer = new Timer( 250, timeListener);
      timer.start();
      
      mouseListener = new MyMouseListener(); // adding mouse listener
      addMouseListener( mouseListener );
      
      score = new JLabel( "Points " + points + "\t Time Elapsed: " + elapsedTime ); // adding game features
      score.setForeground(Color.WHITE);
      add(score);
      setPreferredSize(new Dimension(800,600));
   }
   
   // methods
   
   /*
    * Overriding the paintComponent method to call my Balloon Class' draw method.
    * param graphics object
    * */
   public void paintComponent( Graphics g){
      
      super.paintComponent( g );
      
      Iterator balloonIterator = balloons.iterator();
      
      // using iterator to draw each object
      while( balloonIterator.hasNext() )
      {
         ( (Drawable) balloonIterator.next() ).draw( g );
      }
      
   }
   
   /*
    * A method for resetting the game.
    * */
   public void reset(){
      
      elapsedTime = 0; // resetting score board
      points = 0;
      
      Iterator iterate = balloons.iterator();
      
      while( iterate.hasNext()) // calling the remove method of my iterator
      {
         iterate.remove();
      }
      balloons.removeAll();
      
      for ( int i = 0; i < NUM_BALL; i++ ) // adding new balloons
      {
         Random number1 = new Random();
         Random number2 = new Random();
         
         x = number1.nextInt( 800 );
         y = number2.nextInt( 600 );
         balloon = new Balloon( 25 );
         balloon.setLocation( x, y);
         balloons.add( balloon);
      }
      
      timer.start(); // starting timer again
      addMouseListener(mouseListener);
   }
   // inner classes
   
   /*
    * A inner class implements the action listener for my timer.
    * Author: Berk Saltuk Y?lmaz
    * 08.04.2020
    * */
   public class TimeListener implements ActionListener{
      
      @Override
      public void actionPerformed( ActionEvent e)
      {
         Iterator iterate = balloons.iterator(); // iterating the ShapeContainer to make balloons grow
         
         while( iterate.hasNext()) 
         {
            ( (Balloon)iterate.next() ).grow();
         }
         
         if ( balloons.size() <= 15) // adding balloons if there is less than 15 balloons.
         {
            for ( int i = 0; i < NUM_BALL - balloons.size(); i++ )
            {
               Random number1 = new Random();
               Random number2 = new Random();
               x = number1.nextInt( 800 );
               y = number2.nextInt( 600 );
               balloon = new Balloon( 25 );
               balloon.setLocation( x, y );
               balloons.add( balloon );
            }
         } 
         repaint();
         
         elapsedTime++; // increasing the time and updating the label
         score.setText( "Points " + points + "\t Time Elapsed: " + elapsedTime );
         
         if( elapsedTime >= MAX_TIME ) // end of the game, time is up.
         {
            timer.stop();
            removeMouseListener( mouseListener );
            
            int selection = JOptionPane.showConfirmDialog(BalloonsGamePanel.this, "One more game?" , "Game over...", 0); // play again option pane
            if( selection == JOptionPane.YES_OPTION ){ // if user chooses the yes option
               
               reset(); // calling the reset method
               score.setText( "Points " + points + "\t Time Elapsed: " + elapsedTime );
               
            }
            else if( selection == JOptionPane.NO_OPTION ){ // if user chooses the no option
               System.exit(0);
            }
            
         }
         
         
      }
   }
   
   /*
    * A inner class extends the mouse adapter.
    * Author: Berk Saltuk Y?lmaz
    * 08.04.2020
    * */
   public class MyMouseListener extends MouseAdapter{
      
      @Override
      public void mousePressed( MouseEvent e)
      {
         
         Iterator it = balloons.iterator(); // iterating the ShapeContainer to find intersection zone of balloons.
         int count = 0;
         
         while( it.hasNext() )
         {
            if( ((Balloon)it.next()).contains( e.getX(), e.getY()) != null)
            {
               count++;
            }
         }
         if ( count >= 2) // adding points if there is a intersection
         {
            count = balloons.selectAllAt( e.getX(), e.getY());
            points += count;
            balloons.selectAllAt( e.getX(), e.getY());
            balloons.removeAll();
         }
         
         balloons.selectAllAt( e.getX(), e.getY()); // and removing them :)
         balloons.removeAll();
         repaint();
         
      }
      
   }
}