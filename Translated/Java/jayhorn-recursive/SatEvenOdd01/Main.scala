import stainless.lang.*

//Passes like the expected verdict

object SatEvenOdd01 {
  def isOdd(n: BigInt): BigInt = {
    require(n >= 0)
    decreases(n)
    if (n == 0) {
      BigInt(0)
    } else if (n == 1) {
      BigInt(1)
    } else {
      isEven(n - 1)
    }
  }.ensuring(res => res == n % 2)

  def isEven(n: BigInt): BigInt = {
    require(n >= 0)
    decreases(n)
    if (n == 0) {
      BigInt(1)
    } else if (n == 1) {
      BigInt(0)
    } else {
      isOdd(n - 1)
    }
  }.ensuring(res => res == 1 - (n % 2))

  def testSatEvenOdd01(n: BigInt): Unit = {
    require(n >= 0)
    val result = isOdd(n)
    val mod = n % 2
    if (result < 0 || result == mod) {
      () 
    } else {
      assert(false) 
    }
  }
}
