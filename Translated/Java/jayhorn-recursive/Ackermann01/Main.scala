import stainless.lang.* 

object Ackermann01 {
  def ack(m: BigInt, n: BigInt): BigInt = {
    if (m == 0)
      n + 1
    else if (n == 0)
      ack(m - 1, 1)
    else
      ack(m - 1, ack(m, n - 1))
  }

  def testAckermann01(m: BigInt, n: BigInt): Unit = {
    require(m >= 0 && m <= 3 &&
            n >= 0 && n <= 23)
    val result = ack(m, n)
    assert(m >= 0 && n >=0 && result < 0)
  }
}