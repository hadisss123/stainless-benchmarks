//Pass as expected verdict

object assert5{
  def testAssert5(i: BigInt): Unit = {
    if(i > 1000){
      assert(i > 1000, "i is greater 1000")
    }
  }
}