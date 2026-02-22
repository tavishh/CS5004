import static org.junit.jupiter.api.Assertions.*;

class LinkedListOfStringsTest {
  LinkedListOfStrings list;
  LinkedListOfStrings emptyList;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    list = new LinkedListOfStrings();
    list.add("Alice");
    list.add("Bob");
    list.add("Charlie");

  }

  @org.junit.jupiter.api.Test
  void testIsEmpty() {
    emptyList = new LinkedListOfStrings();
    assertTrue(emptyList.isEmpty());
  }

  @org.junit.jupiter.api.Test
  void testSize() {
    assertEquals(3, list.size());
  }

  @org.junit.jupiter.api.Test
  void testContains() {
    assertTrue(list.contains("Bob"));
  }

  @org.junit.jupiter.api.Test
  void testContainsNotFound() {
    assertFalse(list.contains("Jack"));
  }

  @org.junit.jupiter.api.Test
  void testContainsAll() {
    LinkedListOfStrings other = new LinkedListOfStrings();
    other.add("Alice");
    other.add("Bob");
    assertTrue(list.containsAll(other));
  }

  @org.junit.jupiter.api.Test
  void TestFilterLargerThan() {
    assertEquals(2, list.filterLargerThan(5).size());
  }

  @org.junit.jupiter.api.Test
  void testHasDuplicates() {
    list.add("Bob");
    assertTrue(list.hasDuplicates());
  }

  @org.junit.jupiter.api.Test
  void testRemoveDuplicates() {
    list.add("Bob");
    assertEquals(3, list.removeDuplicates().size());
  }

  @org.junit.jupiter.api.Test
  void testInvalidFilterLargerThan(){
    assertThrows(IllegalArgumentException.class, () -> {list.filterLargerThan(-1);});
  }



}