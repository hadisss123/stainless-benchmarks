import stainless.lang.*

object InsertionSortFunSat01 {
  def sort(a: Array[Int]): Unit = {
    val N = a.length
    var i = 1
    while (i < N) {
      decreases(N - i)
      var j = i - 1
      var x = a(i)
      while ((j >= 0) && (a(j) > x)) {
        decreases(j + 1)
        a(j + 1) = a(j)
        j = j - 1
      }
      a(j + 1) = x
      i = i + 1
    }
  }

  def testInsertionSort(N: Int): Unit = {
    require(N > 0)
    val a = new Array[Int](N)
    var i = 0
    while (i < N) {
      decreases(N - i)
      a(i) = N - i
      i = i + 1
    }
    sort(a)
    assert(N < 2 || a(0) < a(1))
  }
}
