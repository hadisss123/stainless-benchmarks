object MainTestScala {
  val INFINITY = Int.MaxValue

  def runBellmanFord(N: Int, D: Array[Int], src: Int): Array[Int] = {
    require(
      N > 0 &&
        N < 46341 &&
        src >= 0 && src < N &&
        D.length == N * N &&
        isDValid(N, D)
    )
    val dist = new Array[Int](N)
    val infinite = new Array[Boolean](N)
    var i = 0
    while (i < N) {
      dist(i) = INFINITY
      infinite(i) = true
      i += 1
    }
    dist(src) = 0
    infinite(src) = false

    var k = 0
    var relaxed = true
    while (k < N && relaxed) {
      relaxed = false
      var i = 0
      while (i < N) {
        var j = 0
        while (j < N) {
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
      k += 1
    }

    if (k == N) {}
    dist
  }

  def isDValid(V: Int, D: Array[Int]): Boolean = {
    require(V > 0 && V < 46341 && D.length == V * V)
    var valid = true
    var i = 0
    while (i < V) {
      var j = 0
      while (j < V) {
        if (i != j) {
          if (D(i * V + j) < 0 || D(i * V + j) >= V) {
            valid = false
          }
        }
        j += 1
      }
      i += 1
    }
    valid
  }

  def testBellmanFord(V: Int, D: Array[Int]): Unit = {
    require(
      V > 0 && V < 46341 &&
        D.length == V * V &&
        isDValid(V, D)
    )
    val dist = runBellmanFord(V, D, 0)
    var j = 0
    while (j < dist.length) {
      assert(dist(j) == INFINITY || dist(j) <= V)
      j += 1
    }
  }

  def arrayToString(arr: Array[Int]): String = {
    var str = ""
    var i = 0
    while (i < arr.length) {
      str += arr(i)
      i += 1
    }
    str
  }

  def main(args: Array[String]): Unit = {
    val dist = runBellmanFord(1, Array(0), 0)
    println(arrayToString(dist))
    val dist2 = runBellmanFord(3, Array(0, 1, 2, 1, 0, 1, 2, 1, 0), 0)
    println(arrayToString(dist2))
    val dist3 = runBellmanFord(
      4,
      Array(0, 1, 2, 3, 1, 0, 1, 2, 2, 1, 0, 1, 3, 2, 1, 0),
      0
    )
    println(arrayToString(dist3))
    val dist4 = runBellmanFord(3, Array(0, 0, 0, 0, 0, 0, 0, 0, 0), 0)
    println(arrayToString(dist4))
    val dist5 = runBellmanFord(2, Array(0, 1, 1, 0), 0)
    println(arrayToString(dist5))
  }
}
