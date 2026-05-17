import stainless.lang.*

//Passes as expected verdict

object SatFibonacci03 {
    def fibonacci(n: BigInt): BigInt = {
      decreases(if (n < 1) BigInt(0) else n)
      if (n < 1) {
        BigInt(0)
      }
      else if (n == 1) {
        BigInt(1)
      }
      else {
        fibonacci(n - 1) + fibonacci(n - 2)
      }
    }.ensuring(res => res >= 0 && (n < 1 || res >= 1) && res >= n - 1)

    def testSatFibonacci03(x: BigInt): Unit = {
      require(x >= 9 && x <= 46)
      val result = fibonacci(x)
      if (x < 9 || result >= 34) {
        ()
      } else {
        assert(false)
      }
    }
}
