import stainless.lang.*

//Fails as expected verdict


object UnsatAddition01 {
  def addition(m: BigInt, n: BigInt): BigInt = {
    decreases(if(n >= 0) n else -n)
    if (n == 0)
      m
    else if (n > 0)
      addition(m + 1, n - 1)
    else
      addition(m - 1, n + 1)
  }.ensuring(res => res == m + n)

  def testUnsatAddition01(m: BigInt, n: BigInt): Unit = {
    val result = addition(m, n)
    if (result == m - n) {
      () 
    } else {
      assert(false) 
    }
  }

}
