import stainless.lang.* 

// Runs and verifiers true like the expected verdicts
// Maybe not fair since I added ensuring clauses


object SatMccarthy91 {
    def f(n: BigInt): BigInt = {
      decreases(if (n > 100) BigInt(0) else 101 - n)
      if(n > 100) {
        n - 10
      }
      else {
        f(f(n + 11))
      }
    }.ensuring(res => res == (if (n > 100) n - 10 else BigInt(91)))

    def testSatMccarthy91(x: BigInt): Unit = {
      val y = f(x)
      assert(x > 101 || y == 91)
    }
}
