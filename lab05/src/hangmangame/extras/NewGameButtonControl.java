package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * A class for adding new game button.
 * @author Berk Saltuk Yýlmaz
 * @date 15.04.2020
 */
public class NewGameButtonControl extends JButton implements IHangmanView{
   
   // properties
   Hangman hm;
   
   // constructor
   public NewGameButtonControl( Hangman hm)
   {
      this.hm = hm;
      setText( "New Game");
      
      setEnabled( false ); // setting it disabled as default
      addActionListener( new MyActionListener() ); // adding action listener
      
      updateView( hm ); // updating it to change its situation if the game is over
   }
   
   @Override
   public void updateView( Hangman hm )
   {
      Timer timer = new Timer( 25, new ActionListener(){ // adding a timer
         public void actionPerformed( ActionEvent e){
            
            if( hm.isGameOver() ) // if game over, enable the button
            {
               setEnabled( true);
            }
         }
      });
      
      timer.start(); // start to question
      
   }
   
   /**
    * An inner for my action listener.
    * @author Berk Saltuk Yýlmaz
    * @date 15.04.2020
    */
   public class MyActionListener implements ActionListener{
      
      @Override
      public void actionPerformed( ActionEvent e){
         
         setEnabled( false ); // after clicking make it disabled and initialize the new game
         hm.initNewGame();
      }
   }
}