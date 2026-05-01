import stainless.lang.* 

object UnsatMccarthy91 {
  def f(n: BigInt): BigInt = {
    if (n > 100)
      n - 10
    else
      f(f(n + 11))
  }

  def testUnsatMccarthy91(x: BigInt): Unit = {
    val y = f(x)
    assert(x > 101 || y < 90)
  }
}