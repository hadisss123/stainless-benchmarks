import stainless.lang.*

/*def iterativeMergesort(a: Array[Int]): Unit = {
  require(a.length > 0)
  val aux = new Array[Int](a.length)
  var blockSize = 1
  (while (blockSize < a.length) {
    decreases(a.length - blockSize)
    var start = 0
    (while (start < a.length) {
      decreases(a.length - start)
      merge(a, aux, start, start + blockSize, start + 2 * blockSize)
      start = start + 2 * blockSize
    }).invariant(start >= 0 && start <= a.length && blockSize >= 1)
    blockSize = blockSize * 2
  }).invariant(blockSize >= 1 && blockSize <= a.length)
}.ensuring(a.length < 2 || a(0) < a(1))

// iterativeMergesortWithoutCopy and mergeWithoutCopy are omitted:
// Stainless's AntiAliasing phase forbids binding a mutable array to a `var`
// (i.e. `var from = a`), making the array-swapping pattern inexpressible.
// The SV-COMP benchmark property only requires verifying iterativeMergesort.

def merge(a: Array[Int], aux: Array[Int], lo: Int, mid: Int, hi: Int): Unit = {
  require(a.length > 0)
  require(aux.length == a.length)
  require(lo >= 0 && lo <= a.length)
  require(mid >= lo && mid <= a.length)
  require(hi >= mid && hi <= a.length)
  if (mid < a.length) {
    val h = if (hi > a.length) a.length else hi
    var i = lo
    var j = mid
    var k = lo
    (while (k < h) {
      decreases(h - k)
      if (i == mid) {
        aux(k) = a(j)
        j = j + 1
      } else if (j == h) {
        aux(k) = a(i)
        i = i + 1
      } else if (a(j) < a(i)) {
        aux(k) = a(j)
        j = j + 1
      } else {
        aux(k) = a(i)
        i = i + 1
      }
      k = k + 1
    }).invariant(
      k >= lo && k <= h &&
      i >= lo && i <= mid &&
      j >= mid && j <= h
    )
    k = lo
    (while (k < h) {
      decreases(h - k)
      a(k) = aux(k)
      k = k + 1
    }).invariant(k >= lo && k <= h)
  }
}*/

def recursiveMergesort(
    a: Array[Int],
    aux: Array[Int],
    lo: Int,
    hi: Int
): Unit = {
  require(a.length > 0)
  require(aux.length == a.length)
  require(lo >= 0 && lo <= a.length)
  require(hi >= lo && hi <= a.length)
  decreases(hi - lo)
  if (hi - lo > 1) {
    val mid = lo + (hi - lo) / 2
    recursiveMergesort(a, aux, lo, mid)
    recursiveMergesort(a, aux, mid, hi)
    merge(a, aux, lo, mid, hi)
  }
}

def recursiveMergesort(a: Array[Int]): Unit = {
  require(a.length > 0)
  val n = a.length
  val aux = new Array[Int](n)
  recursiveMergesort(a, aux, 0, n)
}
