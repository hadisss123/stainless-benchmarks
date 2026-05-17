//Fail as expected verdict

object assert3 {
    def testAssert3(i: BigInt): Unit = {
        if(i >= 1000){
            if(!(i > 1000)){
              assert(false)
            }
        }
    }
}