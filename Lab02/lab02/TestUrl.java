import cs1.SimpleURLReader;

/**
 * Author: Berk Saltuk Yýlmaz
 * Version: 03.03.2020
 * Testing some URL
 */

public class TestUrl {
   
   public static void main( String[] args ){
      
      // variables
      SimpleURLReader reader;
      MySimpleURLReader myReader;
      HTMLFilteredReader htmlReader;
      HTMLFilteredReader htmlReader2;
      XHTMLFilteredReader xHtmlReader;
      XHTMLFilteredReader jSoup;
      
      CurrencyReader currency;
      // program code
      
      // part a
      reader = new SimpleURLReader(  "http://www.cs.bilkent.edu.tr/~david/housman.txt" );
      
      System.out.println( "********************************************************************" );
      System.out.println( "The content of the page: " + reader.getPageContents() );
      System.out.println( "The line count: " + reader.getLineCount() );
      System.out.println( "********************************************************************" );
      
      // part b
      myReader = new MySimpleURLReader(  "http://www.cs.bilkent.edu.tr/~david/housman.txt" );
      
      System.out.println( "The file name: " + myReader.getName() );
      System.out.println( "********************************************************************" );
      System.out.println( "The fixed content: \n" + myReader.getPageContents() );
      System.out.println( "********************************************************************" );
      
      // part c
      htmlReader = new HTMLFilteredReader(  "http://www.cs.bilkent.edu.tr/~david/housman.htm" );
      
      System.out.println( "The file name: " + htmlReader.getName() );
      System.out.println( "********************************************************************" );
      System.out.println( "The unfiltered content: \n" + htmlReader.getUnfilteredPageContents() );
      System.out.println( "********************************************************************" );
      System.out.println( "The filtered content: \n" + htmlReader.getPageContents() );
      System.out.println( "********************************************************************" );
      
      // part d
      xHtmlReader = new XHTMLFilteredReader(  "http://www.cs.bilkent.edu.tr/~david/index.html" );
      
      System.out.println( "The file name: " + xHtmlReader.getName() );
      System.out.println( "The content of the page: " + xHtmlReader.getPageContents() );
      System.out.println( "The size of filtered html file: " + xHtmlReader.getPageContents().length() );
      System.out.println( "The size of unfiltered html file: " + xHtmlReader.getUnfilteredPageContents().length() );
      System.out.println( "The header: " + xHtmlReader.getOverHead());
      System.out.println( "********************************************************************" );
      System.out.println( "The links that it contains: \n" + xHtmlReader.getLinks() );
      System.out.println( "********************************************************************" );
      
      htmlReader2 = new HTMLFilteredReader(  "http://www.cs.bilkent.edu.tr/~david/david.html" );
      
      System.out.println( "The file name: " + htmlReader2.getName() );
      System.out.println( "********************************************************************" );
      System.out.println( "The unfiltered content: \n" + htmlReader2.getUnfilteredPageContents() );
      System.out.println( "********************************************************************" );
      System.out.println( "The filtered content: \n" + htmlReader2.getPageContents() );

      
      currency = new CurrencyReader( "https://www.tcmb.gov.tr/kurlar/today.xml");
      System.out.println( "********************************************************************" );
      System.out.println( "The unfiltered content: \n" + currency.getUnfilteredPageContents() );
      System.out.println( "********************************************************************" );
      System.out.println( "The filtered content: \n" + currency.getPageContents() );
      System.out.println( "********************************************************************" );
      System.out.println( "The currency: \n" + currency.getCurrency() );
      System.out.println( "********************************************************************" );
      
      jSoup = new XHTMLFilteredReader("https://jsoup.org/");
      System.out.println( "The links that it contains: \n" + jSoup.getLinks() );
   }
}