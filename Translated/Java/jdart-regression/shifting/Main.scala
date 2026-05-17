//Fail as expected verdict
import stainless.lang._

object shifting {
  def testShifting(i: Int): Unit = {
    require(i >= 0 && i <= 100)
    
    if ((1L << i) > Int.MaxValue) {
      assert(false)
    }
  }
}
