package src;
/*
 * This class for our Selectable Interface.
 * Author: Berk Saltuk Y�lmaz
 * 11.03.2020
 * */
public interface Selectable{

   boolean getSelected();
   void setSelected( boolean selected);
   Shape contains( int x, int y);
      
}