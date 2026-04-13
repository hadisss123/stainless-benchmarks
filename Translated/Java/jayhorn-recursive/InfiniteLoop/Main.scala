import stainless.lang._


// Result is invalid, expected verdict was false for the asserts
// and true for no runtime exception
object InfiniteLoop {
  def testInfiniteLoop(b: Boolean): Unit = {
    var i = 0

    while (true) {
      i += 1
      assert(b)
    }
  }
}