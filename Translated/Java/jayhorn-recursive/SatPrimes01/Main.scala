import stainless.lang.* 

object SatPrimes01 {

  def mult(n: BigInt, m: BigInt): BigInt = {
    if (m < 0) {
      mult(n, -m)
    } else if (m == 0) {
      BigInt(0)
    } else if (m == 1) {
      BigInt(1)
    } else {
      n + mult(n, m - 1)
    }
  }

  def multiple_of(n: BigInt, m: BigInt): BigInt = {
    if (m < 0) {
      multiple_of(n, -m)
    } else if (n < 0) {
      multiple_of(-n, m)
    } else if (m == 0) {
      BigInt(0)
    } else if (n == 0) {
      BigInt(1)
    } else {
      multiple_of(n - m, m)
    }
  }

  def is_prime(n: BigInt): BigInt = {
    is_prime_(n, n - 1)
  }

  def is_prime_(n: BigInt, m: BigInt): BigInt = {
    if (n <= 1) {
      BigInt(0)
    } else if (n == 2) {
      BigInt(1)
    } else {
      if (m <= 1) {
        BigInt(1)
      } else {
        if (multiple_of(n, m) == BigInt(0)) {
          BigInt(0)
        } else {
          is_prime_(n, m - 1)
        }
      }
    }
  }

  def testSatPrimes01(n: BigInt, f1: BigInt, f2: BigInt): Unit = {
    if (!(n < 1 || n > 46340)) {
      val result = is_prime(n)
      if (!(f1 < 1 || f1 > 46340)) {
        //Probably a typo in the original, meant to check f2
        if (!(f1 < 1 || f1 > 46340)) {
          if (result == 1 && mult(f1, f2) == n && f1 > 1 && f2 > 1) {
            assert(false)
          } else {
            ()
          }
        }
      }
    }
  }
}
