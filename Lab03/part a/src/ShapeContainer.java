import java.util.ArrayList;

public class ShapeContainer {
   
   ArrayList<Shape> container;
   
   public ShapeContainer(){
      
      container = new ArrayList<Shape>();
      
   }
   
   public void add( Shape s){
      
      container.add(s);
   }
   
   public double getArea(){
      
      double areaSum = 0;
      
      for ( int i = 0; i < container.size(); i++)
      {
         areaSum += container.get(i).getArea();
      }
      
      return areaSum;
   }
   
   public Shape contains( int x, int y)
   {
      boolean contains = true;
      
      Selectable selected;
      
      Shape returnShape = null;
      
      for ( int i = 0; i < container.size() && contains; i++)
      {
         selected = (Selectable)container.get(i);
         
         if( selected.contains( x, y) != null )
         {
            contains = false;
            selected.setSelected( true);
            
            returnShape = container.get(i);
         }
      }
      
      return returnShape;
      
   }
   
   public void removeAll(){
      Selectable selected;
      
      for ( int i = 0; i < container.size(); i++)
      {
         selected = (Selectable)container.get(i);
         if ( selected.getSelected() == true)
         {
            container.remove(i);
         }
      }
   }
   public String toString(){
      
      String display = "";
      int count1 = 0;
      int count2 = 0;
      
      
      for ( int i = 0; i < container.size(); i++)
      {
         display = "" + container.get(i);
         
         if ( display.charAt(0) == 'C')
         {
            count1++;
         }
         else if ( display.charAt(0) == 'R')
         {
            count2++;
         }
         
      }
      display = "The size of this container is " + container.size() + "\nThis container contains " + count1 + " circles and " + count2 + " rectangles.\n";
      
      for ( int i = 0; i < container.size(); i++)
      {
         display = display+ "\n" + container.get(i);
      }
      
      return display;
   } 
}