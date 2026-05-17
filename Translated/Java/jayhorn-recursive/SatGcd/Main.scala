import stainless.lang.*

// Made into BigInt to avoid overflow
// Result is valid for stainless, expected verdict was true
// for both assertions and no runtime exception
// Done

object SatGcd {
  def gcd(y1: BigInt, y2: BigInt): BigInt = {
    decreases(y1 + y2)
    require(y1 > 0 && y1 <= 2147483647 && y2 > 0 && y2 <= 2147483647)
    if (y1 <= 0 || y2 <= 0) {
      BigInt(0)
    } else if (y1 == y2) {
      y1
    } else if (y1 > y2) {
      gcd(y1 - y2, y2)
    } else {
      gcd(y1, y2 - y1)
    }
  }.ensuring(res => res >= 1)
}
