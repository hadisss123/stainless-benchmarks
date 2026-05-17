import stainless.lang._
import stainless.collection._
import stainless.annotation._

object InsertionSortFunUnsat01 {

  def sort(a: Array[Int]): Unit = {
    require(a.length > 0)
    val N = a.length
    
    var i = 1
    (while (i < N) {
      decreases(N - i)
      
      var j = i - 1
      val x = a(i)
      
      (while (j >= 0 && a(j) > x) {
        decreases(j)
        a(j + 1) = a(j)
        j -= 1
      }).invariant(j >= -1 && j < i && i < N)
      
      a(j + 1) = x
      i = i + 1
    }).invariant(i >= 1 && i <= N)
  }

  def testInsertionSort(N: Int, a: Array[Int]): Unit = {
    require(
      N > 0 &&
      N < 1000000 &&
      a.length == N
    )

    sort(a)
    
    assert(N < 2 || a(0) < a(1)) 
  }

}
