//Pass as expected verdict
import stainless.lang._

object lookupswitch1 {
  def testLookupswitch1(i: BigInt): Unit = {
    var j: BigInt = 0
    
    i match {
      case _ if i == 1 => j = 2
      case _ if i == 10 => j = 11
      case _ if i == 100 => j = 101
      case _ if i == 1000 => j = 1001
      case _ if i == 10000 => j = 10001
      case _ if i == 100000 => j = 100001
      case _ => j = -1
    }

    if (i == 1 || i == 10 || i == 100 || i == 1000 || i == 10000 || i == 100000) {
      assert(j == i + 1)
    } else {
      assert(j == -1)
    }
  }
}
