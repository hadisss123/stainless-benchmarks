import stainless.lang.*

//Passes but expected verdict is False

object UnsatAddition02 {
  def addition(m: BigInt, n: BigInt): BigInt = {
    decreases(if(n >= 0) n else -n)
    if (n == 0)
      m
    else if (n > 0)
      addition(m + 1, n - 1)
    else
      addition(m - 1, n + 1)
  }.ensuring(res => res == m + n) 

  def testUnsatAddition02(m: BigInt, n: BigInt): Unit = {
    val result = addition(m, n)
    if (m < 100 || n < 100 || result >= 200) {
      ()
    } else {
      assert(false)
    }
    
  }
}
