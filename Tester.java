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
  }
}
