import org.junit.*;
import static org.junit.Assert.*;
import java.util.LinkedList;

public class RailYardTester{
  
  //testing helper methods oneCycleSort and mergeForArray
  @Test
  public void testOneCycleSortAndMergeForArray(){
    
    int[] numYards = {0}; //testing none
    RailYard<Integer> yard = new RailYard<Integer>(numYards);
    Integer[] unsort = {3, 4, 1, 8, 6}; //middle of array out of order
    Integer[] sort = {null, null, null, null, null};
    yard.oneCycleSort(0, unsort);
    yard.mergeForArray(0, unsort);
    
    int[] numYards1 = {1}; //testing one track
    RailYard<Integer> yard1 = new RailYard<Integer>(numYards1);
    Integer[] unsort1 = {3, 4, 1, 6, 8};
    Integer[] sort1 = {3, 4, 1, 6, 8};
    yard1.oneCycleSort(0, unsort1);
    yard1.mergeForArray(0, unsort1);
    
    int[] numYards2 = {4}; //testing many tracks
    RailYard<Integer> yard2 = new RailYard<Integer>(numYards2);
    Integer[] unsort2 = {4, 3, 1, 8, 6}; //front and back of array out of order
    Integer[] sort2 = {1, 3, 4, 6, 8};
    yard2.oneCycleSort(0, unsort2);
    yard2.mergeForArray(0, unsort2);
    
    int[] numYards3 = {2,3}; //different types
    RailYard<String> yard3 = new RailYard<String>(numYards3);
    String[] unsort3 = {"b", "a", "d", "f", "c"};
    String[] sort3 = {"a", "b", "c", "d", "f"};
    yard3.oneCycleSort(0, unsort3);
    yard3.mergeForArray(0, unsort3);
    
    assertArrayEquals("cycle sort for array", sort, unsort);
    assertArrayEquals("merge and cycle sort for one yard", sort1, unsort1);
    assertArrayEquals("merge and cycle sort for one yard", sort2, unsort2);
    assertArrayEquals("merge and cycle sort for one yard", sort3, unsort3);
    
    
  }
  
  //testing helper methods oneClosestSort and mergeForArray
  @Test
  public void testOneClosestSortAndMergeForArray(){
    
    int[] numYards = {0}; //testing none
    RailYard<Integer> yard = new RailYard<Integer>(numYards);
    Integer[] unsort = {3, 4, 1, 6, 8};
    Integer[] sort = {null, null, null, null, null};
    yard.oneClosestSort(0, unsort);
    yard.mergeForArray(0, unsort);
    
    int[] numYards1 = {1}; //testing one track
    RailYard<Integer> yard1 = new RailYard<Integer>(numYards1);
    Integer[] unsort1 = {3, 4, 6, 8};
    Integer[] sort1 = {3, 4, 6, 8};
    yard1.oneClosestSort(0, unsort1);
    yard1.mergeForArray(0, unsort1);
    
    int[] numYards2 = {4}; //testing many tracks
    RailYard<Integer> yard2 = new RailYard<Integer>(numYards2);
    Integer[] unsort2 = {3, 4, 1, 6, 8}; //middle out of order
    Integer[] sort2 = {1, 3, 4, 6, 8};
    yard2.oneClosestSort(0, unsort2);
    yard2.mergeForArray(0, unsort2);
    
    int[] numYards3 = {2,3}; //different type
    RailYard<String> yard3 = new RailYard<String>(numYards3);
    String[] unsort3 = {"b", "a", "d", "f", "c"}; // first part of array out of order, last part out of order
    String[] sort3 = {"a", "b", "c", "d", "f"};
    yard3.oneClosestSort(0, unsort3);
    yard3.mergeForArray(0, unsort3);
    
    assertArrayEquals("cycle sort for array", sort, unsort);
    assertArrayEquals("merge and cycle sort for one yard", sort1, unsort1);
    assertArrayEquals("merge and cycle sort for one yard", sort2, unsort2);
    assertArrayEquals("merge and cycle sort for one yard", sort3, unsort3); 
    
  }
  
  
  //testing cycleSort method for arrays
  @Test
  public void testCycleSortForArray(){
    
    
    int[] numYards = {0}; //testing none
    RailYard<Integer> yard = new RailYard<Integer>(numYards);
    Integer[] unsort = {3, 4, 1, 6, 8};
    Integer[] sort = {null, null, null, null, null};
    yard.cycleSort(unsort);
    
    int[] numYards1 = {1}; //testing one yard
    RailYard<Integer> yard1 = new RailYard<Integer>(numYards1);
    Integer[] unsort1 = {3, 4, 6, 8};
    Integer[] sort1 = {3, 4, 6, 8};
    yard1.cycleSort(unsort1);
    
    int[] numYards2 = {2, 3, 2}; //testing many yards
    RailYard<Integer> yard2 = new RailYard<Integer>(numYards2);
    Integer[] unsort2 = {3, 4, 1, 6, 8}; //middle array out of order
    Integer[] sort2 = {1, 3, 4, 6, 8};
    yard2.cycleSort(unsort2);
    
    int[] numYards3 = {2,3}; //testing different type
    RailYard<String> yard3 = new RailYard<String>(numYards3);
    String[] unsort3 = {"b", "a", "d", "f", "c"}; //first part and last part of array out of order
    String[] sort3 = {"a", "b", "c", "d", "f"};
    yard3.cycleSort(unsort3);
    
    
    assertArrayEquals("cycle sort for array", sort, unsort);
    assertArrayEquals("cycle sort for array", sort1, unsort1);
    assertArrayEquals("cycle sort for array", sort2, unsort2);
    assertArrayEquals("cycle sort for array", sort3, unsort3);
    
  }
  
  //testing closestSort for arrays
  @Test
  public void testClosestSortForArray(){
    
    int[] numYards = {0}; //testing none
    RailYard<Integer> yard = new RailYard<Integer>(numYards);
    Integer[] unsort = {3, 4, 1, 6, 8};
    Integer[] sort = {null, null, null, null, null};
    yard.closestSort(unsort);
    
    int[] numYards1 = {1}; //testing one yard
    RailYard<Integer> yard1 = new RailYard<Integer>(numYards1);
    Integer[] unsort1 = {1, 6, 8};
    Integer[] sort1 = {1, 6, 8};
    yard1.closestSort(unsort1);
    
    int[] numYards2 = {2, 3, 2}; //testing many yards
    RailYard<Integer> yard2 = new RailYard<Integer>(numYards2);
    Integer[] unsort2 = {3, 4, 1, 6, 8}; //middle part of array out of order
    Integer[] sort2 = {1, 3, 4, 6, 8};
    yard2.closestSort(unsort2);
    
    int[] numYards3 = {2,3}; //testing different type
    RailYard<String> yard3 = new RailYard<String>(numYards3);
    String[] unsort3 = {"b", "a", "d", "f", "c"}; //first and last part of array out of order
    String[] sort3 = {"a", "b", "c", "d", "f"};
    yard3.closestSort(unsort3);
    
    
    assertArrayEquals("cycle sort for array", sort, unsort);
    assertArrayEquals("closest sort for array", sort1, unsort1);
    assertArrayEquals("closest sort for array", sort2, unsort2);
    assertArrayEquals("closest sort for array", sort3, unsort3);
    
  }
  
  
  //testing case where cycleSort is success but closestSort fails
  @Test
  public void testCycleFailClosestSuccess(){
    
    int[] numYards1 = {3, 3};
    RailYard<Integer> yard1 = new RailYard<Integer>(numYards1);
    Integer[] unsort1 = {45, 2, 78, 1, 6, 89};
    Integer[] sort1 = {1, 2, 6, 45, 78, 89};
    yard1.cycleSort(unsort1);
    
    assertNotSame("cycle sort does not fail", unsort1, sort1);
    
    int[] numYards2 = {3, 3};
    RailYard<Integer> yard2 = new RailYard<Integer>(numYards2);
    Integer[] unsort2 = {45, 2, 78, 1, 6, 89};
    Integer[] sort2 = {1, 2, 6, 45, 78, 89};
    yard2.closestSort(unsort2);
    
    assertArrayEquals("closest sort is not successful", unsort2, sort2);
    
  }
  
  //testing oneCycleSort and mergeForList method
  @Test
  public void testOneCycleSortAndMergeForList(){
    
    
    int[] numYards = {3}; //test many tracks
    RailYard<Integer> yard = new RailYard<Integer>(numYards);
    LinkedList<Integer> unsort = new LinkedList<Integer>();
    unsort.add(4); //front and middle scrambled
    unsort.add(1);
    unsort.add(2);
    LinkedList<Integer> sort = new LinkedList<Integer>();
    sort.add(1);
    sort.add(2);
    sort.add(4);
    yard.oneCycleSort(0, unsort);
    yard.mergeForList(0, unsort);
    
    
    int[] numYards1 = {4}; //test one classification yard
    RailYard<Integer> yard1 = new RailYard<Integer>(numYards1);
    LinkedList<Integer> unsort1 = new LinkedList<Integer>();
    unsort1.add(5); //front and back scrambled
    unsort1.add(4);
    unsort1.add(9);
    unsort1.add(1);
    LinkedList<Integer> sort1 = new LinkedList<Integer>();
    sort1.add(1);
    sort1.add(4);
    sort1.add(5);
    sort1.add(9);
    yard1.oneCycleSort(0, unsort1);
    yard1.mergeForList(0, unsort1);
    
    int[] numYards2 = {0}; //test zero
    RailYard<Integer> yard2 = new RailYard<Integer>(numYards2);
    LinkedList<Integer> unsort2 = new LinkedList<Integer>();
    unsort2.add(5); //front and back scrambled
    unsort2.add(4);
    unsort2.add(9);
    unsort2.add(1);
    LinkedList<Integer> sort2 = new LinkedList<Integer>();
    yard2.oneCycleSort(0, unsort2);
    yard2.mergeForList(0, unsort2);
    
    
    assertEquals(unsort, sort);
    assertEquals(unsort1, sort1);
    assertEquals(unsort2, sort2);
    
    
  }
  
  //testing cycleSort method for a list
  @Test
  public void testCycleSortForList(){
    
    int[] numYards = {3, 6, 8}; //test many yards
    RailYard<Integer> yard = new RailYard<Integer>(numYards);
    LinkedList<Integer> unsort = new LinkedList<Integer>();
    unsort.add(6); //front and middle scrambled
    unsort.add(1);
    unsort.add(2);
    LinkedList<Integer> sort = new LinkedList<Integer>();
    sort.add(1);
    sort.add(2);
    sort.add(6);
    yard.cycleSort(unsort);
    
    int[] numYards1 = {1}; //test one
    RailYard<Integer> yard1 = new RailYard<Integer>(numYards1);
    LinkedList<Integer> unsort1 = new LinkedList<Integer>();
    unsort1.add(5); //front and back scrambled
    unsort1.add(4);
    unsort1.add(9);
    unsort1.add(1);
    LinkedList<Integer> sort1 = new LinkedList<Integer>();
    sort1.add(5);
    sort1.add(4);
    sort1.add(9);
    sort1.add(1);
    yard1.cycleSort(unsort1);
    
    int[] numYards2 = {0}; //test zero tracks
    RailYard<Integer> yard2 = new RailYard<Integer>(numYards2);
    LinkedList<Integer> unsort2 = new LinkedList<Integer>();
    unsort2.add(5); //front and back scrambled
    unsort2.add(4);
    unsort2.add(9);
    unsort2.add(1);
    LinkedList<Integer> sort2 = new LinkedList<Integer>();
    yard2.cycleSort(unsort2);
    
    assertEquals(unsort1, sort1);
    assertEquals(unsort1, sort1);
    assertEquals(unsort2, sort2);
    
  }
  
  //testing oneClosestSort and mergeForList methods
  @Test
  public void testOneClosestSortAndMergeForList(){
    
    int[] numYards = {3}; //test many tracks
    RailYard<Integer> yard = new RailYard<Integer>(numYards);
    LinkedList<Integer> unsort = new LinkedList<Integer>();
    unsort.add(4); //front and middle scrambled
    unsort.add(1);
    unsort.add(2);
    LinkedList<Integer> sort = new LinkedList<Integer>();
    sort.add(1);
    sort.add(2);
    sort.add(4);
    yard.oneClosestSort(0, unsort);
    yard.mergeForList(0, unsort);
    
    
    int[] numYards1 = {1}; //test one
    RailYard<Integer> yard1 = new RailYard<Integer>(numYards1);
    LinkedList<Integer> unsort1 = new LinkedList<Integer>();
    unsort1.add(5); //front and back scrambled
    unsort1.add(4);
    unsort1.add(9);
    unsort1.add(1);
    LinkedList<Integer> sort1 = new LinkedList<Integer>();
    sort1.add(1);
    sort1.add(4);
    sort1.add(5);
    sort1.add(9);
    yard1.oneClosestSort(0, unsort1);
    yard1.mergeForList(0, unsort1);
    
    int[] numYards2 = {0}; //test zero tracks and yards
    RailYard<Integer> yard2 = new RailYard<Integer>(numYards2);
    LinkedList<Integer> unsort2 = new LinkedList<Integer>();
    unsort2.add(5); //front and back scrambled
    unsort2.add(4);
    unsort2.add(9);
    unsort2.add(1);
    LinkedList<Integer> sort2 = new LinkedList<Integer>();
    yard2.oneClosestSort(0, unsort2);
    yard2.mergeForList(0, unsort2);
    
    assertEquals(unsort, sort);
    assertEquals(unsort1, sort1);
    assertEquals(unsort2, sort2);
    
    
  }
  
  //testing closestSort for a list type
  @Test
  public void testClosestSortForList(){
    
    int[] numYards = {3, 5}; //test many classification yards
    RailYard<Integer> yard = new RailYard<Integer>(numYards);
    LinkedList<Integer> unsort = new LinkedList<Integer>();
    unsort.add(4); //front and middle scrambled
    unsort.add(1);
    unsort.add(2);
    LinkedList<Integer> sort = new LinkedList<Integer>();
    sort.add(1);
    sort.add(2);
    sort.add(4);
    yard.closestSort(unsort);
    
    int[] numYards1 = {1}; //test one classification yard
    RailYard<Integer> yard1 = new RailYard<Integer>(numYards1);
    LinkedList<Integer> unsort1 = new LinkedList<Integer>();
    unsort1.add(5); //front and back scrambled
    unsort1.add(4);
    unsort1.add(9);
    unsort1.add(1);
    LinkedList<Integer> sort1 = new LinkedList<Integer>();
    sort1.add(1);
    sort1.add(4);
    sort1.add(5);
    sort1.add(9);
    yard1.closestSort(unsort1);
    
    int[] numYards2 = {0}; //test zero tracks
    RailYard<Integer> yard2 = new RailYard<Integer>(numYards2);
    LinkedList<Integer> unsort2 = new LinkedList<Integer>();
    unsort2.add(5); //front and back scrambled
    unsort2.add(4);
    unsort2.add(9);
    unsort2.add(1);
    LinkedList<Integer> sort2 = new LinkedList<Integer>();
    yard2.closestSort(unsort2);
    
    assertEquals(unsort, sort);
    assertEquals(unsort1, sort1);
    assertEquals(unsort2, sort2);
    
  }
  
  
  
  
  
  
  
}