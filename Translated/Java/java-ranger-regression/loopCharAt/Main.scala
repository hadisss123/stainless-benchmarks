//Fail as expected verdict
import stainless.lang._
import stainless.collection._

object loopCharAt {
  def testLoopCharAt(arg: List[Char]): Unit = {
    var counter = 0
    var remaining = arg
    
    (while (!remaining.isEmpty) {
      decreases(remaining.size)
      val myChar = remaining.head
      if (myChar == 'B') {
        counter = counter + 1
      }
      remaining = remaining.tail
    }).invariant(counter >= 0)
    
    assert(counter != 121)
  }
}
