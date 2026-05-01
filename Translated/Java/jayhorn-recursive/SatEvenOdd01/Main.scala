import stainless.lang.* 

object SatEvenOdd01 {
  def isOdd(n: BigInt): BigInt = {
    if (n == 0){
      0
    }
    else if (n == 1){
      1
    }
    else{
      isEven(n - 1)
    }
  }

  def isEven(n: BigInt): BigInt = {
    if (n == 0){
      1
    } else if (n == 1){
      0
    } else{
      isOdd(n - 1)
    }
  }

  def testSatEvenOdd01(n: BigInt): Unit = {
    require(n >= 0)
    val result = isOdd(n)
    val mod = n % 2
    assert(result < 0 || result == mod)
  }
}