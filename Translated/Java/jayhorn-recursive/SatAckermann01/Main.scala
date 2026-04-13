import stainless.lang.* 

// Made into BigInt to avoid overflow
// Result is valid for stainless, expected verdict was true
// for both assertions and no runtime exception

object SatAckermann01 {
    def ackermann(m: BigInt, n: BigInt): BigInt = {
        require(m >= 0 && n >= 0)
        
        decreases(m, n)
        if (m == 0) {
            n + 1
        } else if (n == 0) {
            ackermann(m - 1, 1)
        } else {
            ackermann(m - 1, ackermann(m, n - 1))
        }
    }.ensuring(res => res >= 0)

    def testAckermann(m: BigInt, n: BigInt): Unit = {
        require(m >= 0 && m < 4)
        require(n >= 0 && n < 24)
        val result = ackermann(m, n)
        assert(result >= 0)
    }
}