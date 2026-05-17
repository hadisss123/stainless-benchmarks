//Pass as expected verdict
import stainless.lang._

object recursion2 {
  def recursion_test(depth: BigInt): BigInt = {
    decreases(if (depth < 10) 10 - depth else BigInt(0))
    if (depth < 10) recursion_test(depth + 1) + 1
    else BigInt(0)
  }

  def testRecursion2(): Unit = {
    assert(recursion_test(0) == 10)
  }
}
