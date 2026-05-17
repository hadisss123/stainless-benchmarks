//Fail as expected verdict

object assert2 {
  def testAssert2(i: BigInt): Unit = {
    if(i >= 1000){
      assert(i > 1000, "i is greater 1000")
    } 
  }
}