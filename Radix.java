public class Radix {

  //get nth digit of an int, where 0 is the ones column, 1 is the tens column etc
  //if number is negative, returns the positive version of the nth digit
  public static int nth(int n, int col) {
    if (n >= 0) return (int)( ( n % Math.pow(10, col+1) ) / Math.pow(10, col) );
    else return (int)( ( n % Math.pow(10, col+1) ) / Math.pow(10, col) ) * -1;
  }

  //returns the number of digits in n
  public static int length(int n) {
    if (n == 0) return 1;
    if (n < 0) n = Math.abs(n);
    return (int)(Math.log10(n)) + 1;
  }

  //big woah: you aren't actually sorting the buckets, etc. in this method!
  //you are just doing the merging!
  //merge all of the linked lists in the bucket array into your original linked list
  //original MyLinkedList may have elements, and those should be kept
  //this should be O(buckets.length) {which will be o(10) cuz 0-9 = 10 digits = 10 buckets}
  //bucket[0] list will be merged with original first, then bucket[1], etc
  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    //extending LinkedList is constant time; if you do this 10 times, it's still O(1)
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

  //returns length of the longest number in data
  private static int longest(SortableLinkedList data) {
    if (data.size() == 0) return 0;
    int longestLength = length(data.get(0));
    for (int i = 0; i < data.size(); i++) {
      if (length(data.get(i)) > longestLength) longestLength = length(data.get(i));
    }
    return longestLength;
  }

  //clears SortableLinkedList; ****see if can do O(1)
  private static SortableLinkedList clear(SortableLinkedList data) {
    int count = data.size();
    for (int i = 0; i < count; i++) {
      data.remove(data.size()-1);
    }
    return data;
  }

  //sorts non-negative integer values
  //uses buckets algorithm described in class notes
  public static void radixSortSimple(SortableLinkedList data) {
    //start with the LSD (least significant digit): ones column --> tens --> hundreds, etc
    SortableLinkedList[] buckets = new SortableLinkedList[10]; //there are 10 SortableLinkedLists in this []

    //initializing every bucket in buckets
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new SortableLinkedList();
    }

    for (int i = 0; i < longest(data); i++) { //for number of columns needed to pass
      for (int k = 0; k < data.size(); k++) { //for every element in data
        buckets[ nth ( data.get(k), i ) ].add(data.get(k));
      }
      merge(clear(data), buckets);
      //System.out.println(data.toString());
    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList negData = new SortableLinkedList();

    for (int i = data.size()-1; i >= 0; i++) {
      if (data.get(i) < 0) { //if the number is negative
        negData.add(data.remove(i)*-1); //make those negative numbers temporarily positive
      }
    }

    radixSortSimple(data); //data = SortableLinkedList that holds only the positive values
    radixSortSimple(negData); //negData = SortableLinkedList that holds only the negative values
    
  }
}
