import stainless.lang._
import stainless.annotation._

object aastore_aaload1 {
  case class A(value: BigInt)

  def test(size: Int): Unit = {
    require(size >= 0)

    val array: Array[Boolean] = new Array[Boolean](size)

    var i = 0
    (while (i < size) {
      decreases(size - i)
      array(i) = true
      i = i + 1
    })
    .invariant(
      i >= 0 && i <= size &&
        array.length == size &&
        forall((k: Int) => !(k >= 0 && k < i) || array(k))
    )

    var j = 0
    (while (j < size) {
      decreases(size - j)
      assert(array(j))
      j = j + 1
    })
    .invariant(
      j >= 0 && j <= size &&
        array.length == size &&
        forall((k: Int) => !(k >= 0 && k < size) || array(k))
    )
  }
}
