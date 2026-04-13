import stainless.lang.* 


// Made into BigInt to avoid overflow

// Result is valid for stainless as the expected verdict

object Addition {
  def addition(m: BigInt, n: BigInt): BigInt = {
    decreases(if (n >= 0) n else -n)
    if(n == 0){
      m
    }
    else if(n > 0){
      addition(m + 1, n - 1)
    }
    else{
      addition(m - 1, n + 1)
    }
  }.ensuring(res => res == m + n)

  def testAddition(m: BigInt, n: BigInt): Unit = {
    require(m >= 0 && m < 10000)
    require(n >= 0 && n < 10000)
    val result = addition(m, n)
    assert(result == m + n)
  }
}