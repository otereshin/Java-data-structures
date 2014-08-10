package data.structures.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import data.structures.BTSSymbolTable.BTSSymbolTable;

public class BTSSymbolTableTest {

  private BTSSymbolTable<Integer, String> symbolTable;
  private static final String TEST_STRING_NAME_HOMER = "HOMER";
  private static final String TEST_STRING_NAME_ALEX = "ALEX";
  private static final String TEST_STRING_NAME_DENIS = "DENIS";
  private static final Integer HOMER_AGE = 33;
  private static final Integer ALEX_AGE = 22;
  private static final Integer DENIS_AGE = 28;

  @Before
  public void setUp() {
    symbolTable = new BTSSymbolTable<Integer, String>();
    symbolTable.put(HOMER_AGE, TEST_STRING_NAME_HOMER);
    symbolTable.put(ALEX_AGE, TEST_STRING_NAME_ALEX);
    symbolTable.put(DENIS_AGE,  TEST_STRING_NAME_DENIS);
  }
  
  @Test
  public void deleteMinTest(){
    assertEquals(ALEX_AGE, symbolTable.minKey());
    symbolTable.deleteMin();
    assertEquals(false,symbolTable.contains(ALEX_AGE));
    assertEquals(2, symbolTable.size());
  }
  @Test
  public void getValueFromSymbolTableTest() {
    assertEquals(TEST_STRING_NAME_HOMER, symbolTable.get(HOMER_AGE));
  }

  @Test
  public void containsMethodTest() {
    assertEquals(true, symbolTable.contains(HOMER_AGE));
    assertEquals(false, symbolTable.contains(444));
  }

  @Test
  public void sizeAndIsEmptyTest() {
    assertEquals(3, symbolTable.size());
    symbolTable = new BTSSymbolTable<Integer, String>();
    assertEquals(true, symbolTable.isEmpty());
    assertEquals(0, symbolTable.size());
    symbolTable.put (HOMER_AGE, TEST_STRING_NAME_HOMER);
    assertEquals(false, symbolTable.isEmpty());
    assertEquals(1, symbolTable.size());
  }

  @Test
  public void symbolTableIterationTest() {
    Integer previousAge = 0;
    for (Integer age : symbolTable.keys()) {
      if(previousAge != 0){
        assertNotNull(symbolTable.get(age));
        assertTrue(age >  previousAge);
      }
      assertNotNull(symbolTable.get(age));
      previousAge = age;
    }
  }

}
