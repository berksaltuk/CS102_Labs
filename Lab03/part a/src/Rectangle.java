public class Rectangle extends Shape implements Selectable {
   
   int width;
   int height;
   int x;
   int y;
   
   boolean select;
   
   public Rectangle( int width, int height){
      this.width = width;
      this.height = height;
   }
   
   public boolean getSelected(){
      
      return select;
   }
   
   public void setSelected( boolean select){
      
      this.select = select;
   }
   
   public Shape contains( int x, int y){
      
      if (((((width / 2) + getX()) >= x ) && (( getX() - (width / 2)) <= x )) && ((((height / 2) + getY()) >= y ) || (( getY() - ( height / 2)) <= y )))
      {
         return this;
      }
      else
      {
         return null;
      }
   }
   
   public double getArea(){
      
      return width * height;
   }
   
   public String toString(){
      
      if ( select )
      {
         return "Rectangle is selected.";
      }
      else
      {
         return "Rectangle is not selected.";
      }
   }
   
}