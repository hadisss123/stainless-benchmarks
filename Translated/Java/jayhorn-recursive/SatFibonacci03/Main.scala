import stainless.lang.*

object SatFibonacci03 {
    def fibonacci(n: BigInt): BigInt = {
        if (n < 1) {
          0
        }
        else if (n == 1) {
          1
        }
        else {
          fibonacci(n - 1) + fibonacci(n - 2)
        }
    }

    def testSatFibonacci03(x: BigInt): Unit = {
        require(x >= 0 && x <= 46)
        val result = fibonacci(x)
        assert(x < 9 || result >= 34)
    }
}
