import stainless.lang.*

object SatFibonacci02 {

  def fibonacci(n: BigInt): BigInt = {
    // We add a `decreases` clause because Stainless requires termination proofs for recursive functions.
    decreases(if (n < 0) BigInt(0) else n)
    if (n < 1) {
      0
    } else if (n == 1) {
      1
    } else {
      fibonacci(n - 1) + fibonacci(n - 2)
    }
  }

  def testFibonacci(): Unit = {
    val x = BigInt(9)
    val result = fibonacci(x)
    assert(result == 34)
  }
}
