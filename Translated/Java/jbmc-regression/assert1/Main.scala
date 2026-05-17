//Pass as expected verdict

object assert1 {
  def testAssert1(i: BigInt): Unit = {
    if(i >= 10) assert(i >= 10, "my super assertion")
    if(i >= 20) assert(i >= 10, "my super assertion")
  }
}