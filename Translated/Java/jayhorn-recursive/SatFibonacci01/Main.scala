//Pass as expected verdict
import stainless.lang._

object SatFibonacci01 {
  def fibonacci(n: BigInt): BigInt = {
    decreases(if (n < 1) BigInt(0) else n)
    if (n < 1) {
      BigInt(0)
    } else if (n == 1) {
      BigInt(1)
    } else {
      fibonacci(n - 1) + fibonacci(n - 2)
    }
  }.ensuring(res => res >= 0 && (n < 1 || res >= 1) && res >= n - 1)

  def testSatFibonacci01(x: BigInt): Unit = {
    require(x <= 46 && x != -2147483648)
    
    val result = fibonacci(x)
    if (result >= x - 1) {
      ()
    } else {
      assert(false)
    }
  }
}
