import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Creating the game
 * Author: Berk Saltuk Yýlmaz
 * Date: 01.04.2020
 * version 1.0
 */
public class ButtonGame{

   // main class!
   public static void main( String[] args )
   {
      ButtonMatrix buttonGame = new ButtonMatrix();     // game is here!
      JFrame frame = new JFrame ("Button Matrix Game"); // adding a frame
      
      frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
      frame.setLayout( new BorderLayout()); 
      
      frame.getContentPane().add( buttonGame );

      frame.pack();
      frame.setVisible(true);
   }
}

