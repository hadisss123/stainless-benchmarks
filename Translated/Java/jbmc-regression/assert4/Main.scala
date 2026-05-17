//Fail as expected verdict

object assert4 {
  def testAssert4(i: BigInt): Unit = {
    if(i >= 10){
      assert(i >= 20, "my super assertion")
    }
  }
}