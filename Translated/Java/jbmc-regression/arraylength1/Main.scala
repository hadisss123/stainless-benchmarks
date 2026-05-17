//Pass as expected verdict

object arraylength1 {
  def testArraylength1(size: Int): Unit = {
    require(size >= 0)
    val int_array: Array[Int] = Array.fill(size)(0)
    assert(int_array.length == size)
  }
}
