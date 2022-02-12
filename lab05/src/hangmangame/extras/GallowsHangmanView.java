package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.ArrayList;

/**
 * A class for creating the pieces of man to hang.
 * @author Berk Saltuk Yýlmaz
 * @date 15.04.2020
 */
public class GallowsHangmanView extends JPanel implements IHangmanView{
   
   
   // properties
   Hangman hm;
   JLabel label;
   
   // constructor
   public GallowsHangmanView( Hangman hm)
   {
      this.hm = hm;
      label = new JLabel( "Let's have some fun!" );
      add( label);     // adding label
      updateView( hm );// updating the limbs of hangman
   }
   
   @Override
   public void paintComponent( Graphics g)
   {
      super.paintComponent( g);
      setBackground( Color.CYAN);
      
      g.fillRect(50,25,125, 25); // building the gallow
      g.fillRect(50,25,25,250);
      g.fillRect(175, 25, 12, 50);
      g.fillRect(25, 250, 200, 37);
  
      if(  hm.getNumOfIncorrectTries() >= 1) // for head
      {
         g.drawOval( 157, 75, 50, 50);
         label.setText( "You have " + (6 - hm.getNumOfIncorrectTries() ) + " tries left!" );
      }
      if(  hm.getNumOfIncorrectTries() >= 2) // for body
      {
         g.drawLine( 182, 125, 182, 175);
         label.setText( "You have " + (6 - hm.getNumOfIncorrectTries() ) + " tries left!" );
      }
      if(  hm.getNumOfIncorrectTries() >= 3) // for hand 1
      {
         g.drawLine( 157, 145, 182, 135);
         label.setText( "You have " + (6 - hm.getNumOfIncorrectTries() ) + " tries left!" );
      }
      if(  hm.getNumOfIncorrectTries() >= 4) // for hand 2
      {
         g.drawLine( 182, 135, 207, 145);
         label.setText( "You have " + (6 - hm.getNumOfIncorrectTries() ) + " tries left!" );
      }
      if(  hm.getNumOfIncorrectTries() >= 5) // for leg 1 
      {
         g.drawLine( 157, 205, 182, 175);
         label.setText( "Your last chance!" );
      }
      if(  hm.getNumOfIncorrectTries() >= 6) // for leg 2
      {
         g.drawLine( 182, 175, 207, 205);
         label.setText( "You have lost the game!" ); // Oops!
      }
      
      if( hm.isGameOver() && !hm.hasLost() ) // setting label for the win case
      {
      label.setText( "Well, well, well... WE HAVE A WINNER!" );
      }
   }
   
   @Override
   public void updateView( Hangman hm )
   {
       Timer timer = new Timer( 25, new ActionListener(){ // adding a timer to query the hangman's situation accordingly
         public void actionPerformed( ActionEvent e){
           
            repaint(); // repaint it!
            
            if ( hm.getUsedLetters().equals("") ) // if user clicks to the new game setting the label default.
            {
               label.setText("Let's have some fun!");
            }
         }
      });
      
      timer.start(); // start to question
      
   }
}

