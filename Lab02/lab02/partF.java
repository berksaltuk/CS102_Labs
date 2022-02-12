import java.util.ArrayList;
/**
 * Author: Berk Saltuk Yýlmaz
 * Version: 03.03.2020
 * My URL Reader
 */

public class CurrencyReader extends HTMLFilteredReader {
   
   //properties
   String url;
   String content;
   
   // constructors
   
   // inherits from the parent class
   public CurrencyReader( String n){
      super( n );
      this.url = n;
   }
}
   
   