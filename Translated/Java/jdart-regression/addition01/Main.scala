//Fail as expected verdict (Timeout aswell)
import stainless.lang._

object addition01 {
  def addition(m: BigInt, n: BigInt, c: BigInt): BigInt = {
    decreases(if (n >= 0) n else -n)
    
    if (n == 0) {
      m
    } else {
      if (c >= 150) {
        assert(false)
      }
      if (n > 0) {
        addition(m + 1, n - 1, c + 1)
      } else {
        addition(m - 1, n + 1, c + 1)
      }
    }
  }

  def testAddition01(m: BigInt, n: BigInt): Unit = {
    require(m >= 0 && m < 10000)
    require(n >= 0 && n < 10000)
    
    val result = addition(m, n, 0)
    assert(result == m + n)
  }
}
