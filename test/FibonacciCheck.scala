import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

object FibonacciCheck extends Properties("Fibonacci"){

  val genNonNegativesInts: Gen[Int] = Gen.choose(0, 20)
  val listOfNonNegatives: Gen[Array[Int]] =
    for {
      size <- Gen.choose(2,1000)
      elems <- Gen.containerOfN[Array, Int](size, genNonNegativesInts)
    } yield elems

  property("both solutions should be equivalent") =
    forAll(genNonNegativesInts){n  =>
      val assertion = Fibonacci.calc_fib(n) == Fibonacci.calc_fib_stream(n)
      if (!assertion)
        System.out.println("ERROR EN F[" + n + "]")
      assertion
    }

}
