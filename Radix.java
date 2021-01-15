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

  //merge all of the linked lists in the bucket array into your original linked list
  //original SortableLinkedList may have elements, and those should be kept
  //this should be O(buckets.length) {which will be o(10) cuz 0-9 = 10 digits = 10 buckets}
  //bucket[0] list will be merged with original first, then bucket[1], etc
  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

  //sorts non-negative integer values
  //uses buckets algorithm described in class notes
  public static void radixSortSimple(SortableLinkedList data) {
    //start with the LSD (least significant digit): ones column --> tens --> hundreds, etc
    SortableLinkedList[] buckets = new SortableLinkedList[10]; //there are 10 SortableLinkedLists in this []
    int passes = 1;

    //initializing every bucket in buckets
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new SortableLinkedList();
    }

    for (int i = 0; i < passes; i++) {
      while (data.size() != 0) {
        int ans = data.remove(0);
        buckets[ nth(ans, i) ].add(ans);
        if (i == 0) { //find max length in the first pass
          if (length(ans) > passes) passes = length(ans)+1;
        }
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList negData = new SortableLinkedList();

    int origSize = data.size();
    for (int i = 0; i < origSize; i++) {
      int ans = data.remove(0);
      if (ans < 0) { //if the number is negative
        negData.add(ans);
      }
      else {
        data.add(ans);
      }
    }

    radixSortSimple(data); //data = SortableLinkedList that holds only the positive values
    radixSortSimple(negData); //negData = SortableLinkedList that holds only the negative values

    reverser(negData);
    negData.extend(data);
    data.extend(negData);
  }

  private static void reverser(SortableLinkedList data) {
    //removing from end of SortableLinkedList is O(1) * n terms
    // = this method is O(n)
    SortableLinkedList temp = new SortableLinkedList();
    for (int i = data.size()-1; i >= 0; i--) {
      temp.add(data.remove(data.size()-1));
    }
    data.extend(temp);
  }
}
