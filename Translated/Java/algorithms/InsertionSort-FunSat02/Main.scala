import stainless.lang._

object InsertionSortFunSat02 {

  def sort(a: Array[Int]): Unit = {
    require(a.length > 0)
    val N = a.length
    var i = 1
    (while (i < N) {
      decreases(N - i)
      var j = i - 1
      val x = a(i)
      (while ((j >= 0) && (a(j) > x)) {
        decreases(j + 1)
        a(j + 1) = a(j)
        j = j - 1
      })
      .invariant(j >= -1 && j < i && i < N && a.length == N)
      a(j + 1) = x
      i = i + 1
    })
    .invariant(i >= 1 && i <= N && a.length == N)
  }

  def testSort(N: Int, i1: Int, i2: Int): Unit = {
    require(N > 0)
    require(0 <= i1 && i1 < i2 && i2 < N)

    val a = new Array[Int](N)
    var i = 0
    (while (i < N) {
      decreases(N - i)
      a(i) = N - i
      i = i + 1
    })
    .invariant(i >= 0 && i <= N && a.length == N)

    sort(a)

    assert(a(i1) <= a(i2))
  }
}
