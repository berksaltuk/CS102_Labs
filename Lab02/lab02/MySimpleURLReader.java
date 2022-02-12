import cs1.SimpleURLReader;

/**
 * Author: Berk Saltuk Yýlmaz
 * Version: 03.03.2020
 * My URL Reader
 */

public class MySimpleURLReader extends SimpleURLReader {
   
   // properties
   String url;
   
   // constructors
   
   //takes the properties from the parent class
   public MySimpleURLReader( String n ){
      super( n );
      
      this.url = n;
   }
   
   //methods
   
   /**
    * Takes the file name part of URL
    * @return file name
    */
   public String getName(){
      
      // variables
      int lastSlash;
      int index;
      boolean lastSlashFound;
      
      // program code
      index = url.length() - 1;
      lastSlashFound = false;
      lastSlash = 0;
      
      while( !lastSlashFound && index >= 0  )
      {
         if ( url.charAt(index) == '/')
         {
            lastSlash = index;
            lastSlashFound = true;
         }
         
         index = index - 1;
      }
      return url.substring( lastSlash + 1, url.length() );
   }
   
   /**
    * Takes the page contents without null part
    * @return page content
    */
   public String getPageContents(){
      
      return super.getPageContents().substring( 4, super.getPageContents().length() );
      
   }
}