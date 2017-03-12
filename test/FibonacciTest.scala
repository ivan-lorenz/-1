import org.scalatest.FlatSpec

class FibonacciTest extends FlatSpec {

  behavior of "Fibonacci"

  it should "compute Fibonacci" in {
    assert(Fibonacci.calc_fib_stream(3) == 2)
  }

}
