import stainless.lang.* 

object UnsatFibonacci01 {
  def fibonacci(n: BigInt): BigInt = {
    if(n < 1) 
      0 
    else if(n == 1) 
      1 
    else 
      fibonacci(n - 1) + fibonacci(n - 2)
  }

  def testUnsatFibonacci01(x: BigInt): Unit = {
    val result = fibonacci(x)
    assert(x != 5 || result == 3)
  }
}