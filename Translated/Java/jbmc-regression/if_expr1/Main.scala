//Pass as expected verdict

object if_expr1 {
  def testIfExpr1(x: BigInt): Unit = {
    val y: BigInt = if (x == 10) 11 else 9
    if (x == 10) assert(y == 11)
    else assert(y == 9)
  }
}
