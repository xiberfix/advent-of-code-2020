import org.junit.Test
import kotlin.test.assertEquals

class Day9Test {
    private val input = """
        35
        20
        15
        25
        47
        40
        62
        55
        65
        95
        102
        117
        150
        182
        127
        219
        299
        277
        309
        576
    """.trimIndent()

    @Test
    fun testPart1() {
        val result = day9.part1(input, 5)
        assertEquals(127, result)
    }

    @Test
    fun testPart2() {
        val result = day9.part2(input, 5)
        assertEquals(62, result)
    }
}
