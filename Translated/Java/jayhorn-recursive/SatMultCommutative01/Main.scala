import stainless.lang.*

//Passes as expected verdict

object SatMultCommutative01 {

  def mult(n: BigInt, m: BigInt): BigInt = {
    decreases(m)
    require(
      m >= 0 && m <= 46340 &&
        n >= 0 && n <= 46340
    )
    if (m < 0) {
      mult(n, -m)
    } else if (m == 0) {
      BigInt(0)
    } else {
      n + mult(n, m - 1)
    }
  }.ensuring(res => res == n * m)

  def testMult(n: BigInt, m: BigInt): Unit = {
    require(
      m >= 0 && m <= 46340 &&
        n >= 0 && n <= 46340
    )
    val res1 = mult(n, m)
    val res2 = mult(m, n)
    if (res1 != res2 && m > 0 && n > 0) {
      assert(false)
    } else {
      ()
    }
  }
}
