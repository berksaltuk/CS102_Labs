public abstract class Shape implements Locatable{
   
   public abstract double getArea();
   
   int x;
   int y;
   
   public int getX(){
      return this.x; 
   }
   public int getY(){
      return this.y;
   }
   
   public void setLocation( int x, int y){
      
      this.x = x;
      this.y = y;
   }
}