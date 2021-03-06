import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ListTestCase extends TestCase {
   
   private List list;
   /**
    * A test method.
    * (Replace "X" with a name describing the test.  You may write as
    * many "testSomething" methods in this class as you wish, and each
    * one will be called when running JUnit over this class.)
    */
   public void testList() 
   {
      String str;
      
      list = new List();
      
      list.addToHead("bsy");
      
      str = list.getData(0);
      assertEquals("bsy", str);
   }
   
}
