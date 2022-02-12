import java.util.ArrayList;
/**
 * Author: Berk Saltuk Yýlmaz
 * Version: 03.03.2020
 * My URL Reader
 */

public class HTMLFilteredReader extends MySimpleURLReader {
   
   // properties
   String url;
   
   
   // constructors
   public HTMLFilteredReader( String n){
      super( n );
      this.url = n;
   }
   
   // methods
   
   /**
    * Takes the page contents from the parent class
    * @return unfiltered content
    */
   public String getUnfilteredPageContents(){

      return super.getPageContents();
   }
   
   /**
    * Takes the page contents from the parent class and filters it
    * @return filtered content
    */
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
