//Fail as expected verdict
import stainless.lang._

object return2 {
  def testReturn2(v1: BigInt, v2: BigInt): Unit = {
    assert(v1 == v2)
  }
}
