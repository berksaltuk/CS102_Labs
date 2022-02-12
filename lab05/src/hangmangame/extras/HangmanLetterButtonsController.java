package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * A sub class for my buttons.
 * @author Berk Saltuk Yýlmaz
 * @date 15.04.2020
 */
public class HangmanLetterButtonsController implements ActionListener{

   // properties
   Hangman hm;
   
   // constructors
   public HangmanLetterButtonsController( Hangman hm )
   {
      this.hm = hm;
   }
   
   @Override
   public void actionPerformed( ActionEvent e)
   {
      if ( e.getSource() != null)            // if i clicked something and if it is a button...
      {
         JButton b = (JButton)e.getSource(); // make it equal to a button
         
         String onButton = b.getText();      // getting the text on buttons
         for( int i = 0; i < onButton.length(); i++) 
         {
            hm.tryThis( onButton.charAt( i ) ); // trying the chars on button
         }
         
         b.setEnabled( false ); // disable the button after clicking
         
      }
   }
}
   