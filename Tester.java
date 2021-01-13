public class Tester {
  public static void main(String[] args) {
    int[] numbers = new int[]{1, 2, 4, 7, 9,
                              10, 21, 55, 90, 99,
                              100, 212, 586, 777, 999,
                              1000, 4444, 6748, 9187, 9999};
    //WOAHHH; Math.log does ln(number), not log(base 10) of number!
    System.out.println(Math.log10(4));
    System.out.println((int)Math.log10(4));
    for (int i = 0; i < numbers.length; i++) {
      System.out.println("length of " + numbers[i] + " is " + Radix.length(numbers[i]));
    }

    for (int i = 0; i < numbers.length; i++) { //for all elements in [] numbers
      for (int j = 0; j < Radix.length(numbers[i]); j++) { //get ones, tens, etc. digit of the number
        if (j == 0) System.out.print("ones digit: ");
        else if (j == 1) System.out.print("tens digit: ");
        else if (j == 2) System.out.print("hundreds digit: ");
        else if (j == 3) System.out.print("thousands digit: ");
        System.out.println(Radix.nth(numbers[i], j));
      }
      System.out.println();
    }
    System.out.println(Radix.nth(1, 8)); //finding tenths place of 8
    System.out.println(Radix.nth(2, 8));
    System.out.println(Radix.nth(2, 18));
    System.out.println("~~~~~~~~~~~~~~~~~~~~~");

    //big distinction!
    SortableLinkedList bucket = new SortableLinkedList(); //this creates a singular SortableLinkedList
    System.out.println(bucket.size());

    SortableLinkedList[] buckets = new SortableLinkedList[10]; //this creates 10 SortableLinkedLists!
    System.out.println(buckets.length);

    System.out.println("~~~~~~~~~~~~~~~~~~~~~");
    SortableLinkedList nums = new SortableLinkedList();
    nums.add(12);     nums.add(34);     nums.add(42);     nums.add(32);
    nums.add(44);     nums.add(41);     nums.add(34);     nums.add(11);
    nums.add(32);     nums.add(23);     nums.add(87);     nums.add(50);
    nums.add(77);     nums.add(58);     nums.add(8);
    for (int j = 0; j < 3; j++) { //get ones place, then tens place, then hundreds place of all numbers in nums
      for (int i = 0; i < nums.size(); i++) {
        System.out.print(Radix.nth(nums.get(i), j) + " ");
      }
      System.out.println();
    }
    System.out.println(nums.toString());
    //System.out.println(Radix.clear(nums).toString());
    Radix.radixSortSimple(nums);
    System.out.println(nums.toString());

  }
}
