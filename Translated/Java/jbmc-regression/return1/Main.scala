//Fail as expected verdict

object return1 {
  def short_value(): Short = {
    val s: Short = 1
    s
  }

  def bool_value(): Boolean = {
    val b: Boolean = true
    b
  }

  def long_value(): Long = {
    val l: Long = 0x10000ffffl
    l
  }

  def testReturn1(): Unit = {
    val s: Short = short_value()
    if (s == 1) {
      if (bool_value()) {
        if (long_value() == 0x10000ffffl) {
          assert(false)
        }
      }
    }
  }
}
