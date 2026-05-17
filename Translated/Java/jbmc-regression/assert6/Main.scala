//Pass as expected verdict

object assert6 {
    def testAssert6(i: BigInt): Unit = {
        if (i >= 1000) {
            if (!(i >= 1000)) {
                assert(false)
            }
        }
    }
}