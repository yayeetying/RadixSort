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
  }
}
