import java.util.ArrayList;
/**
 * Author: Berk Saltuk Yýlmaz
 * Version: 03.03.2020
 * My URL Reader
 */

public class CurrencyReader extends XHTMLFilteredReader {
   
   //properties
   String url;
   String content;
   
   // constructors
   
   // inherits from the parent class
   public CurrencyReader( String n){
      super( n );
      this.url = n;
   }
   
   public String getPageContents() {
      
      return super.getPageContents();
   }
   
   /**
    * Takes the currency of euro and dollar
    * @return the currencies
    */
   public ArrayList<String> getCurrency(){
      
      super.getPageContents();
      
      ArrayList<String> current;
      
      String[] code;
      String[] code2;
      
      String unfilteredCurrent;
      String filtered;
      
      boolean checker;
      
      current = new ArrayList<String>();
      
      code = new String[]{"ABD","EURO"};
      code2 = new String[]{"<CrossRateUSD/>", "</CrossRateOther>"};
      
      int start;
      int end;
      
      content = super.getUnfilteredPageContents();
      

      
      for ( int index = 0; index < code.length; index++)
      {
         start = content.indexOf( code[index]);
         end = content.indexOf( code2[index], start);
         
         unfilteredCurrent = content.substring( start, end);
         
         filtered = "";
         checker = false;
         
         
         for( int i = 0; i < unfilteredCurrent.length() - 1; i++)
         {
            if( unfilteredCurrent.charAt(i) == '<')
            {
               checker = true;
            }    
            else if( unfilteredCurrent.charAt(i) == '>')
            {
               checker = false;
            } 
            else if( checker == false )
            {
               filtered = filtered + unfilteredCurrent.charAt(i);
            }
         }
         
         current.add( filtered);
      }
      
      
      return current;
   }
}

