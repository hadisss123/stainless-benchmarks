//Fail as expected verdict
import stainless.lang._

object boundcheck30 {
  def recursion(i: BigInt): Unit = {
    decreases(if (i >= 0) i else -i)
    if (i == 0) {
      ()
    } else {
      if (i > 0) {
        recursion(i - 1)
      }
      if (i < 0) {
        assert(false)
      }
    }
  }

  def testBoundcheck30(x: BigInt): Unit = {
    require(x == 30)
    recursion(x)
    assert(false)
  }
}
