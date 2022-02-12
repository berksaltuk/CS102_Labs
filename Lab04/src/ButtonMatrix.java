import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * A Class for button matrix 5x5
 * Author: Berk Saltuk Yýlmaz
 * Date: 01.04.2020
 * version 1.0
 */
public class ButtonMatrix extends JPanel{
   
   // properties
   ArrayList<JButton> buttons;  // for easy adding of buttons and action listeners
   
   JPanel  buttonPanel;         // a panel for buttons
   JButton button;              // here goes the buttons!  
   
   int randomNumber;            // random number
   int count;                   // number of tries
   Random random = new Random();// generating a Random object
   
   JButton buttonYes;           // provides playing again
   JButton buttonNo;            
   JLabel  again;               // play again?
   JLabel  myJLabel;            // shows the tries
   
   final int ROW = 5;
   final int COLUMN = 5;
   
   // constructor
   public ButtonMatrix(){
      
      count = 0; // tries
      
      myJLabel = new JLabel( "Tries: " + count ); // to see tries
      this.add( myJLabel, BorderLayout.NORTH); // layouts...
      
      buttons = new ArrayList< JButton >(); // initializing...
       
      randomNumber = random.nextInt( ROW * COLUMN ); // generating a random number!
      
      // a for loop for adding buttons to my arrayList
      for ( int i = 0; i < ROW * COLUMN; i++)
      {
         button = new JButton( "Button " + ( i + 1 ) ); // labeling buttons
         buttons.add( button );
      }
      
      // a for loop for adding actionListeners to my buttons
      for ( int j = 0; j < ROW * COLUMN; j++)
      {
         buttons.get(j).setBackground( Color.white); // setting the buttons' background colors
         buttons.get(j).addActionListener( new MyListener( j ) ); // adding specified action listener
      }
      
      buttonPanel = new JPanel( new GridLayout( ROW, COLUMN ) ); // to make them look like a matrix
       
      // getting buttons from arraylist and adding them to my panel
      for( int k = 0; k < ROW * COLUMN; k++ ){
         buttonPanel.add( buttons.get( k ) , BorderLayout.CENTER ); // adding buttons to panel
      }
      
      // adding button panel to matrix panel
      this.add( buttonPanel, BorderLayout.SOUTH ); // adding buttons to general panel
      
      // setting accessories
      setBackground( Color.cyan ); 
   }
   
   /**
    * Resets the game or closes it.
    */
   public void resetGame()
   {
      // naming the buttons
      buttonYes = new JButton( "YES" );
      buttonNo = new JButton( "NO" );
      again = new JLabel( "Play Again?" );
      
      // adding some buttons!
      add( again );
      add( buttonYes );
      add( buttonNo );
      
      // yes is here to start it again
      buttonYes.addActionListener( new ActionListener(){
         
         //anonymous class to set the game again
         public void actionPerformed( ActionEvent e )
         {
            // removing buttons after clicking on them
            remove( buttonYes );
            remove( buttonNo );
            remove( again );
            
            // making buttons available, setting color and naming them again.
            for ( int i = 0; i < ROW * COLUMN; i++)
            {
               buttons.get( i ).setText( "Button " + ( i + 1 ) );
               buttons.get( i ).setBackground( Color.white );
               buttons.get( i ).setEnabled( true );
               
            }
            
            // generating new random number and forgetting the past...
            count = 0;
            randomNumber = random.nextInt( ROW * COLUMN );
            
            myJLabel.setText( "Tries: " + count);
         } 
      });
      
      // adding some action listener to no button.
      buttonNo.addActionListener( new ActionListener(){
         
         // basically, it closes.
         public void actionPerformed( ActionEvent e)
         {
            System.exit(0);
         } 
      });
   }
   
   // an inner class that implements ActionListener, aim is making things easier for ourselves
   public class MyListener implements ActionListener{
      
      // properties
      int clicked;
      
      // constructor
      public MyListener( int clicked)
      {
         this.clicked = clicked;
      }
      
      /**
       * Overriding the method of interface
       */
      public void actionPerformed( ActionEvent e){
         
         buttons.get( clicked ).setEnabled( false ); // getting sure that buttons will not be pressed again.
         count++; // try once more!   
         
         // when user finds the button with prize
         if ( clicked == randomNumber)
         {
            myJLabel.setText( "You found the prize in " + count + " times!"); // it speaks for itself...
            buttons.get( clicked ).setText( "FOUND IT!");        // changes the message on button
            buttons.get( clicked ).setBackground( Color.yellow); // marks the true one!
            
            // making all false. So no one can click any other button when game finished
            for ( int i = 0; i < ROW * COLUMN; i++)
            {
               buttons.get( i ).setEnabled( false );
            }
            
            // resetting it
            resetGame();
         }
         else
         {
            buttons.get( clicked ).setText( "Oops!"); // false guess.
            myJLabel.setText( "Tries: " + count);     // updating the number of tries.
         }
      }
   } 
}