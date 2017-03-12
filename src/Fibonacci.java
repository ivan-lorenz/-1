import java.util.Scanner;
import java.util.stream.Stream;

public class Fibonacci {
  public static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  public static long calc_fib_fast(int n) {

    if (n < 2) return n;

    long[] F;
    F = new long[n+1];
    F[0] = 0;
    F[1] = 1;

    for (int i = 2; i <= n; i++)
      F[i] = F[i-1] + F[i-2];

    return F[n];
  }

  public static long calc_fib_stream(int n) {

    if (n < 2) return n;

    return Stream.iterate(new int[] {0, 1},
            tuple -> new int[] {tuple[1], tuple[1] + tuple[0]}).skip(n-1)
            .mapToLong(tuple -> tuple[1])
            .findFirst()
            .getAsLong();
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib_stream(n));
  }
}
