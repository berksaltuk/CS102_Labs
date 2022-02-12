public class Circle extends Shape implements Selectable {
   
   int radius;
   int x;
   int y;
   
   boolean select;
   
   public Circle( int radius)
   {
      this.radius = radius;
   }
   
   
   public double getArea() {
      
      return Math.pow( radius, 2) * Math.PI;
   }
   
   public boolean getSelected(){
      
      return select;
   }
   
   public void setSelected( boolean select){
      
      this.select = select;
   }
   
   public Shape contains( int x, int y){
      
       if ( Math.pow( x - getX(), 2) + Math.pow( y - getY(), 2) <= Math.pow( radius, 2))
      {
         return this;
      }
      else
      {
         return null;
      }
   }
   
   public String toString(){
      
      if ( select )
      {
         return "Circle is selected.";
      }
      else
      {
         return "Circle is not selected.";
      }
   }
}