package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * A class for adding a interactive text field.
 * @author Berk Saltuk Yýlmaz
 * @date 15.04.2020
 */
public class TextFieldControlPanel extends JPanel{
   
   // properties
   Hangman hangman;
   JTextField tf1;
   
   // properties
   public TextFieldControlPanel(Hangman hangman){
      
      this.hangman = hangman;    
      
      tf1 = new JTextField(10);
      tf1.addActionListener( new MyActionListener()); // adding my action listener
      add( tf1);
   }
   
   /**
    * An inner class for action listener.
    * @author Berk Saltuk Yýlmaz
    * @date 15.04.2020
    */
   public class MyActionListener implements ActionListener{
      
      // properties
      String letter;
      
      @Override
      public void actionPerformed( ActionEvent e)
      {
         if( e.getSource() == tf1 ) // if some info entered to the text field...
         {
            letter = tf1.getText(); // taking it as text field
            
            for ( int i = 0; i < letter.length(); i++) // and checking char by char...
            {
               hangman.tryThis(letter.charAt(i));
            }
            tf1.setText(""); // after i am done setting the text to empty string!
         }
      }
   }
}