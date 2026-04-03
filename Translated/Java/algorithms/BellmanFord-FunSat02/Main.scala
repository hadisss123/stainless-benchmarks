import stainless.lang.*

object BellmanFordFunSat02:

  val INFINITY = Int.MaxValue

  // Flattened D[i][j] access. Faithful to Java D[i][j] with layout D(i*N+j).
  // isDValid encodes the Verifier.assume(tmp >= 0 && tmp < 1000000) loop.
  // The diagonal is skipped matching Java's "if (i == j) continue".
  def isDValid(V: Int, D: Array[Int]): Boolean =
    require(V > 0 && V <= 46340 && D.length == V * V)
    var valid = true
    var i = 0
    while i < V do
      decreases(V - i)
      var j = 0
      while j < V do
        decreases(V - j)
        if i != j && (D(i * V + j) < 0 || D(i * V + j) >= 1000000) then
          valid = false
        j += 1
      i += 1
    valid

  // safeAdd is needed because Java wraps on overflow silently.
  // Stainless must prove no overflow occurs. Since dist can be INFINITY
  // and D values can be up to 999999, raw addition overflows.
  // This is documented as annotation overhead due to the semantic gap
  // between Java's defined wraparound and Stainless's overflow-free model.
  def safeAdd(a: Int, b: Int): Int =
    require(b >= 0)
    if a == Int.MaxValue then Int.MaxValue
    else if a > Int.MaxValue - b then Int.MaxValue
    else a + b

  def runBellmanFord(N: Int, D: Array[Int], src: Int): Array[Int] =
    require(
      N > 0 &&
      N <= 46340 &&        // tighter than Java's V < 1000000 — needed to prevent
                           // i*N+j overflowing Int. Documented as annotation overhead.
      src >= 0 && src < N &&
      D.length == N * N && // flat encoding of Java's D[N][N]
      isDValid(N, D)       // encodes the D-filling assume loop from Java main()
    )
    val dist    = new Array[Int](N)
    val infinite = new Array[Boolean](N)

    // Initialize — identical to Java
    var i = 0
    while i < N do
      decreases(N - i)
      dist(i)    = INFINITY
      infinite(i) = true
      i += 1
    dist(src)    = 0
    infinite(src) = false

    // Relaxation loop — Java's for(k=0;k<N;k++) with break
    // translated to while + boolean flag, identical semantics
    var k       = 0
    var relaxed = true
    while k < N && relaxed do
      decreases(N - k)
      relaxed = false
      var i = 0
      while i < N do
        decreases(N - i)
        var j = 0
        while j < N do
          decreases(N - j)
          // Java: if (i == j) continue — translated to if i != j
          if i != j && !infinite(i) then
            // Java: dist[i] + D[i][j] — translated to safeAdd(dist(i), D(i*N+j))
            // safeAdd replaces raw + to handle the overflow semantic gap
            val candidate = safeAdd(dist(i), D(i * N + j))
            if dist(j) > candidate then
              dist(j)    = candidate
              infinite(j) = false
              relaxed    = true
          j += 1
        i += 1
      k += 1

    // Java: if (k == N) { /* negative cycle */ } — kept as comment, no action
    dist

  // This function corresponds to Java's main().
  // Verifier.nondetInt() + Verifier.assume(P) becomes parameter + require(P).
  // The assert loop at the end of Java main() becomes the assert here.
  def verify(V: Int, D: Array[Int]): Unit =
    require(
      V > 0 &&
      V <= 46340 &&        // Java has V < 1000000 but we tighten to prevent overflow.
                           // Documented as annotation overhead.
      D.length == V * V &&
      isDValid(V, D)
    )
    val dist = runBellmanFord(V, D, 0)
    var j = 0
    while j < dist.length do
      decreases(dist.length - j)
      // Identical to Java: assert(d == INFINITY || d <= V)
      assert(dist(j) == INFINITY || dist(j) <= V)
      j += 1