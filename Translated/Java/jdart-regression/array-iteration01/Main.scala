//Fail as expected verdict
import stainless.lang._

object array_iteration01 {
  def testArrayIteration01(index: Int, value: Int): Unit = {
    require(index >= 0 && index < 200)
    
    val ia = Array.fill(200)(0)
    ia(index) = value
    
    var i = 0
    (while (i < ia.length) {
      decreases(ia.length - i)
      assert(ia(i) != 0) 
      i += 1
    }).invariant(i >= 0 && i <= ia.length)
  }
}
