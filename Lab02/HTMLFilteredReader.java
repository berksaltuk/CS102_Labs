import java.util.ArrayList;
/**
 * Author: Berk Saltuk Y?lmaz
 * Version: 03.03.2020
 * My URL Reader
 */

public class HTMLFilteredReader extends MySimpleURLReader {
   
   String url;
   
   public HTMLFilteredReader( String n){
      super( n );
   }
   
   public String getUnfilteredPageContents(){
      super.getPageContents();
      
      return super.getPageContents();
   }
   
   public String getPageContents(){
      
      String filtered = "";
      boolean checker = false;
      
      
      for( int i = 0; i < super.getPageContents().length() - 1; i++)
      {
         if( super.getPageContents().charAt(i) == '<')
         {
            checker = true;
         }    
         else if( super.getPageContents().charAt(i) == '>')
         {
            checker = false;
         } 
         else if( checker == false )
         {
            filtered = filtered + super.getPageContents().charAt(i);
         }
      }
      
      return filtered;
   }
   
  
}
