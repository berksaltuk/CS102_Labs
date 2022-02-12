package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * A sub class for editing my buttons
 * @author Berk Saltuk Yýlmaz
 * @date 15.04.2020
 */
public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView{
   
   // properties
   public HangmanLetterButtonControls(String letters, Hangman hm)
   {
      super(letters, hm);
      setPreferredSize( new Dimension( 135, 100));
      updateView( hm );
   }
   
   // methods
   @Override
   public void updateView( Hangman hm )
   {
      Timer timer = new Timer( 25, new ActionListener(){ // adding a timer
         public void actionPerformed( ActionEvent e){
            
            String lettersUsed = hm.getUsedLetters(); // setting the clicked buttons disabled
            setDisabled( lettersUsed); 
            
            if( hm.getUsedLetters().equals("") ) // if game starts again activates the button
            {
               setEnabledAll( true );
            }
            if( hm.isGameOver() ) // if game is over user cannot click on buttons
            {
               setEnabledAll( false );
            }
         }
      });
      
      timer.start(); // start to question
      
   }
}


