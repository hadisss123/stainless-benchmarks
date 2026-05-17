//Pass as expected verdict

object ifxx1 {
  def testIfxx1(): Unit = {
    var i: Int = 0
    if (i != 0) {
      assert(false)
    }
    i = 1
    if (i == 0) {
      assert(false)
    }
    if (i < 0) {
      assert(false)
    }
    i = 0
    if (i > 0) {
      assert(false)
    }
    i = 1
    if (i <= 0) {
      assert(false)
    }
    i = -1
    if (i >= 0) {
      assert(false)
    }
  }
}
