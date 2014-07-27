package data.structures.tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import data.scructure.LinkedSymbolTable.LinkedSymbolTable;

public class LinkedSymbolTableTest {

  private LinkedSymbolTable<String, Integer> symbolTable;
  private static final String TEST_STRING_NAME_HOMER = "HOMER";
  private static final String TEST_STRING_NAME_ALEX = "ALEX";
  private static final String TEST_STRING_NAME_DENIS = "DENIS";
  private static final Integer HOMER_AGE = 33;
  private static final Integer ALEX_AGE = 22;
  private static final Integer DENIS_AGE = 28;

  @Before
  public void setUp() {
    symbolTable = new LinkedSymbolTable<String, Integer>();
    symbolTable.put(TEST_STRING_NAME_HOMER, HOMER_AGE);
    symbolTable.put(TEST_STRING_NAME_ALEX, ALEX_AGE);
    symbolTable.put(TEST_STRING_NAME_DENIS, DENIS_AGE);
  }

  @Test
  public void getValueFromSymbolTableTest() {
    assertEquals(HOMER_AGE, symbolTable.get(TEST_STRING_NAME_HOMER));
  }

  @Test
  public void containsMethodTest() {
    assertEquals(true, symbolTable.contains(TEST_STRING_NAME_HOMER));
  }

  @Test
  public void deleteContainsElementTest() {
    symbolTable.delete(TEST_STRING_NAME_DENIS);
    assertEquals(2, symbolTable.size());
    assertEquals(false, symbolTable.contains(TEST_STRING_NAME_DENIS));
  }

  @Test(expected = NoSuchElementException.class)
  public void deleteNotContainsElement() {
    symbolTable.delete("String");
  }

  @Test
  public void sizeAndIsEmptyTest() {
    symbolTable = new LinkedSymbolTable<String, Integer>();
    assertEquals(true, symbolTable.isEmpty());
    assertEquals(0, symbolTable.size());
    symbolTable.put(TEST_STRING_NAME_HOMER, HOMER_AGE);
    assertEquals(false, symbolTable.isEmpty());
    assertEquals(1, symbolTable.size());
  }

  @Test
  public void symbolTableIterationTest() {
    for (String name : symbolTable.keys()) {
      assertNotNull(symbolTable.get(name));
    }
  }

}
