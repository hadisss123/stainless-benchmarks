//Pass as expected verdict

object array2 {
  def testArray2(unknown: Int): Unit = {
    val arr = if (unknown > 0) Array.fill(1)(0) else Array.fill(0)(0)
    
    if (unknown > 0) arr(0) = 1
    
    if (unknown > 0) assert(arr.length == 1 && arr(0) == 1)
    else assert(arr.length == 0)
  }
}
