import stainless.lang._
import stainless.collection._

object BellmanFordFunUnsat01 {

  val INFINITY: Int = Int.MaxValue

  def runBellmanFord(N: Int, D: Array[Int], src: Int): Array[Int] = {
    require(
      N > 0 &&
      N < 1000000 &&
      D.length == N * N &&
      src >= 0 && src < N
    )

    val dist = new Array[Int](N)
    val infinite = new Array[Boolean](N)

    var i = 0
    while (i < N) {
      decreases(N - i)
      dist(i) = INFINITY
      infinite(i) = true
      i += 1
    }
    dist(src) = 0
    infinite(src) = false

    var k = 0
    var shouldBreak = false
    while (k < N && !shouldBreak) {
      decreases(N - k)
      var relaxed = false
      var i = 0
      while (i < N) {
        decreases(N - i)
        var j = 0
        while (j < N) {
          decreases(N - j)
          if (i != j) {
            if (!infinite(i)) {
              if (dist(j) > dist(i) + D(i * N + j)) {
                dist(j) = dist(i) + D(i * N + j)
                infinite(j) = false
                relaxed = true
              }
            }
          }
          j += 1
        }
        i += 1
      }
      if (!relaxed) {
        shouldBreak = true
      } else {
        k += 1
      }
    }

    if (k == N) {
    }

    dist
  }

  def testBellmanFord(V: Int, D: Array[Int]): Unit = {
    require(
      V > 0 && V < 1000000 &&
      D.length == V * V &&
      forall((i: Int, j: Int) => 
        (i >= 0 && i < V && j >= 0 && j < V && i != j) ==> 
        (D(i * V + j) >= 0 && D(i * V + j) < 1000000)
      )
    )

    val dist = runBellmanFord(V, D, 0)
    
    var i = 0
    while (i < V) {
      decreases(V - i)
      assert(dist(i) > V)
      i += 1
    }
  }

}
