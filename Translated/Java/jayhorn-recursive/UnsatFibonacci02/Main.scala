import stainless.lang.*

//Fail as expected verdict

object UnsatFibonacci02 {
  def fibonacci(n: BigInt): BigInt = {
    if (n < 1)
      BigInt(0)
    else if (n == 1)
      BigInt(1)
    else
      fibonacci(n - 1) + fibonacci(n - 2)
  }.ensuring(res => res >= 0 && (n < 1 || res >= 1) && res >= n - 1)

  def testUnsatFibonacci02(x: BigInt): Unit = {
    val result = fibonacci(x)
    if (x < 8 || result >= 34) {
      ()
    } else {
      assert(false)
    }
  }
}
