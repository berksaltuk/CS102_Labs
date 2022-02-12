package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * A class for adding the informative labels.
 * @author Berk Saltuk Yýlmaz
 * @date 15.04.2020
 */
public class LabelsHangmanView extends JPanel implements IHangmanView{
   
   // properties
   JLabel incorrect;
   JLabel soFar;
   JLabel used;
   JLabel lost;
   Hangman hm;
   
   // constructors
   public LabelsHangmanView( Hangman hm){
      
      this.hm = hm;
      
      incorrect = new JLabel(); // initializing the labels
      soFar = new JLabel();
      used = new JLabel();
      lost = new JLabel();
      
      updateView(hm); // getting info and setting the text of labels
      
      add( incorrect); // adding them to the panel
      add( soFar);
      add( used);
      add( lost);
      
      setBackground( Color.ORANGE);
      
      setLayout( new GridLayout( 4, 1));
   }
   
   @Override
   public void updateView( Hangman hm)
   {
      Timer timer = new Timer( 25, new ActionListener(){ // adding a timer to query the hangman accordingly
         public void actionPerformed( ActionEvent e){
            
            incorrect.setText( "Incorrect tries: " + hm.getNumOfIncorrectTries() ); // keeping the info updated
            soFar.setText( "Revealed letters so far: " + hm.getKnownSoFar() );
            used.setText( "Used letters: " + hm.getUsedLetters() );
            lost.setText( "Has game lost?: " + hm.hasLost() );
         }
      });
      
      timer.start(); // start to question...
   }
}