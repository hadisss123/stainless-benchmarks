import stainless.lang.* 

object SatAckermann03 {
  def ackermann(m: BigInt, n: BigInt): BigInt = {
    if (m == 0)
      n + 1
    else if (n == 0)
      ackermann(m - 1, 1)
    else
      ackermann(m - 1, ackermann(m, n - 1))
  }

  def testSatAckermann03(m: BigInt, n: BigInt): Unit = {
    require(m >= 0 && m <= 3 &&
            n >= 0 && n <= 23)
    val result = ackermann(m, n)
    assert(m < 2 || n < 2 || result < 7)
  }
}