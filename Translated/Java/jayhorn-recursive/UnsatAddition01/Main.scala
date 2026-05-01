import stainless.lang.* 

object UnsatAddition01 {
  def addition(m: BigInt, n: BigInt): BigInt = {
    if(n == 0) 
      m 
    else if(n > 0) 
      addition(m + 1, n - 1)
    else
      addition(m - 1, n + 1)
  }
  
  def testUnsatAddition01(m: BigInt, n: BigInt): Unit = {
    val result = addition(m, n)
    assert(result == m - n)
  }

}