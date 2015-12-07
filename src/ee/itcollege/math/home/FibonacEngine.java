package ee.itcollege.math.home;

public class FibonacEngine {
	public static long fib(long n)

	{

		if (n == 0 || n == 1) // base case
			return n;
		else
			return fib(n - 1) + fib(n - 2);

	}

}
