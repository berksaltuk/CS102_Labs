package hangmangame.extras;

import cs102.hangman.HangmanModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Collection of UI components to form a complete Hangman game. 
 * View components implement IHangmanView, so they can automatically update
 * whenever the hangmanModel associated with changes, changes.
 * Other components are hangman controllers that update the model.
 * @author david
 */
public class HangmanGUIPanel extends JPanel {

   // properties
   HangmanModel hm;           // adding all the panels
   TextFieldControlPanel tfcp;
   NewGameButtonControl ngbc;
   LabelsHangmanView lhv;
   GallowsHangmanView ghv;
   HangmanLetterButtonControls lbc;
   
   // constructor
   public HangmanGUIPanel( HangmanModel hm) {
      // add controls and views here...
      this.hm = hm;
      
      lhv = new LabelsHangmanView( hm );        // initializing all properties
      tfcp = new TextFieldControlPanel( hm );
      ngbc = new NewGameButtonControl( hm );
      ghv = new GallowsHangmanView( hm );
      lbc = new HangmanLetterButtonControls( hm.getAllLetters(), hm);
      setPreferredSize( new Dimension( 600, 400) );
      
      setLayout( new BorderLayout() );
      setBackground(Color.CYAN);
      
      add( tfcp, BorderLayout.NORTH);
      add ( ngbc, BorderLayout.SOUTH);
      add ( lhv, BorderLayout.WEST);
      add ( ghv, BorderLayout.CENTER);

      add ( lbc, BorderLayout.EAST);
      
   }
   
}
