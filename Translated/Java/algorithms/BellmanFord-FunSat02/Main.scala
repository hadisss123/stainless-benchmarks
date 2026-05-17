import stainless.lang._
import stainless.collection._
import stainless.annotation._

object BellmanFordFunSat02 {

  val INFINITY: Int = Int.MaxValue

  def runBellmanFord(N: Int, D: Array[Array[Int]], src: Int): Array[Int] = {
    require(
      N > 0 &&
        N < 1000000 &&
        D.length == N &&
        forall((i: Int) => (i >= 0 && i < N) ==> (D(i).length == N)) &&
        src >= 0 && src < N
    )

    val dist = new Array[Int](N)
    val infinite = new Array[Boolean](N)

    var i = 0
    (while (i < N) {
      decreases(N - i)
      dist(i) = INFINITY
      infinite(i) = true
      i += 1
    }).invariant(i >= 0 && i <= N)
    dist(src) = 0
    infinite(src) = false

    var k = 0
    var shouldBreak = false
    (while (k < N && !shouldBreak) {
      decreases(N - k)

      var relaxed = false
      var i = 0
      (while (i < N) {
        decreases(N - i)

        var j = 0
        (while (j < N) {
          decreases(N - j)

          if (i != j) {
            if (!infinite(i)) {
              if (dist(j) > dist(i) + D(i)(j)) {
                dist(j) = dist(i) + D(i)(j)
                infinite(j) = false
                relaxed = true
              }
            }
          }
          j += 1
        }).invariant(j >= 0 && j <= N && i >= 0 && i < N)
        i += 1
      }).invariant(i >= 0 && i <= N)
      if (!relaxed) {
        shouldBreak = true
      } else {
        k += 1
      }
    })
    .invariant(k >= 0 && k <= N)

    if (k == N) {}

    dist
  }.ensuring(res => res.length == N)

  def testBellmanFord(V: Int, D: Array[Array[Int]]): Unit = {
    require(
      V > 0 && V < 1000000 &&
        D.length == V &&
        forall((i: Int) => (i >= 0 && i < V) ==> (D(i).length == V)) &&
        forall((i: Int, j: Int) =>
          (i >= 0 && i < V && j >= 0 && j < V && i != j) ==>
            (D(i)(j) >= 0 && D(i)(j) < 1000000)
        )
    )

    val dist = runBellmanFord(V, D, 0)

    var i = 0
    (while (i < V) {
      decreases(V - i)
      assert(dist(i) == INFINITY || dist(i) <= V)
      i += 1
    }).invariant(i >= 0 && i <= V)

  }

}
