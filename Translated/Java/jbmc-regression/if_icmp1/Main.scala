//Pass as expected verdict
import stainless.lang._


object if_icmp1 {
  def f(i: BigInt, j: BigInt): Unit = {
    require(j == i + 1)
    if (i == j) {
      assert(false)
    }
    if (i >= j) {
      assert(false)
    }
    if (j > i) {
      assert(true)
    } else {
      assert(false)
    }
    if (j <= i) {
      assert(false)
    }
    if (j < i) {
      assert(false)
    } else {
      assert(true)
    }
  }

  def testIfIcmp1(i: BigInt): Unit = {
    require(i + 1 >= 0)
    f(i, i + 1)
  }
}
