//Pass as expected verdict

object iarith1 {
  def testIarith1(): Unit = {
    var i: Int = 99
    i = i + 1
    var tmp: Int = i + 2
    i = tmp
    tmp = i - 3
    i = tmp
    i = i + 3
    i = i - 3
    tmp = i * 2
    i = tmp
    tmp = i / 3
    i = tmp
    i = i % 34
    i = -i
    assert(i == -32)

    var l: Long = 99L
    l = l + 1L
    l = l + 2L
    l = l - 3L
    l = l * 2L
    l = l / 3L
    l = l % 34L
    l = -l
    assert(l == -32L)
  }
}
