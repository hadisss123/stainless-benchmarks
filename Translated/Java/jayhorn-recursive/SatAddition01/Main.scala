import stainless.lang.*

//Passes as expected verdict

object SatAddition01 {
  def addition(m: BigInt, n: BigInt): BigInt = {
    decreases(if (n >= 0) n else -n)
    if (n == 0) then m
    else if (n > 0) then addition(m + 1, n - 1)
    else addition(m - 1, n + 1)
  }.ensuring(res => res == m + n)

  def testSatAddition01(m: BigInt, n: BigInt): Unit = {
    require(
      m >= 0 && m <= 2147483647 &&
        n >= 0 && n <= 2147483647
    )
    val result = addition(m, n)
    if (result == m + n) {
      ()
    } else {
      assert(false)
    }
  }
}
