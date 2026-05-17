//Pass as expected verdict

object boolean2 {
  def f(b: Boolean): Boolean = {
    !b
  }

  def testBoolean2(b: Boolean): Unit = {
    val result: Boolean = f(b)
    assert(result == !b)
  }
}
