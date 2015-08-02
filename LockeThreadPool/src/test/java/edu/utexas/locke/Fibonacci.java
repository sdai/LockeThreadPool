package test.java.edu.utexas.locke;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

// @TODO: Convert this to use our library, which means we need to
// implement a LockeTask object.
class Fibonacci extends RecursiveTask<Integer> {
  final int n;
  Fibonacci(int n) { this.n = n; }
  protected Integer compute() {
    if ((n == 0)||(n == 1 )) return 1;
    Fibonacci f1 = new Fibonacci(n - 1);
    f1.fork();
    Fibonacci f2 = new Fibonacci(n - 2);
    return f2.compute() + f1.join();
  }
  public static void main(String[] args) {
    int processors = Runtime.getRuntime().availableProcessors();
    System.out.println("Number of processors: " + processors);
    Fibonacci f = new Fibonacci(Integer.parseInt(args[0]));
    ForkJoinPool pool = new ForkJoinPool(processors);
    int result = pool.invoke(f);
    System.out.println("Result: " + result);
  }
}
