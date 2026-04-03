import stainless.collection.*

object Test1 {
  def function(arg1: Int, arg2: Int): Int = {
    require(
      if (arg2 > 0) arg1 <= Int.MaxValue - arg2
      else arg1 >= Int.MinValue - arg2
    )
    arg1 + arg2
  }
}
