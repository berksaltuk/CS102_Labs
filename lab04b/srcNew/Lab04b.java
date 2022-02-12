package srcNew;

import src.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/*
 * Main method for the frame of game.
 * Author: Berk Saltuk Yýlmaz
 * 08.04.2020
 * */
public class Lab04b{
   
   // main method
   public static void main( String[] args )
   {
      // variables
      JFrame balloon;
      BalloonsGamePanel gamePanel;
      
      // program code
      gamePanel = new BalloonsGamePanel();
      
      balloon = new JFrame( "Balloon Game");
      balloon.setPreferredSize( new Dimension( 800, 600));
      balloon.setBackground( Color.black);
      balloon.getContentPane().add(gamePanel);
      
      balloon.pack();
      balloon.setVisible( true);
   
   }
}