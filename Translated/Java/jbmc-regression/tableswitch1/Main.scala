//Pass as expected verdict
import stainless.lang._

object tableswitch1 {
  def testTableswitch1(i: BigInt): Unit = {
    var j: BigInt = 0

    i match {
      case _ if i == -1 => j = 0
      case _ if i == 0 => j = 1
      case _ if i == 1 => j = 2
      case _ if i == 2 => j = 3
      case _ if i == 3 => j = 4
      case _ if i == 4 => j = 5
      case _ if i == 5 => j = 6
      case _ if i == 6 => j = 7
      case _ if i == 7 => j = 8
      case _ if i == 8 => j = 9
      case _ if i == 9 => j = 10
      case _ if i == 10 => j = 11
      case _ if i == 11 => j = 12
      case _ => j = 1000
    }

    if (i >= -1 && i <= 11) assert(j == i + 1)
    else assert(j == 1000)
  }
}
