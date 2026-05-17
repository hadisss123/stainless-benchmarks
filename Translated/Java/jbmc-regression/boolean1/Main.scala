//Pass as expected verdict

object boolean1 {
  def testBoolean1(my_boolean: Boolean): Unit = {
    if (my_boolean == true) return
    if (my_boolean == false) return

    assert(false)
  }
}
