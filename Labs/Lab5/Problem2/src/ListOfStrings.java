public interface ListOfStrings {
  boolean isEmpty();
  int size();
  boolean contains(String str);
  boolean containsAll(ListOfStrings list);
  ListOfStrings filterLargerThan(int maxLength);
  boolean hasDuplicates();
  ListOfStrings removeDuplicates();

}
