import stainless.lang.* 

//Fails like the expected verdict

object UnsatAckermann01 {
    def ackermann(m: BigInt, n: BigInt): BigInt = {
      decreases(m, n)
      if(m == 0) {
        n + 1
      }
      else if(n == 0) {
        ackermann(m - 1, 1)
      }
      else {
        ackermann(m - 1, ackermann(m, n - 1))
      }
    }
    
    def testUnsatAckermann01(m: BigInt, n: BigInt): Unit = {
        val result = ackermann(m, n)
        if (m < 2 || result >= 4) {
            ()
        } else {
            assert(false)
        }
    }
}