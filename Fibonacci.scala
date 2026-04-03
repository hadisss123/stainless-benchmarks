import stainless.collection.*

object Fibonacci {
  def fibonacci(n: BigInt): BigInt = {
    require(n >= 0)
    if (n == 0) 0
    else if (n == 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
}
