public class Square extends Rectangle {
  
   int side;
   
   public Square (int side)
   {
      super( side, side);
      this.side = side;
   }
   
   public double getArea(){
      
      super.getArea();  
      return side * side;
      
   }
}