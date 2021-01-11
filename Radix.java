public class Radix {

  //get nth digit of an int, where 0 is the ones column, 1 is the tens column etc
  public static int nth(int n, int col) {
    //restraint: col has to be < n.length();
    return 0;
  }

  //returns the number of digits in n
  public static int length(int n) {
    return (int)(Math.log10(n)) + 1;
  }
}
