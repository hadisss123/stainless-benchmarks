import stainless.lang.* 

object SatAddition01 {
  def addition(m: BigInt, n: BigInt): BigInt = {
    if (n == 0) then
      m
    else if (n > 0) then
      addition(m + 1, n - 1)
    else
      addition(m - 1, n + 1)
  }

  def testSatAddition01(m: BigInt, n: BigInt): Unit = {
    require(m >= 0 && m <= 2147483647 &&
            n >= 0 && n <= 2147483647)
    val result = addition(m, n)
    assert(result == m + n)
  }
}