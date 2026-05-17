//Pass like the expected verdict

object iarith2{
    def i(): Int = {
        var value = 3
        value = value & 1
        value = value | 4
        value = value ^ 4
        value = value << 2
        value = value >> 1
        value = -value
        value = value >>> 1
        value
    }

    def l(): Long = {
        var value = 3L
        value = value & 1L
        value = value | 4L
        value = value ^ 4L
        value = value << 2L
        value = value >> 1L
        value = -value
        value = value >>> 1L
        value
    }

    def s(): Unit = {
        var lhs: Short = 127
        var rhs: Short = 32767
        if (lhs < rhs) {
            ()  
        } else {
            assert(false)
        }
    }

    def testIarith2(): Unit = {
        assert(i() == 2147483647)
        assert(l() == 9223372036854775807L)
        s()
    }
}